package hw_swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Buttons {
    public static void main(String[] args) {
        WebDriver driver = login();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (WebElement button : addToCartButtons) {
            button.click();
        }
        WebElement cartButton = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        int numbersOfCart = Integer.parseInt(cartButton.getText());
        Assert.assertEquals(numbersOfCart, addToCartButtons.size());

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(numbersOfCart, listOfProducts.size());

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
