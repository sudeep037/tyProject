package com.pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.excelUtils;
import com.github.javafaker.Faker;

public class addPatientPOM {

	public WebDriver driver;
	
	@FindBy(xpath="//span[.=' Patients ']")
	private WebElement patientBtn;
	
	@FindBy(xpath="//span[.=' Add Patient']")
	private WebElement addPatientBtn;
	
	@FindBy(xpath="//input[@name='patname']")
	private WebElement patientName;
	
	@FindBy(xpath="//input[@name='patcontact']")
	private WebElement patientContact;
	
	@FindBy(xpath="//input[@name='patemail']")
	private WebElement patientEmail;
	
	@FindBy(xpath="//textarea[@name='pataddress']")
	private WebElement patientAddress;
	
	@FindBy(xpath="//input[@name='patage']")
	private WebElement patientAge;
	
	@FindBy(xpath="//textarea[@name='medhis']")
	private WebElement patientMedHist;
	
	@FindBy(xpath="//label[contains(.,'Male')]")
	private WebElement selectGender;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickOnSubmit;
	
	public addPatientPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPatientBtn() {
		return patientBtn;
	}

	public WebElement getAddPatientBtn() {
		return addPatientBtn;
	}

	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getPatientContact() {
		return patientContact;
	}

	public WebElement getPatientEmail() {
		return patientEmail;
	}

	public WebElement getPatientAddress() {
		return patientAddress;
	}

	public WebElement getPatientAge() {
		return patientAge;
	}

	public WebElement getPatientMedHist() {
		return patientMedHist;
	}

	public WebElement getSelectGender() {
		return selectGender;
	}

	public WebElement getClickOnSubmit() {
		return clickOnSubmit;
	}


	// Business Logic
	public void addPatientUsingExcel(excelUtils exUtils, WebDriver driver, Faker faker) throws IOException
	{
		getPatientBtn().click();
		getAddPatientBtn().click();
		
		Object patArr [][]= {
				{patientName,faker.name().fullName()},
				{patientContact, faker.numerify("7896034578")},
				{patientEmail, faker.internet().emailAddress()},
				{patientAddress,faker.address().buildingNumber()},
				{patientAge, faker.numerify("45")},
				{patientMedHist, faker.medical().symptoms()} };
		
		// Passing an Object array to write data into excel
		exUtils.writeDataIntoExcel1("Sheet1", patArr);
		
		getSelectGender().click();
		getClickOnSubmit().click();
	}
	
	public void addPatientProcess(String patientName, String patientContact, String patientEmail, String patientAdd, String patientAge, String patientMedHist)
	{
		getPatientBtn().click();
		getAddPatientBtn().click();
		getPatientName().sendKeys(patientName);
		getPatientContact().sendKeys(patientContact);
		getPatientEmail().sendKeys(patientEmail);
		getSelectGender().click();
		getPatientAddress().sendKeys(patientAdd);
		getPatientAge().sendKeys(patientAge);
		getPatientMedHist().sendKeys(patientMedHist);
		getClickOnSubmit().click();
	}
	
}
