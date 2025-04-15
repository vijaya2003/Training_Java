package com.qualizeal.login50pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage {
	public void actionLogin(List<Map<String, String>> map) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		for (int i = 0; i < map.size(); i++) {
			Map<String, String> config = map.get(i);
            
            
			driver.get(config.get("url")); 
			
			WebElement userName = driver.findElement(By.xpath(config.get("xpathUsername")));
			
			userName.clear();
			userName.sendKeys(config.get("username"));
			
			WebElement password = driver.findElement(By.xpath(config.get("xpathPassword")));
			password.clear();
			
			password.sendKeys(config.get("password"));
			

			WebElement login = driver.findElement(By.xpath(config.get("login")));
			
			login.click();

			Thread.sleep(4000);
			
		}
		driver.quit();
		System.out.println("completed");
	}
}
