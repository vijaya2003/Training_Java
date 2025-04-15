package com.qualizeal.commonUtilities;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers {
    private static WebDriver driver;

    public SeleniumHelpers(WebDriver driver) {
        SeleniumHelpers.driver = driver;
    }

    public static WebElement findEle(String path) {
        return driver.findElement(By.xpath(path));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void sendData(WebElement ele, String data) {
        if (data != null && !data.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
            ele.clear();
            ele.sendKeys(data);
        }
    }

    public static void clickElement(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        waitForElementToBeClickable(ele);
        ele.click();
    }

    public static void uploadFile(WebElement ele, String path) {
        File file = new File(path);
        if (file.exists()) {
            ele.sendKeys(file.getAbsolutePath());
        } else {
            System.out.println("File not found: " + path);
        }
    }
}
