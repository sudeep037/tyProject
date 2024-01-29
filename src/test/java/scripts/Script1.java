package scripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Script1 {

	public static void main(String[] args) throws Throwable{
			
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/hms/admin/");
		
		Thread.sleep(20000);
		
		// Login to the Admin Module
		
		String actualLoginPage = "Admin-Login";
		String expLoginPage = driver.findElement(By.xpath("//title[.='Admin-Login']")).getText();
		
		if(actualLoginPage.equals(expLoginPage))
		{
		
		// Entering username and password 
		WebElement unTxt = driver.findElement(By.xpath("//input[@type='text']"));
		WebElement pswdTxt = driver.findElement(By.xpath("//input[@type='password']"));
		unTxt.sendKeys("admin");
		pswdTxt.sendKeys("Test@1234");
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
		System.out.println("1. Successfully logged in...");
		}	
		else {
			System.out.println("Oops Error!!!");
		}
		
		// Click on Doctor dropdown
		
		WebElement doctorDD =  driver.findElement(By.xpath("//span[.=' Doctors ']"));
		doctorDD.click();
		
		// click on Add doctor button 
		WebElement addDocBtn = driver.findElement(By.xpath("//span[contains(.,'Add Doctor')]"));
		addDocBtn.click();
		
		// Verifying Add doctor page is displayed or not
		String actualAddDocPage = "Admin | Add Doctor";
		String expAddDocPage = driver.findElement(By.xpath("//title[text()='Admin | Add Doctor']")).getText();
		
		if(actualAddDocPage.equals(expAddDocPage))
		{
			System.out.println("Correct page title is displayed");
			
			// Steps to Add doctor 
			
			// Select specialization 
			WebElement specialization = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
			Select s = new Select(specialization);
			s.getFirstSelectedOption();
			
			// Add Doctor Name 
			WebElement name = driver.findElement(By.xpath("//input[@name='docname']"));
		    name.sendKeys("Gaurav");
		    
		    // Add Clinic Address
		    WebElement clinicAdd = driver.findElement(By.xpath("//textarea[@name='clinicaddress']"));
		    clinicAdd.sendKeys("Kolkata");
			
		}
	
		
	}
}
