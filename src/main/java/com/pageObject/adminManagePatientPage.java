package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminManagePatientPage {

	@FindBy(xpath="//span[.=' Patients ']")
	private WebElement patientBtn;
	
	@FindBy(xpath="//span[.=' Manage Patients ']")
	private WebElement managePatientBtn;
	
	public adminManagePatientPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientBtn() {
		return patientBtn;
	}

	public WebElement getManagePatientBtn() {
		return managePatientBtn;
	}
	
	// Business Logic 
	
	public void managePatient()
	{
		getPatientBtn().click();
		getManagePatientBtn();
	}
	
}
