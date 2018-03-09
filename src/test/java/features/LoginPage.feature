@smoke @release1 @sprint1
Feature: Login Feature
  This feature deals with the Login functionality of the application

  Scenario: Verify login functionality with valid credentails of Amazon application

    Given I navigate to Amazon landing page
    When I input valid credentials of "cigniti.automationDemo@gmail.com" and "Cigniti@2017"
    Then I see Amazon home page with title as ""

  Scenario: Verify login functionality with invalid credentails of Amazon application

    Given I navigate to Amazon landing page
     When I input invalid credentials of "username" and "password"
     Then I do not see  Amazon home page
