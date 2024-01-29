package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.webDriverUtilities;

public class patientUpdatePage extends webDriverUtilities{

	@FindBy(xpath="//span[@class='username']")
	private WebElement patIconBtn;
	
	@FindBy(xpath="//a[contains(.,'My Profile')]")
	private WebElement myProfileBtn;
	
	@FindBy(xpath="//input[@name='fname']")
	private WebElement userName;
	
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath="//select[@name='gender']")
	private WebElement gender;
	
	@FindBy(xpath="//input[@name='uemail']")
	private WebElement userEmail;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement updateBtn;
	
	public patientUpdatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatIconBtn() {
		return patIconBtn;
	}

	public WebElement getMyProfileBtn() {
		return myProfileBtn;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public void patUpdateProcess(String UN, String addrrs, String city)
	{
		getPatIconBtn().click();
		getMyProfileBtn().click();
		getUserName().clear();
		getUserName().sendKeys(UN);
		getAddress().clear();
		getAddress().sendKeys(addrrs);
		getCity().clear();
		getCity().sendKeys(city);
		selectDropDownOptions(gender, "male");
		getUpdateBtn().click();
	}
}
