package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    public void initPages(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

    }
}
