Feature: Project CRUD

  Background: Login
    When I perform a login as
    Then I will have a user logged

  Scenario: Create that a new project is created
    When I added a new project
      | ProjectName     | Automation Project Test |
      | Account         | AutomationTestAT01      |
      | Project privacy | Private                 |
    Then Verify that a new project is created
