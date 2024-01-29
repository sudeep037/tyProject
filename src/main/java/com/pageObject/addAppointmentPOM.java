package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.webDriverUtilities;

public class addAppointmentPOM extends webDriverUtilities {

	@FindBy(xpath="//span[text()=' Book Appointment ']")
	private WebElement bookAppBtn;
	
	@FindBy(name= "Doctorspecialization")
	private WebElement specDrop;
	
	@FindBy(name="doctor")
	private WebElement docDrop;
	
	@FindBy(name="appdate")
	private WebElement appDateTxt;
	
	@FindBy(xpath="//th[contains(.,'January')]/../../..//tbody//tr[4]//td[4]")
	private WebElement appDate;
	
	@FindBy(xpath="//input[@name='apptime']")
	private WebElement appTime;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement appSubmitBtn;
	
	@FindBy(name="username")
	private WebElement patLogIcon;
	
	public addAppointmentPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBookAppBtn() {
		return bookAppBtn;
	}

	public WebElement getAppDate() {
		return appDate;
	}

	public WebElement getAppTime() {
		return appTime;
	}

	public WebElement getAppSubmitBtn() {
		return appSubmitBtn;
	}
	
	public WebElement getSpecDrop() {
		return specDrop;
	}

	public WebElement getDocDrop() {
		return docDrop;
	}
	
	public WebElement getAppDateTxt() {
		return appDateTxt;
	}
	
	public void bookAppointmentProcess(WebDriver driver, String time)
	{
		getBookAppBtn().click();
		selectDropDownOptions(specDrop, "Ayurveda");
		selectDropDownOptions("Nikhita", docDrop);
		getAppTime().clear();
		getAppTime().sendKeys(time);
		getAppDateTxt().click();
		getAppDate().click();
		getAppSubmitBtn().click();
		explicitWaitConditions(driver,10,patLogIcon);
	}

	
}
