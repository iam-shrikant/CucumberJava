Feature: Search for iPhones on Flipkart website

  Scenario: Search for iPhone mobile having a maximum price of INR 40000 on Flipkart website
    Given Open browser
    And Goto Flipkart.com
    When User search for iPhones mobile 
    And Having maximum price of INR 50000
    Then Retrive and Save device model, Storage capacity and customer rating