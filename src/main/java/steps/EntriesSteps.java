package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.EditEntryPage;
import pages.EntriesPage;

public class EntriesSteps {
    private EntriesPage entriesPage;
    private EditEntryPage editEntryPage;

    public EntriesSteps(){
        entriesPage = new EntriesPage();
        editEntryPage = new EditEntryPage();
    }

    @Step("Create entry and check it in the list of all entries")
    public void createNewEntryAndCheckEntryIsCreated(String entryText){
        entriesPage.openFormForNewEntry();
        editEntryPage.fillEntryForm(entryText);
        editEntryPage.backToAllEntries();
        Assert.assertEquals(entriesPage.getEntryTextFromListOfEntries(), entryText);
    }

    @Step("Update entry and check it in the list of all entries")
    public void updateEntryAndCheckEntryIsUpdated(String entryText){
        String originalEntryText = entriesPage.getEntryTextFromListOfEntries();
        entriesPage.clickEntryDescription();
        editEntryPage.fillEntryForm(entryText);
        editEntryPage.backToAllEntries();
        String changedEntryText = entriesPage.getEntryTextFromListOfEntries();
        Assert.assertEquals(changedEntryText, originalEntryText + entryText);
    }

    @Step("Check and delete entry by description")
    public void checkAndDeleteEntryByDescription(String entryDescription){
        entriesPage.checkEntryFromList(entryDescription);
        entriesPage.clickDeleteButton();
    }

    @Step("Create and delete an entry")
    public void createAndDeleteEntry(String entryText){
        entriesPage.openFormForNewEntry();
        editEntryPage.fillEntryForm(entryText);
        editEntryPage.backToAllEntries();
        checkAndDeleteEntryByDescription(entryText);
        String lastEntryDescription = entriesPage.getEntryTextFromListOfEntries();
        Assert.assertNotEquals(lastEntryDescription, entryText);
    }
}
