package net.TrainingRite.AllTest;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


@RunWith(value = Parameterized.class)
public class D3Assignment {
	
	WebDriver oWD;
	String baseUrl;
	
	//Declaration of Variables / Assignment of Variables
	
	String vFirstName = "John";
	String vLastName = "Puttin";
	String vEmail = "johnputtin@gmail.com";
	String vPassword = "Password";
	String vVerifyPassword = "Password";
	String vHomePhone = "08023248495";
	String vCellPhone = "08023248495";
	String vInstructions = "Login Instructions for John Puttin";
	
	// Create Constructor
	public D3Assignment(String vFirstName, String vLastName, String vEmail, String vPassword, String vVerifyPassword, String vHomePhone, String vCellPhone, String vInstructions){
		
	// Map the constructor into the variable
		
	this.vFirstName = vFirstName;
	this.vLastName = vLastName;
	this.vEmail = vEmail;
	this.vPassword = vPassword;
	this.vVerifyPassword = vVerifyPassword;
	this.vHomePhone = vHomePhone;
	this.vCellPhone = vCellPhone;
	this.vInstructions = vInstructions;
	

	}
	
	
	
	// Definition of function
	
	@Parameters
	public static Collection newsignupTestData(){
		return Arrays.asList(new Object [][]
				{
			
			{"John", "Puttin", "johnputtin@gmail.com", "Password", "Password", "08023248495", "08023248495", "Login Instruction for John Puttin"},
			{"Joe", "Stone", "js@gmail.com", "Password", "Password", "08023248495", "08023248495", "Login Instruction for Joe Stone"},
			{"Peter", "Fish", "pf@gmail.com", "Password", "Password", "08023248495", "08023248495", "Login Instruction for Peter Fish"},
			{"Luke", "Snow", "ls@gmail.com", "Password", "Password", "08023248495", "08023248495", "Login Instruction for Luke Snow"},
			{"Sam", "Meatball", "sm@gmail.com", "Password", "Password", "08023248495", "08023248495", "Login Instruction for Sam Meatball"}
			
				});
	}
	
	
	
	@Before
	public void setUp() throws Exception {
		
		// Setting environment for cross platform testing.
		
		oWD = new FirefoxDriver ();
		System.out.println("FireFox started and navigated to AUT");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\AllJars\\chromedriver.exe");
		//oWD = new ChromeDriver();
		
		//System.setProperty("webdriver.i.e.driver", "C:/Selenium/AllJars/IEDriverServer.exe");
		//oWD = new InternetExplorerDriver();
		
		baseUrl = "http://trainingrite.net";
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		oWD.close();
	}

	@Test
	public void test_DataParametisation() {
		
		// Locate the AUT
		oWD.get(baseUrl + "/");
		
		// Send Data to click on "sign up Field"
		oWD.findElement(By.className("submitbtn")).click();
		System.out.println("Sign up process started");
		
		// Send Data to First Name Field
		oWD.findElement(By.id("ctl00_MainContent_txtFirstName")).sendKeys(vFirstName);
		System.out.println("First Name Entered Successfully");
		
		// Send Data to Last Name Field
		oWD.findElement(By.id("ctl00_MainContent_txtLastName")).sendKeys(vLastName);
		System.out.println("Last Name Entered Successfully");
		
		//Send Data to Email Field
		oWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtEmail']")).sendKeys(vEmail);
		System.out.println("Email Entered Successfully");
		
		// Send Data to Password Field
		oWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtPassword']")).sendKeys(vPassword);
		System.out.println("Password Entered");
		
		// Send Data to Verify Password
		oWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtVerifyPassword']")).sendKeys(vVerifyPassword);
		System.out.println("Password Verified");
		
		//Send Data to Home Phone Field
		oWD.findElement(By.id("ctl00_MainContent_txtHomePhone")).sendKeys(vHomePhone);
		System.out.println("Home Phone Entered");
		
		// Send Data to Cell Phone Field
		oWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtCellPhone']")).sendKeys(vCellPhone);
		System.out.println("Cell Phone Entered");
		
		// Send Data to Instructions Field
		oWD.findElement(By.xpath("//*[@id='ctl00_MainContent_txtInstructions']")).sendKeys(vInstructions);
		System.out.println("Login Instructions Entered");
		
		// Hit Submit
		oWD.findElement(By.xpath("//*[@id='ctl00_MainContent_btnSubmit']")).click();
		
		
	}

}
