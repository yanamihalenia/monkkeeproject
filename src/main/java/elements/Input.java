package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Input {
    public void fillFieldWithClear(SelenideElement inputElement, String value){
        inputElement.should(Condition.visible).clear();
        inputElement.sendKeys(value);
    }

    public void fillField(SelenideElement inputElement, String value){
        inputElement.should(Condition.visible);
        inputElement.sendKeys(value);
    }
}
