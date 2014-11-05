package net.TrainingRite.AllTest;

import static org.junit.Assert.*;

import javax.swing.Spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_TR_SignUp_Two {
	/*
	 /* Test Case:
	 Create an New account for New customers
	  1)Navigate to the AUT (http://www.trainingrite.net)
	  2)Click on sign up
	  3)Enter First Name
	  4)Enter Last Name
	  5)Enter Email
	  6)Enter Password
	  7)Enter verify Password
	  8)Enter Cell Phone
	  9)Enter Password
	  10))Enter Instructions
	  11)Click on Submit
	  
	 */
  
	 
	WebDriver objWD;
	String sURL = "http://trainingrite.net/";
	String sCustSuccess;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_Sign_Up() {
		//1)Navigate to the AUT (http://www.trainingrite.net)
		objWD=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\AllJars\\chromedriver.exe");
		//objWD=new ChromeDriver();
		//objWD=new IEDriver();
		objWD.get(sURL);
		System.out.println("Browser opened and navigated to the AUT");
		
		 // 2)Click on sign up
			
			objWD.findElement(By.xpath("//*[@id='al']/tbody/tr[2]/td/font/center[2]/table/tbody/tr[2]/td[1]/div/input")).click();
			
		// 3)Enter First Name
			objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtFirstName']")).sendKeys("A1Tester");
			System.out.println("First Name entered");
			
		//4)Enter Last Name
			objWD.findElement(By.name("ctl00$MainContent$txtLastName")).sendKeys("A1Tester");
			System.out.println("Last Name Entered");
			
		// 5)Enter Email
			objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtEmail']")).sendKeys("A1Tester@hotmail.com");
			System.out.println("Email entered");
			
		 // 6)Enter Password
			objWD.findElement(By.xpath(".//*[@id='ctl00_MainContent_txtPassword']")).sendKeys("A1Tester");
			System.out.println("Password entered");
			
		 // 7)Enter Verify Password
			objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtVerifyPassword']")).sendKeys("A1Tester");
			System.out.println("VerifyPassword Entered");
			
		 // 8)Enter Home Phone
			objWD.findElement(By.xpath(".//*[@id='ctl00_MainContent_txtHomePhone']")).sendKeys("1111111111");
			
		 // 9)Enter Cell Phone
			objWD.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys("041111111111");
			System.out.println("Home Phone entered");
			
		 // 10))Enter Instructions
			objWD.findElement(By.name("ctl00$MainContent$txtInstructions")).sendKeys("Don't know what to write here");
			System.out.println("Instructions");
			
		 // 11)Click on Submit
			objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_btnSubmit']")).click();
		
		  //12)Check that the Customer information added successfully
			sCustSuccess = objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_lblTransactionResult']")).getText();
			
			if (sCustSuccess.equals("Customer information added successfully")){
			System.out.println("Test Passed");	
			}
			else{
			System.out.println("Test Failed");
				
			}//end If
			
			objWD.close();
			
	//System.out.println("Test Failed for " + sDisplayName + " " + sSignedInMessage);
		  
	}//end of function test_Sign_Up
	
	@After
	public void tearDown() throws Exception {
	}//@After

	

}//end of Class TC_TR_SignUp
