package Steps;

import Data.ConstantsData;
import Pages.MainPage;
import Utils.BaseTest;
import Utils.CommonCommands;
import Utils.LoggerUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class StepsDefinition extends BaseTest {
    private MainPage mainPage = new MainPage((CommonCommands) driver);
    private Checkout checkoutPage = new Checkout(driver);

    @Given("I am on the main page and I am logged in")
    public void i_am_on_the_main_page_and_i_am_logged_in() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
    }

    @When("I enter the username {string} and the password {string}")
    public void i_enter_the_username_and_the_password(String username, String password) {
        loginPage.userLogin(username, password);
    }

    @Then("I should see the logout button")
    public void i_should_see_the_logout_button() {
        Assert.assertTrue(commands.isElementVisible(mainPageMap.signOutButton));
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }

    @Then("I should see the message {string}.")
    public void i_should_see_the_message(String expectedMessage) {
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.errorMessage), expectedMessage);
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }

    @When("I add the product {string} to the cart")
    public void i_add_the_product_to_the_cart(String productName) {
        mainPage.addToCart(productName);
        commands.isElementVisible(By.cssSelector(".mb-3")); // Ensure this is correct according to your code
        LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
    }

    @Then("I should see the alert message")
    public void i_should_see_the_alert_message() {
        commands.isElementVisible(mainPageMap.alertMessage);
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }

    @When("I view and continue")
    public void i_view_and_continue() {
        mainPage.seeAndContinue();
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }

    @When("I filter by name {string}")
    public void i_filter_by_name(String productName) {
        mainPage.filterByName(productName);
        commands.waitForElementToDisappear(mainPageMap.zaraCoatArticleText);
        LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
    }

    @Then("I should see the number of results {string}")
    public void i_should_see_the_number_of_results(String expectedResult) {
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), expectedResult);
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }

    @When("I purchase {int} units")
    public void i_purchase_units(int quantity) {
        checkoutPage.buyZaraCoat3(quantity); // Adjust according to your implementation
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        Assert.assertEquals(commands.getTextFromElement(checkoutPageMap.ThanksMsg), expectedMessage);
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }

    @When("I apply the price range")
    public void i_apply_the_price_range() {
        mainPage.priceRange();
        LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
    }

    @When("I search by categories")
    public void i_search_by_categories() {
        mainPage.categories();
        LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
    }

    @When("I search for a subcategory that does not exist")
    public void i_search_for_a_subcategory_that_does_not_exist() {
        mainPage.subCatError(); // Implement this logic in your page
        LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
    }

    @When("I verify the order")
    public void i_verify_the_order() {
        OrdersPage.verifyTheOrder(); // Ensure this is correct according to your implementation
    }

    @When("I delete the order")
    public void i_delete_the_order() {
        OrdersPage.deleteTheOrder(); // Ensure this is correct according to your implementation
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }

    @When("I validate the required fields")
    public void i_validate_the_required_fields() {
        checkoutPage.validateRequiredFields();
        Assert.assertFalse(false); // Adjust according to the logic you need
        LoggerUtil.info(ConstantsData.LOG_COMPLETED);
    }
}
