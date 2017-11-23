Feature: Login Feature
  This feature deals with the Login functionality of the application

  Scenario: Verify login functionality with valid credentails of GitHub application

    Given I navigate to GitHublanding page
    When I input valid credentials of "username" and "password"
    Then I see Github home page with all my open source projects
        And I can successfully signout from the application

  Scenario: Verify login functionality with invalid credentails of GitHub application

     Given I navigate to GitHublanding page
     When I input invalid credentials of "username" and "password"
     Then I see an error message for invalid credentials
