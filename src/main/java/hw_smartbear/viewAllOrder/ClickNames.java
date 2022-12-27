package hw_smartbear.viewAllOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class ClickNames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // to prevent to get message "Element Not Visible Exception"
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl04_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl05_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl06_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl08_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector")).click();

        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        Assert.assertEquals(driver.findElement(By.id("ctl00_MainContent_orderMessage")).getText(),"List of orders is empty. In order to add new order use this link.");

        driver.findElement(By.id("ctl00_MainContent_orderLInk")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div h2")).getText(),"Order");

        driver.close();

        System.out.println("TEST PASSED!");
    }
}
