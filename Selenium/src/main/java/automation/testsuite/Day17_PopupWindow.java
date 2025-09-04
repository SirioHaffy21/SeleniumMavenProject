package automation.testsuite;

import static org.testng.Assert.*;

import java.util.Set;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_PopupWindow extends CommonBase {
	@BeforeMethod
	public void beforeMethod() 
	{
		driver = initChromeDriver(CT_PageURL.GURU_POPUP_URL);
	}
	
	@Test
	public void handleWindowPopup() 
	{
		String mainWindow = driver.getWindowHandle();
		click(By.xpath("//a[text()='Click Here']"));
		Set<String> listWindows = driver.getWindowHandles();
		
		for (String window : listWindows) 
		{
			if (!window.equals(mainWindow)) 
			{
				driver.switchTo().window(window);
				assertTrue(isElementDisplayed(By.xpath("//h2[contains(text(), 'Enter your email address')]")));
				type(By.name("emailid"), "nika@gmail.com");
				click(By.name("btnLogin"));
				pause(3);
				assertTrue(isElementDisplayed(By.xpath("//h2[contains(text(), 'Access details to demo site.')]")));
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		String currentUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, CT_PageURL.GURU_POPUP_URL);
		
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}
}
