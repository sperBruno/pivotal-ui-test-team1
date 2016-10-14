package org.fundacionjala.pivotaluitest.cucumber.stepdefinition.ui.project;

import java.util.Map;

import cucumber.api.java.en.When;

import org.fundacionjala.pivotaluitest.ui.pages.Dashboard;
import org.fundacionjala.pivotaluitest.ui.pages.account.Account;
import org.fundacionjala.pivotaluitest.ui.pages.account.ManageAccount;
import org.fundacionjala.pivotaluitest.ui.pages.menu.TopMenu;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectForm;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectManagement;

/**
 * This class is manage the project step.
 */
public class ProjectStep {
    private Map<ProjectFormSetting, String> settingMap;
    private TopMenu topMenu;

    public ProjectStep() {
        topMenu = new TopMenu();
    }

    /**
     * This method added a new project.
     *
     * @param newSettingMap SettingMap that contains the setting for project.
     */
    @When("^I added a new project$")
    public void iAddedANewProject(final Map<ProjectFormSetting, String> newSettingMap) {
        settingMap = newSettingMap;
        Dashboard dashboardPage = new Dashboard();
        ProjectForm projectForm = dashboardPage.clickCreateProjectButton();
        projectForm.setConfiguration(newSettingMap);
        ProjectManagement projectManagement = projectForm.clickCreateProjectButton();
    }

    @When("^I delete all account the project$")
    public void deleteAllAccountForProject() {
        topMenu.clickUserNameDropDown();
        Account account = topMenu.clickAccountDropDownItem();
        account.deleteAllAccounts();
        topMenu.gotToDashboard();
    }

    @When("^I create a new account (.*)$")
    public void CreateANewAccount(String accountName) {
        topMenu.clickUserNameDropDown();
        Account account = topMenu.clickAccountDropDownItem();
        ManageAccount manageAccount = account.createAccount(accountName);
        manageAccount.gotToDashboard();
    }

    /**
     * This method obtain settingMap.
     *
     * @return SettingMap to Map type.
     */
    Map<ProjectFormSetting, String> getSettingMap() {
        return settingMap;
    }
}
