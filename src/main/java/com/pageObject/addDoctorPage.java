package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.webDriverUtilities;

public class addDoctorPage extends webDriverUtilities{

	@FindBy(xpath="//span[.=' Doctors ']")
	private WebElement docBtn;
	
	@FindBy(xpath="//span[text()=' Add Doctor']")
	private WebElement addDocBtn;
	
	@FindBy(xpath="//span[.=' Doctor Specialization ']")
	private WebElement specBtn;
	
	@FindBy(xpath="//input[@name='doctorspecilization']")
	private WebElement addSpecTxt;
	
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
	
	@FindBy(xpath="//input[@name='npass']")
	private WebElement pswd;
	
	@FindBy(xpath="//input[@name='cfpass']")
	private WebElement ConfirmPswd;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	
	public addDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDocBtn() {
		return docBtn;
	}

	public WebElement getAddDocBtn() {
		return addDocBtn;
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

	public WebElement getPswd() {
		return pswd;
	}

	public WebElement getConfirmPswd() {
		return ConfirmPswd;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getSpecBtn() {
		return specBtn;
	}
	
	public WebElement getAddSpecTxt() {
		return addSpecTxt;
	}
	
	// Business logic
	
	public void addDoctorProcess(String addSpec, String name, String add, String docFess, String no, String email, String Pswd, String cnfPswd)
	{
		getDocBtn().click();
		getSpecBtn().click();
		getAddSpecTxt().sendKeys(addSpec);
		getDocBtn().click();
		getAddDocBtn().click();
        selectDropDownOptions("Ayurveda", specDrop);
		getDocName().sendKeys(name);
		getClinicAdd().sendKeys(add);
		getFees().sendKeys(docFess);
		getContactNo().sendKeys(no);
		getDoctorEmail().sendKeys(email);
		getPswd().sendKeys(Pswd);
		getConfirmPswd().sendKeys(cnfPswd);
		getSubmitBtn().click();
	}
	
	
	
}
