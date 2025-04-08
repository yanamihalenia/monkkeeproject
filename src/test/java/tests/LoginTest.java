package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "2. Login with valid data")
    public void successLoginTest(){
        loginSteps.fillAndConfirmLoginForm(USER, PASSWORD, LOGIN_PAGE_URL);
    }

    @Test(description = "3. Login with empty username")
    public void loginWithEmptyUsernameTest(){
        loginSteps.fillAndConfirmLoginForm("", PASSWORD, LOGIN_PAGE_URL);
        loginSteps.checkUsernameValidation();
    }

    @Test(description = "4. Login with empty password")
    public void loginWithEmptyPasswordTest(){
        loginSteps.fillAndConfirmLoginForm(USER, "", LOGIN_PAGE_URL);
        loginSteps.checkPasswordValidation();
    }

    @Test(description = "5. Login with empty username and password")
    public void loginWithEmptyFieldsTest(){
        loginSteps.fillAndConfirmLoginForm("", "", LOGIN_PAGE_URL);
        loginSteps.checkUsernameValidation();
        loginSteps.checkPasswordValidation();
    }
}
