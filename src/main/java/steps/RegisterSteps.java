package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class RegisterSteps {
    private LoginPage loginPage;

    public RegisterSteps(){
        loginPage = new LoginPage();
    }

    @Step("Fill register form and confirm it")
    public void registerUser(String email, String password, String passwordHint){
        loginPage.goToRegisterPage()
                .fillRegisterForm(email, password, passwordHint)
                .confirmRegister()
                .checkUserRegisterText();
    }
}
