package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientDashboardPage {

	@FindBy(xpath="//a[contains(.,'Update Profile')]")
	private WebElement updateProfileBtn;
	
	@FindBy(xpath="//a[contains(text(),'View Appointment History')]")
	private WebElement viewAppointmentBtn;
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement appointmentHistoryBtn;
	
	@FindBy(xpath="(//a[contains(.,'Book Appointment')])[2]")
	private WebElement bookAppointmentBtn;
	
	@FindBy(xpath="//span[.=' Medical History ']")
	private WebElement medicalHistoryBtn;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement patientIcon;
	
	@FindBy(xpath="//a[contains(.,'My Profile')]")
	private WebElement myProfileBtn;
	
	@FindBy(xpath="//a[contains(.,'Change Password')]")
	private WebElement changePswdBtn;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement logoutBtn;
	
	
	public patientDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdateProfileBtn() {
		return updateProfileBtn;
	}

	public WebElement getAppointHistoryBtn() {
		return viewAppointmentBtn;
	}

	public WebElement getBookAppointmentBtn() {
		return bookAppointmentBtn;
	}

	public WebElement getMedicalHistoryBtn() {
		return medicalHistoryBtn;
	}

	public WebElement getPatientIcon() {
		return patientIcon;
	}

	public WebElement getMyProfileBtn() {
		return myProfileBtn;
	}

	public WebElement getChangePswdBtn() {
		return changePswdBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public WebElement getAppointmentHistoryBtn() {
		return appointmentHistoryBtn;
	}

	
	// Business logic
	
	public void dashBoardFunctionality()
	{
		getAppointHistoryBtn().click();
	}
}
