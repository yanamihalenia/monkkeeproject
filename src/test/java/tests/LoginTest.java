package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "2. Login with valid data")
    public void successLoginTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        loginSteps.checkEnteriesPageOpened();
    }

    @Test(description = "3. Login with empty username")
    public void loginWithEmptyUsernameTest(){
        loginSteps.login("", PASSWORD, LOGIN_PAGE_URL);
        loginSteps.checkUsernameValidation();
    }

    @Test(description = "4. Login with empty password")
    public void loginWithEmptyPasswordTest(){
        loginSteps.login(USER, "", LOGIN_PAGE_URL);
        loginSteps.checkPasswordValidation();
    }

    @Test(description = "5. Login with empty username and password")
    public void loginWithEmptyFieldsTest(){
        loginSteps.login("", "", LOGIN_PAGE_URL);
        loginSteps.checkUsernameValidation();
        loginSteps.checkPasswordValidation();
    }
}
