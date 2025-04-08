package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{
    public static final String ERROR_TEXT_MESSAGE = "Mandatory field";
    SoftAssert softAssert = new SoftAssert();

    @Test(description = "2. Login with valid data")
    public void successLoginTest(){
        loginSteps.fillAndConfirmLoginForm(USER, PASSWORD, LOGIN_PAGE_URL);
    }

    @Test(description = "3. Login with empty username")
    public void loginWithEmptyUsernameTest(){
        loginSteps.fillAndConfirmLoginForm("", PASSWORD, LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getUsernameErrorMessageText(), ERROR_TEXT_MESSAGE);
    }

    @Test(description = "4. Login with empty password")
    public void loginWithEmptyPasswordTest(){
        loginSteps.fillAndConfirmLoginForm(USER, "", LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getPasswordErrorMessageText(), ERROR_TEXT_MESSAGE);
    }

    @Test(description = "5. Login with empty username and password")
    public void loginWithEmptyFieldsTest(){
        loginSteps.fillAndConfirmLoginForm("", "", LOGIN_PAGE_URL);
        softAssert.assertEquals(loginPage.getUsernameErrorMessageText(), ERROR_TEXT_MESSAGE);
        softAssert.assertEquals(loginPage.getPasswordErrorMessageText(), ERROR_TEXT_MESSAGE);
        softAssert.assertAll();
    }
}
