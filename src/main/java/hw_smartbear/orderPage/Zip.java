package hw_smartbear.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Zip {
    public static void main(String[] args) {
        WebDriver driver = login();

        driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("a");
        driver.findElement(By.cssSelector("label[for='ctl00_MainContent_fmwOrder_TextBox1']")).click();// to take error message
        Assert.assertEquals(driver.findElement(By.id("ctl00_MainContent_fmwOrder_rev1")).getText(),"Invalid format. Only digits allowed.");

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
