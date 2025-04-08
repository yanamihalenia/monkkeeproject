package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterSteps {
    private RegisterPage registerPage;
    private LoginPage loginPage;

    public RegisterSteps(){
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
    }

    @Step("Fill register form and confirm it")
    public void registerUser(String email, String password, String passwordHint){
        loginPage.goToRegisterPage()
                .fillRegisterForm(email, password, passwordHint)
                .confirmRegister();
    }
}
