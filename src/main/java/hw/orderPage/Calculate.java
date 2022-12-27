package hw.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Calculate {
    public static void main(String[] args) {
        WebDriver driver = login();

        driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
        List<WebElement> options = driver.findElements(By.cssSelector("select option"));

        for (int i = 0; i < options.size(); i++) {
            options.get(i).click();

            driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("9");

            int quantity = Integer.parseInt(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).getAttribute("value"));
            int pricePerUnit = Integer.parseInt(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).getAttribute("value"));

            driver.findElement(By.cssSelector("input[type='submit']")).click();

            Assert.assertEquals(Integer.parseInt(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value")), quantity * pricePerUnit);

        }
        driver.quit();

    }

    private static WebDriver login() {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // to prevent to get message "Element Not Visible Exception"
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        return driver;
    }
}
