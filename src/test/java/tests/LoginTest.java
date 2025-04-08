package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{
    public static final String ERROR_TEXT_MESSAGE = "Mandatory field";
    SoftAssert softAssert = new SoftAssert();

    @Test(description = "2. Login with valid data")
    public void successLoginTest(){
        loginPage.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
//        Assert.assertEquals(loginPage.getCurrentUrl(), LIST_OF_ENTRIES_URL);
//        Assert.assertTrue(headerPage.isLogoutDisplayed(), "Logout button is not found");
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

    @Test(description = "5. Login with empty username and password")
    public void loginWithEmptyFieldsTest(){
        loginPage.login("", "", IConstants.LOGIN_PAGE_URL);
        softAssert.assertEquals(loginPage.getUsernameErrorMessageText(), ERROR_TEXT_MESSAGE);
        softAssert.assertEquals(loginPage.getPasswordErrorMessageText(), ERROR_TEXT_MESSAGE);
        softAssert.assertAll();
    }
}
