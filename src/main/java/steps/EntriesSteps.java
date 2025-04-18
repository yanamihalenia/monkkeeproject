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
    public void createNewEntryAndCheckEntryIsCreated(String entryText){
        entriesPage
                .openFormForNewEntry()
                .fillEntryForm(entryText)
                .backToAllEntries();
        Assert.assertEquals(entriesPage.getEntryTextFromListOfEntries(), entryText);
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
                .checkEntryFromList(entryDescription)
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
    public void selectAllEntriesAndDelete(){
        entriesPage
                .checkAllEntries()
                .clickDeleteButton();
    }

    @Step("Check number of entries")
    public String checkNumberOfEntries(){
        String numOfEntriesInList = entriesPage.getNumOfEntries();
        return numOfEntriesInList;
    }

    @Step
    public void checkMessageWhenNoEntries() {
        Assert.assertTrue(entriesPage.getNotFoundEntriesMessage());
    }
}
