package exercises.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/exercises/cucumber",glue = "exercises.stepDefinition",tags = "@Regression", monochrome = true,plugin = {"html:target/cucumber.html"})
public class TestNGTestRunnerTest extends AbstractTestNGCucumberTests {

}
