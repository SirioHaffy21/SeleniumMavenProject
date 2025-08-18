package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;

public class Alada_LoginTest extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
	}

	@Test
	public void loginSuccessfully() {
		ALADA_LoginPageFactory factory = new ALADA_LoginPageFactory(driver);
		factory.loginFunction("nva@gmail.com", "123456");
		WebElement khoahocCuatoi = driver.findElement(By.xpath("//a[text() = 'Khóa học của tôi']"));
		assertTrue(khoahocCuatoi.isDisplayed());
	}

	@Test
	public void logoutSuccessfully() {

		ALADA_LoginPageFactory factory = new ALADA_LoginPageFactory(driver);
		factory.loginFunction("nva@gmail.com", "123456");
		ALADA_HomePageFactory factoryHome = new ALADA_HomePageFactory(driver);
		factoryHome.logoutFunction();

		assertTrue(factory.isDisplayLogin());
	}

}
