package hw.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Reset {
    public static void main(String[] args) {
        WebDriver driver = login();

        driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("3");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Jack Sparrow");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("St55");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Topeka");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Kansas");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("485926");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("7848597813204");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("08/29");
        driver.findElement(By.cssSelector("input[type='reset']")).click();

        Assert.assertEquals(Integer.parseInt(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).getAttribute("value")),0);

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


