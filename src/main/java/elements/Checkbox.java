package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Checkbox {
    public void checkCheckbox(SelenideElement selenideElement){
        $(selenideElement).click();
    }
}
