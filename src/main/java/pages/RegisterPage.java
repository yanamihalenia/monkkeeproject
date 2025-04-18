package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Checkbox;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage extends BasePage{
    private static final SelenideElement EMAIL_INPUT = $("#registration_email");
    private static final SelenideElement PASSWORD_INPUT = $("#registration_password");
    private static final SelenideElement PASSWORD_CONFIRMATION_INPUT = $("#registration_password_confirmation");
    private static final SelenideElement PASSWORD_HINT_INPUT = $("#registration_password_hint");
    private static final String AGREEMENT_CHECKBOX_FIRST = "registration_terms_of_use";
    private static final String AGREEMENT_CHECKBOX_SECOND = "registration_lost_password_warning_registered";
    private static final SelenideElement OK_BUTTON_XPATH = $x("//*[@type='submit']");
    private static final SelenideElement USER_REGISTERED_TEXT_XPATH = $x("//*[contains(text(),'User registered')]");

    public RegisterPage fillRegisterForm(String email, String password, String passwordHint){
        input.fillFieldWithClear(EMAIL_INPUT, email);
        input.fillFieldWithClear(PASSWORD_INPUT, password);
        input.fillFieldWithClear(PASSWORD_CONFIRMATION_INPUT, password);
        input.fillFieldWithClear(PASSWORD_HINT_INPUT, passwordHint);
        return this;
    }

    public RegisterPage confirmRegister(){
        new Checkbox(AGREEMENT_CHECKBOX_FIRST).setCheckboxValue(true);
        new Checkbox(AGREEMENT_CHECKBOX_SECOND).setCheckboxValue(true);
        button.clickButton(OK_BUTTON_XPATH);
        return new RegisterPage();
    }

    public RegisterPage checkUserRegisterText(){
        USER_REGISTERED_TEXT_XPATH.shouldBe(Condition.visible);
        return this;
    }
}
