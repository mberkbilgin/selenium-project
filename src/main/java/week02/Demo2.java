import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/MBB/Desktop/SDET/driver/chromedriver.exe");
        int indexOfTest = 1;

        //Username,Password
        String[] arr = {"Tester,test","Tester,abcd","Hamza,Ali"};

        for (String param:arr){
            String[] paramArrs = param.split(",");

            String userName = paramArrs[0];
            String password = paramArrs[1];
            WebDriver driver1 = new ChromeDriver();

        }


    }
}
