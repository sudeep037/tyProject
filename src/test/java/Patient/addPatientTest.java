package Patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genericUtilities.baseClass;
import com.genericUtilities.excelUtils;
import com.genericUtilities.fileUtils;
import com.genericUtilities.webDriverUtilities;
import com.github.javafaker.Faker;
import com.pageObject.addPatientPOM;
import com.pageObject.doctorLoginPOM;
import com.pageObject.doctorLogoutPOM;
import com.pageObject.patientLoginPage;
import com.pageObject.patientLogoutPOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addPatientTest extends baseClass {

	
        @Test
        public void addPatient_Test() throws Throwable
        {
		String patName = faker.name().fullName();
		
		// Fetch login details of Doctor 
		String docUN = prop.readDataFromPropertyFile("doctorUsername");
		String docPswd = prop.readDataFromPropertyFile("doctorPassword");
		String docURL = prop.readDataFromPropertyFile("doctorUrl");
		
		// Launching the Browser
		driver.get(docURL);
		
		// Login to Doctor
	    doctorLoginPOM doc = new doctorLoginPOM(driver);
	    doc.doctorLogin(docUN, docPswd);
		
        // Invoking POM Constructor
		addPatientPOM pom = new addPatientPOM(driver);
		
		// Passing arguments to Business logic method 
		pom.addPatientProcess(patName, faker.numerify("7896542309"), faker.internet().emailAddress(), faker.address().buildingNumber(), faker.numerify("45"), faker.medical().symptoms());
		
		// Logout as Doctor ---> Invoking POM constructor for Doctor Logout
		doctorLogoutPOM dl = new doctorLogoutPOM(driver);
		dl.docLogoutProcess();	
	}
}
