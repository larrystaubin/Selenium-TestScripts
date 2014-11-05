package net.trainingrite.shoppingcart;

import org.openqa.selenium.By;

public class CatalogSearch {
	
		public void SearchItem(){
			driver.findElement(By.name("txtSearch")).clear();
		    driver.findElement(By.name("txtSearch")).sendKeys("Panasonic");
		    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
		    
		    System.out.println("Search Catalog");
		}
	 	

}
