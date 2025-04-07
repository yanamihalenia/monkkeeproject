package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
    private static String EMAIL_INPUT = "#registration_email";
    private static String PASSWORD_INPUT = "#registration_password";
    private static String PASSWORD_CONFIRMATION_INPUT = "#registration_password_confirmation";
    private static String PASSWORD_HINT_INPUT = "#registration_password_hint";
    private static String AGREEMENT_CHECKBOX_FIRST = "#registration_terms_of_use";
    private static String AGREEMENT_CHECKBOX_SECOND = "#registration_lost_password_warning_registered";
    private static final String OK_BUTTON_XPATH = "//*[@type='submit']";

    public void fillRegisterForm(String email, String password, String passwordHint){
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(PASSWORD_CONFIRMATION_INPUT).sendKeys(password);
        $(PASSWORD_HINT_INPUT).sendKeys(passwordHint);
    }

    public void checkCheckbox(String checkbox){
        $(checkbox).click();
    }

    public void clickOK(){
        $x(OK_BUTTON_XPATH).click();
    }

    public void confirmRegister(){
        checkCheckbox(AGREEMENT_CHECKBOX_FIRST);
        checkCheckbox(AGREEMENT_CHECKBOX_SECOND);
        clickOK();
    }
}
