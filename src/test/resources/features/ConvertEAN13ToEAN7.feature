Feature: Convert EAN13 to EAN7

  Scenario: Successful conversion of a valid EAN13 to EAN7
    Given the user has a valid EAN13 barcode "1234567890128"
    When the user converts the EAN13 barcode to EAN7
    Then the system should return the EAN7 barcode "1234567"

  Scenario: Conversion of an invalid EAN13 barcode
    Given the user has an invalid EAN13 barcode "123456789012"
    When the user attempts to convert the EAN13 barcode to EAN7
    Then the system should display an error message "Invalid EAN13 barcode"

  Scenario: Conversion of an EAN13 barcode with non-numeric characters
    Given the user has an EAN13 barcode "12345A7890128"
    When the user attempts to convert the EAN13 barcode to EAN7
    Then the system should display an error message "Invalid EAN13 barcode"

  Scenario: Conversion of an EAN13 barcode with less than 13 digits
    Given the user has an EAN13 barcode "12345678901"
    When the user attempts to convert the EAN13 barcode to EAN7
    Then the system should display an error message "Invalid EAN13 barcode"

  Scenario: Conversion of an EAN13 barcode with more than 13 digits
    Given the user has an EAN13 barcode "12345678901234"
    When the user attempts to convert the EAN13 barcode to EAN7
    Then the system should display an error message "Invalid EAN13 barcode"

  Scenario Outline: Conversion of EAN13 barcodes with edge values
    Given the user has an EAN13 barcode "<ean13>"
    When the user converts the EAN13 barcode to EAN7
    Then the system should return the EAN7 barcode "<ean7>"

    Examples:
      | ean13           | ean7     |
      | 0000000000000   | 0000000  |
      | 9999999999999   | 9999999  |

  Scenario: Conversion of a valid EAN13 barcode with leading zeros
    Given the user has a valid EAN13 barcode "0000001234567"
    When the user converts the EAN13 barcode to EAN7
    Then the system should return the EAN7 barcode "0000123"

  Scenario: Conversion of a valid EAN13 barcode with trailing zeros
    Given the user has a valid EAN13 barcode "1234567000000"
    When the user converts the EAN13 barcode to EAN7
    Then the system should return the EAN7 barcode "1234567"