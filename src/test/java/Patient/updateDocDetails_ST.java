package Patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genericUtilities.baseClass;
import com.genericUtilities.fileUtils;
import com.genericUtilities.webDriverUtilities;
import com.github.javafaker.Faker;
import com.pageObject.doctorLoginPOM;
import com.pageObject.patientLoginPage;
import com.pageObject.patientLogoutPOM;
import com.pageObject.patientUpdatePage;
import com.pageObject.updateDocPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class updateDocDetails_ST extends baseClass{

	@Test
	public void patUpdate_Test() throws Throwable
	{	
		// Fetch data from Property file
		String patUN = prop.readDataFromPropertyFile("patientUsername");
		String patPswd = prop.readDataFromPropertyFile("patientPassword");
		String patURL = prop.readDataFromPropertyFile("patientLoginUrl");
		
		// launch browser and entering URL
		driver.get(patURL);
		
		// Entering data into login page
		patientLoginPage login = new patientLoginPage(driver);
		login.patientLoginProcess(patUN, patPswd);
		
		// Click on Patient Icon button
		patientUpdatePage pUpd = new patientUpdatePage(driver);
		pUpd.patUpdateProcess(faker.name().fullName(),faker.address().buildingNumber(),faker.address().city());
		
		// Logout as patient
		patientLogoutPOM patLogout = new patientLogoutPOM(driver);
		patLogout.patientLogoutProcess();
	}	
	
	@Test
	public void updateDoctor() throws Throwable
	{
		// Login as Doctor --->> Fetch doc data from property files
		String docUN = prop.readDataFromPropertyFile("doctorUsername");
		String docPswd = prop.readDataFromPropertyFile("doctorPassword");
		String docURL = prop.readDataFromPropertyFile("doctorUrl");
		
		driver.get(docURL);
		
		// Login as Doctor
		doctorLoginPOM docLogin = new doctorLoginPOM(driver);
		docLogin.doctorLogin(docUN, docPswd);
		
		// Updating doctor details
		updateDocPage updateDoc = new updateDocPage(driver);
		updateDoc.updateDocProcess("Asansol,westbengal", "6000");
		
		// Handling alert 
		wbUtils.alertAccept(driver);
		
		System.out.println("Doctor details successfully updated");
	}
}
