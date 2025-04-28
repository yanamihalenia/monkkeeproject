package steps;

import com.codeborne.selenide.WebDriverRunner;
import constants.IConstants;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.EntriesPage;
import pages.HeaderPage;
import pages.LoginPage;

public class LoginSteps implements IConstants {
    private LoginPage loginPage;
    private EntriesPage entriesPage;
    private HeaderPage headerPage;

    public LoginSteps(){
        loginPage = new LoginPage();
        entriesPage = new EntriesPage();
        headerPage = new HeaderPage();
    }

    @Step("Fill login/password and click Login")
    public void login(String username, String password, String url){
        loginPage.login(username, password, url);
    }

    @Step("Check Entries page opened after login")
    public void checkEntriesPageOpened(){
        entriesPage.isCreateButtonVisible();
    }

    @Step("Logout and check user is on login page")
    public void logoutAndCheckLoginPage(){
        headerPage.clickLogout();
        String currentUrl = WebDriverRunner.url();
        Assert.assertEquals(currentUrl, LOGIN_PAGE_URL);
    }

    @Step("Check username validation message (mandatory field)")
    public void checkUsernameValidation(){
        Assert.assertEquals(loginPage.getUsernameErrorMessageText(), ERROR_TEXT_MESSAGE);
    }

    @Step("Check password validation message (mandatory field)")
    public void checkPasswordValidation(){
        Assert.assertEquals(loginPage.getPasswordErrorMessageText(), ERROR_TEXT_MESSAGE);
    }
}
