package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.ALADA_LoginLogoutPageFactory;

public class Alada_LoginTest extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
	}

	@Test
	public void loginSuccessfully() {
		ALADA_LoginLogoutPageFactory factory = new ALADA_LoginLogoutPageFactory(driver);
		factory.loginFunction("nva@gmail.com", "123456");
		WebElement khoahocCuatoi = driver.findElement(By.xpath("//a[text() = 'Khóa học của tôi']"));
		assertTrue(khoahocCuatoi.isDisplayed());
	}

	@Test
	public void logoutSuccessfully() {

		loginSuccessfully();
		ALADA_LoginLogoutPageFactory factory = new ALADA_LoginLogoutPageFactory(driver);
		factory.logoutFunction();

		assertTrue(factory.isDisplayLogin());
	}

}
