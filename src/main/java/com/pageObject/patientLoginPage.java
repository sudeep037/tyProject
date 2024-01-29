package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientLoginPage {

	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pswd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	public patientLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPswd() {
		return pswd;
	}

	public WebElement getLogin() {
		return login;
	}
	
	public void patientLoginProcess(String username,String pswd)
	{
		getUsername().sendKeys(username);
		getPswd().sendKeys(pswd);
		getLogin().click();
	}
}
