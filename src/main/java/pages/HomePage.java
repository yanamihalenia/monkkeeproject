package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{
    public static final SelenideElement LOGIN_BUTTON = $x("//a[text()='Login']");

    public LoginPage openLoginPage(){
        button.clickButton(LOGIN_BUTTON);
        return new LoginPage();
    }
}
