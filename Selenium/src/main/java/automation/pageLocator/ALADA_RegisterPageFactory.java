package automation.pageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ALADA_RegisterPageFactory {
	private WebDriver driver;

	@FindBy(xpath = "//a[text()='Đăng Ký']")
	@CacheLookup
	private WebElement registerNavigate;

	@FindBy(xpath = "//input[@placeholder='Nhập họ và tên']")
	@CacheLookup
	private WebElement nameText;

	@FindBy(xpath = "(//input[@placeholder='Địa chỉ email'])[4]")
	@CacheLookup
	private WebElement emailText;

	@FindBy(xpath = "//input[@placeholder='Nhập lại địa chỉ email']")
	@CacheLookup
	private WebElement emailReText;

	@FindBy(xpath = "(//input[@placeholder='Mật khẩu'])[3]")
	@CacheLookup
	private WebElement passText;

	@FindBy(xpath = "(//input[@placeholder='Nhập lại mật khẩu'])[3]")
	@CacheLookup
	private WebElement passReText;

	@FindBy(xpath = "//input[@placeholder='Chúng tôi cam kết bảo mật tuyệt đối số điện thoại của bạn.']")
	@CacheLookup
	private WebElement phoneText;

	@FindBy(id = "chkRight")
	@CacheLookup
	private WebElement agreeCheck;

	@FindBy(xpath = "(//button[text()='ĐĂNG KÝ'])[3]")
	@CacheLookup
	private WebElement registerButton;

	public ALADA_RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void registerAccount(String name, String email, String pass, String phone) {
		if (registerNavigate.isEnabled())
			registerNavigate.click();
		else
			return;

		nameText.clear();
		nameText.sendKeys(name);

		emailText.clear();
		emailText.sendKeys(email);

		emailReText.clear();
		emailReText.sendKeys(email);

		passText.clear();
		passText.sendKeys(pass);

		passReText.clear();
		passReText.sendKeys(pass);

		phoneText.clear();
		phoneText.sendKeys(phone);

		if (agreeCheck.isSelected() == false) {
			agreeCheck.click();
		}

		if (registerButton.isEnabled())
			registerButton.click();
	}
}
