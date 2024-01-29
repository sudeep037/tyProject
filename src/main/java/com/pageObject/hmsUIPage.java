package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hmsUIPage {

	@FindBy(xpath="(//a[.='Click Here'])[1]")
	private WebElement patientLoginLink;
	
	@FindBy(xpath="(//a[.='Click Here'])[2]")
	private WebElement doctorLoginLink;
	
	@FindBy(xpath="//a[@href='hms/admin']")
	private WebElement adminLoginLink;
	
	public hmsUIPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientLoginLink() {
		return patientLoginLink;
	}

	public WebElement getDoctorLoginLink() {
		return doctorLoginLink;
	}

	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}
	
	// Business Logic
	
	public void loginLinks()
	{
		getDoctorLoginLink().click();
	}
}
