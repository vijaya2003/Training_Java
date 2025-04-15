package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestNGHelpers {
	public static void validateUsingAsserts(WebDriver driver,String fName, String lName, String gender, String mobileNo,String email) {
        int temp = 0;
        
		if (fName.isEmpty()) {
			temp=1;
			boolean fNameValid = SeleniumHelpers.compareColors(driver,"//input[@id='firstName']");
			Assert.assertTrue(!fNameValid,"First name is Mandatory");
		}

		if (lName.isEmpty()) {
			temp=1;
			boolean lNameValid = SeleniumHelpers.compareColors(driver,"//input[@id='lastName']");
			Assert.assertTrue(!lNameValid, "Last name is Mandatory");
		}

		if (gender.isEmpty() || !(gender.equals("Male") || gender.equals("Female") || gender.equals("Other"))) {
			temp=1;
			boolean genderValid = SeleniumHelpers.compareColors(driver,"//label[text()='Male']");
			Assert.assertTrue(!genderValid,"gender is Mandatory");
		}
		
		if (mobileNo.isEmpty() || !(mobileNo.length() == 10 || (mobileNo).matches("^[1-9]\\d{9}$"))) {
			temp=1;
			boolean mobileNoValid = SeleniumHelpers.compareColors(driver,"//input[@id='userNumber']");
			Assert.assertTrue(!mobileNoValid,"mobile number is Mandatory");
		}
		
		String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		boolean e = email.matches(emailRegex);
		if(!email.isEmpty()&&!e) {
			boolean emailValid = SeleniumHelpers.compareColors(driver,"//input[@id='userEmail']");
			Assert.assertTrue(!emailValid,"Email is in wrong formate");
		}
		
		if(temp==0) {
			String actual = driver.findElement(By.xpath("//div[contains(text(),'Thanks')]")).getText();
			String expected = "Thanks for submitting the form";
			Assert.assertEquals(actual, expected,"Form submitted");
		}

	}


}
