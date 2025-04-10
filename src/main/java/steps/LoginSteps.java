package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.EntriesPage;
import pages.LoginPage;

public class LoginSteps implements IConstants {
    private LoginPage loginPage;
    private EntriesPage entriesPage;

    public LoginSteps(){
        loginPage = new LoginPage();
        entriesPage = new EntriesPage();
    }

    @Step
    public void login(String username, String password, String url){
        loginPage.login(username, password, url);
    }

    @Step("Check Enteries page opened after login")
    public void checkEnteriesPageOpened(){
        entriesPage.isCreateButtonVisible();
    }

    @Step
    public void checkUsernameValidation(){
        Assert.assertEquals(loginPage.getUsernameErrorMessageText(), ERROR_TEXT_MESSAGE);
    }

    @Step
    public void checkPasswordValidation(){
        Assert.assertEquals(loginPage.getPasswordErrorMessageText(), ERROR_TEXT_MESSAGE);
    }
}
