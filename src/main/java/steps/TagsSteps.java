package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import pages.EditEntryPage;
import pages.EntriesPage;
import pages.TagsPage;

public class TagsSteps implements IConstants {
    private EntriesPage entriesPage;
    private EditEntryPage editEntryPage;
    private TagsPage tagsPage;

    public TagsSteps(){
        entriesPage = new EntriesPage();
        editEntryPage = new EditEntryPage();
        tagsPage = new TagsPage();
    }

    @Step("Open edit entry page and add new tag")
    public void openEditEntryPageAndAddNewTag(String tagName){
        entriesPage
                .clickEntryDescription()
                .createNewTag(tagName);
    }

    @Step("Open Manage tags and check tag exist")
    public void openManageTagsAndCheckTagExist(String url, String tagName){
        tagsPage
                .openManageTagsPage(url)
                .tagExistInTheList(tagName);
    }

    @Step("Add new tag and check on Manage Tags page")
    public void createTagAndCheckItOnManageTagsPage(String tagName){
        openEditEntryPageAndAddNewTag(tagName);
        openManageTagsAndCheckTagExist(MANAGE_TAGS_URL, tagName);
    }
}
