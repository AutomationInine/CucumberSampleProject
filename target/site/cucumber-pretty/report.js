$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SearchProduct.feature");
formatter.feature({
  "line": 2,
  "name": "AamzonSearch Feature",
  "description": "\r\nThis feature deals with the search functionality of the amazon application",
  "id": "aamzonsearch-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    },
    {
      "line": 1,
      "name": "@release2"
    },
    {
      "line": 1,
      "name": "@sprint4"
    },
    {
      "line": 1,
      "name": "@search"
    }
  ]
});
formatter.before({
  "duration": 16014015962,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Verify search and adding to Cart functionality of Amazon application",
  "description": "",
  "id": "aamzonsearch-feature;verify-search-and-adding-to-cart-functionality-of-amazon-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I navigate to Amazon landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I search for \"iphone\" product",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I see search results",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I add first result to the cart",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I see cart count is increased by 1 to the earlier cartCount",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_Amazon_landing_page()"
});
formatter.result({
  "duration": 174671595,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iphone",
      "offset": 14
    }
  ],
  "location": "SearchProductsSteps.i_search_for_product(String)"
});
formatter.result({
  "duration": 13627083952,
  "status": "passed"
});
formatter.match({
  "location": "SearchProductsSteps.i_see_search_results()"
});
formatter.result({
  "duration": 6225903215,
  "status": "passed"
});
formatter.match({
  "location": "SearchProductsSteps.i_add_first_result_to_the_cart()"
});
