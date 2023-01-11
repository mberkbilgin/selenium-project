package exercises.stepDefinition;

import exercises.section18.*;
import exercises.section19.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefinition extends BaseTest {
    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String username, String password) {
        productCatalogue = landingPage.loginApplication(username, password);

    }
 @When("^I add product (.+) from Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException {
     List<WebElement> products = productCatalogue.getProductList();
     productCatalogue.addProductToCart(productName);
 }
 @When("^Checkout (.+) and submit the order$")
    public void check_out_submit_order(String productName){
     CartPage cartPage = productCatalogue.goToCarPage();
     Boolean match = cartPage.verifyProductDisplay(productName);
     Assert.assertTrue(match);
     CheckoutPage checkoutPage = cartPage.goToCheckout();
     checkoutPage.selectCountry("india");
     confirmationPage = checkoutPage.submitOrder();
 }
 @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string){
     String confirmationMessage = confirmationPage.verifyConfirmationMessage();
     Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
     driver.close();
 }
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
        Assert.assertEquals("Incorrect email or password.",landingPage.getErroMessage());
        driver.close();
    }
}
