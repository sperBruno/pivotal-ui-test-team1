package org.fundacionjala.pivotal.ui.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.logging.Logger;

/**
 * Created by bruno on 4/9/2017.
 */
public class StoryDashBoardTest {
            private static final Logger LOGGER = Logger.getLogger(StoryDashBoard.class.getName());
            private Dashboard dashboard;
            private StoryDashBoard storyDashBoard;

            /**
             * This before will be executed before a suite.
             */
            @BeforeSuite
            public void beforeSuite() {
                LOGGER.info("inside setup");
                dashboard = SignInForm.loginAsPrimaryUser();
            }

            /**
             * This test will enter to a storyDashBoard.
             */
            @Test
            public void createStory() {
                final String projectNameLink = "template";
                dashboard = new Dashboard();
                storyDashBoard = dashboard.projectsList(projectNameLink);
                IceBox iceBox = storyDashBoard.getSideBarBoard().clickAddStory();
            }

            /**
             * This after suit will close the app.
             */
            @AfterSuite
            public void logoutPivotal() {
            }
        }


