package exercises.section16;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {
    @Test(groups = {"smoke"})
    public void ploan(){
        System.out.println("good");
    }
    @BeforeTest
    public void prerequiste(){
        System.out.println("I will execute first");
    }

}
