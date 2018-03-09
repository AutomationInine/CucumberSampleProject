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
  "duration": 18439707297,
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
  "duration": 128255361,
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
formatter.result({
  "duration": 19060837136,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 38
    }
  ],
  "location": "LoginSteps.i_see_Amazon_home_page_with_title_as(String)"
});
formatter.result({
  "duration": 14505144,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cAmazon[.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs \u0026 more]\u003e but was:\u003cAmazon[[[.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs \u0026 more]]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat steps.LoginSteps.i_see_Amazon_home_page_with_title_as(LoginSteps.java:37)\r\n\tat ✽.Then I see Amazon home page with title as \"\"(LoginPage.feature:9)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 2283330840,
  "status": "passed"
});
formatter.before({
  "duration": 16084137490,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Verify login functionality with invalid credentails of Amazon application",
  "description": "",
  "id": "login-feature;verify-login-functionality-with-invalid-credentails-of-amazon-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "I navigate to Amazon landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I input invalid credentials of \"username\" and \"password\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I do not see  Amazon home page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_Amazon_landing_page()"
});
formatter.result({
  "duration": 99525,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "username",
      "offset": 32
    },
    {
      "val": "password",
      "offset": 47
    }
  ],
  "location": "LoginSteps.i_input_invalid_credentials_of_and(String,String)"
});
formatter.result({
  "duration": 36234582258,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.i_do_not_see_Amazon_home_page()"
});
formatter.result({
  "duration": 27398918,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cAmazon[ Sign In]\u003e but was:\u003cAmazon[[.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs \u0026 more]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat steps.LoginSteps.i_do_not_see_Amazon_home_page(LoginSteps.java:49)\r\n\tat ✽.Then I do not see  Amazon home page(LoginPage.feature:15)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1200027805,
  "status": "passed"
});
});