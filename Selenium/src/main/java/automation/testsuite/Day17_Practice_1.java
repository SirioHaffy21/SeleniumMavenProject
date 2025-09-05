package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_Practice_1 extends CommonBase{
	@BeforeMethod
	public void initProcess() 
	{
		driver = initChromeDriver(CT_PageURL.MEDIAMART_URL);
	}
	
	@Test
	public void testZaloIframe() throws InterruptedException 
	{
		System.out.println("iframe count: " + driver.findElements(By.tagName("iframe")).size());
		pause(5);
		assertTrue(isElementDisplayed(By.xpath("//iframe[contains(@src, 'zalo')]")));
		driver.switchTo().frame(0);
		assertTrue(isElementDisplayed(By.xpath("//div[@class = 'za-chat']")));
		clickByJS(By.xpath("//div[@class = 'logo']"));
		Thread.sleep(2000);
		String zaloText = getText(By.xpath("//p[@class='text-hint-welcome']"));
		assertEquals(zaloText, "Bắt đầu trò chuyện với Siêu thị điện máy MediaMart");
	}
	
	@AfterMethod
	public void endProcess() 
	{
		driver.quit();
	}
}
