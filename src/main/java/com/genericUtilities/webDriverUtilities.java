package com.genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtilities {
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public Select selectClassObject(WebElement element)
	{
		Select select = new Select(element);
		return select;
	}
	
	public Actions actionClassObject(WebDriver driver)
	{
		Actions action = new Actions(driver);
		return action;
	}
	
	public Timeouts implicitWait(WebDriver driver, int sec)
	{
		Timeouts implicit = driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
		return implicit;
	}
	
	//Common Method for ExplicitWait
	public WebDriverWait handleExplicitWaitConditions(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait;
	}
	
	public void explicitWaitConditions(WebDriver driver, WebElement element)
	{
		handleExplicitWaitConditions(driver).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaitConditions(WebDriver driver, int sec, WebElement element)
	{
		
	   handleExplicitWaitConditions(driver).until(ExpectedConditions.alertIsPresent());
	}
	
	public void explicitWaitConditions(WebDriver driver,WebElement element, int sec)
	{
		handleExplicitWaitConditions(driver).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// Methods for selecting dropdown Options
	public void selectDropDownOptions(int index, WebElement element)
	{
		selectClassObject(element).selectByIndex(index);		
	}
	
	public void selectDropDownOptions(String text, WebElement element)
	{
		selectClassObject(element).selectByVisibleText(text);
	}
	
	public void selectDropDownOptions(WebElement element, String value)
	{
		selectClassObject(element).selectByValue(value);
	}
	
	public void selectAllOptions(String expOption,WebElement element)
	{
		Select s = new Select(element);
		List<WebElement> allOptions = s.getOptions();
		for(WebElement option:allOptions)
		{
			String actualOption = option.getText();
			if(expOption.equals(actualOption))
			{
				option.click();
			}
		}
	}
	
	public void clickOnElement(WebElement element, WebDriver driver)
	{
		actionClassObject(driver).click(element).perform();
	}
	
	public void dragAndDrop(WebElement src, WebElement dest, WebDriver driver, WebElement element)
	{
		actionClassObject(driver).dragAndDrop(src, dest).perform();
	}
	
	public void doubleClick(WebDriver driver)
	{
		actionClassObject(driver).doubleClick().perform();
	}
	
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		actionClassObject(driver).doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		actionClassObject(driver).contextClick().perform();
	}
	
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		actionClassObject(driver).contextClick(element).perform();
	}
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void openPageinNextTab() throws AWTException
	{
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_ALT);
		rbt.keyRelease(KeyEvent.VK_ALT);
	}
	
	public void scrollAction(WebDriver driver, int x, int y, int count)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 1; i<=count; i++)
		{
		  js.executeScript("window.scrollBy(x,y)");
		}
	}
	
	public void enterValuesInDisabledElement(WebDriver driver, String key, String data)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+key+"').value='"+data+"'");
	}
	
	public void switchToChildWindows(WebDriver driver, String expTab)
	{
		Set<String> allTabs = driver.getWindowHandles();
		for(String tab:allTabs)
		{
			driver.switchTo().window(tab);
			String destinedExpTab = expTab;
			String actTab = driver.getTitle();
			
			if(destinedExpTab.equals(actTab))
			{
			   break;
			}
		}
	}
	
	public void takeScreenShot(WebDriver driver) throws IOException
	{
		Date d = new Date();
		String data = d.toString().replace(":", "-");
		TakesScreenshot shot = (TakesScreenshot) driver;
		File temp = shot.getScreenshotAs(OutputType.FILE);
		File per = new File(IpathConstants.photoPath+data+".jpg");
		org.openqa.selenium.io.FileHandler.copy(temp, per);
	}
	
	public void notificationPopUp()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disabled-notifications");
	}
	
	public void frame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void frameByName(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void frame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToImmediateParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public void switchToDefault(WebDriver driver, int index)
	{
		driver.switchTo().defaultContent();
	}
	
	public static String takeScreenshot(WebDriver driver, String methodName) throws Throwable
	{
		Date d = new Date();
		String date = d.toString().replace(":", "-");
		TakesScreenshot shot = (TakesScreenshot) driver;
		File temp = shot.getScreenshotAs(OutputType.FILE);
		File per = new File("./screenshots/"+date+".jpg");
		FileUtils.copyFile(temp, per);
		return date;
	}
}
