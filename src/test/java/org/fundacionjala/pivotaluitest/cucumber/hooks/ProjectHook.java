package org.fundacionjala.pivotaluitest.cucumber.hooks;

import java.util.List;
import java.util.Map;

import cucumber.api.java.Before;

import org.fundacionjala.pivotaluitest.api.RequestManager;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectForm;

import static org.fundacionjala.pivotaluitest.api.RequestManager.delete;

/**
 * Hook to delete all projects that is created with the feature.
 */
public class ProjectHook {
    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String ID_KEY = "id";

    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteProjectsByDefault")
    public final void deleteProjectsByDefault() {
        List<Map<String, ?>> projects = RequestManager.get(PROJECTS_ENDPOINT).jsonPath().get();
        for (Map<String, ?> object : projects) {
            delete(PROJECTS_ENDPOINT + object.get(ID_KEY).toString());
        }
    }
}
