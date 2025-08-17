package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CRMStar_LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@placeholder='Email']")
	@CacheLookup
	private WebElement emailInput;

	@FindBy(xpath = "//input[@placeholder='Mật khẩu']")
	@CacheLookup
	private WebElement passInput;

	@FindBy(xpath = "//button[text()='Đăng nhập']")
	@CacheLookup
	private WebElement buttonLogin;

	@FindBy(xpath = "//h4[contains(normalize-space(), 'Đăng nhập')]")
	@CacheLookup
	private WebElement loginTitle;

	@FindBy(xpath = "//span[@class='fl-message']")
	@CacheLookup
	private WebElement errorMessage;

	public CRMStar_LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void loginFunction(String email, String pass) {
		if (emailInput.isDisplayed()) {
			emailInput.clear();
			emailInput.sendKeys(email);
		}
		if (passInput.isDisplayed()) {
			passInput.clear();
			passInput.sendKeys(pass);
		}
		if (buttonLogin.isEnabled()) {
			buttonLogin.click();
		}
	}

	public boolean isDisplayed() {
		return loginTitle.isDisplayed();
	}

	public String inform() {
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText();
	}
}
