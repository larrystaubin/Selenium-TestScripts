package net.trainingrite.shoppingcart;

import org.openqa.selenium.By;

public class ModifyShoppingCart {
	public void ModifyCart(){	
		
	    driver.findElement(By.name("txtItemQty1")).clear();
	    driver.findElement(By.name("txtItemQty1")).sendKeys("2");
	    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	    System.out.println("Modify Cart");
		
	}

}
