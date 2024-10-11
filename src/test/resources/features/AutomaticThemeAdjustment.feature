Feature: Automatic Theme Adjustment

  Scenario: App adjusts to Light mode when system is set to Light mode
    Given the system theme is set to Light mode
    When I open the application
    Then the application should display in Light mode

  Scenario: App adjusts to Dark mode when system is set to Dark mode
    Given the system theme is set to Dark mode
    When I open the application
    Then the application should display in Dark mode

  Scenario: App theme changes to Light mode when system theme is changed to Light mode
    Given the system theme is set to Dark mode
    And the application is open
    When I change the system theme to Light mode
    Then the application should immediately display in Light mode

  Scenario: App theme changes to Dark mode when system theme is changed to Dark mode
    Given the system theme is set to Light mode
    And the application is open
    When I change the system theme to Dark mode
    Then the application should immediately display in Dark mode