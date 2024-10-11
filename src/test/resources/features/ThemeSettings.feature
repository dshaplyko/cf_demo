Feature: Theme Settings

  Scenario: Application displays Light theme when device is set to Light mode
    Given the device is set to Light mode
    When the app is launched
    Then the app should display the Light theme

  Scenario: Application displays Dark theme when device is set to Dark mode
    Given the device is set to Dark mode
    When the app is launched
    Then the app should display the Dark theme