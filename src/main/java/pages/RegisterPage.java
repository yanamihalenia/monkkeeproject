package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Checkbox;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage extends BasePage{
    private static final SelenideElement EMAIL_INPUT = $("#registration_email");
    private static final SelenideElement PASSWORD_INPUT = $("#registration_password");
    private static final SelenideElement PASSWORD_CONFIRMATION_INPUT = $("#registration_password_confirmation");
    private static final SelenideElement PASSWORD_HINT_INPUT = $("registration_password_hint");
    private static final String AGREEMENT_CHECKBOX_FIRST = "registration_terms_of_use";
    private static final String AGREEMENT_CHECKBOX_SECOND = "registration_lost_password_warning_registered";
    private static final SelenideElement OK_BUTTON_XPATH = $x("//*[@type='submit']");

    public RegisterPage fillRegisterForm(String email, String password, String passwordHint){
        input.fillField(EMAIL_INPUT, email);
        input.fillField(PASSWORD_INPUT, password);
        input.fillField(PASSWORD_CONFIRMATION_INPUT, password);
        input.fillField(PASSWORD_HINT_INPUT, passwordHint);
        return this;
    }

    public void confirmRegister(){
        new Checkbox(AGREEMENT_CHECKBOX_FIRST).setCheckboxValue(true);
        new Checkbox(AGREEMENT_CHECKBOX_SECOND).setCheckboxValue(true);
        button.clickButton(OK_BUTTON_XPATH);
    }
}
