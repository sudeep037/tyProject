import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.genericUtilities.IpathConstants;
import com.genericUtilities.excelUtils;
import com.genericUtilities.fileUtils;
import com.genericUtilities.webDriverUtilities;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addPatient_SmokeTC {

	public static void main(String[] args) throws Throwable{
		
		webDriverUtilities wbUtils = new webDriverUtilities();
		fileUtils propUtils = new fileUtils();
		Faker faker = new Faker();
	
		// Fetching data from property file
		String docUN = propUtils.readDataFromPropertyFile("doctorUsername");
		String docPswd = propUtils.readDataFromPropertyFile("doctorPassword");
		String docURL =propUtils.readDataFromPropertyFile("doctorUrl");
	
		// Launching the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		// Implicit Wait
		wbUtils.implicitWait(driver, 10);
		
		// Maximize window
		wbUtils.maximizeWindow(driver);
		
		// Entering URL
		driver.get(docURL);
		
	    // Check whether Login page is displayed or not	
		String expLoginPage = "Doctor Login";
		String actLoginPage = driver.getTitle();
		
		if(expLoginPage.contains(actLoginPage))
		{
		  // Proceed with Login Credentials to enter data 
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(docUN);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(docPswd);
		  driver.findElement(By.xpath("//button[@name='submit']")).click();
		  
		  String expDocDashboard = "Doctor  | Dashboard";
		  String actDocDashboard = driver.getTitle();
		  System.out.println(actDocDashboard);
		  
		  if(expDocDashboard.equals(actDocDashboard))
		  {
			  System.out.println("Doctor Dashboard Page is Displayed");
		  }
		  else {
			  System.out.println("This is the bug "+actDocDashboard);
		  }
		}
		
		else {
			System.out.println("Page cannot found!!!!");
		}
		
		// Navigate to Left Hand Navigation and click on Patients button
		driver.findElement(By.xpath("//span[.=' Patients ']")).click();
		driver.findElement(By.xpath("//span[.=' Add Patient']")).click();
		
		// Verify whether Add patients page is displayed or not
	    String expAddPatientPage = "Doctor | Add Patient";
	    String actAddPatientPage = driver.getTitle();
	    
	    if(expAddPatientPage.contains(actAddPatientPage))
	    {
	    	System.out.println("Add Patient page is displayed");
	    }
	    else {
	    	System.out.println("This is the bug "+actAddPatientPage);
	    }
	    
	    // write the data from the Excel
	    excelUtils exUtil = new excelUtils();
	    
	    Object arr [][]= {
	    		{"patname",faker.name().fullName()},
	    		{"patcontact", faker.phoneNumber().cellPhone()},
	    		{"patemail",faker.internet().emailAddress()},
	    		{"pataddress",faker.address().buildingNumber()},
	    		{"patage",faker.numerify("34")},
	    		{"medhis",faker.medical().symptoms()}
	    };
	    
	    exUtil.writeDataIntoExcel1("Sheet2", arr);
	    
	    FileInputStream fis1 = new FileInputStream(IpathConstants.excelPath);
	    Workbook workbook =  WorkbookFactory.create(fis1);
	    Sheet sheet = workbook.getSheet("Sheet2");
	    int rowCount = sheet.getLastRowNum();
	    
	    HashMap<String, String> map = new HashMap<>();
	    
	    for(int r = 0; r<=rowCount; r++)
	    {
	    	String key = sheet.getRow(r).getCell(0).getStringCellValue();
	    	String value = sheet.getRow(r).getCell(1).getStringCellValue();
	    	map.put(key, value);
	    }
	    
	    for(Entry<String, String> set:map.entrySet())
	    {
	    	// Entering data into the textfield
	       driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
	    }
	    
	    // Selecting gender for patient
	    
	    driver.findElement(By.xpath("//label[contains(.,'Male')]")).click();
	    
	    // Click on Add button
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    System.out.println("Your patient added succesfully...");
	    	
	    driver.quit();
	}
}
