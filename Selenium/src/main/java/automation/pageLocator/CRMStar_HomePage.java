package automation.pageLocator;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CRMStar_HomePage {
	By account = By.xpath("");
	private WebDriver driver;

	/**
	 * @param driver
	 */
	public CRMStar_HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void logout(String options) {
		WebElement dropdownAccount = driver.findElement(By.id("dropdownMenuLink"));
		if (dropdownAccount.isEnabled())
			dropdownAccount.click();
		WebElement logoutButton = driver.findElement(By.xpath("//button[text()='Đăng xuất']"));
		assertTrue(logoutButton.isDisplayed());
		if (logoutButton.isEnabled())
			logoutButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MyModal")));
		WebElement logoutModal = modal
				.findElement(By.xpath("//div[contains(@class, 'modal')]//button[text()='" + options + "']"));
		assertTrue(logoutModal.isDisplayed());
		if (logoutModal.isEnabled())
			logoutModal.click();
	}

	public boolean isDisplay() {
		WebElement resultHomePage = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
		return resultHomePage.isDisplayed();
	}

}
