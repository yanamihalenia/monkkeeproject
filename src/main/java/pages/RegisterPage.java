package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage extends BasePage{
    private static final SelenideElement EMAIL_INPUT = $("#registration_email");
    private static final SelenideElement PASSWORD_INPUT = $("#registration_password");
    private static final SelenideElement PASSWORD_CONFIRMATION_INPUT = $("#registration_password_confirmation");
    private static final SelenideElement PASSWORD_HINT_INPUT = $("#registration_password_hint");
    private static final SelenideElement AGREEMENT_CHECKBOX_FIRST = $("#registration_terms_of_use");
    private static final SelenideElement AGREEMENT_CHECKBOX_SECOND = $("#registration_lost_password_warning_registered");
    private static final SelenideElement OK_BUTTON_XPATH = $x("//*[@type='submit']");

    public void fillRegisterForm(String email, String password, String passwordHint){
        input.fillField(EMAIL_INPUT, email);
        input.fillField(PASSWORD_INPUT, password);
        input.fillField(PASSWORD_CONFIRMATION_INPUT, password);
        input.fillField(PASSWORD_HINT_INPUT, passwordHint);
    }

    public void confirmRegister(){
        checkbox.checkCheckbox(AGREEMENT_CHECKBOX_FIRST);
        checkbox.checkCheckbox(AGREEMENT_CHECKBOX_SECOND);
        button.clickButton(OK_BUTTON_XPATH);
    }
}
