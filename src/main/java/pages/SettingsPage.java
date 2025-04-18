package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage extends BasePage{
    private static final String SETTINGS_TAB = "//*[contains(@class,'sidenav')]//*[contains(@ng-class,'%s')]";
    private static final SelenideElement PAGE_TITLE_XPATH = $x("//*[contains(@class,'settings__content')]//h1");

    public void switchToSettingTabByName(String name){
        $x(String.format(SETTINGS_TAB, name)).click();
    }

    public String getPageTitle(){
        return PAGE_TITLE_XPATH.getText();
    }
}
