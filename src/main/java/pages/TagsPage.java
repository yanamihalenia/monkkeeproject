package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$x;

public class TagsPage {
    private static final String TAG_BY_TEXT = "//table//*[@ng-repeat='tag in tags']//td[contains(text(),'%s')]";

    public void tagExistInTheList(String tagName){
        $x(String.format(TAG_BY_TEXT, tagName)).should(Condition.visible);
    }

    public TagsPage openManageTagsPage(String url){
        open(url);
        return this;
    }
}
