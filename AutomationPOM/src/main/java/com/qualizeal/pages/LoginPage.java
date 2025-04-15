package com.qualizeal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qualizeal.utils.SeleniumHelpers;

public class LoginPage {
	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
       public static void enterUsername(String userName) {
    	   SeleniumHelpers.sendData(SeleniumHelpers.findEle("//input[@id='Email']"),userName);
       }
       public static void enterPass(String pass) {
    	   SeleniumHelpers.sendData(SeleniumHelpers.findEle("//input[@id='Password']"),pass);
       }
       public static void clickOnCheck() {
    	   SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//input[@id='RememberMe']"));
       }
       public static void clickOnLogin() {
    	   SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//input[@value='Log in']"));
       }
}
