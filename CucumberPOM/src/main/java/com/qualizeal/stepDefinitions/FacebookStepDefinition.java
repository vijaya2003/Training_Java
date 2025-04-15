package com.qualizeal.stepDefinitions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qualizeal.commonUtilities.BaseClass;
import com.qualizeal.commonUtilities.SeleniumHelpers;
import com.qualizeal.pages.FBLoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookStepDefinition {
    WebDriver driver;
    FBLoginPage fbLogin; 
    static ExtentReports extent;
    ExtentTest test;

    @Before
    public void setUp() {
    	File reportsDir = new File("TestOutput");
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "TestOutput/Extent-Report-" + timestamp + ".html";

        
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        test = extent.createTest("Facebook Login Test");
        
        BaseClass.initializeDriver();  
        driver = BaseClass.getDriver();  
        new SeleniumHelpers(driver);  
        driver.get("https://www.facebook.com");
        fbLogin = new FBLoginPage(driver);
        
        test.info("Browser launched and navigated to Facebook login page.");
    }


    @Given("User is on the Facebook login page")
    public void user_is_on_facebook_login_page() {
        driver.get("https://www.facebook.com");
        test.pass("User is on Facebook login page.");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        fbLogin.enterEmail(username);
        fbLogin.enterPassword(password);
        test.pass("Entered username and password.");
    }

    @And("User clicks on the login button")
    public void user_clicks_login() {
        fbLogin.clickLogin();
        test.pass("Clicked on login button.");
    }
    
    @Then("User Closes the Browser")
    public void user_closes_the_browser() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	
    	if (driver != null) {
    		driver.close();
    		test.pass("Closed the browser.");
    	}
    	
    }
    
    @After
    public void close() {
    	if (driver != null) {
    		driver.quit();
    		driver = null;
    		test.pass("Browser session ended.");
    	}
    	
    	extent.flush();
    }
}
