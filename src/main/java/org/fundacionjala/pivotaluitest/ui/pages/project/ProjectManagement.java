package org.fundacionjala.pivotaluitest.ui.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.utils.WaitElement;
import org.fundacionjala.pivotaluitest.utils.Environment;

/**
 * This Class is Project Management.
 */
public class ProjectManagement extends AbstractBasePage {
    @FindBy(css = "span.raw_context_name")
    private WebElement projectNameSpan;

    /**
     * This method go to home.
     */
    public void goToHome() {
        WaitElement.waitUntil(projectNameSpan);
        final String dashboard = "dashboard";
        driver.get(String.format("%s/%s", Environment.getInstance().getBaseUrl(), dashboard));
    }

    /**
     * this project obtain project name.
     *
     * @return project name.
     */
    public String getProjectName() {
        return WaitElement.getText(projectNameSpan);
    }
}
