package net.JetBlue.reservations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JetBlueBookiing {
	
	//System.setProperty("webdriver.chrome.driver", "C://Selenium//ALLJARS//chromedriver.exe");
		 // WebDriver driver = new ChromeDriver();
			WebDriver driver = new FirefoxDriver();
			String strState = "California";
			String strPickUpLocation = "LAX - Los Angeles International Airport"; 
			String strDropOffLocation = "HOLLYWOOD";
			String strRateDetailsFromApp;
			String strVehicleType;
			int xlNumOfRows;
			int xlNumOfCols;
			String [][] DataFromXLInLocalArray;
			
			//ArrayList to write to excel
	        ArrayList<String> strRateList = new ArrayList<String>();
			  
			//EXCEL READ/WRITE: variables
			public String xlTestDataFile = "C:/Selenium/TR_JetBlueReservation_WebDriver.xls";
		
			@BeforeMethod
			public void setUp() throws Exception{
				ReadXLTestData(xlTestDataFile);
				xlNumOfRows = DataFromXLInLocalArray.length;    
		        xlNumOfCols = DataFromXLInLocalArray[0].length;
			}
			
			@AfterMethod
			public void tearDown(){
			CloseBrowser();
				
			}
  @Test
  public void tc_JbReservationTest() {
	  try {
	   
		  for (int i=1;i < xlNumOfRows; i++){  
			  
			//reading from array and assigning the value to variables
		      	strState             = DataFromXLInLocalArray[i][0];
		      	strPickUpLocation     = DataFromXLInLocalArray[i][1];    
		      	strDropOffLocation     = DataFromXLInLocalArray[i][2];
		      	strVehicleType         = DataFromXLInLocalArray[i][3];
			  
		  
		      	OpenBrowserNavigateAUT();
		      	SelectState();
		      	PickUpDropOffInfo();
		      	CaptureResults();
		      
		  }
		
	} 
	  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  public void OpenBrowserNavigateAUT() throws Exception{
	  driver.get("http://www.trainingrite.net/project/JetBlueFrequentFlier/index.html");            
      Thread.sleep(3000);

      driver.findElement(By.xpath("//*[@id='page2']/div[1]/div/nav/ul/li[6]/a")).click();        
      Thread.sleep(3000);	  
  }
  
  public void SelectState() throws Exception{
	  new Select(driver.findElement(By.id("State"))).selectByVisibleText(strState);        
      driver.findElement(By.name("btnstate")).click();
      Thread.sleep(3000);
  }
      
  public void PickUpDropOffInfo() throws Exception{
	  new Select(driver.findElement(By.name("Airport"))).selectByVisibleText(strPickUpLocation);
      Thread.sleep(3000);
      new Select(driver.findElement(By.name("custcity"))).selectByVisibleText(strDropOffLocation);
      Thread.sleep(3000);
      new Select(driver.findElement(By.name("type"))).selectByVisibleText(strVehicleType);
     
      Thread.sleep(5000);
      driver.findElement(By.id("btnSubmit")) .click();
  }
  
  public void CaptureResults() throws Exception{
	 strRateDetailsFromApp = driver.findElement(By.xpath("//*[@id='content']/div/div/strong/div[1]/center/table[2]/tbody/tr/td/div")).getText();
     Thread.sleep(6000);
     System.out.println("Trip from "+strPickUpLocation+" to "+strDropOffLocation+" : "+strRateDetailsFromApp);
     Thread.sleep(3000);  
  }
  
  public void CloseBrowser(){
	 driver.close();
  }
  
//Reads data from the excel sheet

  public String[][] ReadXLTestData(String xlTestDataFile) throws Exception{          

     File xlFile = new File(xlTestDataFile);

     FileInputStream testDataStream = new FileInputStream(xlFile);

     HSSFWorkbook xlWorkBook = new HSSFWorkbook(testDataStream);

     HSSFSheet xlSheet = xlWorkBook.getSheetAt(0);

            xlNumOfRows = xlSheet.getLastRowNum()+1;

            xlNumOfCols = xlSheet.getRow(0).getLastCellNum();


     DataFromXLInLocalArray = new String[xlNumOfRows][xlNumOfCols];

     	int i, j;
     	
     for(i=0; i < xlNumOfRows; i++){

         HSSFRow row = xlSheet.getRow(i);

              for(j=0; j < xlNumOfCols; j++){

                 HSSFCell cell = row.getCell(j); // read values from each cell

                 String value = cellToString(cell);

                 DataFromXLInLocalArray[i][j] = value;                                                                                

              }       
              
      

     }

     return DataFromXLInLocalArray;

  }     
  
  // This function will convert an object of type excel cell to a string value
  
  public String cellToString(HSSFCell cell) {            

          int type = cell.getCellType();

         Object result;

          switch (type) {

              case HSSFCell.CELL_TYPE_NUMERIC: //0

             result = cell.getNumericCellValue();

              break;

          case HSSFCell.CELL_TYPE_STRING: //1

             result = cell.getStringCellValue();

              break;

          case HSSFCell.CELL_TYPE_FORMULA: //2

             throw new RuntimeException("We can't evaluate formulas in Java");

          case HSSFCell.CELL_TYPE_BLANK: //3

             result = "-";

              break;

          case HSSFCell.CELL_TYPE_BOOLEAN: //4

             result = cell.getBooleanCellValue();

              break;

          case HSSFCell.CELL_TYPE_ERROR: //5

             throw new RuntimeException ("This cell has an error");

          default:

             throw new RuntimeException("We don't support this cell type: " + type);

      }

     return result.toString();

   }
  


 }


 

