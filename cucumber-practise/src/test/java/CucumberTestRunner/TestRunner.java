package CucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@Sanity or @Smoke",
		features = {"src/test/resources/features"},
		glue = {"StepDefinitions"},
		plugin = {"pretty", "html:cucumberTestReports//cucumber-reports.html"} //report generation
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	

}
