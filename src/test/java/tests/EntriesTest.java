package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Slf4j
public class EntriesTest extends BaseTest{

    @Test(description = "6. Create an entry", groups = "afterMethodGroup")
    public void createNewEntryTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
    }

    @Test(description = "7. Update an entry", groups = "afterMethodGroup")
    public void updateEntryTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
        entriesSteps.updateEntryAndCheckEntryIsUpdated(faker.animal().name());
    }

    @Test(description = "8. Delete an entry")
    public void deleteEntryTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createAndDeleteEntry(faker.animal().name());
    }

    @Test(description = "9. Update entry's date", groups = "afterMethodGroup")
    public void changeEntryDateTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
        entriesPage.clickEntryDescription();
        editEntryPage.setEntryDate();
        editEntryPage.backToAllEntries();
    }

    private Object[][] getEntries(){
        return new Object[][]{
                {faker.animal().name()},
                {faker.book().title()},
                {faker.funnyName().name()},
                {faker.internet().emailAddress()},
        };
    }

    @Test(description = "11. Check entries pagination")
    public void checkEntriesPaginationTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        Object[][] entries = getEntries();
        for (Object[] entry : entries) {
            entriesSteps.createNewEntryAndCheckEntryIsCreated((String) entry[0]);
        }
        String numOfEntries = entriesSteps.checkNumberOfEntries();
        Assert.assertEquals(numOfEntries, "4 entries");
        entriesSteps.selectAllEntriesAndDelete();
        entriesSteps.checkMessageWhenNoEntries();
    }

    @Test(description = "12. Search entry by description", groups = "afterMethodGroup")
    public void searchEntryByDescriptionTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated("Pay for bill");
        entriesSteps.createNewEntryAndCheckEntryIsCreated("Meeting");
        entriesSteps.createNewEntryAndCheckEntryIsCreated("Meeting with team");
        Assert.assertEquals(entriesSteps.checkNumberOfEntries(), "3 entries");
        entriesSteps.fillSearchAndClickSearch("Pay");
        Assert.assertEquals(entriesSteps.checkNumberOfEntries(), "1 entries");
        entriesSteps.resetSearch();
        Assert.assertEquals(entriesSteps.checkNumberOfEntries(), "3 entries");
    }

    @Test(description = "15. Check tag assigned to entry", groups = "afterMethodGroup")
    public void checkTagAssignedToEntryTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createEntry(faker.name().fullName());
        editEntryPage.createNewTag("some tag");
        entriesSteps.checkTagAssignedToEntry();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        String[] groups = result.getMethod().getGroups();
        for (String group : groups) {
            if ("afterMethodGroup".equals(group)) {
                entriesSteps.selectAllEntriesAndDelete();
                System.out.println("AfterMethod for afterMethodGroup tests");
            }
        }
    }
}
