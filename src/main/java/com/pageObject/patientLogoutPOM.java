package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientLogoutPOM {

	@FindBy(xpath="//span[@class='username']")
	private WebElement logoutIcon;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement logoutBtn;
	
	public patientLogoutPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void patientLogoutProcess()
	{
		getLogoutIcon().click();
		getLogoutBtn().click();
	}
}
