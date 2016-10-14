package org.fundacionjala.pivotaluitest.ui.pages.account;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.utils.CommonActions;

/**
 * Created by Administrator on 10/14/2016.
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

    public ManageAccount clickManageAccount(WebElement manageAccountButton) {
        CommonActions.clickElement(manageAccountButton);
        return new ManageAccount();
    }

    public List<WebElement> getManageAccountButtonList() {
        return manageAccountButtonList;
    }

    public void setAccountNameTextField(String accountName) {
        CommonActions.clearTextField(accountNameTextField);
        CommonActions.sendKeys(accountNameTextField, accountName);
    }

    public void clickCreateAccountButton() {
        CommonActions.clickElement(createAccountButton);
    }

    public ManageAccount clickAddAccountButton() {
        CommonActions.clickElement(addAccountButton);
        return new ManageAccount();
    }

    public ManageAccount createAccount(String accountName) {
        clickCreateAccountButton();
        setAccountNameTextField(accountName);
        return clickAddAccountButton();
    }

    public void deleteAllAccounts() {//Improve
        List<WebElement> listAccounts = getManageAccountButtonList();
        int index = 0;
        while (!listAccounts.isEmpty()) {
            WebElement webElement = listAccounts.get(index);
            String test = webElement.getText();
            if (test.equals(MANAGE_ACCOUNT)) {//improve
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

}
