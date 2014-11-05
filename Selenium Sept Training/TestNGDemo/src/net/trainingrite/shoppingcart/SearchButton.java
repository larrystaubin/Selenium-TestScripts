package net.trainingrite.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


	
public class SearchButton {
	WebDriver driver;
	String vURL = "http://www.trainingrite.net/online";
	
	
  @Test
  public void test_Search() {
	  System.out.println("click search button");
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C://Selenium//ALLJARS//chromedriver.exe");
	 
	  driver = new ChromeDriver();
	  driver.get(vURL);
	  System.out.println("Open browser and navigate to AUT");
	 
  }

  @AfterTest
  public void afterTest() {
  }

}
