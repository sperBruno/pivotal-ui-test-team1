package org.fundacionjala.pivotaluitest.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectForm;
import org.fundacionjala.pivotaluitest.ui.utils.CommonActions;

/**
 * Dashboard page the PivotalTracker.
 */
public class Dashboard extends AbstractBasePage {
    @FindBy(id = "create_new_project_button")
    private WebElement createProjectButton;

    /**
     * This method a clickElement "Create Project" button.
     *
     * @return ProjectForm page.
     */
    public ProjectForm clickCreateProjectButton() {
        CommonActions.clickElement(createProjectButton);
        return new ProjectForm();
    }
}
