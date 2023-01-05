package exercises.section16;

import org.testng.annotations.*;

public class Day3 {
    @BeforeClass
    public void befoclass(){
        System.out.println("Before executing any methods in the class");
    }
    @AfterClass
    public void afteclass(){
        System.out.println("After executing any methods in the class");
    }
    @Parameters({"URL","APIKey/usrname"})
    @Test
    public void WebLoginCarLoan(String urlname, String key){
        System.out.println("weblogincar");
        System.out.println(urlname);
        System.out.println(key);
    }
    @Test(groups = {"smoke"})
    public void MobileLoginCarLoan(){
        System.out.println("MobileLoginCarLoan");
    }

    @BeforeSuite
    public void Bfsuite(){
        System.out.println("I am number one");
    }
    @BeforeMethod
    public void beforeevery(){
        System.out.println("I will execute before every test method in day 3 class");
    }
    @AfterMethod
    public void afterevery(){
        System.out.println("I will execute after every test method in day 3 class");
    }
    @Test(enabled = false)
    public void MobileSignCarLoan(){
        System.out.println("MobileSignCarLoan");
    }

    @Test(dataProvider = "getData")
    public void MobileSignoutCarLoan(String username, String password){
        System.out.println("MobileSignoutCarLoan");
        System.out.println(username);
        System.out.println(password);
    }

    @Test(dependsOnMethods = {"WebLoginCarLoan"})
    public void APICarLoan(){
        System.out.println("APIlogincar");
    }
    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];
        data[0][0] = "firstsetusername";
        data[0][1] = "firstpassword";

        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";

        data[2][0] = "thirdsetusername";
        data[2][1] = "thirdpassword";

        return data;

    }
}
