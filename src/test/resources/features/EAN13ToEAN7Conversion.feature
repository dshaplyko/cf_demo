Feature: EAN13 to EAN7 Conversion

  Scenario: Provided Example
    Given an EAN of 13 characters "0200147030964"
    When I submit this EAN to the application
    Then the last 6 characters are removed to obtain "0200147"