package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ALADA_UpdatePassPageFactory {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//div[@class='avatar2']")
	@CacheLookup
	private WebElement accountImg;

	@FindBy(xpath = "//a[text()='Thoát']")
	@CacheLookup
	private WebElement exitButton;

	@FindBy(xpath = "//input[@placeholder='Mật khẩu hiện tại']")
	@CacheLookup
	private WebElement currentPassText;

	@FindBy(xpath = "//input[@placeholder='Mật khẩu mới']")
	@CacheLookup
	private WebElement newPassText;

	@FindBy(xpath = "//input[@placeholder='Nhập lại mật khẩu mới']")
	@CacheLookup
	private WebElement reNewPassText;

	@FindBy(xpath = "//button[text()='Lưu mật khẩu mới']")
	@CacheLookup
	private WebElement saveNewPassButton;

	/**
	 * @param driver
	 */
	public ALADA_UpdatePassPageFactory(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void changePass(String currentPass, String newPass, String reNewPass) {
		currentPassText.clear();
		currentPassText.sendKeys(currentPass);

		newPassText.clear();
		newPassText.sendKeys(newPass);

		reNewPassText.clear();
		reNewPassText.sendKeys(reNewPass);

		if (saveNewPassButton.isEnabled())
			saveNewPassButton.click();

		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	public void logoutFunction() {
		accountImg.click();
		exitButton.click();
	}

}
