package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final String USER_INPUT = "#login";
    private static final String PASSWORD_INPUT = "#password";
    private static final String LOGIN_BUTTON_XPATH = "//*[@type='submit']";
    private static final String REGISTER_LINK_XPATH = "(//*[@class='login__links']/a)[2]";

    public void login(String username, String password){
        $(USER_INPUT).sendKeys(username);
        $(PASSWORD_INPUT).sendKeys(password);
        $x(LOGIN_BUTTON_XPATH).click();
    }

    public RegisterPage openRegisterPage(){
        $x(REGISTER_LINK_XPATH).click();
        return new RegisterPage();
    }
}
