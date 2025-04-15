package pageObject;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniumHelpers;

public class FormPage {
	WebDriver driver;

	public FormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstNameEle;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastNameEle;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement emailEle;

//	@FindBy(xpath = "//label[text()='\" + gender + \"']")
//	private WebElement gender;

	@FindBy(xpath = "//input[@id='userNumber']")
	private WebElement mobileEle;

	@FindBy(xpath = "//*[@id='subjectsContainer']//input")
	private WebElement subjectEle;

	@FindBy(xpath = "//label[text()='Sports']")
	private WebElement sportsEle;

	@FindBy(xpath = "//label[text()='Reading']")
	private WebElement readingEle;

	@FindBy(xpath = "//label[text()='Music']")
	private WebElement musicEle;

	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement filepathEle;

	@FindBy(xpath = "//textarea")
	private WebElement addressEle;

	@FindBy(xpath = "//div[@id='state']")
	private WebElement stateEle;

	@FindBy(xpath = "//div[@id='city']")
	private WebElement cityEle;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submitEle;
	
	@FindBy(xpath="//input[@id='dateOfBirthInput']")
	private WebElement dobField;
	
	@FindBy(className="react-datepicker__year-select")
	private WebElement yearDropdownEle;
	
	@FindBy(className="react-datepicker__month-select")
	private WebElement monthDropdownEle;
	

	public void setFirstName(String fName) throws InterruptedException {
		Thread.sleep(1000);
		if(fName.isEmpty()) {
			return;
		}
		SeleniumHelpers.sendData(firstNameEle,fName);
	}

	public void setLastName(String lName) {
		if(lName.isEmpty()) {
			return;
		}
		SeleniumHelpers.sendData(lastNameEle, lName);
	}

	public void setEmail(String email) {
		if(email.isEmpty()) {
			return;
		}
		else {
				SeleniumHelpers.sendData(emailEle, email);
		}

	}

	public void setGender(String gender) {
		if (gender.equals("Male") || gender.equals("Female") || gender.equals("Other")) {
			WebElement gen = driver.findElement(By.xpath("//label[text()='" + gender + "']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);
			gen.click();
		}

	}

	public void setMobileNo(String mobileNo) {
		if(mobileNo.isEmpty()|| !(mobileNo.length()==10)) {
			return;
		}
		else {
			SeleniumHelpers.sendData(mobileEle, mobileNo);
		}
	}



	public void setSubject(String subjects) {
		if (subjects.isEmpty()||subjects == null) {
			return;
		} else {
			Actions actions = new Actions(driver);
			SeleniumHelpers.sendData(subjectEle, subjects);
			actions.keyDown(Keys.ENTER).click().keyUp(Keys.ENTER).perform();

		}

	}

	public void setSports(String sports) {
		if (sports.equals("TRUE")) {
			SeleniumHelpers.clickOn(sportsEle);
		}
	}

	public void setReading(String reading) {
		if (reading.equals("TRUE")) {
			SeleniumHelpers.clickOn(readingEle);
		}
	}

	public void setMusic(String music) {
		if (music.equals("TRUE")) {
			SeleniumHelpers.clickOn(musicEle);
		}
	}

	public void setDob(String year, String month, String date) throws InterruptedException {
		SeleniumHelpers.clickOn(dobField);
		Select yearSelect = new Select(yearDropdownEle);
		yearSelect.selectByVisibleText(year);
//		Thread.sleep(2000);
		Select monthSelect = new Select(monthDropdownEle);
		monthSelect.selectByVisibleText(month);
//		Thread.sleep(2000);
		WebElement dateEle = driver.findElement(By.xpath("//div[contains(@class, "+date+")]"));
		SeleniumHelpers.clickOn(dateEle);
//		Thread.sleep(2000);

	}
	
	
	public void setChooosefile(String filePath) {
		SeleniumHelpers.uploadFile(filepathEle,filePath);
	}

	public void setAddress(String address) {
		if (address.length() > 0 && address.length() <= 20) {
			SeleniumHelpers.sendData(addressEle, address);
		} else {
			return;
		}
	}

	public void setStateAndCity(String state, String city) {
		try {
			
			SeleniumHelpers.clickOn(stateEle);
			
			if (state.isEmpty()) {
				return;
			}
			WebElement ss = driver.findElement(By.xpath("//div[text()='" + state + "']"));
			ss.click();

			SeleniumHelpers.clickOn(cityEle);

			if (city.isEmpty()) {
				return;
			} else {
				WebElement cs = driver.findElement(By.xpath("//div[text()='" + city + "']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cs);
				cs.click();
			}
		} 
		catch (NoSuchElementException e) {
			System.out.println("Dropdown not found for ID: " + state);
		}
		catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for dropdown ID: " + city);
		} 
		catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public void setSubmit() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitEle);
		SeleniumHelpers.clickOn(submitEle);
		Thread.sleep(1000);
	}

}
