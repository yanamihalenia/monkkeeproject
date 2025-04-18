package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Input {
    public void fillField(SelenideElement inputElement, String value){
        inputElement.should(Condition.visible).clear();
        inputElement.sendKeys(value);
    }
}
