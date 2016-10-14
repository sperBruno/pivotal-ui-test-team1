package org.fundacionjala.pivotaluitest.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.utils.CommonActions;

/**
 * Created by Administrator on 10/14/2016.
 */
public class SettingAccount extends AbstractBasePage {
    @FindBy(css = "a.button.current")
    private WebElement settingButton;
    @FindBy(css = "div.description > a")
    private WebElement deleteAccountLink;

    public void clickOKAlertMessage() {
        driver.switchTo().alert().accept();
    }

    public void clickDeleteAccountLink() {
        CommonActions.clickElement(deleteAccountLink);
        clickOKAlertMessage();
    }
}
