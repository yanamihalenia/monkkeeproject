package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class EditEntryPage extends BasePage{
    private static final SelenideElement BACK_TO_OVERVIEW_BUTTON = $("#back-to-overview");
    private static final SelenideElement ENTRY_INPUT = $("#editable");
    private static final SelenideElement SAVE_BUTTON = $x("//*[@class='cke_toolgroup']//*[contains(@title,'Save')]");
    private static final SelenideElement SETTINGS_OF_ENTRY_INPUT = $x("//*[@class='cke_top']");
    private static final SelenideElement INPUT_NEW_TAG = $("#new-tag");
    private static final SelenideElement NEW_TAG_OK_BUTTON = $x("//*[@ng-submit='createTag()']//*[@type='submit']");
    private static final SelenideElement CHANGE_DATE_TIME_LINK = $x("//*[@class='entry__date-wrapper']//*[contains(text(), 'Change date/time')]");
    private static final SelenideElement DATE_INPUT = $("#date");
    private static final SelenideElement CHANGE_DATE_OK_BUTTON = $x("//*[@ng-show='editDate']/button");
    private static final SelenideElement CLOSE_CALENDAR = $x("//*[@class='datepicker dropdown-menu']//*[@class='datepicker-close']");
    private static final SelenideElement ASSIGNED_TAG = $x("//*[@id='tags']//*[contains(@class,'entry__assigned-tags')]//a");

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

    public EditEntryPage setEntryDate(Integer year, Integer month, Integer day){
        CHANGE_DATE_TIME_LINK.click();
        LocalDate dateToSelect = LocalDate.of(year, month, day);
        datePicker.selectDate(dateToSelect, DATE_INPUT);
        button.clickButton(CLOSE_CALENDAR);
        button.clickButton(CHANGE_DATE_OK_BUTTON);
        return this;
    }

    public String getTagNameOnEditEntryPage(){
        try {
            log.info("Getting tag name on edit entry page");
            return ASSIGNED_TAG.getText();
        } catch (Exception e) {
            log.error("Failed to retrieve tag name on edit entry page", e);
            return "";
        }
    }
}
