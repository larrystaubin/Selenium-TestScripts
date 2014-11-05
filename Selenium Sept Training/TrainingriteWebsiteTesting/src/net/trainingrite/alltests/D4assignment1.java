package net.trainingrite.alltests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class D4assignment1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://trainingrite.net";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDataParametization1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("input.submitbtn")).click();
    
    // Send Data to First Name field
    driver.findElement(By.id("ctl00_MainContent_txtFirstName")).clear();
    driver.findElement(By.id("ctl00_MainContent_txtFirstName")).sendKeys("Paul");
    System.out.println("First Name entered succesfully");
    
    // Send Data to Last Name Field
    driver.findElement(By.id("ctl00_MainContent_txtLastName")).clear();
    driver.findElement(By.id("ctl00_MainContent_txtLastName")).sendKeys("John");
    System.out.println("Last Name entered succesfully");
    
    // Send Data to Email Field
    driver.findElement(By.id("ctl00_MainContent_txtEmail")).clear();
    driver.findElement(By.id("ctl00_MainContent_txtEmail")).sendKeys("pauljohn@gmail.com");
    System.out.println("Email entered successfully");
    
    // Send Data to verify Password
    driver.findElement(By.id("ctl00_MainContent_txtVerifyPassword")).clear();
    driver.findElement(By.id("ctl00_MainContent_txtVerifyPassword")).sendKeys("password");
    System.out.println("Password Verified");
    
    // Send Data to Home Phone Field
    driver.findElement(By.id("ctl00_MainContent_txtHomePhone")).clear();
    driver.findElement(By.id("ctl00_MainContent_txtHomePhone")).sendKeys("08023248495");
    System.out.println("Home Phone Entered");
    
    // Send Data to Cell Phone
    driver.findElement(By.id("ctl00_MainContent_txtCellPhone")).clear();
    driver.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys("08023248495");
    System.out.println("Cell Phone Entered");
    
    // Send Data to Instruction Field
    driver.findElement(By.id("ctl00_MainContent_txtInstructions")).clear();
    driver.findElement(By.id("ctl00_MainContent_txtInstructions")).sendKeys("Login for Paul John");
    System.out.println("Instructions sent");
    
    driver.findElement(By.id("ctl00_MainContent_btnSubmit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.close();
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
