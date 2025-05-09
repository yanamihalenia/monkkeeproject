package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class EntriesPage extends BasePage{
    private static final SelenideElement CREATE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='create-entry']");
    private static final SelenideElement DELETE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='delete-entries']");
    private static final SelenideElement CHECKBOX_SELECT_ALL = $x("//*[@class='entries__checkbox-wrapper']/input[@title='Select all']");
    private static final String CHECKBOX_SELECT_ONE = "//*[contains(text(),'%s')]/ancestor::*[@class='entries__entry-container clearfix ng-scope']//input";
    private static final SelenideElement ENTRY_DESCRIPTION = $x("//*[@class='entries__entry']//*[@class=' entries__body']");
    private static final SelenideElement NUMBER_OF_ENTRIES = $x("//*[@class='pagination-section clearfix']//*[contains(@class,'pagination__num-of-entries')]");
    private static final SelenideElement NO_ENTRIES_MESSAGE = $x("//*[@class='content']//*[contains(@class,'entries__no-entries')]");
    private static final SelenideElement SEARCH_INPUT = $("#appendedInputButton");
    private static final SelenideElement SEARCH_BUTTON = $x("//*[@title='Search']");
    private static final SelenideElement RESET_LINK = $("#reset-search");
    private static final SelenideElement ENTRY_TAG_NAME = $x("//*[@class='entries']//*[contains(@class,'entries__tags')]/span");
    private static final SelenideElement ENTRY_FULL_DATE = $x("//*[@class='entries__checkbox-datetime-wrapper']/div[contains(@class,'entries__full-date')]");
    /**
     * Check Create button is visible.
     *
     * @return the Entries page
     */
    public EntriesPage isCreateButtonVisible(){
        CREATE_ENTRY_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Check Delete button is disabled.
     *
     * @return the Entries page
     */
    public EntriesPage isDeleteButtonDisabled(){
        DELETE_ENTRY_BUTTON.shouldHave(cssClass("disabled"));
        return this;
    }

    /**
     * Open new entry form.
     *
     * @return the Entries page
     */
    public EditEntryPage openFormForNewEntry(){
        button.clickButton(CREATE_ENTRY_BUTTON);
        return new EditEntryPage();
    }

    /**
     * Reset filter.
     */
    public void clickReset(){
        button.clickButton(RESET_LINK);
    }

    /**
     * Wait Reset become visible.
     */
    public void waitResetIsVisible(){
        waiter.waitForElementIsVisible(RESET_LINK, Duration.ofSeconds(3));
    }

    /**
     * Wait Create become visible.
     */
    public void waitCreateButtonIsVisible(){
        waiter.waitForElementIsVisible(CREATE_ENTRY_BUTTON, Duration.ofSeconds(3));
    }

    /**
     * Get entry text from Entries list.
     */
    public String getEntryTextFromListOfEntries(){
        try {
            log.info("Getting entry description from list of entries");
            return ENTRY_DESCRIPTION.getText();
        } catch (Exception e) {
            log.error("Failed to get entry description", e);
            return "";
        }
    }

    /**
     * Click entry description.
     *
     * @return the Entry edit page
     */
    public EditEntryPage clickEntryDescription(){
        ENTRY_DESCRIPTION.click();
        return new EditEntryPage();
    }

    /**
     * Select checkbox near entry by entry description.
     *
     * @return the Entry edit page
     */
    public EntriesPage selectEntryFromList(String entryDescription){
        $x(String.format(CHECKBOX_SELECT_ONE, entryDescription)).click();
        return this;
    }

    /**
     * Get entry date and time.
     */
    public String getEntryDateTime(){
        isCreateButtonVisible();
        return ENTRY_FULL_DATE.getText();
    }

    /**
     * Click Delete button.
     */
    public void clickDeleteButton(){
        button.clickButton(DELETE_ENTRY_BUTTON);
        Selenide.switchTo().alert().accept();
        isDeleteButtonDisabled();
    }

    /**
     * Get Tag name from entry description.
     */
    public String getTagNameFromDescription(){
        try {
            log.info("Getting tag name from entry description");
            return ENTRY_TAG_NAME.getText();
        }catch (Exception e) {
            log.warn("Failed to get tag name from entry description", e);
            return "";
        }
    }

    /**
     * Select All entries checkbox.
     *
     * @return the Entries page
     */
    public EntriesPage checkAllEntries(){
        CHECKBOX_SELECT_ALL.click();
        return this;
    }

    /**
     * Fill Search field.
     */
    public void fillSearchField(String textSearch){
        input.fillField(SEARCH_INPUT, textSearch);
    }

    /**
     * Click Search button.
     */
    public void clickSearch(){
        button.clickButton(SEARCH_BUTTON);
    }

    /**
     * Get number of entries from pagination.
     */
    public String getNumOfEntries(){
        try {
            log.info("Getting number of entries");
            return NUMBER_OF_ENTRIES.getText();
        } catch (Exception e) {
            log.error("Failed to get number of entries", e);
            return "";
        }
    }

    /**
     * Check 'Not found Entries' message displayed.
     */
    public boolean isNotFoundEntriesMessageDisplay(){
        try {
            log.info("Checking 'No entries found' message");
            NO_ENTRIES_MESSAGE.shouldBe(Condition.visible);
            return true;
        }catch (Exception e) {
            log.warn("'No entries found' message is hidden", e);
            return false;
        }
    }
}
