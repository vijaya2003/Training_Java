Feature: submitting the form

  Scenario: User submits the form successfully
    Given I navigate to the DemoApplication Page
    When I enter valid credentials for mandatory fields like FirstName,LastName,Gender and mobile Number
    When I enter the remaing feilds in the DemoApplication Page
    When I click on submit button
    Then I should see the page like Thanks for submitting the form