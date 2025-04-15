package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.EntriesSteps;
import steps.LoginSteps;
import steps.RegisterSteps;
import utils.PropertyReader;
import waiters.Waiter;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest implements IConstants {
    HomePage homePage;
    LoginPage loginPage;
    LoginSteps loginSteps;
    RegisterPage registerPage;
    RegisterSteps registerSteps;
    EntriesPage entriesPage;
    HeaderPage headerPage;
    EditEntryPage editEntryPage;
    Waiter waiter;
    EntriesSteps entriesSteps;
    Faker faker = new Faker();

    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");

    public void initPages(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        loginSteps = new LoginSteps();
        registerPage = new RegisterPage();
        registerSteps = new RegisterSteps();
        entriesPage = new EntriesPage();
        headerPage = new HeaderPage();
        editEntryPage = new EditEntryPage();
        waiter = new Waiter();
        entriesSteps = new EntriesSteps();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest(){
        getWebDriver().quit();
    }
}
