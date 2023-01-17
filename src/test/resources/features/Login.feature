Feature: Login Functionality

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters valid emai address "<Username>" into email field
    And User has entered valid password "<Password>" into password field
    And User clicks on Login button
    Then User should get successfully logged in

    Examples: 
      | Username            | Password |
      | sachin121@gmail.com |    12345 |
      | sachin121@gmail.com |    12345 |
      | sachin121@gmail.com |    12345 |

  Scenario: Login with Invalid credentials
    Given User navigates to login page
    When User enters invalid emai address into email field
    And User has entered valid password "12345284" into password field
    And User clicks on Login button
    Then User should get warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When User enters valid emai address "sachin121@gmail.com" into email field
    And User has entered valid password "12345284" into password field
    And User clicks on Login button
    Then User should get warning message about credentials mismatch

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid emai address into email field
    And User has entered valid password "12345" into password field
    And User clicks on Login button
    Then User should get warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User do not enter email address into email field
    And User do not enter password into password field
    And User clicks on Login button
    Then User should get warning message about credentials mismatch
