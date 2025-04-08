package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage {
    private static SelenideElement LOGOUT_BUTTON_XPATH = $x("//*[@class='user-menu__btn']//*[contains(text(),'Logout')]");
    private static SelenideElement SETTINGS_BUTTON = $("");

    public boolean isLogoutDisplayed(){
        return LOGOUT_BUTTON_XPATH.should(Condition.exist, Duration.ofSeconds(1)).isDisplayed();
    }
}
