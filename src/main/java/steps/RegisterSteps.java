package steps;

import io.qameta.allure.Step;
import pages.RegisterPage;

public class RegisterSteps {
    private RegisterPage registerPage;

    public RegisterSteps(){
        registerPage = new RegisterPage();
    }

    @Step("Fill register form and confirm it")
    public void registerUser(String email, String password, String passwordHint){
        registerPage.fillRegisterForm(email, password, passwordHint);
        registerPage.confirmRegister();
    }
}
