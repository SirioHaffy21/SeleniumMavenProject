package automation.pageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import automation.common.CommonBase;

public class ALADA_LoginPageFactory extends CommonBase {
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
		if (isElementDisplayed(By.xpath("//a[text()='Đăng Nhập']")))
			clickByJS(By.xpath("//a[text()='Đăng Nhập']"));
		else
			return;

		//emailInput.clear();
		type(By.id("txtLoginUsername"), email);
		//passInput.clear();
		type(By.id("txtLoginPassword"), pass);

		if (isElementDisplayed(By.xpath("(//button[text()='ĐĂNG NHẬP'])[3]")))
			clickByJS(By.xpath("(//button[text()='ĐĂNG NHẬP'])[3]"));
	}

	public boolean isDisplayLogin() {
		return isElementDisplayed(By.xpath("//a[text()='Đăng Nhập']"));
	}
}
