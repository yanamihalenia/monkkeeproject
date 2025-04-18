package utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("======================================== STARTING TEST {} ========================================\n", iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("======================================== FINISHED TEST {} Duration: {}s ========================================\n",
                iTestResult.getName(), getExecutionTime(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("======================================== FAILED TEST {} Duration: {}s ========================================\n",
                iTestResult.getName(), getExecutionTime(iTestResult));
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("======================================== SKIPPING TEST {} ========================================\n", iTestResult.getName());
        takeScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // Optional
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // Optional
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // Optional
    }

    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot() {
        try {
            File screenshot = Screenshots.takeScreenShotAsFile();
            if (screenshot != null && screenshot.exists()) {
                return Files.readAllBytes(screenshot.toPath());
            }
        } catch (IOException e) {
            log.error("Failed to attach screenshot to Allure report", e);
        }
        return new byte[0];
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(
                iTestResult.getEndMillis() - iTestResult.getStartMillis()
        );
    }
}