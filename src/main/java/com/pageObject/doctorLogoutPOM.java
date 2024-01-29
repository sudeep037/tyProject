package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.baseClass;
import com.genericUtilities.webDriverUtilities;

public class doctorLogoutPOM extends webDriverUtilities {

	@FindBy(xpath="//span[@class='username']")
	private WebElement docLogOutIcon;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement docLogoutBtn;
	
	public doctorLogoutPOM(WebDriver driver) {
	   PageFactory.initElements(driver, this);
	}

	public WebElement getDocLogOutIcon() {
		return docLogOutIcon;
	}

	public WebElement getDocLogoutBtn() {
		return docLogoutBtn;
	}
	
	public void docLogoutProcess()
	{
		getDocLogOutIcon().click();
		getDocLogoutBtn().click();
	}
}
