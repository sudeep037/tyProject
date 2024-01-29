package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class managePatientPage {

	@FindBy(xpath="//span[.=' Patients ']")
	private WebElement patBtn;
	
	@FindBy(xpath="//span[.=' Manage Patients ']")
	private WebElement managePatBtn;
	
	public managePatientPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatBtn() {
		return patBtn;
	}

	public WebElement getManagePatBtn() {
		return managePatBtn;
	}
	
	// Business logic
	
	public void managePatientProcess()
	{
		getPatBtn().click();
		getManagePatBtn().click();
	}
}
