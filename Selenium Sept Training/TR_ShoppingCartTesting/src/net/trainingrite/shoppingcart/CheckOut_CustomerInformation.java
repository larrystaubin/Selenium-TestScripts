package net.trainingrite.shoppingcart;

import org.openqa.selenium.By;

public class CheckOut_CustomerInformation {
	
	public void CustomerInformation(){
		driver.findElement(By.name("txtCustomerName")).clear();
	    driver.findElement(By.name("txtCustomerName")).sendKeys("Tester Ten");
	    driver.findElement(By.name("txtAddress")).clear();
	    driver.findElement(By.name("txtAddress")).sendKeys("10 main street");
	    driver.findElement(By.name("txtCity")).clear();
	    driver.findElement(By.name("txtCity")).sendKeys("new york");
	    driver.findElement(By.name("txtState")).clear();
	    driver.findElement(By.name("txtState")).sendKeys("NY");
	    driver.findElement(By.name("txtZIP")).clear();
	    driver.findElement(By.name("txtZIP")).sendKeys("11111");
	    driver.findElement(By.name("txtPhone")).clear();
	    driver.findElement(By.name("txtPhone")).sendKeys("2223334567");
	    
	 public void CheckOut_PaymentInformation(){
			
		    driver.findElement(By.name("optPaymentType")).click();
		    driver.findElement(By.name("txtAcctNo")).clear();
		    driver.findElement(By.name("txtAcctNo")).sendKeys("4111111111112");
		    driver.findElement(By.name("txtCVV2No")).clear();
		    driver.findElement(By.name("txtCVV2No")).sendKeys("123");
		    driver.findElement(By.name("txtExpDate")).clear();
		    driver.findElement(By.name("txtExpDate")).sendKeys("04/2017");
		    
		    
	 }
	}

}
