package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    private static final SelenideElement USER_INPUT = $("#login");
    private static final SelenideElement PASSWORD_INPUT = $("#password");
    private static final SelenideElement LOGIN_BUTTON = $x("//*[@type='submit']");
    private static final String REGISTER_LINK_XPATH = "(//*[@class='login__links']/a)[2]";
    private static final SelenideElement ERROR_MESSAGE_USER_XPATH = $x("//*[@id='login']/../div");
    private static final SelenideElement ERROR_MESSAGE_PASSWORD_XPATH = $x("//*[@for='password']/../div/div[@class='help-block ng-binding']");

    public EntriesPage login(String username, String password, String url){
        open(url);
        input.fillField(USER_INPUT, username);
        input.fillField(PASSWORD_INPUT, password);
        button.clickButton(LOGIN_BUTTON);
        return new EntriesPage();
    }

    public LoginPage openLoginPage(String url){
        open(url);
        return new LoginPage();
    }

    public RegisterPage goToRegisterPage(){
        openLoginPage(LOGIN_PAGE_URL);
        $x(REGISTER_LINK_XPATH).click();
        return new RegisterPage();
    }

    public String getUsernameErrorMessageText() {
        try {
            log.info("Getting username error message text.");
            return ERROR_MESSAGE_USER_XPATH.getText();
        } catch (Exception e) {
            log.error("Failed to get username error message.", e);
            return "";
        }
    }

    public String getPasswordErrorMessageText() {
        try {
            log.info("Getting password error message text.");
            return ERROR_MESSAGE_PASSWORD_XPATH.getText();
        } catch (Exception e) {
            log.error("Failed to get password error message.", e);
            return "";
        }
    }

    public String getCurrentUrl(){
        return WebDriverRunner.url();
    }
}
