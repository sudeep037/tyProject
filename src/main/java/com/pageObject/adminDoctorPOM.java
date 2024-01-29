package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminDoctorPOM {

	@FindBy(xpath="//span[text()=' Doctors ']")
	private WebElement docButton;
	
	@FindBy(xpath="//span[text()=' Add Doctor']")
	private WebElement addDocButton;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement submitButton;
	
	public adminDoctorPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDocButton() {
		return docButton;
	}

	public WebElement getAddDocButton() {
		return addDocButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	// Business Logic 
	
	public void clickOnDocBtn()
	{
		getAddDocButton().click();
		getAddDocButton().click();
		getSubmitButton().click();
	}
}
