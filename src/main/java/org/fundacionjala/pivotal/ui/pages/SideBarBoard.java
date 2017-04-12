package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.pivotal.ui.browser.DriverManager;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

/**
 * Created by bruno on 4/9/2017.
 */
public class SideBarBoard extends AbstractBasePage{
    private static final Logger LOGGER = Logger.getLogger(SideBarBoard.class.getName());
    //    @FindBy(xpath = ".//span[text()='Add Story']")
    @FindBy(css = ".add_story span span")
    private WebElement addStroyBtn;

    @FindBy(css = ".raw_context_name.public")
    private WebElement nameOfProject;

    @FindBy(css = "a[data-aid='navTab-settings'] span")
    private WebElement namesOfProjecsst;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * This method will be used to click on addStroy Button.
     * @return IceBox.
     */
    public IceBox clickAddStory() {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(nameOfProject));
        LOGGER.info("inside ad dstory");
//            js.executeScript("$(\".add_story span span\").click();");
//            CommonActions.clickElement(namesOfProjecsst);

//        js.executeScript("document.getElement(By.By.cssSelector('a[data-aid='navTab-settings'] span').click()");
            CommonActions.clickElement(addStroyBtn);
        return new IceBox();
    }

}
