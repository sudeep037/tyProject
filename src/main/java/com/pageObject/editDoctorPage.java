package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editDoctorPage {

	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement docSpec;
	
	@FindBy(xpath="//input[@name='docname']")
	private WebElement nameTxt;
	
	@FindBy(xpath="//textarea[@name='clinicaddress']")
	private WebElement addTxtArea;
	
	@FindBy(xpath="//input[@name='docfees']")
	private WebElement docFees;
	
	@FindBy(xpath="//input[@name='doccontact']")
	private WebElement docContact;
	
	@FindBy(xpath="//input[@name='docemail']")
	private WebElement docEmail;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	

	public editDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDocSpec() {
		return docSpec;
	}

	public WebElement getNameTxt() {
		return nameTxt;
	}

	public WebElement getAddTxtArea() {
		return addTxtArea;
	}

	public WebElement getDocFees() {
		return docFees;
	}

	public WebElement getDocContact() {
		return docContact;
	}

	public WebElement getDocEmail() {
		return docEmail;
	}
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}
