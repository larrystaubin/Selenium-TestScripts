package net.TrainingRite.AllTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(value = Parameterized.class)
public class JUnit_Intro_Parameterization {

	 
		WebDriver objWD;
		String sURL = "http://trainingrite.net/";
		String sCustSuccess;
		String vFirstName = "Tester1";
		String vLastName = "One";
		String vEmail = "testerone@ddf.edu";
		String vPassword = "password";
		String vVerifyPassword = "password";
		String vHomePhone = "3334445555";
		String vCellPhone = "7776665555";
		String vInstructions = "Testing Variables";
		
		 
		public JUnit_Intro_Parameterization(String vFirstName, String vLastName, String vEmail, String vPassword, String vVerifyPassword, String vHomePhone, String vCellPhone, String vInstructions){
		this.vFirstName = vFirstName;
		this.vLastName = vLastName;
		this.vEmail = vEmail;
		this.vPassword = vPassword;
		this.vVerifyPassword = vVerifyPassword;
		this.vHomePhone = vHomePhone;
		this.vCellPhone = vCellPhone;
		this.vInstructions = vInstructions;
		
	
		}
		@Parameters
		public static Collection newcustTestData(){
			return Arrays.asList(new Object [][]
					{
					
					{"Tester1", "One", "one@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },
					
					{"Tester2", "Two", "two@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },

					{"Tester3", "Three", "three@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },

					{"Tester4", "Four", "four@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },

					{"Tester5", "Five", "five@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" }


					});
			
					
					}
		
		
		
		@Before
		public void setUp() throws Exception {
		}

		@Test
		public void test_Sign_Up() {
			//1)Navigate to the AUT (http://www.trainingrite.net)
			objWD=new FirefoxDriver();
			//objWD=new ChromeDriver();
			//objWD=new IEDriver();
			objWD.get(sURL);
			
			 // 2)Click on sign up
				
				objWD.findElement(By.xpath("//*[@id='al']/tbody/tr[2]/td/font/center[2]/table/tbody/tr[2]/td[1]/div/input")).click();
				
			// 3)Enter First Name
				objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtFirstName']")).sendKeys(vFirstName);
				
			//4)Enter Last Name
				objWD.findElement(By.name("ctl00$MainContent$txtLastName")).sendKeys(vLastName);
									
			// 5)Enter Email
				objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtEmail']")).sendKeys(vEmail);
				
			 // 6)Enter Password
				objWD.findElement(By.xpath(".//*[@id='ctl00_MainContent_txtPassword']")).sendKeys(vPassword);
				
			 // 7)Enter Verify Password
				objWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtVerifyPassword']")).sendKeys(vVerifyPassword);
				
			 // 8)Enter Home Phone
				objWD.findElement(By.xpath(".//*[@id='ctl00_MainContent_txtHomePhone']")).sendKeys(vHomePhone);
				
			 // 9)Enter Cell Phone
				objWD.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys(vCellPhone);
				
			 // 10))Enter Instructions
				objWD.findElement(By.name("ctl00$MainContent$txtInstructions")).sendKeys(vInstructions);
				
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

}