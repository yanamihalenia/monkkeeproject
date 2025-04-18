package waiters;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public class Waiter {
    public void waitForElementIsVisible(SelenideElement element, Duration timeout){
        element.should(Condition.visible, timeout);
    }
}
