package Patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genericUtilities.baseClass;
import com.genericUtilities.excelUtils;
import com.genericUtilities.fileUtils;
import com.genericUtilities.webDriverUtilities;
import com.pageObject.addAppointmentPOM;
import com.pageObject.patientLoginPage;
import com.pageObject.patientLogoutPOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addAppointmentTest extends baseClass{

	  @Test
	   public void addAppointment_Test() throws Throwable
       {	
		// Fetch patient Login Details from Property file
		String patUN = prop.readDataFromPropertyFile("patientUsername");
		String patPswd = prop.readDataFromPropertyFile("patientPassword");
		String patURL = prop.readDataFromPropertyFile("patientLoginUrl");
		
		// Launching browser and Entering URL
		driver.get(patURL);
		
		// login as Patient
		patientLoginPage pLoginPage = new patientLoginPage(driver);
		pLoginPage.patientLoginProcess(patUN, patPswd);
		
		// Add Appointment for the patient
		addAppointmentPOM appPom = new addAppointmentPOM(driver);
		appPom.bookAppointmentProcess(driver,"9:30 PM");
		
		// Handling alert
		wbUtils.alertAccept(driver);
		
		Thread.sleep(2000);
		
		// logout as Patient 
		patientLogoutPOM pLogoutPage = new patientLogoutPOM(driver);
		pLogoutPage.patientLogoutProcess();	
	}
}
