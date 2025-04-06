package pages;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public static final String LOGIN_BUTTON_XPATH = "//a[text()='Login']";

    public LoginPage openLoginPage(){
        $x(LOGIN_BUTTON_XPATH).click();
        return new LoginPage();
    }
}
