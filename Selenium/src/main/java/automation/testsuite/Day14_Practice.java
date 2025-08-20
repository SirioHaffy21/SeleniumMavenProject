package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;
import automation.utils.Utils;

public class Day14_Practice extends CommonBase {
	private String name = "Peter Parker";
	private static String baseEmail = "testBase";
	private String pass = "spiderman_123";
	private String newPass = "spiderman1234@";
	private String phone = "0986625325";

	 public static String generateRandomString(int length) {
	        // Define the character set to be used for the random string
	        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder email = new StringBuilder(); // Use StringBuilder for efficient string construction
	        Random random = new Random(); // Create a Random object

	        // Loop to append random characters until the desired length is reached
	        for (int i = 0; i < length; i++) {
	            // Get a random index within the character set
	            int index = random.nextInt(characterSet.length());
	            // Append the character at the random index to the StringBuilder
	            email.append(characterSet.charAt(index));
	        }
	        // Convert the StringBuilder content to a String and return it
	        baseEmail = baseEmail + email.toString() + "@gmail.com";
	        return baseEmail;
	    }


	@BeforeMethod
	public void initProcess() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL_2);
	}

	@Test(priority = 2)
	public void loginSuccess() {
		ALADA_LoginPageFactory loginPage = new ALADA_LoginPageFactory(driver);
		loginPage.loginFunction(baseEmail, pass);

		ALADA_HomePageFactory honePage = new ALADA_HomePageFactory(driver);
		assertTrue(honePage.checkHomePage());
	}

	// 1. Vào trang https://alada.vn/ và đăng ký thành công tài khoản mới
	@Test(priority = 1)
	public void checkRegister() throws InterruptedException {
		generateRandomString(4);
		ALADA_RegisterPageFactory registerPage = new ALADA_RegisterPageFactory(driver);
		registerPage.registerAccount(name, baseEmail, pass, phone);

		Thread.sleep(2000);

		ALADA_HomePageFactory homePage = new ALADA_HomePageFactory(driver);
		assertTrue(homePage.checkHomePage_Register(baseEmail));
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
		loginPage.loginFunction(baseEmail, newPass);
		assertTrue(homePage.checkHomePage());
	}

	@AfterMethod
	public void endProcess() {
		driver.quit();
	}
}
