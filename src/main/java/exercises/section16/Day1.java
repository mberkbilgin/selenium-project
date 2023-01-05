package exercises.section16;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {
    @AfterTest
    public void lastexecution(){
        System.out.println("I will execute last");
    }
    @Test
    @AfterSuite
    public void afSuite(){
        System.out.println("I am the number 1 from last ");
    }
    public void Demo() {
        System.out.println("Hello");
    }
    @Test
    public void SecondTest() {
        System.out.println("bye");
    }
}
