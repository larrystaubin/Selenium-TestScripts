package net.trainingrite.shoppingcart;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TR_shoppingcart {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.trainingrite.net/online/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


  public void testDay2SeptShoppingCart() throws Exception {
    driver.get(baseUrl + "/online/");
    driver.findElement(By.name("txtSearch")).clear();
    driver.findElement(By.name("txtSearch")).sendKeys("TV");
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
    driver.findElement(By.xpath("//tr[4]/td[3]/a/img")).click();
    driver.findElement(By.name("cmdSubmit")).click();
    driver.findElement(By.name("txtSearch")).clear();
    driver.findElement(By.name("txtSearch")).sendKeys("Camera");
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
    driver.findElement(By.xpath("//tr[3]/td[3]/a/img")).click();
    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
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
    driver.findElement(By.xpath("(//input[@name='optPaymentType'])[2]")).click();
    driver.findElement(By.name("txtAcctNo")).clear();
    driver.findElement(By.name("txtAcctNo")).sendKeys("4111111111112");
    driver.findElement(By.name("txtCVV2No")).clear();
    driver.findElement(By.name("txtCVV2No")).sendKeys("123");
    driver.findElement(By.name("txtExpDate")).clear();
    driver.findElement(By.name("txtExpDate")).sendKeys("04/2017");
    driver.findElement(By.name("txtshipCustomerName")).clear();
    driver.findElement(By.name("txtshipCustomerName")).sendKeys("Tester Two");
    driver.findElement(By.name("txtshipAddress")).clear();
    driver.findElement(By.name("txtshipAddress")).sendKeys("22 King St");
    driver.findElement(By.name("txtshipCity")).clear();
    driver.findElement(By.name("txtshipCity")).sendKeys("Chicago");
    driver.findElement(By.name("txtshipState")).clear();
    driver.findElement(By.name("txtshipState")).sendKeys("IL");
    driver.findElement(By.name("txtshipZIP")).clear();
    driver.findElement(By.name("txtshipZIP")).sendKeys("22222");
    driver.findElement(By.name("txtshipPhone")).clear();
    driver.findElement(By.name("txtshipPhone")).sendKeys("1114445555");
    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
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
