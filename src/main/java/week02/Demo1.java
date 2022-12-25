import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.wikipedia.org/");
        String str = driver1.getCurrentUrl();
        System.out.println("Test 1 :" + str);
        Thread.sleep(2000);
        WebElement searchInputBox = driver1.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchInputBox.sendKeys("English");

        WebElement searchButton = driver1.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i"));
        searchButton.click();
        String currentPageUrl = driver1.getCurrentUrl();
        if (currentPageUrl.equalsIgnoreCase("https://tr.wikipedia.org/wiki/T%C3%BCrk%C3%A7e")){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }
        Thread.sleep(2000);
        driver1.quit();
    }
}
