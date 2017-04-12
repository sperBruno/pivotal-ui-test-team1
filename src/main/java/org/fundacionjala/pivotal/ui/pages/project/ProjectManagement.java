package org.fundacionjala.pivotal.ui.pages.project;

import org.fundacionjala.pivotal.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.fundacionjala.pivotal.ui.pages.common.CommonActions.clickElement;

/**
 * This Class is Project Management.
 */
public class ProjectManagement extends AbstractBasePage {
    @FindBy(css = "span.raw_context_name")
    private WebElement projectNameSpan;

    @FindBy(css = "a[data-aid='navTab-settings'] span")
    private WebElement navBarSettings;



    @FindBy(css = "a[data-aid='navTab-stories']")
    private WebElement staorytab;





    @FindBy(css = "project_name")
    WebElement projectName;

    @FindBy(css = "save_bar__submit")
    WebElement save;

    /**
     * this project obtain project name.
     *
     * @return project name.
     */
    public String getProjectName() {
        return CommonActions.getText(projectNameSpan);
    }



    /**
     * this project obtain project id.
     *
     * @return Project id of created new project.
     */
    public String getProjectId() {
        String projectId = "";
        String regularExpression = "(\\d+)$";
        String url = driver.getCurrentUrl();
        Matcher matcher = Pattern.compile(regularExpression).matcher(url);
        if (matcher.find()) {
            projectId = matcher.group();
        }
        return projectId;
    }

    /**
     * Thits method will select setting tab.
     * @return
     */
    public SettingsProject clickSettingsTab() {
        clickElement(navBarSettings);
        return new SettingsProject();
    }

    public Story clickAddStory() {

        clickElement(staorytab);
        return new Story();

    }




    public void ediProjectNAme(String name) {
        CommonActions.clickElement(projectName);
        CommonActions.sendKeys(projectName,name);
    }

    public void saveEditProject() {
        CommonActions.clickElement(save);
    }

}
