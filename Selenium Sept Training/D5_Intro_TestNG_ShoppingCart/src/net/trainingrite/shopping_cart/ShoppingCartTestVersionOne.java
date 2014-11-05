package net.trainingrite.shopping_cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ShoppingCartTestVersionOne {
	
	WebDriver driver;
	String vURL = "http://www.trainingrite.net/online";
	
  
  @BeforeClass
  public void beforeClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  
	  	// FireFox
		//driver=new FirefoxDriver();
				  
		//chrome
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\AllJars\\chromedriver.exe");
		driver=new ChromeDriver();
					
		//InternetExplorer 
		//System.setProperty("webdriver.ie.driver","C:\\Selenium\\AllJars\\IEDriverServer.exe");
		//driver=new InternetExplorerDriver();*/
		driver.get(vURL);
  }
  //Enter the search term
  @Test
  public void test_SearchItem() {
	  System.out.println("Enter Search term");
  }
  
  //Click the Go button
  @Test
  public void test_GoButton(){
	  System.out.println("Click Go Button");
  }
  
  //In the search results click the Add to Cart button
  
  @Test
  public void test_AddToCart(){
	  System.out.println("Click the Add To Cart button");
	  
  }
  
  //Change Quantity and click the Recalculate Order button
  @Test
  public void test_ModifyCart(){
	  System.out.println("Modify the cart");
  }
  
//Click the Checkout button

  @Test
  public void test_CheckoutButton(){
	  System.out.println("Click the Checkout button");
  }
  
  //Enter Customer information and submit order
  
 @Test
 public void test_CustomerInformation(){
	 System.out.println("Customer Information entered and Submit order");
 }
  
 //Confirm the order
 
 @Test
 public void test_ConfirmOrder(){
	 System.out.println("Confirm the order");
	 
 }
  @AfterTest
  public void afterTest() {
	 //driver.close();
  }

}
