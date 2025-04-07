package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    public static final String ERROR_TEXT_MESSAGE = "Mandatory field";

    @Test(description = "2. Login with valid data")
    public void successLoginTest(){
        loginPage.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
    }

    @Test(description = "3. Login with empty username")
    public void loginWithEmptyUsernameTest(){
        loginPage.login("", PASSWORD, IConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getUsernameErrorMessageText(), ERROR_TEXT_MESSAGE);
    }

    @Test(description = "4. Login with empty password")
    public void loginWithEmptyPasswordTest(){
        loginPage.login(USER, "", IConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getPasswordErrorMessageText(), ERROR_TEXT_MESSAGE);
    }
}
