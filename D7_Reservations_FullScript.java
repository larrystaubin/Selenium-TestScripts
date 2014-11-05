package net.JetBlue.reservations;

import java.io.File;
import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.Select;


/**

 * Web Driver - parameterization

 * @Date: mar,2013
 
 *

 */



public class Reservations_FullScript {
    

    
     WebDriver oWD = new InternetExplorerDriver(); 
 
    //EXCEL READ/WRITE: variables
     public String xlTestDataFile     = "C:/Selenium/TR_JetBlueReservation_WebDriver.xls";
     public String xlResultsDataFile = "C:/Selenium/TR_JetBlueReservation_WebDriverResults.xls";

        public int xlNumOfRows, xlNumOfCols = 0;
        int i,j = 0;            
        public String strRateFromList = "";

     //Array to hold values from excel
 
    public String DataFromXLInLocalArray[][];

     //ArrayList to write to excel
        ArrayList<String> strRateList = new ArrayList<String>();

     //Page 2 - STATE: variables
 
    public String strState = "";

    
 
    //Page 3 - PICKUP/DROPOFF/VEHICLETYPE: variables

         public String strPickUpLocation = "";    
         public String strDropOffLocation = "";
         public String strVehicleType = "";
 
        

    //Page 4 - RESERVATION NUMBER

         public String strRateDetailsFromApp = "";
 
    
    @Before
 
    public void setUp() throws Exception {    

         //read excel and build the array
 
        DataFromXLInLocalArray = ReadXLTestData(xlTestDataFile);        
 
        xlNumOfRows = DataFromXLInLocalArray.length;    
          xlNumOfCols = DataFromXLInLocalArray[0].length;
 
    }

     @Test
     public void testReservation()throws Exception {
        for (i=1;i < xlNumOfRows; i++){                

             //Navigate to AUT
 
            oWD.get("http://www.trainingrite.net/project/JetBlueFrequentFlier/index.html");            
         //    oWD.manage().window().maximize();
             Thread.sleep(3000);

                //reading from array and assigning the value to variables
                  strState             = DataFromXLInLocalArray[i][0];
                 strPickUpLocation     = DataFromXLInLocalArray[i][1];    
                 strDropOffLocation     = DataFromXLInLocalArray[i][2];
                 strVehicleType         = DataFromXLInLocalArray[i][3];
                        

            ClickReservation();
 
            SelectStateAndGo();

            PickUpDropOff();
 
            CaptureRate();                
 
        }

         // Call function to write the results to excel

         WriteDataToExcelFile(xlResultsDataFile,strRateList);
 
    }


     /**
 
    * **********************FUNCTIONS**********************

     */

     public void ClickReservation() throws Exception{
 
        oWD.findElement(By.xpath("//*[@id='page2']/div[1]/div/nav/ul/li[6]/a")).click();        
         Thread.sleep(3000);

     }

    
 
    public void SelectStateAndGo() throws Exception{

         new Select(oWD.findElement(By.id("State"))).selectByVisibleText(strState);        
         oWD.findElement(By.name("btnstate")).click();
         Thread.sleep(3000);

     }




     public void PickUpDropOff() throws Exception{

         new Select(oWD.findElement(By.name("Airport"))).selectByVisibleText(strPickUpLocation);
         Thread.sleep(3000);
         new Select(oWD.findElement(By.name("custcity"))).selectByVisibleText(strDropOffLocation);
        Thread.sleep(3000);
         new Select(oWD.findElement(By.name("type"))).selectByVisibleText(strVehicleType);
        
         Thread.sleep(5000);
         oWD.findElement(By.id("btnSubmit")).click();
        
 
    }

    

     public void CaptureRate() throws Exception{
        // Thread.sleep(5000);
        strRateDetailsFromApp = oWD.findElement(By.xpath("//*[@id='content']/div/div/strong/div[1]/center/table[2]/tbody/tr/td/div")).getText();
         Thread.sleep(6000);
        System.out.println("Trip from "+strPickUpLocation+" to "+strDropOffLocation+" : "+strRateDetailsFromApp);
        Thread.sleep(3000);
         strRateList.add(strRateDetailsFromApp);        
 
    }

    

    

     /**

     * 

     * ************************EXCEL READ/WRITE**************
 
    */

     // Reads data from the excel sheet

     public String[][] ReadXLTestData(String xlTestDataFile) throws Exception{          
 
        File xlFile = new File(xlTestDataFile);

        FileInputStream testDataStream = new FileInputStream(xlFile);




        HSSFWorkbook xlWorkBook = new HSSFWorkbook(testDataStream);
 
        HSSFSheet xlSheet = xlWorkBook.getSheetAt(0);




               xlNumOfRows = xlSheet.getLastRowNum()+1;

               xlNumOfCols = xlSheet.getRow(0).getLastCellNum();
 



        DataFromXLInLocalArray = new String[xlNumOfRows][xlNumOfCols];




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

    
 
    //Writes to excel sheet

     public void WriteDataToExcelFile(String fileName, ArrayList<String>strRateList) {        
 
        try {            

             System.out.println("inside write to excel method");
            

            HSSFWorkbook myWorkBook = new HSSFWorkbook();

            HSSFSheet xlSheet = myWorkBook.createSheet();

             HSSFRow myRow;

            HSSFCell myCell;

           
            int listCounter = 0;

            for(int row = 1; row < strRateList.size()+1; row++){                
 
                strRateFromList = strRateList.get(listCounter);                  

                    
 
                    myRow = xlSheet.createRow(0);                   

                    myCell = myRow.createCell(0);
 
                   //myCell.setCellStyle(style);

                    myCell.setCellValue("RESULTS");
 
                                   

                    myRow = xlSheet.createRow(row);                   

                    myCell = myRow.createCell(0);
 
                    myCell.setCellValue(strRateFromList); 

                    listCounter++;

            }

            

             FileOutputStream out = new FileOutputStream(fileName);

            myWorkBook.write(out);

            out.flush();

            out.close();

            

            strRateList.clear();
 
            System.out.println("Check excel sheet: "+xlResultsDataFile+" for results");

            System.out.println("END OF CODE");

            

        } catch (Exception e) {
 
            e.printStackTrace();

        }

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
    
    
      

     @After
 
    public void tearDown() throws Exception {

        // oWD.quit();

     }
 
        

}
