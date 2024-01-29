package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminLoginPOM {

	@FindBy(name="username")
	private WebElement adminUN;
	
	@FindBy(name="password")
	private WebElement adminPswd;
	
	@FindBy(xpath="//button[contains(.,'Login')]")
	private WebElement submitBtn;
	
	public adminLoginPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getAdminUN() {
		return adminUN;
	}

	public WebElement getAdminPswd() {
		return adminPswd;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	// Business Logic 
	
	public void adminLogin(String adminUN, String adminPswd)
	{
		getAdminUN().sendKeys(adminUN);
		getAdminPswd().sendKeys(adminPswd);
		getSubmitBtn().click();
	}
}
