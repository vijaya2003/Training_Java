package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagDemoLogin {
	static WebDriver driver;
	
	@Given("Launch swag demo application")
	public void launch_swag_demo_application() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		driver.get("https://www.saucedemo.com/v1/index.html");
	}

	@When("Enter valid username and password")
	public void enter_valid_username_and_password() {
	    WebElement username=driver.findElement(By.id("user-name"));
	    WebElement pass=driver.findElement(By.id("password"));
	    username.sendKeys("standard_user");
	    pass.sendKeys("secret_sauce");    
	}
	
	@And("Click on login button")
	public void click_on_login_button() {
		WebElement login=driver.findElement(By.id("login-button"));
		login.click();
	}

	@Then("Validate home page is launched")
	public void validate_home_page_is_launched() {
	   
	}

	@And("Close swag demo application")
	public void close_swag_demo_application() {
	    driver.quit();
	}
	
	@Given("Launch orangeHRM application")
	public void launch_orange_hrm_application() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
	}

	@When("Enter login credintials")
	public void enter_login_credintials() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
	}

	@When("Click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	}

	@Then("Validate orangeHRM home page is launched")
	public void validate_orange_hrm_home_page_is_launched() {
	    
	}

	@Then("Close orangeHRM application")
	public void close_orange_hrm_application() {
		driver.quit();
	}

}
