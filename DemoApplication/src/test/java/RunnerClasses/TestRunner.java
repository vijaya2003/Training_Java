package RunnerClasses;

//import io.cucumber.spring.CucumberContextConfiguration;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature",  // Path to your feature files
    glue = "stepdefinitions",      // Path to your step definition package
    plugin = {"pretty", "html:target/cucumber-reports.html"},  // Report generation
    tags = "@SmokeTest",                       // (Optional) You can specify tags to run specific tests
    monochrome = true                          // (Optional) Set to true to make the console output more readable
)


//public class TestRunner extends AbstractTestNGCucumberTests{
//	 
//    
//}


public class TestRunner extends AbstractTestNGCucumberTests{
	 
    
}
