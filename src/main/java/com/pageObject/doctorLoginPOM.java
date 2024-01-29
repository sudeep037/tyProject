package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class doctorLoginPOM {

	@FindBy(xpath="//input[@name='username']")
	private WebElement docUN;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement docPswd;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	
	public doctorLoginPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDocUN() {
		return docUN;
	}

	public WebElement getDocPswd() {
		return docPswd;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void doctorLogin(String Username, String Password)
	{
		getDocUN().sendKeys(Username);
		getDocPswd().sendKeys(Password);
		getSubmitBtn().click();
	}
	
}
