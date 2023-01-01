package exercises.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> options = driver.findElements(By.cssSelector("[type='checkbox']"));
        options.get(1).click();
        String name = driver.findElement(By.xpath("//label[normalize-space()='Option2']")).getText();
        System.out.println(name);

        WebElement staticDropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText(name);

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();

        if(driver.switchTo().alert().getText().contains(name)){
            System.out.println("TEST PASSED!");
        }



    }
}
