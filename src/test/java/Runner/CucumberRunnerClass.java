package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "", features = "src/test/resources/Features/SearchProduct.feature", glue = "Definitions") 
 
public class CucumberRunnerClass extends AbstractTestNGCucumberTests {
 
}