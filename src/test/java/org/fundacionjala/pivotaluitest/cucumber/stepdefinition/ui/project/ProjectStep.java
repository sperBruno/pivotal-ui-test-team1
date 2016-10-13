package org.fundacionjala.pivotaluitest.cucumber.stepdefinition.ui.project;

import java.util.Map;

import cucumber.api.java.en.When;

import org.fundacionjala.pivotaluitest.ui.pages.Home;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectForm;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectManagement;

/**
 * This class is manage the project step.
 */
public class ProjectStep {
    private Map<ProjectFormSetting, String> settingMap;

    /**
     * This method added a new project.
     *
     * @param newSettingMap  SettingMap that contains the setting for project.
     */
    @When("^I added a new project$")
    public void iAddedANewProject(final Map<ProjectFormSetting, String> newSettingMap) {
        settingMap = newSettingMap;
        Home homePage = new Home();
        ProjectForm projectForm = homePage.clickCreateProjectButton();
        projectForm.setConfiguration(newSettingMap);
        ProjectManagement projectManagement = projectForm.clickCreateProjectButton();
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
