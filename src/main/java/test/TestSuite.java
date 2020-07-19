package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import utilities.Constants;

import test.module1.TestScript;
public class TestSuite {

	// ==========PATH============================================================================================================================================

	String chrome_driver_path = "D:\\Automation\\chromedriver.exe"; // It is the local path of the Chrome driver saved in the System
    String firefox_driver_path = "D:\\Automation\\geckodriver.exe";
	// ========INITIALIZATION=========================================================================================================================


	WebDriver driver;
	TestScript test = new TestScript();
	
	/**
	 *Launch browser before test case execution 
	 * @throws Exception
	 */
	@Parameters("browser")
	@BeforeTest
	public void before_test_setup(String browser) throws Exception {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(Constants.chrome_driver, chrome_driver_path); 
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
	     	System.setProperty(Constants.firefox_driver, firefox_driver_path);
	     	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	     	capabilities.setCapability("marionette",true);
			driver = new FirefoxDriver(capabilities); 
		}
		driver.get(Constants.Website_URL);
		driver.manage().window().maximize();
		System.out.println("---------Test Script Start-----------");  

	}

	@AfterTest
	public void after_test_setup() {
		System.out.println("---------------Test Script End-----------"); 

	} 
	
	// ==========================TESTCASES STARTED===============================================================================
	
	@Test(priority=1, description="This function is to fill details")
	public void details() throws Exception
	{
		test.details(driver);    
	}
	
	@Test(priority=2, description="This function is to make payment")
	public void payment() throws Exception
	{
		test.payment(driver);  
	}
	
	@Test(priority=3, description="This function is to fill card details and make payment")
	public void card_payment() throws Exception
	{
		test.card_payment(driver);   
	}
	
}
