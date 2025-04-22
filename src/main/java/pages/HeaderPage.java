package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage extends BasePage{
    private static final SelenideElement LOGOUT_BUTTON = $x("//*[contains(text(),'Logout')]");
    private static final SelenideElement SETTINGS_BUTTON = $x("//*[contains(text(),'Settings')]");
    private static final SelenideElement LANGUAGE_DROPDOWN = $("#locale-menu");

    public void goToSettings(){
        button.clickButton(SETTINGS_BUTTON);
    }

    public LoginPage clickLogout(){
        button.clickButton(LOGOUT_BUTTON);
        waiter.waitForElementIsVisible(LANGUAGE_DROPDOWN, Duration.ofSeconds(2));
        return new LoginPage();
    }
}
