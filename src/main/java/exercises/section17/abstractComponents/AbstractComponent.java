package exercises.section17.abstractComponents;

import exercises.section18.CartPage;
import exercises.section18.OrdersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;
    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public CartPage goToCarPage() {
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    public OrdersPage goToOrdersPage() {
        orderHeader.click();
        OrdersPage orderPage = new OrdersPage(driver);
        return orderPage;
    }

    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(1000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOf(ele));
    }
}
