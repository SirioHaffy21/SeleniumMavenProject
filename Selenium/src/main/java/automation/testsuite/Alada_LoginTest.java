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
	@Parameters({ "browser" })
	public void initProcess(@Optional("edge") String browser) {
		setupDriver(browser);
		driver.get(CT_PageURL.ALADA_URL);
	}

	@Test
	public void loginSuccessfully() {
		ALADA_LoginPageFactory factory = new ALADA_LoginPageFactory(driver);
		factory.loginFunction("nva@gmail.com", "123456");
		WebElement khoahocCuatoi = driver.findElement(By.xpath("//a[text() = 'Khóa học của tôi']"));
		assertTrue(khoahocCuatoi.isDisplayed());
	}

	@Test
	public void logoutSuccessfully() throws InterruptedException {

		ALADA_LoginPageFactory factory = new ALADA_LoginPageFactory(driver);
		factory.loginFunction("nva@gmail.com", "123456");
		Thread.sleep(2000);
		ALADA_HomePageFactory factoryHome = new ALADA_HomePageFactory(driver);
		factoryHome.logoutFunction();

		assertTrue(factory.isDisplayLogin());
	}

	@AfterMethod
	public void endProcess() {
		closeDriver();
	}

}
