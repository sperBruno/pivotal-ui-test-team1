package org.fundacionjala.pivotal.ui.pages.project;

import org.fundacionjala.pivotal.ui.pages.Dashboard;
import org.fundacionjala.pivotal.ui.pages.common.CommonMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.pivotal.ui.pages.common.CommonNavigator.goToDashboard;
import static org.fundacionjala.pivotal.ui.pages.project.ProjectFormSetting.*;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Bruno Barrios on 4/12/2017.
 */
public class ProjectManagementTest {

    public static final String COCOBONGO = "COCOBONGO";
    public static final String PUBLIC = "Public";
//    private Dashboard dashboard;

    @BeforeClass
    public void setup() {
//        dashboard = SignInForm.loginAsPrimaryUser();
    }

    @Test
    public void  createProject() {
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm =dashboard.clickCreateProjectButton();

        Map<ProjectFormSetting, String> newPro = new HashMap<>();
        final String testeandOsd = "TESTEANDOsd";
        newPro.put(PROJECT_NAME, testeandOsd);
        newPro.put(ACCOUNT, COCOBONGO);
        newPro.put(PROJECT_PRIVACY, PUBLIC);

        projectForm.setConfiguration(newPro);
        ProjectManagement projectManagement = projectForm.clickCreateProjectButton();

        assertEquals(testeandOsd, projectManagement.getProjectName());
    }


    @AfterClass
    public void teardown() {
        CommonMethods.deleteAllProjects();
        goToDashboard();
    }
}