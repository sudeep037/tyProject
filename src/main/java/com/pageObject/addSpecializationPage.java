package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addSpecializationPage {

	@FindBy(xpath="//span[.=' Doctors ']")
	private WebElement docBtn;
	
	@FindBy(xpath="//span[.=' Doctor Specialization ']")
	private WebElement docSpecializationBtn;
	
	@FindBy(xpath="//input[@name='doctorspecilization']")
	private WebElement specializationTxt;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public addSpecializationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDocBtn() {
		return docBtn;
	}

	public WebElement getDocSpecializationBtn() {
		return docSpecializationBtn;
	}

	public WebElement getSpecializationTxt() {
		return specializationTxt;
	}
	
	public void addSpecProcess(String spec)
	{
		getDocBtn().click();
		getDocSpecializationBtn().click();
		getSpecializationTxt().sendKeys(spec);
		getSubmitBtn().click();
	}
}
