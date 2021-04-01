Feature: feature to test login functionality

  Scenario Outline: Check login is successfull with valid login credentials
    Given user is on login page
    When user enter valid <username> and <password>
    And click on submit button
    Then user must redirect to home page

    Examples: 
      | username  | password |
      | shrikant  |    12345 |
      | Aishwarya |     1354 |
