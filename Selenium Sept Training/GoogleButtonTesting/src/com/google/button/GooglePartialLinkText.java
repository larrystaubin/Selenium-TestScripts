package com.google.button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GooglePartialLinkText {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		WebElement aboutLink = driver.findElement(By.partialLinkText("Privacy"));
		aboutLink.click();
	}
}