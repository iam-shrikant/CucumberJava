Feature: feature to test google search functionality

  Scenario: Validate google search
    Given open browser
    And goto google.com
    When user enter text for search
    And Press enter or search
    Then user should navigate to search result page
