package net.trainingrite.shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ShoppingCart_V1 {
	WebDriver driver;
	String vURL = "http://trainingrite.net/online";
	String vSearch="TV"; 
	String vQty = "2";
			  
	String vCustName = "Tester One";
	String vCustAddress="10 Main Street";
	String vCustCity ="Chicago";
	String vCustState = "IL";
	String vCustZip =  "22345";
	String vCustPhone="11223344";
	String vPaymentMethod="Visa";
	String vCreditCardNumber="1234567890";
	String vCVV2Number="123";
	String vExpirationDate="01/2015";
	  
	  
	  //************** Shipping Information **************************
	String vShipName= "Tester two";
	String vShipAddress= "2 10th Avenue";
	String vShipCity="New York"; 
	String vShipState="NY";
	String vShipZip= "10012";
	String vShipPhone = "9998887654";
	String vMessage = "Thank you for ordering with us!";
	
	@DataProvider
	public Object[][]ShoppingCart_TestData(){
		return new Object [][]{
			new Object[]{"Samsung", "1", "Tester10", "4445556667778"},
			new Object[]{"tv", "2", "Tester11", "5445556667778"},
			new Object []{"Panasonic", "3", "Tester12", "6445556667778"},
			new Object []{"camera", "4", "Tester13", "7445556667778"},
		};
	}
 
  @BeforeTest
  public void beforeTest() {
	  
	//FireFox
	
			  
	//chrome
	//System.setProperty("webdriver.chrome.driver","C:\\Selenium\\AllJars\\chromedriver.exe");
	//driver=new ChromeDriver( 
	//InternetExplorer 
	//System.setProperty("webdriver.ie.driver","C:\\Selenium\\AllJars\\IEDriverServer.exe");
	//driver=new InternetExplorerDriver();*/
			
				
	
  }
  // Enter search term and click Go
  @Test(dataProvider = "ShoppingCart_TestData")

  public void ShoppingCart(String vSearch, String vQty, String vCustName, String vCreditCardNumber) {
	 
	  	CatalogSearch(vSearch);
	  
	  	AddToCart();
	  	
	  
	  driver=new FirefoxDriver();
	 driver.get(vURL); 	    
	System.out.println("Open browser and navigate to website");
	
	
	
	
	//Modify cart
	
	 driver.findElement(By.name("txtItemQty1")).clear();
	  
	 driver.findElement(By.name("txtItemQty1")).sendKeys(vQty);
	  System.out.println("Enter quantity");
	  
	 driver.findElement(By.xpath("html/body/font/form/div/input[2]")).click();
	  System.out.println("Click the Recalculate Order btn");
	  
	 driver.findElement(By.xpath("html/body/font/form/div/input[3]")).click();
	  System.out.println("Click Proceed to Checkout");	 
	
 //Checkout page
	  
	  //Customer Information
	  driver.findElement(By.name("txtCustomerName")).sendKeys(vCustName);
	  driver.findElement(By.name("txtAddress")).sendKeys(vCustAddress);
	  driver.findElement(By.name("txtCity")).sendKeys(vCustCity);
	  driver.findElement(By.name("txtState")).sendKeys(vCustState);
	  driver.findElement(By.name("txtZIP")).sendKeys(vCustZip);
	  driver.findElement(By.name("txtPhone")).sendKeys(vCustPhone);
	  
	  //Credit Card Information
	  driver.findElement(By.xpath("html/body/font/form/table[1]/tbody/tr/td[1]/table/tbody/tr[6]/td[2]/font/input[1]")).click();
	  driver.findElement(By.name("txtAcctNo")).sendKeys(vCreditCardNumber);
	  driver.findElement(By.name("txtCVV2No")).sendKeys(vCVV2Number);
	  driver.findElement(By.name("txtExpDate")).sendKeys(vExpirationDate);
	  
	  //Shipping information
	  driver.findElement(By.name("txtshipCustomerName")).sendKeys(vShipName);
	  driver.findElement(By.name("txtshipAddress")).sendKeys(vShipAddress);
	  driver.findElement(By.name("txtshipCity")).sendKeys(vShipCity);
	  driver.findElement(By.name("txtshipState")).sendKeys(vShipState);
	  driver.findElement(By.name("txtshipZIP")).sendKeys(vShipZip);
	  driver.findElement(By.name("txtshipPhone")).sendKeys(vShipPhone);
	  driver.findElement(By.xpath("html/body/font/form/div/input[3]")).click();	  
	  	  
	  

	  if (vMessage.equals("Thank you for ordering with us!")){
		  System.out.println("Order Test Passed");
	  }
	  else {System.out.println("Order Test failed");
	  }
	  
	  driver.close();
		 System.out.println("Close the browser");
  }
  
  	
 
  	public void CatalogSearch(String vSearch){
  		driver.findElement(By.name("txtSearch")).sendKeys(vSearch);
  		driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td[1]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/input")).click();
  	
  	
  	public void AddToCart(){
  	//Add to cart
  		driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[3]/a/img")).click();
  		
  	}
  	}
  
  
  @AfterTest
  public void afterTest() {
	
	 
  }

}