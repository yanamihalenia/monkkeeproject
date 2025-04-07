package tests;

import constants.IConstants;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "2. Login with valid data")
    public void successLoginTest(){
        loginPage.login(USER, PASSWORD, IConstants.LOGIN_PAGE_URL);
    }
}
