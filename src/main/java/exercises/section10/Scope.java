package exercises.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        WebElement columnDriver = footerdriver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000);
        }
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }


    }
}
