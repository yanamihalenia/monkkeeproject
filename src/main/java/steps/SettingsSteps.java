package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.HeaderPage;
import pages.SettingsPage;

public class SettingsSteps {
    private SettingsPage settingsPage;
    private HeaderPage headerPage;

    public SettingsSteps(){
        settingsPage = new SettingsPage();
        headerPage = new HeaderPage();
    }

    @Step("Open settings page")
    public SettingsSteps openSettingsPage(){
        headerPage.goToSettings();
        return this;
    }

    @Step("Open setting tab by name and check title")
    public void openSettingTabAndCheckTitle(String tabName, String title){
        settingsPage.switchToSettingTabByName(tabName);
        Selenide.sleep(700);
        Assert.assertEquals(settingsPage.getPageTitle(), title);
    }
}
