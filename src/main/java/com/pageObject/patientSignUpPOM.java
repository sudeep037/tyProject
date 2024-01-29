package com.pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.IpathConstants;

public class patientSignUpPOM {

	@FindBy(name="full_name")
	private WebElement fullName;
	
	@FindBy(name="address")
	private WebElement address;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="password_again")
	private WebElement cnfPassword;
	
	@FindBy(xpath="//label[contains(.,'Male')]")
	private WebElement genderBtn;
	
	@FindBy(xpath="//button[contains(.,'Submit')]")
	private WebElement submitBtn;
	
	
	public WebElement getGenderBtn() {
		return genderBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getCnfPassword() {
		return cnfPassword;
	}

	public patientSignUpPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	public void patientSignProcess() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook book =  WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<>();
		for(int r=0; r<=rowCount; r++)
		{
			String key = sheet.getRow(r).getCell(0).getStringCellValue();
			String value =sheet.getRow(r).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> set:map.entrySet())
		{
		getFullName().sendKeys(set.getValue());
		getAddress().sendKeys(set.getValue());
		getCity().sendKeys(set.getValue());
		getEmail().sendKeys(set.getValue());
		getPassword().sendKeys(set.getValue());
		getCnfPassword().sendKeys(set.getValue());
		getGenderBtn().click();
		getSubmitBtn().click();
		}
	}
}
