package org.fundacionjala.pivotaluitest.ui.pages.account;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.common.CommonActions;

/**
 * This Account page class.
 */
public class Account extends AbstractBasePage {

    private static final String MANAGE_ACCOUNT = "MANAGE ACCOUNT";

    @FindBy(id = "new_account_link")
    private WebElement createAccountButton;


    @FindBy(id = "add_account_button")
    private WebElement addAccountButton;

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(className = "header_button")
    private List<WebElement> manageAccountButtonList;

    /**
     * This method set the account name in the text field.
     *
     * @param accountName String  whit the account name.
     */
    public void setAccountNameTextField(final String accountName) {
        CommonActions.clearTextField(accountNameTextField);
        CommonActions.sendKeys(accountNameTextField, accountName);
    }

    /**
     * This method doing click on "Manage Account" button.
     *
     * @param manageAccountButton WebElement that represent a "Management Account".
     * @return ManageAccount page.
     */
    public ManageAccount clickManageAccount(final WebElement manageAccountButton) {
        CommonActions.clickElement(manageAccountButton);
        return new ManageAccount();
    }

    /**
     * This method doing click on "Create Account" button.
     */
    public void clickCreateAccountButton() {
        CommonActions.clickElement(createAccountButton);
    }

    /**
     * This method added a new account.
     *
     * @return ManageAccount page.
     */
    public ManageAccount clickAddAccountButton() {
        CommonActions.clickElement(addAccountButton);
        return new ManageAccount();
    }

    /**
     * This method created a new account.
     *
     * @param accountName String  whit the account name.
     * @return ManageAccount page.
     */
    public ManageAccount createAccount(final String accountName) {
        clickCreateAccountButton();
        setAccountNameTextField(accountName);
        return clickAddAccountButton();
    }

    /**
     * This method deleted all accounts.
     */
    public void deleteAllAccounts() {
        //improve
        List<WebElement> listAccounts = getManageAccountButtonList();
        int index = 0;
        while (!listAccounts.isEmpty()) {
            WebElement webElement = listAccounts.get(index);
            String test = webElement.getText();
            if (test.equals(MANAGE_ACCOUNT)) {
                String attributeValue = webElement.getAttribute("href");
                attributeValue = attributeValue.replace("plans", "settings");
                int indexOf = attributeValue.indexOf("/accounts");
                attributeValue = attributeValue.substring(indexOf);
                ManageAccount manageAccount = clickManageAccount(webElement);
                SettingAccount settingAccount = manageAccount.clickSetting(attributeValue);
                settingAccount.clickDeleteAccountLink();
                listAccounts = getManageAccountButtonList();
                index = 0;
            }
            index++;
        }
    }

    /**
     * This method obtains a of WebElement list.
     *
     * @return List the WebElement the button type.
     */
    public List<WebElement> getManageAccountButtonList() {
        return manageAccountButtonList;
    }

}
