package hw_swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class E2E {
    public static void main(String[] args) {
        WebDriver driver = login();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("a[class=shopping_cart_link]")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Idris");
        driver.findElement(By.id("last-name")).sendKeys("Garden");
        driver.findElement(By.id("postal-code")).sendKeys("34537");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h2[class='complete-header']")).getText(),"THANK YOU FOR YOUR ORDER");

        driver.quit();

    }
    private static WebDriver login() {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        return driver;

    }
}
