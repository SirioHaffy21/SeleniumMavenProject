package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;

public class Day14_Practice extends CommonBase {
	private String name = "Peter Parker";
	private String email = "spiderman7@gmail.com";
	private String pass = "spiderman_123";
	private String newPass = "spiderman1234@";
	private String phone = "0986625325";

	@BeforeMethod
	public void initProcess() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL_2);
	}

	@Test(priority = 2)
	public void loginSuccess() {
		ALADA_LoginPageFactory loginPage = new ALADA_LoginPageFactory(driver);
		loginPage.loginFunction(email, pass);

		ALADA_HomePageFactory honePage = new ALADA_HomePageFactory(driver);
		assertTrue(honePage.checkHomePage());
	}

	// 1. Vào trang https://alada.vn/ và đăng ký thành công tài khoản mới
	@Test(priority = 1)
	public void checkRegister() throws InterruptedException {
		ALADA_RegisterPageFactory registerPage = new ALADA_RegisterPageFactory(driver);
		registerPage.registerAccount(name, email, pass, phone);

		Thread.sleep(3000);

		ALADA_HomePageFactory homePage = new ALADA_HomePageFactory(driver);
		assertTrue(homePage.checkHomePage_Register(email));
	}

	// 2. Vào màn Chỉnh sửa thông tin, sau đó cập nhật mật khẩu mới
	// 3. Đăng nhập bằng mật khẩu mới và assert mọt element của trang chủ hiện ra
	@Test(priority = 3)
	public void changePass() {
		loginSuccess();
		ALADA_HomePageFactory homePage = new ALADA_HomePageFactory(driver);
		homePage.updateInfoNavigate();
		ALADA_UpdatePassPageFactory changePassPage = new ALADA_UpdatePassPageFactory(driver);
		changePassPage.changePass(pass, newPass, newPass);

		changePassPage.logoutFunction();

		ALADA_LoginPageFactory loginPage = new ALADA_LoginPageFactory(driver);
		loginPage.loginFunction(email, newPass);
		assertTrue(homePage.checkHomePage());
	}

	@AfterMethod
	public void endProcess() {
		driver.quit();
	}
}
