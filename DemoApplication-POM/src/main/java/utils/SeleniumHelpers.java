package utils;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers {
	static WebDriver driver;
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebDriver browserOpen(String browser) {
		WebDriver driver;
		switch(browser){
		case "chrome" :
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		default:
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void sendData(WebElement ele,String data) {
		ele.sendKeys(data);
	}

	public static void clickOn(WebElement ele) {
		if (!ele.isSelected()) {
			waitForElementToBeClickable(ele);
			ele.click();
		}
	}
	public static void uploadFile(WebElement ele,String path) {
		File f= new File(path);
		String file = System.getProperty("user.dir") + path;
		if(f.exists()) {
			sendData(ele,file);
		}
		
	}
	
	public static boolean compareColors(WebDriver driver,String xpath) {
		String actual = driver.findElement(By.xpath(xpath)).getCssValue("border-color");
		boolean validate = actual.equals("rgb(204, 204, 204)") || actual.equals("rgb(40, 167, 69)");
		return validate;
	}
	
}
