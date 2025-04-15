package waiters;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;

public class Waiter {

    public void waitForElementIsVisible(SelenideElement element, Duration timeout){
        element.shouldBe(Condition.visible, timeout);
    }

    public void waitForButtonToBecomeDisabled(SelenideElement button, Duration timeout) {
        button.shouldHave(cssClass("cke_button_disabled"), timeout);
    }
}
