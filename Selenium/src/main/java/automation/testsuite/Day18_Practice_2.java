package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day18_Practice_2 extends CommonBase{
	@BeforeMethod
	@Parameters({"browser"})
	public void initProcess(String browser) 
	{
		setupDriver(browser);
		driver.get(CT_PageURL.BEPANTOAN_URL);
	}
	
	@Test
	public void checkZaloChat() throws InterruptedException {
		pause(6);
		String mainWindow = driver.getWindowHandle();
		clickByJS(By.xpath("//a[contains(@href,'zalo.me')]"));
		Set<String> listWindows = driver.getWindowHandles();
		for (String window : listWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				Thread.sleep(3000);
				assertEquals(driver.getTitle(), "Zalo - Nhắn Gửi Yêu Thương (Nhắn tin thoại - Trò chuyện nhóm ...)");
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		assertEquals(driver.getCurrentUrl(), CT_PageURL.BEPANTOAN_URL);
	}
	
	@AfterMethod
	public void endProcess() 
	{
		closeDriver();
	}
}
