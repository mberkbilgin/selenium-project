package exercises.section17.pageObjects;

import exercises.section18.CartPage;
import exercises.section18.ProductCatalogue;
import exercises.section19.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest extends BaseTest {
    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() throws InterruptedException, IOException {
        String productName = "ZARA COAT 3";

        landingPage.loginApplication("asdasf@asdas.com","1234567.As");
        Assert.assertEquals("Incorrect email or password.",landingPage.getErroMessage());
    }
    @Test
    public void ProductErrorValidation() throws InterruptedException, IOException {
        String productName = "ZARA COAT 3";

        ProductCatalogue productCatalogue = landingPage.loginApplication("asdas@asdas.com","123456.As");

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCarPage();

        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);


    }
}
