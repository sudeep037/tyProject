package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class doctorDashboardPage {

	@FindBy(xpath="//a[contains(.,'Update Profile')]")
	private WebElement updateProfileBtn;
	
	@FindBy(xpath="//a[contains(.,'View Appointment History')]")
	private WebElement viewAppointHistory;
	
	@FindBy(xpath="//span[.=' Appointment History ']")
	private WebElement appointHistoryBtn;
	
	@FindBy(xpath="//span[.=' Patients ']")
	private WebElement patDropdown;
	
	@FindBy(xpath="//span[.=' Search ']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement patientIcon;
	
	@FindBy(xpath="//a[contains(.,'My Profile')]")
	private WebElement myProfileBtn;
	
	@FindBy(xpath="//a[contains(.,'Change Password')]")
	private WebElement changePswdBtn;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement logoutBtn;
	
	public doctorDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdateProfileBtn() {
		return updateProfileBtn;
	}

	public WebElement getViewAppointHistory() {
		return viewAppointHistory;
	}

	public WebElement getAppointHistoryBtn() {
		return appointHistoryBtn;
	}

	public WebElement getPatDropdown() {
		return patDropdown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
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
	
	
}
