Feature: Automatic Theme Adjustment

Scenario: App applies light theme when system is in light mode
  Given the system is set to light mode
  When the user launches the app
  Then the app should display the light theme

Scenario: App applies dark theme when system is in dark mode
  Given the system is set to dark mode
  When the user launches the app
  Then the app should display the dark theme

Scenario: App dynamically changes to dark theme when system changes to dark mode
  Given the system is set to light mode
  And the user has the app open
  When the system changes to dark mode
  Then the app should dynamically change to the dark theme