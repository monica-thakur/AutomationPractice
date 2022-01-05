@Regression
Feature: Checkout

  Scenario: Checkout from Automation Practice store
    Given user goes to products page
    And user navigates to "Summer Dresses" home category
    And user adds first item to cart
    And user checks out from "home" page
    And user checks out from "order-summary" page
    Then verify user is at "sign-in" page
