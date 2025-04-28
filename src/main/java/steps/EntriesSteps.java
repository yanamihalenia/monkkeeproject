package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.EditEntryPage;
import pages.EntriesPage;

public class EntriesSteps implements IConstants {
    private EntriesPage entriesPage;
    private EditEntryPage editEntryPage;

    public EntriesSteps(){
        entriesPage = new EntriesPage();
        editEntryPage = new EditEntryPage();
    }

    @Step("Create entry and check it in the list of all entries")
    public EntriesSteps createNewEntryAndCheckEntryIsCreated(String entryText){
        entriesPage
                .openFormForNewEntry()
                .fillEntryForm(entryText)
                .backToAllEntries();
        Assert.assertEquals(entriesPage.getEntryTextFromListOfEntries(), entryText);
        return this;
    }

    @Step("Create entry and stay on Edit page")
    public void createEntry(String entryText){
        entriesPage
                .openFormForNewEntry()
                .fillEntryForm(entryText);
    }

    @Step("Update entry and check it in the list of all entries")
    public void updateEntryAndCheckEntryIsUpdated(String entryText){
        String originalEntryText = entriesPage.getEntryTextFromListOfEntries();
        entriesPage
                .clickEntryDescription()
                .fillEntryForm(entryText)
                .backToAllEntries();
        String changedEntryText = entriesPage.getEntryTextFromListOfEntries();
        Assert.assertEquals(changedEntryText, originalEntryText + entryText);
    }

    @Step("Check and delete entry by description")
    public void selectAndDeleteEntryByDescription(String entryDescription){
        entriesPage
                .selectEntryFromList(entryDescription)
                .clickDeleteButton();
    }

    @Step("Create and delete an entry")
    public void createAndDeleteEntry(String entryText){
        entriesPage
                .openFormForNewEntry()
                .fillEntryForm(entryText)
                .backToAllEntries();
        selectAndDeleteEntryByDescription(entryText);
        String lastEntryDescription = entriesPage.getEntryTextFromListOfEntries();
        Assert.assertNotEquals(lastEntryDescription, entryText);
    }

    @Step("Select all entries and delete")
    public EntriesSteps selectAllEntriesAndDelete(){
        entriesPage
                .checkAllEntries()
                .clickDeleteButton();
        return this;
    }

    @Step("Check number of entries")
    public String checkNumberOfEntries(){
        return entriesPage.getNumOfEntries();
    }

    @Step("Check message when no entries")
    public void checkMessageWhenNoEntries() {
        Assert.assertTrue(entriesPage.isNotFoundEntriesMessageDisplay());
    }

    @Step("Search entry")
    public void fillSearchAndClickSearch(String textSearch){
        entriesPage.fillSearchField(textSearch);
        entriesPage.clickSearch();
        entriesPage.waitResetIsVisible();
    }

    @Step("Reset search")
    public void resetSearch(){
        entriesPage.clickReset();
        entriesPage.waitCreateButtonIsVisible();
    }

    @Step("Check tag assigned to entry")
    public void checkTagAssignedToEntry(){
        String tagNameOnEdit = editEntryPage.getTagNameOnEditEntryPage();
        editEntryPage.backToAllEntries();
        String tagNameOnAllEntries = entriesPage.getTagNameFromDescription();
        Assert.assertEquals(tagNameOnEdit, tagNameOnAllEntries);
    }

    @Step("Click on entry description to open edit entry page")
    public void changeEntryDate(Integer year, Integer month, Integer day){
        entriesPage.clickEntryDescription();
        editEntryPage.setEntryDate(year, month, day);
        editEntryPage.backToAllEntries();
    }
}
