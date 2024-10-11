Feature: EAN13 to EAN7 Conversion

Scenario: Successful conversion of a 12-character EAN starting with "02"
  Given I am a user with a 12-character EAN "020014703096"
  When I submit the EAN
  Then a "0" is added at the beginning to format it as EAN13
  And the last 6 characters are removed to get an EAN7 "0200147"

Scenario: Successful conversion of a 12-character EAN starting with "21"
  Given I am a user with a 12-character EAN "210014703096"
  When I submit the EAN
  Then a "0" is added at the beginning to format it as EAN13
  And the last 6 characters are removed to get an EAN7 "2100147"

Scenario: 12-character EAN not starting with specified prefixes
  Given I am a user with a 12-character EAN "310014703096"
  When I submit the EAN
  Then the EAN is not modified

Scenario: 13-character EAN
  Given I am a user with a 13-character EAN "1234567890123"
  When I submit the EAN
  Then the EAN is not modified

Scenario: Conversion of a 12-character EAN "0200147030964"
  Given I am a user with a 12-character EAN "0200147030964"
  When I submit the EAN
  Then a "0" is added at the beginning to format it as EAN13, resulting in "00200147030964"
  And the last 6 characters are removed to get "0200147"