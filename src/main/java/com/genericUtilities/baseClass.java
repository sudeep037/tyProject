package com.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	// Object for the Utilities
	public webDriverUtilities wbUtils = new webDriverUtilities();
	public databaseUtils dbUtils = new databaseUtils();
	public excelUtils xlUtils = new excelUtils();
	public fileUtils prop = new fileUtils();
	public randomUtil randUtil = new randomUtil();
	public Faker faker = new Faker();
	public static WebDriver driver;
	
	@BeforeSuite
	public void configBeforeSuite() throws Throwable
	{
		dbUtils.connectToDB();
		System.out.println("--Connected to Database--");
	}
	
	
	@BeforeClass
	public void configBeforeClass()
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		wbUtils.maximizeWindow(driver);
		wbUtils.implicitWait(driver, 10);
		System.out.println("--Firefox Browser launched--");
	}
	
	@AfterClass
	public void configAfterClass()
	{
		driver.close();
		System.out.println("--Browser closed--");
	}
	
	@AfterSuite
	public void configAfterSuite() throws Throwable
	{
		dbUtils.closeDB();
		System.out.println("--Disconnected to Database--");
	}
}
