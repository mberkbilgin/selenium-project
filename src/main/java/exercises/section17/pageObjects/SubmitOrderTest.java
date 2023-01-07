package exercises.section17.pageObjects;

import exercises.section18.*;
import exercises.section19.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void SubmitOrder(HashMap<String,String> input) throws InterruptedException, IOException {


        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCarPage();

        Boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmationMessage = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }
    @Test(dependsOnMethods = {"SubmitOrder"})
    public void OrderHistoryTest(){
        ProductCatalogue productCatalogue = landingPage.loginApplication("asdas@asdas.com","123456.As");
        OrdersPage ordersPage = productCatalogue.goToOrdersPage();
        ordersPage.verifyOrderDisplay(productName);
    }
    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//" + testCaseName + ".png" ;

    }
    @DataProvider
    public Object[][] getData() throws IOException {
   /*     HashMap<String,String> map = new HashMap<>();
        map.put("email","asdas@asdas.com");
        map.put("password","123456.As");
        map.put("product","ZARA COAT 3");

        HashMap<String,String> map1 = new HashMap<>();
        map1.put("email","asdas@asdas.com");
        map1.put("password","123456.As");
        map1.put("product","ADIDAS ORIGINAL");
*/
        List<HashMap<String,String>> data = getJasonDataToMap(System.getProperty("user.dir") + "//src/main/java/exercises/section20/PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}
