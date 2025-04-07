package pages;

public class EntriesPage {
    private static final String CREATE_ENTRY_BUTTON_XPATH = "//*[@class='btn-toolbar']/a[@id='create-entry']";
    private static final String DELETE_ENTRY_BUTTON_XPATH = "//*[@class='btn-toolbar']/a[@id='delete-entries']";
    private static final String CHECKBOX_SELECT_ALL_XPATH = "//*[@class='entries__checkbox-wrapper']/input[@title='Select all']";
    private static final String CHECKBOX_SELECT_ONE_XPATH = "//*[@class='entries__checkbox-wrapper']/input[@ng-change='updateSelectionState()']";
    private static final String MANAGE_TAGS_XPATH = "//*[contains(text(), 'Manage tags')]";
    private static final String ENTRY_INPUT = "#editable";
}
