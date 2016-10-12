package org.fundacionjala.pivotaluitest.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.pivotaluitest.ui.browser.DriverManager;
import org.fundacionjala.pivotaluitest.utils.Environment;

/**
 * This is class wait to load the element.
 */
public final class WaitElement {

    /**
     * Constructor private.
     */
    private WaitElement() {
    }

    /**
     * This method waits the element.
     *
     * @param webElement Element to wait.
     */
    private static void waitElement(final WebElement webElement) {
        final WebDriver driver = DriverManager.getInstance().getDriver();
        final WebDriverWait wait = new WebDriverWait(driver, Environment.getInstance().getTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * This method waits and clear the element.
     *
     * @param webElement Element to wait and clear.
     */
    public static void waitClear(final WebElement webElement) {
        waitElement(webElement);
        webElement.clear();
    }

    /**
     * This method waits and fill the element.
     *
     * @param webElement Element to wait and fill.
     * @param text       text to fill.
     */
    public static void waitSendKeys(final WebElement webElement, final String text) {
        waitElement(webElement);
        webElement.sendKeys(text);
    }

    /**
     * This method waits and click the element.
     *
     * @param webElement Element to wait and click.
     */
    public static void waitClick(final WebElement webElement) {
        waitElement(webElement);
        webElement.click();
    }
}
