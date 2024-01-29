package AdminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtilities.baseClass;
import com.pageObject.addAppointmentPOM;
import com.pageObject.addDoctorPage;
import com.pageObject.addPatientPOM;
import com.pageObject.adminLoginPOM;
import com.pageObject.adminLogoutPOM;
import com.pageObject.doctorDashboardPage;
import com.pageObject.doctorLoginPOM;
import com.pageObject.doctorLogoutPOM;
import com.pageObject.editDoctorPage;
import com.pageObject.hmsUIPage;
import com.pageObject.patientDashboardPage;
import com.pageObject.patientLoginPage;
import com.pageObject.patientLogoutPOM;


public class systemScenario2 extends baseClass{

   // Scenario -> login as patient, book appointment, click on appointment history, logout, login as doctor, add patient, search the created patient, logout, login as admin, add the doctor,
	// logout as admin, login as doctor, update doc details and check whether doc details updated successfully...
	
	@Test
	public void systemTest2() throws Throwable
	{
		// Fetch patient details from property file
		String patUN = prop.readDataFromPropertyFile("patientUsername");
		String patPswd = prop.readDataFromPropertyFile("patientPassword");
		String patUrl = prop.readDataFromPropertyFile("patientLoginUrl");
		
		// entering url
		driver.get(patUrl);
		
		// Login as Patient
		patientLoginPage patLogin = new patientLoginPage(driver);
		patLogin.patientLoginProcess(patUN, patPswd);
		
		// Book Appointment
		addAppointmentPOM appoint = new addAppointmentPOM(driver);
		appoint.bookAppointmentProcess(driver, "7:00 PM");
		
		Thread.sleep(3000);
		
		// Handling alert
		wbUtils.alertAccept(driver);
		
		Thread.sleep(2000);
		// Click on appoinment history
		patientDashboardPage dash = new patientDashboardPage(driver);
		dash.getAppointmentHistoryBtn().click();
		
		// Logout as Patient
		patientLogoutPOM patLogout = new patientLogoutPOM(driver);
		patLogout.patientLogoutProcess();
		
		System.out.println("patient logged out");
		
		Thread.sleep(3000);
		
		// Invoking hmsUI POM Constructor
		hmsUIPage ui = new hmsUIPage(driver);
		ui.getDoctorLoginLink().click();
		
		// Fetch doctor credentials from property file
		
		String docUN = prop.readDataFromPropertyFile("doctorUsername");
		String docPswd = prop.readDataFromPropertyFile("doctorPassword");
		
		// Invoking doctor login POM Constructor ->> Login as doctor
		doctorLoginPOM docLogin = new doctorLoginPOM(driver);
		docLogin.doctorLogin(docUN, docPswd);
		
		// add Patient
		String name = faker.name().fullName();
		addPatientPOM pat = new addPatientPOM(driver);
		pat.addPatientProcess(name, faker.numerify("7699005532"), faker.internet().emailAddress(), faker.address().buildingNumber(), faker.numerify("45"), faker.medical().symptoms());
		
		// Search created patient
		doctorDashboardPage docDash = new doctorDashboardPage(driver);
		docDash.getSearchBtn().click();
		
		driver.findElement(By.xpath("//input[@id='searchdata']")).sendKeys(name);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		String actName = driver.findElement(By.xpath("//td[.='"+name+"']")).getText();
		Assert.assertEquals(actName, name,"ACTUAL AND EXPECTED PATIENT NAME IS DISPLAYED AND IS VERIFIED.....");
		
		// Logout as doctor
		doctorLogoutPOM docLogout = new doctorLogoutPOM(driver);
		docLogout.docLogoutProcess();
		System.out.println("Doctor logged out");
		
		// Login as admin
		hmsUIPage ui1 = new hmsUIPage(driver);
		ui1.getAdminLoginLink().click();
		
		// Fetch admin credentials from property files
		String adminUN = prop.readDataFromPropertyFile("adminUsername");
		String adminPswd = prop.readDataFromPropertyFile("adminPassword");
		adminLoginPOM adminLogin = new adminLoginPOM(driver);
		adminLogin.adminLogin(adminUN, adminPswd);
		
		// Add doctor
		addDoctorPage addDoc = new addDoctorPage(driver);
		String pswd = faker.numerify("12345678");
		addDoc.addDoctorProcess("Neurologist", faker.name().fullName(), faker.address().buildingNumber(), faker.numerify("3500"), faker.numerify("7689099345"), faker.internet().emailAddress(), pswd, pswd);
		
		Thread.sleep(2000);
		wbUtils.alertAccept(driver);
		
		Thread.sleep(2000);
		
		// Logout as admin
		adminLogoutPOM adminLogout = new adminLogoutPOM(driver);
		adminLogout.logoutAsAdmin();
		
		// Login as doctor
		ui.getDoctorLoginLink();
		doctorLoginPOM docLogin1 = new doctorLoginPOM(driver);
		docLogin1.doctorLogin(docUN, docPswd);
		
		// Invoking doctor dashboard POM Constructor and click on update profile
		doctorDashboardPage docDash1 = new doctorDashboardPage(driver);
		docDash1.getUpdateProfileBtn().click();
		
		// Updating doctor profile
		editDoctorPage edit = new editDoctorPage(driver);
		edit.getDocFees().sendKeys("7000");
		edit.getSubmitBtn().click();
		
		Thread.sleep(3000);
		
		wbUtils.alertAccept(driver);
		
		String expFees = "7000";
		WebElement actFees = driver.findElement(By.xpath("//input[@name='docfees']"));
		
		// Verify fees got updated or not
		Assert.assertEquals(actFees.getText(), expFees, "EXPECTED AND ACTUAL FEES IS MACHED AND IS VERIFIED.....");	
	}
}
