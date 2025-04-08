package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EntriesPage {
    private static final SelenideElement CREATE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='create-entry']");
    private static final SelenideElement DELETE_ENTRY_BUTTON = $x("//*[@class='btn-toolbar']/a[@id='delete-entries']");
    private static final SelenideElement CHECKBOX_SELECT_ALL = $x("//*[@class='entries__checkbox-wrapper']/input[@title='Select all']");
    private static final SelenideElement CHECKBOX_SELECT_ONE = $x("//*[@class='entries__checkbox-wrapper']/input[@ng-change='updateSelectionState()']");
    private static final SelenideElement MANAGE_TAGS_LINK = $x("//*[contains(text(),'Manage tags')]");
    private static final SelenideElement ENTRY_INPUT = $("#editable");

    public EntriesPage isCreateButtonVisible(){
        CREATE_ENTRY_BUTTON.shouldBe(Condition.visible);
        return this;
    }
}
