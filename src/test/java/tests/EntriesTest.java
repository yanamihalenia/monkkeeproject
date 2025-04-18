package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

//    @Test(description = "9. Update entry's date")
//    public void changeEntryDate(){
//        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
//        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
//
//    }

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
