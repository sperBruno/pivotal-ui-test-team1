package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.pivotal.ui.pages.account.Account;
import org.fundacionjala.pivotal.ui.pages.account.ManageAccount;
import org.fundacionjala.pivotal.ui.pages.menu.TopMenu;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.fundacionjala.pivotal.ui.pages.common.CommonNavigator.goToDashboard;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Bruno Barrios on 4/12/2017.
 */
public class AccountTest {
    private static final Logger LOGGER = Logger.getLogger(StoryDashBoard.class.getName());
    private Dashboard dashboard;
    private Account account;

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("inside setup");
        dashboard = SignInForm.loginAsPrimaryUser();
    }

    /**
     * This test will create account name.
     */
    @Test
    public void createAccount() {
        TopMenu topMenu = new TopMenu();
        topMenu.clickUserNameDropDown();
        account = topMenu.clickAccountDropDownItem();
        final String accountName = "BRUNO REY";
        ManageAccount manageAccount = account.createAccount(accountName);
        manageAccount.waitPage();

        assertEquals(accountName, manageAccount.getAccountName());

        topMenu.clickUserNameDropDown();
        topMenu.clickAccountDropDownItem();

        assertTrue(account.isAccountDisplayed(accountName));

    }

    /**
     * This method will clean pivatoal environment.
     */
    @AfterClass
    public void tearDown() {
        account.deleteAllAccounts(account.getManageAccountButtonList());
        goToDashboard();
    }

}
