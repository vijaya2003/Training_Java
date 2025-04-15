package com.qualizeal.login50pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSet {
	public static void main(String[] args) throws InterruptedException {
		
//	Map<String, String> config = new HashMap<>();
//    config.put("url", "https://www.facebook.com/login.php/");
//    config.put("usernameXPath", "//*[@id=\"email\"]");
//    config.put("passwordXPath", "//*[@id=\"pass\"]");
//    config.put("loginButtonXPath", "//*[@id=\"loginbutton\"]");
//    config.put("username", "hi");
//    config.put("password", "123456");
		
//		Map<String, ArrayList> config = new HashMap<>();
		
	
//    
//		List url = new ArrayList();
//		url.add("https://www.facebook.com/login.php/");
//		url.add("");
//		
//		List userx = new ArrayList();
//		userx.add("*[@id=\\\"email\\\"]");
//		userx.add("");
//		
//		List passx = new ArrayList();
//		passx.add("*[@id=\\\"pass\\\"]");
//		passx.add("");
//		
//		List logx = new ArrayList();
//		logx.add("*[@id=\\\"loginbutton\\\"]");
//		logx.add("");
//		
//		String[] user = {"hi" , "hello"};
////		user.add("hi");
////		user.add("hello");
//		
//		List pass = new ArrayList();
//		pass.add("pass1");
//		pass.add("pass2");
//		
		
		String[] user = {"hi" , "email334400@gmail.com"};
		String[] pass = {"pass1" , "Password334400@"};
		String[] userx = {"//*[@id=\"email\"]" , "//*[@id=\"login_field\"]"};
		String[] passx = {"//*[@id=\"pass\"]" , "//*[@id=\"password\"]"};
		String[] log = {"//*[@id=\"loginbutton\"]" , "//*[@id=\"login\"]/div[4]/form/div/input[13]"};
		String[] url = {"https://www.facebook.com/login.php/" , "https://github.com/login"};
		
		
		List<Map<String, String>> userSets = new ArrayList<>();

        // Manually adding sets to the list
        for (int i = 0; i < url.length; i++) {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("username", user[i]);
            userMap.put("password", pass[i]);
            userMap.put("xpathUsername", userx[i]);
            userMap.put("xpathPassword", passx[i]);
            userMap.put("login",log[i]);
            userMap.put("url", url[i]);
            userSets.add(userMap);
        }
        
       
    
    
    LoginPage  log1 = new LoginPage();
    log1.actionLogin(userSets);
    
   
 }
	
}
