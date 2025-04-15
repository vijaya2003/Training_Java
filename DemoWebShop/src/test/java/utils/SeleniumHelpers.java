package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers {
	
	
	static WebDriver driver;
	
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
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
}
