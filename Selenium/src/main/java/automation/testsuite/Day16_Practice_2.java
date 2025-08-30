package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;

public class Day16_Practice_2 extends CommonBase {
	BlogPost_PageFactory blogPost;

	@BeforeMethod
	public void initProcess() {
		driver = initChromeDriver(CT_PageURL.BLOGPOST_URL);
		blogPost = new BlogPost_PageFactory(driver);
	}

	@Test
	public void testTryIt() throws InterruptedException {
		blogPost.testTryIt();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.alertIsPresent());
		String result = driver.switchTo().alert().getText();
		assertEquals(result, "Welcome to Selenium WebDriver Tutorials");
	}

	@AfterMethod
	public void endProcess() {
		driver.quit();
	}
}
