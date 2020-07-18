package test.module1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.Constants;
import utilities.PropertyReader;

public class TestScript {
	
	private static final String expectedURL = "https://prueba.undostres.com.mx/payment.php";
	
	/**
	 * Verification of Redirect to payment page
	 * @param driver
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws URISyntaxException
	 */
	public void details(WebDriver driver) throws IOException, InterruptedException, URISyntaxException
	{
		driver.findElement(By.xpath(PropertyReader.fileload("operator"))).click(); 
		Thread.sleep(Constants.timeout);
		driver.findElement(By.xpath(PropertyReader.fileload("operator_name"))).click();
		driver.findElement(By.xpath(PropertyReader.fileload("mobile"))).sendKeys(Constants.mobile);
		driver.findElement(By.xpath(PropertyReader.fileload("amount"))).click();
		Thread.sleep(Constants.timeout);
		driver.findElement(By.xpath(PropertyReader.fileload("amount_select"))).click();
		driver.findElement(By.xpath(PropertyReader.fileload("submit"))).click(); 
		Thread.sleep(Constants.timeout);
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL); 
		System.out.println("Test Case 1 Passed"); 
	}
	
	/**
	 * Payment details 
	 * @param driver
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws URISyntaxException
	 */
	public void payment(WebDriver driver) throws IOException, InterruptedException, URISyntaxException
	{
		driver.findElement(By.xpath(PropertyReader.fileload("card_name"))).sendKeys(Constants.card_name);
		driver.findElement(By.xpath(PropertyReader.fileload("card_no"))).sendKeys(Constants.card_no);
		driver.findElement(By.xpath(PropertyReader.fileload("expmonth"))).sendKeys(Constants.expmonth);
		driver.findElement(By.xpath(PropertyReader.fileload("expyear"))).sendKeys(Constants.expyear);
		driver.findElement(By.xpath(PropertyReader.fileload("cvvno"))).sendKeys(Constants.cvvno);
		driver.findElement(By.xpath(PropertyReader.fileload("email"))).sendKeys(Constants.email);
		driver.findElement(By.xpath(PropertyReader.fileload("payment_button"))).click(); 
		System.out.println("Test case 2 Passed");
	}
	
	/**
	 * To make the Payment successful
	 * @param driver
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws URISyntaxException
	 */
	public void card_payment(WebDriver driver) throws IOException, InterruptedException, URISyntaxException
	{
		int frameIndex = 0;
		Thread.sleep(Constants.timeout);
		driver.findElement(By.xpath(PropertyReader.fileload("payment_email"))).sendKeys(Constants.payment_email);
		driver.findElement(By.xpath(PropertyReader.fileload("payment_password"))).sendKeys(Constants.payment_password);
		List<WebElement> listFrames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(listFrames.get( frameIndex ));
		driver.findElement(By.xpath(PropertyReader.fileload("captcha"))).click();  
		driver.switchTo().defaultContent();
		Thread.sleep(Constants.timeout);
		driver.findElement(By.xpath(PropertyReader.fileload("pay"))).click();  
		System.out.println("Test case 3 Passed and User account was locked");	 
	}
}
