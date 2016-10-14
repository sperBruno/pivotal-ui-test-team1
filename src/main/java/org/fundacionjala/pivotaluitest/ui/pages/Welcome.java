package org.fundacionjala.pivotaluitest.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.utils.CommonActions;

/**
 * Created by Administrator on 10/12/2016.
 */
public class Welcome extends AbstractBasePage {
    @FindBy(css = "div.header__lg > a[href='/signin']")
    private WebElement signinLink;

    /**
     * This method to clicks on the "Signin" button.
     *
     * @return Return to SignInForm page.
     */
    public SignInForm clickSigninLink() {
        CommonActions.clickElement(signinLink);
        return new SignInForm();
    }
}
