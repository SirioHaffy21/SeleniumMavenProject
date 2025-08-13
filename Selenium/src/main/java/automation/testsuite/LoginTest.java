package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.LoginPage;

public class LoginTest extends CommonBase {
	@BeforeMethod
	public void openChromeBrowser() {
		driver = initFireFoxDriver(CT_PageURL.ALADA_URL);
	}

	// Case 1: Login success
	@Test
	public void loginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.loginFunction("nva@gmail.com", "123456");
		// assertEquals(false, null);
		WebElement khoahocCuatoi = driver.findElement(By.xpath("//a[text() = 'Khóa học của tôi']"));
		assertTrue(khoahocCuatoi.isDisplayed());
	}

	@Test
	public void loginFailWithBlank() {
		LoginPage login = new LoginPage(driver);
		login.loginFunction("", "");
		// assertEquals(false, null);
		WebElement textUsernameError = driver.findElement(By.xpath("//label[@for='txtLoginUsername']"));
		assertEquals(textUsernameError.isDisplayed(), true);
		assertEquals(textUsernameError.getText(), "Vui lòng nhập email");
		WebElement textPasswordError = driver.findElement(By.xpath("//label[@for='txtLoginPassword']"));
		assertEquals(textPasswordError.isDisplayed(), true);
		assertEquals(textPasswordError.getText(), "Vui lòng nhập mật khẩu");
	}

	@Test
	public void loginFail_IncorrectUsername() {
		LoginPage login = new LoginPage(driver);
		login.loginFunction("nvb@gmail.com", "123456");
		// assertEquals(false, null);
		WebElement textUsernameError = driver.findElement(By.xpath("//p[@class='cred']"));
		assertEquals(textUsernameError.isDisplayed(), true);
		assertEquals(textUsernameError.getText(), "Email này chưa được đăng ký.");
	}

	@Test
	public void loginFail_IncorrectPassword() {
		LoginPage login = new LoginPage(driver);
		login.loginFunction("nva@gmail.com", "12345");
		// assertEquals(false, null);
		WebElement textPasswordError = driver.findElement(By.xpath("//p[@class='cred']"));
		assertEquals(textPasswordError.isDisplayed(), true);
		assertEquals(textPasswordError.getText(), "Mật khẩu sai.");
	}

	@AfterMethod
	public void closeDriver() {
		if (driver != null)
			driver.close();
	}
}
