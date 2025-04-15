package com.qualizeal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qualizeal.utils.SeleniumHelpers;

public class HomePage {
	WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
    
    public static void clcikOnElectronics() {
    	SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//ul[@class='list']//a[contains(text(),'Electronics')]"));
    }
    public static void clickOnCellphone() {
    	SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//div[@class='sub-category-item']//a[contains(text(),'Cell phones')]"));
    }
    public static void clickOnSmartPhone() throws InterruptedException {
    	Thread.sleep(2000);
    	SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//h2//a[text()='Smartphone']"));
    }
}
