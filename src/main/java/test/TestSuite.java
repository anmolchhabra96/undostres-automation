package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Constants;

import test.module1.TestScript;
public class TestSuite {

	// ==========PATH============================================================================================================================================

	String chrome_driver_path = "D:\\Automation\\chromedriver.exe"; // It is the local path of the Chrome driver saved in the System

	// ========INITIALIZATION=========================================================================================================================

	
	WebDriver driver;
	TestScript test = new TestScript();
	
	/**
	 *Launch browser before test case execution 
	 * @throws Exception
	 */
	@BeforeTest
	public void before_test_setup() throws Exception {
		System.setProperty(Constants.chrome_driver, chrome_driver_path);   
		driver = new ChromeDriver();
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
