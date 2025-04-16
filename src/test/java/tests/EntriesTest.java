package tests;

import org.testng.annotations.Test;

public class EntriesTest extends BaseTest{

    @Test(description = "6. Create an entry")
    public void createNewEntryTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
    }

    @Test(description = "7. Update an entry")
    public void updateEntryTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.book().title());
        entriesSteps.updateEntryAndCheckEntryIsUpdated(faker.animal().name());
    }
}
