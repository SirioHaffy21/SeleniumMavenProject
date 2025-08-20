package automation.pageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_PageFactory {
	private WebDriver driver;

	@FindBy(id = "UserName")
	WebElement textEmail;
	@FindBy(id = "Password")
	WebElement textPass;
	@FindBy(xpath = "//button[text()='Đăng nhập']")
	WebElement buttonLogin;
	@FindBy(id = "my_account")
	WebElement buttonMyAccount;
	@FindBy(xpath = "//a[@title='Đổi mật khẩu']")
	WebElement buttonChangePass;
	@FindBy(id = "OldPassword")
	WebElement textOldPass;
	@FindBy(id = "NewPassword")
	WebElement textNewPass;
	@FindBy(id = "ConfirmNewPassword")
	WebElement textConfirmPass;
	@FindBy(xpath = "//input[@value='Cập nhật']")
	WebElement buttonUpdate;
	@FindBy(id = "onesignal-slidedown-cancel-button")
	WebElement laterButton;

	/**
	 * @param driver
	 */
	public TEDU_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String email, String pass) {
		textEmail.clear();
		textEmail.sendKeys(email);
		textPass.clear();
		textPass.sendKeys(pass);

		if (buttonLogin.isEnabled())
			buttonLogin.click();
	}

	public void updatePassword(String oldPass, String newPass) {
		// laterButton.click();
		// buttonMyAccount.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('my_account').click();");
		js.executeScript("arguments[0].click();", buttonChangePass);
		// buttonChangePass.click();
		textOldPass.sendKeys(oldPass);
		textNewPass.sendKeys(newPass);
		textConfirmPass.sendKeys(newPass);
		buttonUpdate.click();
	}
}
