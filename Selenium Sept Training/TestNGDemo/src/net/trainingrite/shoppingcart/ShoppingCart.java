package net.trainingrite.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ShoppingCart {
	WebDriver driver;
	
	
	 String vURL = "http://www.trainingrite.net/online";
	 
  @Test
  public void test_Search() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ALLJARS\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	  driver.get(vURL);
	  System.out.println("click on search button");
	  
	  
  }
  


}
