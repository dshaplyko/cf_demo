Feature: EAN13 to EAN7 Conversion

  Scenario: Convert EAN13 barcode to EAN7
    Given the app is launched
    When I scan an EAN13 barcode
    Then I should see the EAN7 conversion result