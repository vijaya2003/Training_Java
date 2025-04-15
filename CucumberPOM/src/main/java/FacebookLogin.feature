@tag
Feature: Facebook Login

  Scenario: Login to Facebook with valid credentials
    Given User is on the Facebook login page
    When User enters username "8688170147" and password "Twinkle@1702"
    And User clicks on the login button
    Then User Closes the Browser
    
  

