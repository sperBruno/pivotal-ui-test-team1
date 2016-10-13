package org.fundacionjala.pivotaluitest.ui.pages.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.utils.WaitElement;

import static org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting.ACCOUNT;
import static org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting.PROJECT_PRIVACY;

/**
 * This class is Project form to PivotalTracker.
 */
public class ProjectForm extends AbstractBasePage {
    @FindBy(className = "tc-project-name__input")
    private WebElement projectNameTextField;
    @FindBy(className = "tc-account-selector")
    private WebElement accountDropDownList;
    @FindBy(className = "tc-account-selector__option-account-name")
    private WebElement accountOptionDropDownList;
    @FindBy(css = "button.tc-create-project-footer__button.tc-create-project-footer__button--submit")
    private WebElement createButton;
    @FindBy(css = "div[data-aid='create-account-button']")
    private WebElement createAccountButtonOptionDropDownList;
    @FindBy(css = "input.tc-account-creator__name")
    private WebElement newAccountProjectTextField;

    /**
     * This method set the projectName in the text field.
     *
     * @param projectName String whit the projectName.
     */
    public void setProjectNameTextField(final String projectName) {
        WaitElement.waitClear(projectNameTextField);
        WaitElement.waitSendKeys(projectNameTextField, projectName);
    }

    /**
     * This method set the Account in the text field or DropDownList.
     *
     * @param account That is to search.
     */
    public void setAccountDropDownList(final String account) {
        WaitElement.waitClick(accountDropDownList);
        List<WebElement> menuBodyList = driver.findElements(By.xpath("//div[contains(text(), '" + account + "')]"));
        if (menuBodyList.isEmpty()) {
            WaitElement.waitClick(createAccountButtonOptionDropDownList);
            WaitElement.waitClear(newAccountProjectTextField);
            WaitElement.waitSendKeys(newAccountProjectTextField, account);
        } else {

            final int index = 0;
            WaitElement.waitClick(menuBodyList.get(index));
        }
    }

    /**
     * This method a new project the application.
     *
     * @return Project Management page.
     */
    public ProjectManagement clickCreateProjectButton() {
        WaitElement.waitClick(createButton);
        return new ProjectManagement();
    }

    /**
     * This method selected project privacy.
     *
     * @param projectPrivacyType return project privacy type.
     */
    public void selectedProjectPrivacy(final ProjectPrivacy projectPrivacyType) {
        WebElement projectPrivacy =
                driver.findElement(By.cssSelector("input[data-aid='" + projectPrivacyType.toString() + "']"));
        WaitElement.waitClick(projectPrivacy);
    }

    /**
     * Executes the configurations sent.
     *
     * @param configureMap is a map that contains the configurations.
     */
    public void setConfiguration(final Map<ProjectFormSetting, String> configureMap) {
        Map<ProjectFormSetting, ProjectFormStep> strategyOption = strategyConfigureSetting(configureMap);
        Set<ProjectFormSetting> keys = configureMap.keySet();
        for (ProjectFormSetting key : keys) {
            strategyOption.get(key).executeStep();
        }
    }

    /**
     * Create an strategy steps configuration options filling a map with
     * all the existing configurations.
     *
     * @param configureMap is a map that contains all the configurations.
     * @return the configure map with strategies.
     */
    private Map<ProjectFormSetting, ProjectFormStep> strategyConfigureSetting(
            final Map<ProjectFormSetting, String> configureMap) {
        Map<ProjectFormSetting, ProjectFormStep> strategyMap = new HashMap<>();
        strategyMap.put(PROJECT_NAME, () -> setProjectNameTextField(configureMap.get(PROJECT_NAME)));
        strategyMap.put(ACCOUNT, () -> setAccountDropDownList(configureMap.get(ACCOUNT)));
        strategyMap.put(PROJECT_PRIVACY,
                () -> selectedProjectPrivacy(ProjectPrivacy.valueOf(configureMap.get(PROJECT_PRIVACY).toUpperCase())));
        return strategyMap;
    }
}
