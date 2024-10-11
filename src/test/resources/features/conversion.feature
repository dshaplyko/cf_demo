Feature: Conversion of EAN13 to EAN7

  Scenario: Provided example
    Given an EAN of 13 characters "0200147030964"
    When I submit this EAN to the application
    Then the last 6 characters are removed to obtain "0200147"