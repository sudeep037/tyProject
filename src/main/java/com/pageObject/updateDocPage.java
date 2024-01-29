package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.webDriverUtilities;

public class updateDocPage extends webDriverUtilities {

	@FindBy(xpath="//span[@class='username']")
	private WebElement docIconBtn;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	private WebElement myProfileBtn;
	
	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement specDrop;
	
	@FindBy(xpath="//input[@name='docname']")
	private WebElement docName;
	
	@FindBy(xpath="//textarea[@name='clinicaddress']")
	private WebElement clinicAdd;
	
	@FindBy(xpath="//input[@name='docfees']")
	private WebElement fees;;
	
	@FindBy(xpath="//input[@name='doccontact']")
	private WebElement contactNo;
	
	@FindBy(xpath="//input[@name='docemail']")
	private WebElement doctorEmail;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement updateBtn;

	public updateDocPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDocIconBtn() {
		return docIconBtn;
	}

	public WebElement getMyProfileBtn() {
		return myProfileBtn;
	}

	public WebElement getDocName() {
		return docName;
	}

	public WebElement getClinicAdd() {
		return clinicAdd;
	}

	public WebElement getFees() {
		return fees;
	}

	public WebElement getContactNo() {
		return contactNo;
	}

	public WebElement getDoctorEmail() {
		return doctorEmail;
	}
	
	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	// Business Logic
	public void updateDocProcess(String add, String fees)
	{
		getDocIconBtn().click();
		getMyProfileBtn().click();
		getClinicAdd().clear();
	    getClinicAdd().sendKeys(add);
	    getFees().clear();
	    getFees().sendKeys(fees);
	    getUpdateBtn().click();
	    
	}	
}
