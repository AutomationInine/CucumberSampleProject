$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginPage.feature");
formatter.feature({
  "line": 2,
  "name": "Login Feature",
  "description": "This feature deals with the Login functionality of the application",
  "id": "login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    },
    {
      "line": 1,
      "name": "@release1"
    },
    {
      "line": 1,
      "name": "@sprint1"
    }
  ]
});
formatter.before({
  "duration": 18862568124,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Verify login functionality with valid credentails of Amazon application",
  "description": "",
  "id": "login-feature;verify-login-functionality-with-valid-credentails-of-amazon-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I navigate to Amazon landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I input valid credentials of \"cigniti.automationDemo@gmail.com\" and \"Cigniti@2017\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I see Amazon home page with title as \"\"",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_Amazon_landing_page()"
});
formatter.result({
  "duration": 196104032,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cigniti.automationDemo@gmail.com",
      "offset": 30
    },
    {
      "val": "Cigniti@2017",
      "offset": 69
    }
  ],
  "location": "LoginSteps.i_input_valid_credentials_of_and(String,String)"
});
