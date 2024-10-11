Feature: Automatic Theme Change Based on Device Settings

  Background:
    Given the application is installed on an iOS device

  Scenario: Application changes to Light theme when device is set to Light mode
    Given the device theme is set to Light mode
    When the user opens the application
    Then the application theme should be Light

  Scenario: Application changes to Dark theme when device is set to Dark mode
    Given the device theme is set to Dark mode
    When the user opens the application
    Then the application theme should be Dark

  Scenario: Application retains Light theme when device theme is changed to Light mode while app is running
    Given the device theme is set to Dark mode
    And the user opens the application
    When the device theme is changed to Light mode
    Then the application theme should change to Light

  Scenario: Application retains Dark theme when device theme is changed to Dark mode while app is running
    Given the device theme is set to Light mode
    And the user opens the application
    When the device theme is changed to Dark mode
    Then the application theme should change to Dark

  Scenario: Application retains theme settings across sessions
    Given the device theme is set to Dark mode
    And the user opens the application
    When the user closes and reopens the application
    Then the application theme should be Dark

  Scenario Outline: Application handles invalid or unsupported theme settings gracefully
    Given the device theme is set to <invalid_theme>
    When the user opens the application
    Then the application should default to Light theme

    Examples:
      | invalid_theme |
      | "unsupported" |
      | "null"        |
      | "empty"       |

  Scenario: Application handles rapid theme changes
    Given the device theme is set to Light mode
    And the user opens the application
    When the device theme is rapidly changed to Dark mode and back to Light mode
    Then the application theme should be Light

  Scenario: Application handles theme change during critical operations
    Given the device theme is set to Light mode
    And the user opens the application
    And the user is performing a critical operation
    When the device theme is changed to Dark mode
    Then the application theme should change to Dark
    And the critical operation should not be interrupted

  Scenario: Application theme change does not affect performance
    Given the device theme is set to Light mode
    And the user opens the application
    When the device theme is changed to Dark mode
    Then the application theme should change to Dark
    And the application performance should not degrade