package exercises.section16;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
    @Parameters({"URL"})
    @Test
    public void WebLoginHomeLoan(String uname){
        System.out.println("webloginhomePersonalLoan");
        System.out.println(uname);

    }
    @Test(groups = {"smoke"})
    public void MobileLoginHomeLoan(){
        System.out.println("MobileLoginHomeLoan");
    }
    @Test
    public void LoginAPIHomeLoan(){
        System.out.println("LoginAPIHomeLoan");
    }
}
