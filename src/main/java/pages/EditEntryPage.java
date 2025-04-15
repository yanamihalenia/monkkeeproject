package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditEntryPage extends BasePage{
    private static final SelenideElement BACK_TO_OVERVIEW_BUTTON = $("#back-to-overview");
    private static final SelenideElement DELETE_ENTRY_BUTTON = $("#delete-entry");
    private static final SelenideElement ENTRY_INPUT = $("#editable");
    private static final SelenideElement SAVE_BUTTON = $x("//*[@class='cke_toolgroup']//*[contains(@class,'cke_button__savetoggle')]");

    public EditEntryPage fillEntryForm(String entryText){
        ENTRY_INPUT.click();
        input.fillField(ENTRY_INPUT, entryText);
        waiter.waitForButtonToBecomeDisabled(SAVE_BUTTON, Duration.ofSeconds(5));
        return this;
    }

    public EntriesPage backToAllEntries(){
        button.clickButton(BACK_TO_OVERVIEW_BUTTON);
        return new EntriesPage();
    }
}
