package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class EntriesPage extends BasePage{
    private static final SelenideElement CREATE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='create-entry']");
    private static final SelenideElement DELETE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='delete-entries']");
    private static final SelenideElement CHECKBOX_SELECT_ALL = $x("//*[@class='entries__checkbox-wrapper']/input[@title='Select all']");
    private static final String CHECKBOX_SELECT_ONE = "//*[contains(text(),'%s')]/ancestor::*[@class='entries__entry-container clearfix ng-scope']//input";
    private static final SelenideElement MANAGE_TAGS_LINK = $x("//*[contains(text(),'Manage tags')]");
    private static final SelenideElement ENTRY_DESCRIPTION = $x("//*[@class='entries__entry']//*[@class=' entries__body']");
    private static final SelenideElement NUMBER_OF_ENTRIES = $x("//*[@class='pagination-section clearfix']//*[contains(@class,'pagination__num-of-entries')]");
    private static final SelenideElement NO_ENTRIES_MESSAGE = $x("//*[@class='content']//*[contains(@class,'entries__no-entries')]");


    public EntriesPage isCreateButtonVisible(){
        CREATE_ENTRY_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public EntriesPage isDeleteButtonDisabled(){
        DELETE_ENTRY_BUTTON.shouldHave(cssClass("disabled"));
        return this;
    }

    public EditEntryPage openFormForNewEntry(){
        button.clickButton(CREATE_ENTRY_BUTTON);
        return new EditEntryPage();
    }

    public String getEntryTextFromListOfEntries(){
        return ENTRY_DESCRIPTION.getText();
    }

    public EditEntryPage clickEntryDescription(){
        ENTRY_DESCRIPTION.click();
        return new EditEntryPage();
    }

    public EntriesPage checkEntryFromList(String entryDescription){
        $x(String.format(CHECKBOX_SELECT_ONE, entryDescription)).click();
        return this;
    }

    public void clickDeleteButton(){
        button.clickButton(DELETE_ENTRY_BUTTON);
        Selenide.switchTo().alert().accept();
        isDeleteButtonDisabled();
    }

    public EntriesPage checkAllEntries(){
        CHECKBOX_SELECT_ALL.click();
        return this;
    }

    public String getNumOfEntries(){
        try {
            log.info("Getting number of entries");
            return NUMBER_OF_ENTRIES.getText();
        } catch (Exception e) {
            log.error("Failed to get number of entries", e);
            return "";
        }
    }

    public boolean getNotFoundEntriesMessage(){
//        NO_ENTRIES_MESSAGE.shouldBe(Condition.visible);
//        return true;
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
