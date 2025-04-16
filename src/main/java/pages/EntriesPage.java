package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EntriesPage extends BasePage{
    private static final SelenideElement CREATE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='create-entry']");
    private static final SelenideElement DELETE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='delete-entries']");
    private static final SelenideElement CHECKBOX_SELECT_ALL = $x("//*[@class='entries__checkbox-wrapper']/input[@title='Select all']");
    private static final String CHECKBOX_SELECT_ONE = "//*[contains(text(),'%s')]/ancestor::*[@class='entries__entry-container clearfix ng-scope']//input";
    private static final SelenideElement MANAGE_TAGS_LINK = $x("//*[contains(text(),'Manage tags')]");
    private static final SelenideElement ENTRY_DESCRIPTION = $x("//*[@class='entries__entry']//*[@class=' entries__body']");


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
}
