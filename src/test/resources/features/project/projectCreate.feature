Feature: Project Create

  @deleteAllProjects
  Scenario: Create a new project with setting by default
  Create a new project account and project privacy is private
    When I added a new project
      | PROJECT_NAME | Automation Project Test 01 |
      | ACCOUNT      | AutomationTestAT01-01      |
    Then Verify that a new project is created

  @deleteAllProjects
  Scenario: Create a new project when project account exist
  Create a new project privacy is private by default
    When I added a new project
      | PROJECT_NAME | Automation Project Test 02 |
      | ACCOUNT      | AutomationTestAT01         |
    Then Verify that a new project is created

  @deleteAllProjects
  Scenario: Create a new project when Project privacy is public and the account exist
    When I added a new project
      | PROJECT_NAME    | Automation Project Test |
      | ACCOUNT         | AutomationTestAT01-02   |
      | PROJECT_PRIVACY | Public                  |
    Then Verify that a new project is created

  @deleteAllProjects
  Scenario: Create a new project when Project privacy is public and the account not exist
    When I added a new project
      | PROJECT_NAME    | Automation Project Test 03 |
      | ACCOUNT         | AutomationTestAT01-02      |
      | PROJECT_PRIVACY | Public                     |
    Then Verify that a new project is created