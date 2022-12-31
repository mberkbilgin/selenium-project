package hw_swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown03 {
    public static void main(String[] args) {
        // low --->> high

        WebDriver driver = login();
        driver.manage().window().maximize();

        WebElement staticDropbox = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select dropdown = new Select(staticDropbox);
        dropdown.selectByValue("lohi");

        //driver.findElement(By.xpath("//select/option[3]")).click();
        List<WebElement> labels = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i = 0; i < labels.size() - 1; i++) {
            String[] prices = labels.get(i).getText().split("\\$");
            String[] prices1 = labels.get(i + 1).getText().split("\\$");
            if (Double.parseDouble(prices[1]) - Double.parseDouble(prices1[1]) > 0) {
                System.out.println("TEST IS FAILED!");
                System.exit(-1);
            }
        }
        System.out.println("TEST PASSED!");

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
