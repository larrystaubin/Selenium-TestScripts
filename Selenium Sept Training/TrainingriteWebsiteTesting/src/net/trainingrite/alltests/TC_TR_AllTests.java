package net.trainingrite.alltests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import javax.swing.Spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//2
@RunWith(value = Parameterized.class)

	 public class TC_TR_AllTests {
		 
		 String vFirstName = "Tester1";
		 String vLastName = "One";
		 String vEmail = "test1@bc.com";
		 String vPassword = "password";
		 String vVerifyPassword = "password";
		 String vHomePhone = "123456788";
		 String vCellPhone = "123456788";
		 String vInstructions = "testing variables";
		String vUrl = "http://www.trainingrite.net";	 
				 
	 
		 WebDriver oDriver;
		 //1
		 @Parameters
		 public static  Collection newcustTestData(){
				return Arrays.asList (new Object [][]
						{
						
						{"Tester1", "One", "one@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },
						
						{"Tester2", "Two", "two@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },

						{"Tester3", "Three", "three@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },

						{"Tester4", "Four", "four@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" },

						{"Tester5", "Five", "five@abd.edu", "password", "password", "1113334567", "4445556666", "Notes" }


						});
			
		}
		
		//3
		 
		 public TC_TR_AllTests(String vFirstName, String vLastName, String vEmail, String vPassword, String vVerifyPassword, String vHomePhone, String vCellPhone, String vInstructions){
				this.vFirstName = vFirstName;
				this.vLastName = vLastName;
				this.vEmail = vEmail;
				this.vPassword = vPassword;
				this.vVerifyPassword = vVerifyPassword;
				this.vHomePhone = vHomePhone;
				this.vCellPhone = vCellPhone;
				this.vInstructions = vInstructions;
				}
	
		 
	@Test
	public void test_Sign_Up() {
		//1)Navigate to the AUT (http://www.trainingrite.net)
		oDriver=new FirefoxDriver();	
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ALLJARS\\chromedriver.exe");
		//oDriver = new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\ALLJARS\\IEDriverServer.exe");
		//oDriver = new InternetExplorerDriver();
		
		oDriver.get("http://www.trainingrite.net");
		System.out.println("Opened Firefox and navigate to AUT");
		
		 // 2)Click on sign up
			
			oDriver.findElement(By.xpath("//*[@id='al']/tbody/tr[2]/td/font/center[2]/table/tbody/tr[2]/td[1]/div/input")).click();
			System.out.println("Click Sign Up button");
		// 3)Enter First Name
			oDriver.findElement(By.xpath("//*[@id='ctl00_MainContent_txtFirstName']")).sendKeys(vFirstName);
			System.out.println("Enter First Name");
			
		//4)Enter Last Name
			oDriver.findElement(By.name("ctl00$MainContent$txtLastName")).sendKeys(vLastName);
			System.out.println("Enter Last Name");
			
		// 5)Enter Email
			oDriver.findElement(By.xpath("//*[@id='ctl00_MainContent_txtEmail']")).sendKeys(vEmail);
			System.out.println("Enter Email");
			
		 // 6)Enter Password
			oDriver.findElement(By.xpath(".//*[@id='ctl00_MainContent_txtPassword']")).sendKeys(vPassword);
			System.out.println("Enter Password");
			
		 // 7)Enter Verify Password
			oDriver.findElement(By.xpath("//*[@id='ctl00_MainContent_txtVerifyPassword']")).sendKeys(vVerifyPassword);
			System.out.println("Enter Verify Passord");
			
		 // 8)Enter Home Phone
			oDriver.findElement(By.xpath(".//*[@id='ctl00_MainContent_txtHomePhone']")).sendKeys(vHomePhone);

			
		 // 9)Enter Cell Phone
			oDriver.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys(vCellPhone);
		
			
		 // 10))Enter Instructions
			oDriver.findElement(By.name("ctl00$MainContent$txtInstructions")).sendKeys(vInstructions);
		
			
		 // 11)Click on Submit
			oDriver.findElement(By.xpath("//*[@id='ctl00_MainContent_btnSubmit']")).click();
		
		  //12) Close Browser
			oDriver.close();
			
			
		  
	}//end of function test_Sign_Up
			
}//end of Class TC_TR_SignUp

