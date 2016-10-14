package org.fundacionjala.pivotaluitest.cucumber.hooks;

import cucumber.api.java.Before;

import org.fundacionjala.pivotaluitest.ui.pages.account.Account;
import org.fundacionjala.pivotaluitest.ui.pages.menu.TopMenu;

/**
 * Created by Administrator on 10/14/2016.
 */
public class AccountHooks {
    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteAllAccounts")
    public final void deleteAllAccounts() {
        TopMenu topMenu = new TopMenu();
        topMenu.clickUserNameDropDown();
        Account account = topMenu.clickAccountDropDownItem();
        account.deleteAllAccounts();
        topMenu.gotToDashboard();
    }
}
