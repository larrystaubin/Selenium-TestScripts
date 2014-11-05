package net.trainingrite.shoppingcart;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MainTest_ShoppingCart {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.trainingrite.net";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTRShoppingCartComplete() throws Exception {
	  
	  //Open browser and navigate to website
	  driver.get(baseUrl + "/online/");
	  
	  //Search Catalog
	  CatalogSearch ocatalogSearch = new CatalogSearch
	  ocatalogSearch.SearchItem();
			     
	    //Add to cart
	  AddItemToCart oaddItemToCart = new AddItemToCart
	  oaddItemToCart.AddItem();	  
	    
	    
	    //Modify cart
	  ModifyShoppingCart omodifyShoppingCart = new ModifyShoppingCart
	 omodifyShoppingCart.ModifyCart();	  
	    
	    //CustomerInformation
	     ocheckOut = new CheckOut_CustomerInformation	
	    ocheckOut.CustomerInformation();		
	    
	    //Payment
	     CheckOut_CustomerInformation ocheckOut = new CheckOut_CustomerInformation
	    ocheckOut.CustomerInformation();
	    
	    //ShippingInformation
	    
	    driver.findElement(By.name("txtshipCustomerName")).clear();
	    driver.findElement(By.name("txtshipCustomerName")).sendKeys("Tester Two");
	    driver.findElement(By.name("txtshipAddress")).clear();
	    driver.findElement(By.name("txtshipAddress")).sendKeys("123 fgafg");
	    driver.findElement(By.name("txtshipCity")).clear();
	    driver.findElement(By.name("txtshipCity")).sendKeys("Chicago");
	    driver.findElement(By.name("txtshipState")).clear();
	    driver.findElement(By.name("txtshipState")).sendKeys("IL");
	    driver.findElement(By.name("txtshipZIP")).clear();
	    driver.findElement(By.name("txtshipZIP")).sendKeys("22222");
	    driver.findElement(By.name("txtshipPhone")).clear();
	    driver.findElement(By.name("txtshipPhone")).sendKeys("1114445555");
	    System.out.println("Enter Customer Information");
	    
	    //Submit and Verify Order
	    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	    String OrderConfirmationMessage = driver.findElement(By.cssSelector("h2")).getText();
	    System.out.println("Order Confirmation Details" +  OrderConfirmationMessage );
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
