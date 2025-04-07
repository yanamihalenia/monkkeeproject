package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.EntriesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    EntriesPage entriesPage;

    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");

    public void initPages(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        entriesPage = new EntriesPage();
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
