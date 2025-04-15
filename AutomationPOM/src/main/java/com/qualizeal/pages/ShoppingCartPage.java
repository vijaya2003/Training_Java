package com.qualizeal.pages;

import org.openqa.selenium.WebElement;

import com.qualizeal.utils.SeleniumHelpers;

public class ShoppingCartPage {
	
	public static void clickOnQty() {
		WebElement ele=SeleniumHelpers.findEle("//input[@class=\"qty-input valid\"]");
	    ele.click();
	    ele.clear();
	}
	public static void ChangeQty() {
		
	    
	}
}
