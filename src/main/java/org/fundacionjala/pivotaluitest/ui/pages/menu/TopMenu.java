package org.fundacionjala.pivotaluitest.ui.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.Dashboard;
import org.fundacionjala.pivotaluitest.ui.pages.account.Account;
import org.fundacionjala.pivotaluitest.ui.utils.CommonActions;

/**
 * Created by Administrator on 10/14/2016.
 */
public class TopMenu extends AbstractBasePage {
    @FindBy(css = "div.undefined.tc_profile_dropdown > div.tc_dropdown > a.tc_dropdown_name")
    private WebElement userNameDropDown;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountDropDownItem;

    public void clickUserNameDropDown() {
        CommonActions.clickElement(userNameDropDown);
    }

    public Account clickAccountDropDownItem() {
        CommonActions.clickElement(accountDropDownItem);
        return new Account();
    }

    public Dashboard gotToDashboard() {
        CommonActions.waitUntil(userNameDropDown);
        driver.get("https://www.pivotaltracker.com/dashboard");
        return new Dashboard();
    }
}
