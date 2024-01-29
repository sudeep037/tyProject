package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminLogoutPOM {

	@FindBy(xpath="(//span[contains(.,'Admin')])[1]")
	private WebElement clickOnAdminButton;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement clickOnLogOutBtn;
	
	public adminLogoutPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickOnAdminButton() {
		return clickOnAdminButton;
	}

	public WebElement getClickOnLogOutBtn() {
		return clickOnLogOutBtn;
	}
	
	// Business Logic 
	
	public void logoutAsAdmin()
	{
		getClickOnAdminButton().click();
		getClickOnLogOutBtn().click();
	}
}
