@smoke @release2 @sprint4 @search
Feature: AamzonSearch Feature

  This feature deals with the search functionality of the amazon application

  Scenario: Verify search and adding to Cart functionality of Amazon application

    Given I navigate to Amazon landing page
    When I search for "iphone" product
    Then I see search results

    When I add first result to the cart
    Then I see cart count is increased by 1 to the earlier cartCount


