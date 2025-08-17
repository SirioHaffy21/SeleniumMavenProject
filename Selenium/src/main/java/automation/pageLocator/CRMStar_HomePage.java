package automation.pageLocator;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CRMStar_HomePage {
	By account = By.xpath("");
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "dropdownMenuLink")
	@CacheLookup
	private WebElement dropdownAccount;

	@FindBy(xpath = "//button[text()='Đăng xuất']")
	@CacheLookup
	private WebElement logoutButton;

	@FindBy(id = "MyModal")
	@CacheLookup
	private WebElement modal;

	@FindBy(xpath = "//p[text()='Quản lý người dùng']")
	@CacheLookup
	private WebElement resultHomePage;

	@FindBy(xpath = "//div[contains(@class, 'modal')]//button[text()='Đăng xuất']")
	private WebElement logoutSuccessModal;

	@FindBy(xpath = "//div[contains(@class, 'modal')]//button[text()='Hủy']")
	private WebElement logoutCancelModal;

	/**
	 * @param driver
	 */
	public CRMStar_HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void logout(String options) {

		if (dropdownAccount.isEnabled())
			dropdownAccount.click();
		assertTrue(logoutButton.isDisplayed());

		if (logoutButton.isEnabled())
			logoutButton.click();

		wait.until(ExpectedConditions.visibilityOf(modal));

		if (options == "Đăng xuất") {
			if (logoutSuccessModal.isEnabled())
				logoutSuccessModal.click();
		} else {
			if (logoutCancelModal.isEnabled())
				logoutCancelModal.click();
		}
	}

	public boolean isDisplayed() {
		return resultHomePage.isDisplayed();
	}
}
