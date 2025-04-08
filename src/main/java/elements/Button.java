package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

public class Button {
    public void clickButton(SelenideElement selenideElement){
        selenideElement.click();
    }
}
