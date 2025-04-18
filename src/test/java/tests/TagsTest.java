package tests;

import org.testng.annotations.Test;

public class TagsTest extends BaseTest{

    @Test(description = "10. Create new tag")
    public void createNewTagTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        entriesSteps.createNewEntryAndCheckEntryIsCreated(faker.name().name());
        tagsSteps.createTagAndCheckItOnManageTagsPage(faker.name().title());
    }
}
