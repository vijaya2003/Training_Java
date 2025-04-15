package com.qualizeal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qualizeal.commonUtilities.SeleniumHelpers;

public class FBLoginPage {
    WebDriver driver;

    public FBLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }

    public void enterEmail(String email) {
        SeleniumHelpers.sendData(SeleniumHelpers.findEle("//input[@name='email']"), email);
    }


    public void enterPassword(String password) {
    	SeleniumHelpers.sendData(SeleniumHelpers.findEle("//input[@name='pass']"), password);
    }

    public void clickLogin() {
        SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//button[@name='login']"));
    }
}
