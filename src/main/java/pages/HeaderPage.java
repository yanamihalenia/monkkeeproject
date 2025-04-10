package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage {
    private static final SelenideElement LOGOUT_BUTTON = $x("//*[contains(text(),'Logout')]");
    private static final SelenideElement SETTINGS_BUTTON = $x("//*[contains(text(),'Settings')]");

    public boolean isLogoutDisplayed(){
        return LOGOUT_BUTTON.isDisplayed();
    }
}
