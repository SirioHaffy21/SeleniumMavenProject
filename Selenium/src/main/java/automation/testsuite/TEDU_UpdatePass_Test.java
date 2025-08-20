package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;

public class TEDU_UpdatePass_Test extends CommonBase {
	TEDU_PageFactory tedu;
	private String pass = "spiderman_1234";
	private String newPass = "spiderman_12345";

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.TEDU_URL);
		tedu = new TEDU_PageFactory(driver);
	}

	@Test
	public void loginSuccessfully() throws InterruptedException {

		tedu.login("spiderman123@gmail.com", pass);
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
	}

	@Test
	public void updatePassSuccess() throws InterruptedException {
		loginSuccessfully();
		// driver.switchTo().frame("_hjSafeContext_7489843");
		// WebElement iframe = driver.findElement(null)
		tedu.updatePassword(pass, newPass);
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());
	}
}
