package org.fundacionjala.pivotaluitest.cucumber.stepdefinition.ui.project;

import java.util.Map;

import cucumber.api.java.en.Then;

import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectManagement;

import static org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.junit.Assert.assertEquals;


/**
 * This class is manage the project asserts.
 */
public class ProjectAssert {
    private Map<ProjectFormSetting, String> stringMap;

    /**
     * Constructor where initialize the values.
     *
     * @param projectStep ResourcesStep.
     */
    public ProjectAssert(final ProjectStep projectStep) {
        stringMap = projectStep.getSettingMap();
    }

    /**
     * this method verify that a new project is created.
     */
    @Then("Verify that a new project is created")
    public void verifyThatANewProjectIsCreated() {
        ProjectManagement projectManagement = new ProjectManagement();
        final String expected = projectManagement.getProjectName();
        final String actual = stringMap.get(PROJECT_NAME);
        assertEquals(expected, actual);
        projectManagement.goToHome();
    }
}
