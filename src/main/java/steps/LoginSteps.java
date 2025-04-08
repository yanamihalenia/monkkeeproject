package steps;

import io.qameta.allure.Step;
import pages.EntriesPage;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;
    private EntriesPage entriesPage;

    public LoginSteps(){
        loginPage = new LoginPage();
        entriesPage = new EntriesPage();
    }

    @Step
    public void fillAndConfirmLoginForm(String username, String password, String url){
        loginPage.login(username, password, url);
        entriesPage.isCreateButtonVisible();
    }
}
