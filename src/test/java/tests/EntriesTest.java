package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class EntriesTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    @Test(description = "6. Create an entry", groups = "afterMethodGroup")
    public void createNewEntryTest(){
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
    }

    @Test(description = "7. Update an entry", groups = "afterMethodGroup")
    public void updateEntryTest(){
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        entriesSteps
                .createNewEntryAndCheckEntryIsCreated(faker.book().title())
                .updateEntryAndCheckEntryIsUpdated(faker.animal().name());
    }

    @Test(description = "8. Delete an entry")
    public void deleteEntryTest(){
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        entriesSteps.createAndDeleteEntry(faker.animal().name());
    }

    @Test(description = "9. Update entry's date", groups = "afterMethodGroup")
    public void changeEntryDateTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
        entriesSteps.changeEntryDate(2025, 7, 22);
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
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        Object[][] entries = getEntries();
        for (Object[] entry : entries) {
            entriesSteps.createNewEntryAndCheckEntryIsCreated((String) entry[0]);
        }
        String numOfEntries = entriesSteps.checkNumberOfEntries();
        Assert.assertEquals(numOfEntries, "4 entries");
        entriesSteps
                .selectAllEntriesAndDelete()
                .checkMessageWhenNoEntries();
    }

    @Test(description = "12. Search entry by description", groups = "afterMethodGroup")
    public void searchEntryByDescriptionTest(){
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        entriesSteps
                .createNewEntryAndCheckEntryIsCreated("Pay for bill")
                .createNewEntryAndCheckEntryIsCreated("Meeting")
                .createNewEntryAndCheckEntryIsCreated("Meeting with team");
        softAssert.assertEquals(entriesSteps.checkNumberOfEntries(), "3 entries");
        entriesSteps.fillSearchAndClickSearch("Pay");
        softAssert.assertEquals(entriesSteps.checkNumberOfEntries(), "1 entries");
        entriesSteps.resetSearch();
        softAssert.assertEquals(entriesSteps.checkNumberOfEntries(), "3 entries");
    }

    @Test(description = "15. Check tag assigned to entry", groups = "afterMethodGroup")
    public void checkTagAssignedToEntryTest(){
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        entriesSteps.createEntry(faker.name().fullName());
        editEntrySteps.createNewTagOnEditPage("some tag");
        entriesSteps.checkTagAssignedToEntry();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        String[] groups = result.getMethod().getGroups();
        for (String group : groups) {
            if ("afterMethodGroup".equals(group)) {
                entriesSteps.selectAllEntriesAndDelete();
                log.info("AfterMethod for afterMethodGroup tests");
            }
        }
    }
}
