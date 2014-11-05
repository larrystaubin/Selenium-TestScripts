package net.trainingrite.shoppingcart;

import org.openqa.selenium.By;

public class AddItemToCart {
	
	public void AddItem(){
		driver.findElement(By.xpath("//td[3]/a/img")).click();
	    System.out.println("Add to Cart");
	}

}
