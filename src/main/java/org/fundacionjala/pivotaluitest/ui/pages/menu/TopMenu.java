package org.fundacionjala.pivotaluitest.ui.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.account.Account;
import org.fundacionjala.pivotaluitest.ui.pages.common.CommonActions;

/**
 * This class doing the manage the menu the PivotalTracker application.
 */
public class TopMenu extends AbstractBasePage {
    @FindBy(css = "div.undefined.tc_profile_dropdown > div.tc_dropdown > a.tc_dropdown_name")
    private WebElement userNameDropDown;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountDropDownItem;

    /**
     * This method doing click on "User Name" DropDown.
     */
    public void clickUserNameDropDown() {
        CommonActions.clickElement(userNameDropDown);
    }

    /**
     * This method doing click on "Account" DropDownItem.
     *
     * @return Account page.
     */
    public Account clickAccountDropDownItem() {
        CommonActions.clickElement(accountDropDownItem);
        return new Account();
    }
}
