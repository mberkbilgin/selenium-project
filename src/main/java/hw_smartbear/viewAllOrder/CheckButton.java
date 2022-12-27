package hw_smartbear.viewAllOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CheckButton {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // to prevent to get message "Element Not Visible Exception"
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        //Firstly, control of "uncheck all" button. If "Uncheck All" button
        //work properly, when "delete selected" button is clicked
        //nothing needs to change
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("td h1")).getText(),"Web Orders");

        //Secondly, control of "Check All" button. If this button work properly,
        //when "delete selected" button is clicked, we need to take message on the screen
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        Assert.assertEquals(driver.findElement(By.id("ctl00_MainContent_orderMessage")).getText(),"List of orders is empty. In order to add new order use this link.");

        driver.close();

        System.out.println("TEST IS PASSED!");
    }
}
