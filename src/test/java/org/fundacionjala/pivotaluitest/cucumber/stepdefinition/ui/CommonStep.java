package org.fundacionjala.pivotaluitest.cucumber.stepdefinition.ui;

import cucumber.api.java.en.When;

import org.fundacionjala.pivotaluitest.ui.pages.common.CommonNavigator;

/**
 * This class doing the manage the Common step.
 */
public class CommonStep {
    /**
     * This method goes dashboard.
     */
    @When("^I go to dashboard$")
    public void goToDashboard() {
        CommonNavigator.goToDashboard();
    }
}
