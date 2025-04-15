package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelpers;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailEle;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordEle;
	
	@FindBy(xpath = "//input[@id='RememberMe']")
	private WebElement rememberMeEle;
	
	@FindBy(xpath = "//span[@class='forgot-password']//a")
	private WebElement forgetEle;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginEle;

	
	public void setEmail(String email) {
		if(email.isEmpty()) {
			System.out.println("emailid is null");
			return;
		}
		else {
				SeleniumHelpers.sendData(emailEle, email);
		}
	}

	public void setPassword(String password) {
		if(password.length()>=8) {
			SeleniumHelpers.sendData(passwordEle, password);
		}
		else {
			System.out.println("incorrect password");
		}
		
	}
	
	public void setRememberMe() {
		SeleniumHelpers.clickOn(rememberMeEle);
	}
	
	public void setForget() {
		SeleniumHelpers.clickOn(forgetEle);
	}

	public void setLogin(String login) throws InterruptedException {
		SeleniumHelpers.clickOn(loginEle);	
		Thread.sleep(2000);
		if(driver.getTitle()=="Demo Web Shop") {
			System.out.println("Home page is opened");
		}
		else {
			System.out.println("Home page is not opend");
		}
	}

}
