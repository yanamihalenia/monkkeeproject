package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest{

    @DataProvider(name = "settingPages")
    public Object[][] settingsPage() {
        return new Object[][] {
                {SETTINGS_LANGUAGE_TAB, SETTINGS_LANGUAGE_TITLE},
                {SETTINGS_COLOUR_SCHEME_TAB, SETTINGS_COLOUR_SCHEME_TITLE},
                {SETTINGS_EMAIL_TAB, SETTINGS_EMAIL_TITLE},
                {SETTINGS_PASSWORD_TAB, SETTINGS_PASSWORD_TITLE},
                {SETTINGS_LOGIN_ALIAS_TAB, SETTINGS_LOGIN_ALIAS_TITLE},
                {SETTINGS_INACTIVITY_TIMEOUT_TAB, SETTINGS_INACTIVITY_TIMEOUT_TITLE},
                {SETTINGS_EDITOR_TAB, SETTINGS_EDITOR_TITLE},
                {SETTINGS_EXPORT_TAB, SETTINGS_EXPORT_TITLE},
                {SETTINGS_LICENSE_TAB, SETTINGS_LICENSE_TITLE},
                {SETTINGS_SUPPORT_TAB, SETTINGS_SUPPORT_TITLE},
                {SETTINGS_DELETE_ACCOUNT_TAB, SETTINGS_DELETE_ACCOUNT_TITLE},
        };
    }

    @Test(description = "14. Check all settings tabs are available", dataProvider = "settingPages")
    public void checkAllSettingsAvailableTest(String settingPage, String pageTitle){
        loginSteps.login(System.getProperty("username"), System.getProperty("password"), LOGIN_PAGE_URL);
        settingsSteps.openSettingsPage();
        settingsSteps.openSettingTabAndCheckTitle(settingPage, pageTitle);
    }
}
