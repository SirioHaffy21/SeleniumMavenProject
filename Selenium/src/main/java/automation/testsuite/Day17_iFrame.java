package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_iFrame extends CommonBase {
	@BeforeMethod
	public void initProcess() 
	{
		driver = initChromeDriver(CT_PageURL.CODESTAR_IFRAME_URL);
	}
	
	@Test
	public void handleIframe() 
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		By locator = By.xpath("//h2[contains(text(), 'Đăng kí nhận tư vấn lộ trình ')]");
		scrollToElement(locator);
		System.out.println("iframe count: " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		type(By.id("phone_number"), "0979535822");
		clickByJS(By.xpath("//button[normalize-space()='Gửi ngay']"));
		assertTrue(isElementDisplayed(By.id("email")));
	}
	
	@AfterMethod
	public void endProcess() 
	{
		driver.quit();
	}
}
