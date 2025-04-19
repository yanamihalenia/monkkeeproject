package tests;

import org.testng.annotations.Test;

public class SettingsTest extends BaseTest{

    @Test(description = "14. Check all settings tabs are available")
    public void checkAllSettingsAvailableTest(){
        loginSteps.login(USER, PASSWORD, LOGIN_PAGE_URL);
        settingsSteps.openSettingsPage();
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_LANGUAGE_TAB, SETTINGS_LANGUAGE_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_COLOUR_SCHEME_TAB, SETTINGS_COLOUR_SCHEME_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_EMAIL_TAB, SETTINGS_EMAIL_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_PASSWORD_TAB, SETTINGS_PASSWORD_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_LOGIN_ALIAS_TAB, SETTINGS_LOGIN_ALIAS_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_INACTIVITY_TIMEOUT_TAB, SETTINGS_INACTIVITY_TIMEOUT_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_EDITOR_TAB, SETTINGS_EDITOR_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_EXPORT_TAB, SETTINGS_EXPORT_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_LICENSE_TAB, SETTINGS_LICENSE_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_SUPPORT_TAB, SETTINGS_SUPPORT_TITLE);
        settingsSteps.openSettingTabAndCheckTitle(SETTINGS_DELETE_ACCOUNT_TAB, SETTINGS_DELETE_ACCOUNT_TITLE);
    }
}
