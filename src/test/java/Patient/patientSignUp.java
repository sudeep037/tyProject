package Patient;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genericUtilities.IpathConstants;
import com.genericUtilities.baseClass;
import com.genericUtilities.excelUtils;
import com.genericUtilities.fileUtils;
import com.genericUtilities.webDriverUtilities;
import com.github.javafaker.Faker;
import com.pageObject.patientSignUpPOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class patientSignUp extends baseClass {

	
	@Test
	public void patientSignup_Test() throws Throwable
	{
		String pswd = faker.internet().password();
		String patURL = prop.readDataFromPropertyFile("patientSignupUrl");
		
		// Entering URL
		driver.get(patURL);
		
		// Write data into excel
		// Preparing Object array Data 
		Object arr [][]= {
				{"full_name",faker.name().fullName()},
				{"address", faker.address().city()},
				{"city", faker.address().city()},
				{"email", faker.internet().emailAddress()},
				{"password",pswd},
				{"password_again",pswd}
		};
		
		// Passing Object Array to write data into excel
		xlUtils.writeDataIntoExcel1("Sheet1", arr);
		
		// Entering data into the signup Page 
		patientSignUpPOM psnp = new patientSignUpPOM(driver);
		psnp.patientSignProcess();	
	}
}
