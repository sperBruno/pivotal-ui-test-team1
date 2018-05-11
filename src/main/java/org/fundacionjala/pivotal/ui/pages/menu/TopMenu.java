package org.fundacionjala.pivotal.ui.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotal.ui.pages.account.Account;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;

/**
 * This class manages the menu the PivotalTracker application.
 */
public class TopMenu extends AbstractBasePage {

//    @FindBy(css = "div.undefined.tc_profile_dropdown > div.tc_dropdown > a.tc_dropdown_name")
    @FindBy(css = ".zWDds__Button.TtSTu__Button--header.Dropdown__button")
    private WebElement userNameDropDown;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountDropDownItem;

    /**
     * This method do click on "User Name" DropDown.
     */
    public void clickUserNameDropDown() {
        CommonActions.clickElement(userNameDropDown);
    }

    /**
     * This method do click on "Account" DropDownItem.
     *
     * @return {@link Account}
     */
    public Account clickAccountDropDownItem() {
        CommonActions.clickElement(accountDropDownItem);
        return new Account();
    }
}
