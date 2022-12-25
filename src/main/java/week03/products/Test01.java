package week03.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Test01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Mehmet");
        driver.findElement(By.id("last-name")).sendKeys("Dag");
        driver.findElement(By.id("postal-code")).sendKeys("34165");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h2[class='complete-header']")).getText(),"THANK YOU FOR YOUR ORDER");
        driver.close();

    }
}