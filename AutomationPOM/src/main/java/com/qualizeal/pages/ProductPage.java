package com.qualizeal.pages;

import com.qualizeal.utils.SeleniumHelpers;

public class ProductPage {
	
	public static void clickAddCart() {
		SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//input[@id='add-to-cart-button-43']"));
	}
	public static void clcikShoppingCart() {
		SeleniumHelpers.clickElement(SeleniumHelpers.findEle("//span[contains(text(),'Shopping')]"));
	}
}
