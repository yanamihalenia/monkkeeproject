package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    private static final String USER_INPUT = "#login";
    private static final String PASSWORD_INPUT = "#password";
    private static final String LOGIN_BUTTON_XPATH = "//*[@type='submit']";
    private static final String REGISTER_LINK_XPATH = "(//*[@class='login__links']/a)[2]";
    private static final String ERROR_MESSAGE_USER_XPATH = "//*[@id='login']/../div";
    private static final String ERROR_MESSAGE_PASSWORD_XPATH = "//*[@for='password']/../div/div[@class='help-block ng-binding']";


    public EntriesPage login(String username, String password, String url){
        open(url);
        $(USER_INPUT).sendKeys(username);
        $(PASSWORD_INPUT).sendKeys(password);
        $x(LOGIN_BUTTON_XPATH).click();
        return new EntriesPage();
    }

    public void openLoginPage(String url){
        open(url);
    }

    public RegisterPage goToRegisterPage(){
        openLoginPage(LOGIN_PAGE_URL);
        $x(REGISTER_LINK_XPATH).click();
        return new RegisterPage();
    }

    public String getUsernameErrorMessageText(){
        return $x(ERROR_MESSAGE_USER_XPATH).getText();
    }

    public String getPasswordErrorMessageText(){
        return $x(ERROR_MESSAGE_PASSWORD_XPATH).getText();
    }
}
