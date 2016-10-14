package org.fundacionjala.pivotaluitest.ui.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.Dashboard;
import org.fundacionjala.pivotaluitest.ui.utils.CommonActions;

/**
 * Created by Administrator on 10/14/2016.
 */
public class ManageAccount extends AbstractBasePage {
    @FindBy(className = "account_name")
    private WebElement accountNameLabel;

    public SettingAccount clickSetting(String name){
        WebElement settingButton = driver.findElement(By.cssSelector("a[href='" + name + "']"));
        CommonActions.clickElement(settingButton);
        return new SettingAccount();
    }

    public Dashboard gotToDashboard() {
        CommonActions.waitUntil(accountNameLabel);
        driver.get("https://www.pivotaltracker.com/dashboard");
        return new Dashboard();
    }
}
