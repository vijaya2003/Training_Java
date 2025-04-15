package com.qualizeal.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHelpers {
	private static WebDriver driver;

    public SeleniumHelpers(WebDriver driver) {
        SeleniumHelpers.driver = driver;
    }

    public static WebElement findEle(String path) {
        return driver.findElement(By.xpath(path));
    }
    public static void sendData(WebElement ele, String data) {
        if (data != null && !data.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
            ele.clear();
            ele.sendKeys(data);
        }
    }

    public static void clickElement(WebElement ele) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//        waitForElementToBeClickable(ele);
        ele.click();
    }


}
