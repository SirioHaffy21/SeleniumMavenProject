package automation.testsuite;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;

public class Day13_Practice extends CommonBase {
	@BeforeMethod
	public void initDriver() {
		driver = initFireFoxDriver(CT_PageURL.STARCRM_URL);
	}

	@Test
	public void loginFunction_Successfull() {
		CRMStar_LoginPage loginPage = new CRMStar_LoginPage(driver);
		loginPage.loginFunction("admin@gmail.com", "12345678");
		WebElement resultPage = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
		assertTrue(resultPage.isDisplayed());
	}

	@Test
	public void loginFail_IncorrectEmail() {
		CRMStar_LoginPage loginPage = new CRMStar_LoginPage(driver);
		loginPage.loginFunction("account@gmail.com", "12345678");
		assertEquals(loginPage.notice(), "Email hoặc mật khẩu không đúng");
	}

	@Test
	public void loginFail_IncorrectPass() {
		CRMStar_LoginPage loginPage = new CRMStar_LoginPage(driver);
		loginPage.loginFunction("admin@gmail.com", "12345679");
		assertEquals(loginPage.notice(), "Email hoặc mật khẩu không đúng");
	}

	@Test
	public void loginFail_IncorrectEmailAndPass() {
		CRMStar_LoginPage loginPage = new CRMStar_LoginPage(driver);
		loginPage.loginFunction("account@gmail.com", "12345679");
		assertEquals(loginPage.notice(), "Email hoặc mật khẩu không đúng");
	}

	@Test
	public void logout_success() throws InterruptedException {
		CRMStar_LoginPage loginPage = new CRMStar_LoginPage(driver);
		CRMStar_HomePage homePage = new CRMStar_HomePage(driver);
		loginPage.loginFunction("admin@gmail.com", "12345678");
		assertTrue(homePage.isDisplay());
		Thread.sleep(7000);
		homePage.logout("Đăng xuất");
		assertTrue(loginPage.isDisplay());
	}

	@Test
	public void logout_cancel() throws InterruptedException {
		CRMStar_LoginPage loginPage = new CRMStar_LoginPage(driver);
		CRMStar_HomePage homePage = new CRMStar_HomePage(driver);
		loginPage.loginFunction("admin@gmail.com", "12345678");
		assertTrue(homePage.isDisplay());
		Thread.sleep(7000);
		homePage.logout("Hủy");
		assertTrue(homePage.isDisplay());
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}
