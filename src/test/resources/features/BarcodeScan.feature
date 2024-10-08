Feature: Interpretation of EAN13 to EAN7

Background:
Given the user has installed the Android application
And the user has opened the application

Scenario: Successful interpretation of a valid EAN13
Given the user is on the barcode scan page
When the user scans a valid EAN13 "0212345678901"
Then the application should interpret it as an EAN7 "0212345"
And the user should see the EAN7 displayed on the screen

Scenario: Handling an invalid EAN13
Given the user is on the barcode scan page
When the user scans an invalid EAN13 "123456789012"
Then the application should display an error message "Invalid EAN13"

Scenario: Handling a very short barcode
Given the user is on the barcode scan page
When the user scans a barcode "123"
Then the application should display an error message "Invalid barcode length"

Scenario: Handling a very long barcode
Given the user is on the barcode scan page
When the user scans a barcode "12345678901234567890"
Then the application should display an error message "Invalid barcode length"

Scenario Outline: Interpretation of various valid EAN13s
Given the user is on the barcode scan page
When the user scans a valid EAN13 "<ean13>"
Then the application should interpret it as an EAN7 "<ean7>"
And the user should see the EAN7 displayed on the screen

Examples:
| ean13          | ean7    |
| 0212345678901  | 0212345 |
| 2212345678901  | 2212345 |
| 2912345678901  | 2912345 |

Scenario Outline: Handling various invalid EAN13s
Given the user is on the barcode scan page
When the user scans an invalid EAN13 "<invalid_ean13>"
Then the application should display an error message "Invalid EAN13"

Examples:
| invalid_ean13  |
| 123456789012   |
| 987654321098   |
| 111111111111   |

Scenario: Handling an empty barcode input
Given the user is on the barcode scan page
When the user scans an empty barcode
Then the application should display an error message "No barcode detected"

Scenario: Handling a non-numeric barcode input
Given the user is on the barcode scan page
When the user scans a non-numeric barcode "ABCDEF123456"
Then the application should display an error message "Invalid barcode format"