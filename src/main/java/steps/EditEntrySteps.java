package steps;

import io.qameta.allure.Step;
import pages.EditEntryPage;

public class EditEntrySteps {
    private EditEntryPage editEntryPage;

    public EditEntrySteps(){
        editEntryPage = new EditEntryPage();
    }

    @Step("Create new tag")
    public void createNewTagOnEditPage(String tagName){
        editEntryPage.createNewTag(tagName);
    }
}
