package Patient;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genericUtilities.baseClass;
import com.genericUtilities.databaseUtils;
import com.genericUtilities.excelUtils;
import com.genericUtilities.fileUtils;
import com.genericUtilities.webDriverUtilities;
import com.github.javafaker.Faker;
import com.pageObject.addPatientPOM;
import com.pageObject.adminLoginPOM;
import com.pageObject.adminLogoutPOM;
import com.pageObject.doctorLoginPOM;
import com.pageObject.doctorLogoutPOM;
import com.pageObject.managePatientPage;
import com.pageObject.patientLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyCreatedPatient extends baseClass {

	// Login as doctor, click on patients, add the patients, logout as doctor, login as admin and check whether created patient is displayed in Manage patients , logout
	
	String expPat = faker.name().fullName();
	
       @Test
       public void addPatientTest() throws Throwable
       {
   
		// Fetch the doc login details from property files	
		String docUN = prop.readDataFromPropertyFile("doctorUsername");
		String docPswd = prop.readDataFromPropertyFile("doctorPassword");
		String docURL = prop.readDataFromPropertyFile("doctorUrl");
		
		// Launching browser and entering Url 
		driver.get(docURL);
		
		// Invoking doc Login POM constructor
		doctorLoginPOM doclogin = new doctorLoginPOM(driver);
		doclogin.doctorLogin(docUN, docPswd);
		
		// Invoking add Patient POM constrcutor
		addPatientPOM addPat = new addPatientPOM(driver);
		addPat.addPatientProcess(expPat, faker.numerify("7689546309"), faker.internet().emailAddress(), faker.address().buildingNumber(), faker.numerify("35"), faker.medical().symptoms());
		
		// Logout as doctor ---> Invoking doctor logout POM constructor
		doctorLogoutPOM docLogout = new doctorLogoutPOM(driver);
		docLogout.docLogoutProcess();
       }
       
       @Test
       public void verifyPatientTest() throws Throwable
       {
    	   
		// Fetching patient Credentials from Property file
		String adminUN = prop.readDataFromPropertyFile("adminUsername");
		String adminPswd = prop.readDataFromPropertyFile("adminPassword");
		String adminURL = prop.readDataFromPropertyFile("adminUrl");
		
		// Launching browser
		driver.get(adminURL);
		
		// Invoking admin Login POM constructor 
		adminLoginPOM adminLogin = new adminLoginPOM(driver);
		adminLogin.adminLogin(adminUN, adminPswd);
		
		// Invoking manage patient POM constructor
		managePatientPage manage = new managePatientPage(driver);
		manage.managePatientProcess();
		
		// Verifying created patient displayed in manage patients page or not
		WebElement actPat = driver.findElement(By.xpath("//tbody//td[text()='"+expPat+"']"));
		if(expPat.contains(actPat.getText()))
		{
			System.out.println("Verified");
		}
		
		// logout as admin
		adminLogoutPOM adminLogout = new adminLogoutPOM(driver);
		adminLogout.logoutAsAdmin();
		
		System.out.println("Your end-to-end scenrios is succesfully working");
	}
}
