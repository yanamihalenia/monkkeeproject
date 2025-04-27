package tests;

import org.testng.annotations.Test;

public class TagsTest extends BaseTest{

    @Test(description = "10. Create new tag")
    public void createNewTagTest(){
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.name().name());
        tagsSteps.createTagAndCheckItOnManageTagsPage(faker.name().title());
    }
}
