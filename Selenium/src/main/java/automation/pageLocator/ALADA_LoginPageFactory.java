package automation.pageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ALADA_LoginPageFactory {
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Đăng Nhập']")
	@CacheLookup
	private WebElement loginNavigate;

	@FindBy(id = "txtLoginUsername")
	@CacheLookup
	private WebElement emailInput;

	@FindBy(id = "txtLoginPassword")
	@CacheLookup
	private WebElement passInput;

	@FindBy(xpath = "(//button[text()='ĐĂNG NHẬP'])[3]")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Đăng Nhập']")
	private WebElement menu_LoginButton;

	public ALADA_LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginFunction(String email, String pass) {
		if (loginNavigate.isEnabled())
			loginNavigate.click();
		else
			return;

		emailInput.clear();
		emailInput.sendKeys(email);
		passInput.clear();
		passInput.sendKeys(pass);

		if (loginButton.isEnabled())
			loginButton.click();
	}

	public boolean isDisplayLogin() {
		return menu_LoginButton.isDisplayed();
	}
}
