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
        entriesPage.openFormForNewEntry();
        editEntryPage.fillEntryForm(entryText);
        editEntryPage.backToAllEntries();
        Assert.assertEquals(entriesPage.getEntryTextFromListOfEntries(), entryText);
    }

    @Step("Get entry text")
    public void getEntryText(){
        entriesPage.getEntryTextFromListOfEntries();
    }
}
