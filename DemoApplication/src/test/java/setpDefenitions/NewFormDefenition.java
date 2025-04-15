package setpDefenitions;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import pageObject.FormPage;
import utils.TestNGHelpers;


public class NewFormDefenition {
	public static WebDriver driver;
	
	@Before
	public void loadBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
	}

	FormPage fp = new FormPage(driver);
	
	@Given("I navigate to the DemoApplication Page")
    public void i_navigate_to_the_demo_application_page() {
		driver.get("https://demoqa.com/automation-practice-form");
    }

    @When("I enter valid credentials for mandatory fields like FirstName,LastName,Gender and mobile Number")
    public void i_enter_valid_credentials_for_mandatory_fields() throws InterruptedException {
        fp.setFirstName("Vijaya");
        fp.setLastName("Lakshmi");
        fp.setGender("Female");
        fp.setMobileNo("8008563393");
    }

    @When("I enter the remaining fields in the DemoApplication Page")
    public void i_enter_remaining_fields() {
        fp.setEmail("dasari@gmail.com");
        fp.setSubject("hindi");
        fp.setMusic("TRUE");
        fp.setReading("TRUE");
        fp.setSports("TRUE");
        fp.setChooosefile("TRUE");
        fp.setAddress("bhimavarm");
        fp.setStateAndCity("NCR", "Delhi");
        
        
    }

    @When("I click on submit button")
    public void i_click_on_submit_button() throws InterruptedException {
        fp.setSubmit();
    }
    
    TestNGHelpers th = new TestNGHelpers();

    @Then("I should see the page like Thanks for submitting the form")
    public void i_should_see_confirmation_page() {
        th.validateUsingAsserts(driver, "Vijaya", "Lakshmi", "Female", "8008563393");
    }
    

}
