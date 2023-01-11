@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
    Examples:
      | name            | password  | productName |
      | asdas@asdas.com | 123456.As | ZARA COAT 3 |