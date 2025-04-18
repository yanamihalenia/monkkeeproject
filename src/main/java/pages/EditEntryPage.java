package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditEntryPage extends BasePage{
    private static final SelenideElement BACK_TO_OVERVIEW_BUTTON = $("#back-to-overview");
    private static final SelenideElement DELETE_ENTRY_BUTTON = $("#delete-entry");
    private static final SelenideElement ENTRY_INPUT = $("#editable");
    private static final SelenideElement SAVE_BUTTON = $x("//*[@class='cke_toolgroup']//*[contains(@title,'Save')]");
    private static final SelenideElement SETTINGS_OF_ENTRY_INPUT = $x("//*[@class='cke_top']");
    private static final SelenideElement INPUT_NEW_TAG = $("#new-tag");
    private static final SelenideElement NEW_TAG_OK_BUTTON = $x("//*[@ng-submit='createTag()']//*[@type='submit']");


    public EditEntryPage fillEntryForm(String entryText){
        ENTRY_INPUT.click();
        waiter.waitForElementIsVisible(SETTINGS_OF_ENTRY_INPUT, Duration.ofSeconds(3));
        input.fillField(ENTRY_INPUT, entryText);
        button.clickButton(SAVE_BUTTON);
        return this;
    }

    public EntriesPage backToAllEntries(){
        button.clickButton(BACK_TO_OVERVIEW_BUTTON);
        return new EntriesPage();
    }

    public EditEntryPage createNewTag(String tagName){
        input.fillField(INPUT_NEW_TAG, tagName);
        button.clickButton(NEW_TAG_OK_BUTTON);
        return this;
    }
}
