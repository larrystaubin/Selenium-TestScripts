package net.jetblue.reservations;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JetBlueBooking {
	WebDriver oWD = new FirefoxDriver();	
	//EXCEL READ/WRITE: variables
    public String xlTestDataFile     = "C:/Selenium/TR_JetBlueReservation_WebDriver.xls";
    
    
	String strRateDetailsFromApp;
	String strState = "California";
	String strPickUpLocation = "LAX - Los Angeles International Airport";
	String strDropOffLocation = "HOLLYWOOD";
	int xlNumOfRows;
	int xlNumOfCols;
	String [][]DataFromXLInLocalArray;
	
	@BeforeMethod
	public String[][] ReadXLTestData(String xlTestDataFile) throws Exception{ 
		
	}
	{
		
	}
	
  @Test
  public void tc_JBReservationTest() throws Exception {
	  
	 try {
		 
		 for (int i=1;i < xlNumOfRows; i++){ 
			 
		 }
	  OpenBrowserNavigateAut();
	  
	  SelectState();
	  
	  SelectDropOff();
	  
	  CaptureResults();
  }
  
  public void OpenBrowserNavigateAut() throws Exception{
	  oWD.get("http://www.trainingrite.net/project/JetBlueFrequentFlier/index.html"); 
	  oWD.findElement(By.xpath("//*[@id='page2']/div[1]/div/nav/ul/li[6]/a")).click();        
      Thread.sleep(3000);
	  
  }
  
  public void SelectState(){
	  new Select(oWD.findElement(By.id("State"))).selectByVisibleText(strState);        
      oWD.findElement(By.name("btnstate")).click();
      
  }
  
  public void SelectDropOff() throws Exception{
	  new Select(oWD.findElement(By.name("Airport"))).selectByVisibleText(strPickUpLocation);
      Thread.sleep(3000);
      new Select(oWD.findElement(By.name("custcity"))).selectByVisibleText(strDropOffLocation);
      Thread.sleep(3000);
      new Select(oWD.findElement(By.name("type"))).selectByIndex(0);
        
      Thread.sleep(3000);
      oWD.findElement(By.id("btnSubmit")).click();	
	  
  }
  
  public void CaptureResults() throws Exception{
	  strRateDetailsFromApp = oWD.findElement(By.xpath("//*[@id='content']/div/div/strong/div[1]/center/table[2]/tbody/tr/td/div")).getText();
      Thread.sleep(3000);
      System.out.println("Trip from "+strPickUpLocation+" to "+strDropOffLocation+" : "+strRateDetailsFromApp);
      Thread.sleep(3000);
	  	  
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
              
              WriteDataToExcelFile

     }

     return DataFromXLInLocalArray;

  }
  
//This function will convert an object of type excel cell to a string value
  
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
