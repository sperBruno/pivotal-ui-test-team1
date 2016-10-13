package org.fundacionjala.pivotaluitest.cucumber.stepdefinition.ui.login;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotaluitest.ui.pages.Home;
import org.fundacionjala.pivotaluitest.ui.pages.SignInForm;
import org.fundacionjala.pivotaluitest.ui.pages.Welcome;
import org.fundacionjala.pivotaluitest.utils.Environment;

/**
 * Created by Administrator on 10/12/2016.
 */
public class loginStep {
    @When("^I perform a login as$")
    public void i_perform_a_login_as() {
        final String userName = Environment.getInstance().getPrimaryUser();
        final String password = Environment.getInstance().getPrimaryPassword();
        Welcome welcomePage = new Welcome();
        SignInForm signInForm = welcomePage.clickSigninLink();
        signInForm.setEmailTextField(userName);
        signInForm.clickNextButton();
        signInForm.setPasswordTextField(password);
        Home homePage = signInForm.clickSigninButton();
    }

    @Then("^I will have a user logged$")
    public void i_will_have_a_user_logged() {
        System.out.println("entre al asert");
    }
}
