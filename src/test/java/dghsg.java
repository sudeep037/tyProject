import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtilities.baseClass;

public class dghsg extends baseClass {

	@Test
	public void jsdj() throws InterruptedException
	{
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		WebElement basic = driver.findElement(By.xpath("//div[@class='top-nav']"));
		
		Assert.assertTrue(basic.isDisplayed());
		Assert.assertTrue(basic.isEnabled());
	}
}
