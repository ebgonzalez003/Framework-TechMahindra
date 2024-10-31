Feature: Shopping functionality

  Background:
    Given I am on the main page and I am logged in

  @regression
  Scenario: Validate login credentials
    When I enter the username "valid_username" and the password "valid_password"
    Then I should see the logout button

  @regression
  Scenario: Validate incorrect credentials
    When I enter the username "invalid_username" and the password "invalid_password"
    Then I should see the message "Incorrect email or password."

  @smoke
  Scenario: Add product to cart
    When I add the product "IPHONE 13 PRO" to the cart
    Then I should see the alert message

  @smoke
  Scenario: View and continue
    When I view and continue
    Then I should be redirected correctly

  @smoke
  Scenario: View and add to cart
    When I view and add to cart
    Then I should be redirected correctly

  @regression
  Scenario: Filter by name
    When I filter by name "IPHONE"
    Then I should see the number of results "1"

  @regression
  @smoke
  Scenario: Buy a Zara coat
    When I add the product "ZARA COAT" to the cart
    And I purchase 3 units
    Then I should see the message "Thank you for your purchase"

  @smoke
  Scenario: Validate price range
    When I apply the price range
    Then I should see the number of results "4"

  @smoke
  Scenario: Search by categories
    When I search by categories
    Then I should see the number of results "4"

  @smoke
  Scenario: Product should not appear
    When I search for a subcategory that does not exist
    Then I should see the number of results "0"

  @regression
  @smoke
  Scenario: Validate order after purchase
    When I add the product "ZARA COAT" to the cart
    And I verify the order
    Then I should see the message "Thank you for your order"

  @smoke
  Scenario: Delete the order
    When I delete the order
    Then I should see a success message

  @smoke
  Scenario: Validate required fields
    When I add the product "ZARA COAT" to the cart
    And I validate the required fields
    Then I should show validation errors
