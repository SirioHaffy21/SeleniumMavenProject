package automation.pageLocator;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ALADA_LoginLogoutPageFactory {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(id = "txtLoginUsername")
	@CacheLookup
	private WebElement emailInput;

	@FindBy(id = "txtLoginPassword")
	@CacheLookup
	private WebElement passInput;

	@FindBy(xpath = "(//button[text()='ĐĂNG NHẬP'])[3]")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='avatar2']")
	private WebElement accountImg;

	@FindBy(xpath = "//a[text()='Thoát']")
	private WebElement exitButton;

	@FindBy(xpath = "//a[text()='Đăng Nhập']")
	private WebElement menu_LoginButton;

	public ALADA_LoginLogoutPageFactory(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void loginFunction(String email, String pass) {
		emailInput.clear();
		emailInput.sendKeys(email);
		passInput.clear();
		passInput.sendKeys(pass);

		if(loginButton.isEnabled())
			loginButton.click();
	}

	public void logoutFunction() {

		accountImg.click();
		exitButton.click();
	}

	public boolean isDisplayLogin() {
		return menu_LoginButton.isDisplayed();
	}
}
