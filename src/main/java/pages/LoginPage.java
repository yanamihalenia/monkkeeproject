package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    private static final SelenideElement USER_INPUT = $("#login");
    private static final SelenideElement PASSWORD_INPUT = $("#password");
    private static final SelenideElement LOGIN_BUTTON = $x("//*[@type='submit']");
    private static final SelenideElement REGISTER_LINK_XPATH = $x("(//*[@class='login__links']/a)[2]");
    private static final SelenideElement ERROR_MESSAGE_USER_XPATH = $x("//*[@class='help-block ng-binding']");
    private static final SelenideElement ERROR_MESSAGE_PASSWORD_XPATH = $x("(//*[@class='help-block ng-binding'])[2]");

    /**
     * Fill username, password and click Login button.
     *
     * @return the Entries page
     */
    public EntriesPage login(String username, String password, String url){
        open(url);
        input.fillFieldWithClear(USER_INPUT, username);
        input.fillFieldWithClear(PASSWORD_INPUT, password);
        button.clickButton(LOGIN_BUTTON);
        return new EntriesPage();
    }

    /**
     * Open Login page by URL.
     *
     * @return the Login page
     */
    public LoginPage openLoginPage(String url){
        open(url);
        return new LoginPage();
    }

    /**
     * Open Register page from Login page.
     *
     * @return the Login page
     */
    public RegisterPage goToRegisterPage(){
        openLoginPage(LOGIN_PAGE_URL);
        REGISTER_LINK_XPATH.click();
        return new RegisterPage();
    }

    /**
     * Get username validation error message.
     */
    public String getUsernameErrorMessageText() {
        try {
            log.info("Getting username error message text.");
            return ERROR_MESSAGE_USER_XPATH.getText();
        } catch (Exception e) {
            log.error("Failed to get username error message.", e);
            return "";
        }
    }

    /**
     * Get password validation error message.
     */
    public String getPasswordErrorMessageText() {
        try {
            log.info("Getting password error message text.");
            return ERROR_MESSAGE_PASSWORD_XPATH.getText();
        } catch (Exception e) {
            log.error("Failed to get password error message.", e);
            return "";
        }
    }
}
