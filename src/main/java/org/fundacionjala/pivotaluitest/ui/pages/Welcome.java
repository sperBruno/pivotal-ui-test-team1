package org.fundacionjala.pivotaluitest.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.utils.WaitElement;

/**
 * Created by Administrator on 10/12/2016.
 */
public class Welcome extends AbstractBasePage {
    @FindBy(css = "div.header__lg > a[href='/signin']")
    private WebElement signinLink;

    /**
     * This method to clicks on the "Signin" button.
     *
     * @return Return to Login page.
     */
    public Login clickSigninLink() {
        WaitElement.waitClick(signinLink);
        return new Login();
    }
}
