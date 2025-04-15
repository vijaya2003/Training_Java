package baseSetUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ExcelHelpers;
import utils.SeleniumHelpers;


public class BaseClass {
	public static WebDriver driver;
	public ExtentReports extentReports;
    public ExtentTest test;

	
	@BeforeClass
    public void beforeClass() {
    	String reportPath = System.getProperty("user.dir") + "./reports/ExtentReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
    }
	
	@BeforeMethod
	public void loadBrowser() throws IOException {
//		driver = new ChromeDriver();
		File file = new File("./login.properties");
		FileInputStream fs= new FileInputStream(file);
		Properties p = new Properties();
		p.load(fs);
		
		String browser=p.getProperty("browser");
		driver=SeleniumHelpers.browserOpen(browser);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		
		String url=p.getProperty("url");
		driver.get(url);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@AfterClass
	public void after() {
		extentReports.flush();
	}
	
	@DataProvider(name = "dp")
	public Object[][] dataProvide() throws IOException {
		return ExcelHelpers.returnExceldata();
//		Object[][] arr ={{"","lakshmi","dasari@gmail.com","","8008563393","","","","",
//			"2003","October","5","","Bhimavarm","NCR","Delhi"}};
//		return arr;

	}


}
