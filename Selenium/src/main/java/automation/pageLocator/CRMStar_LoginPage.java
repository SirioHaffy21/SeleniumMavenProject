package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CRMStar_LoginPage{
	private WebDriver driver;
	By emailIndicate = By.xpath("//input[@placeholder='Email']");
	By passIndicate = By.xpath("//input[@placeholder='Mật khẩu']");
	By loginButton = By.xpath("//button[text()='Đăng nhập']");

	public CRMStar_LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginFunction(String email, String pass) {
		WebElement emailInput = driver.findElement(emailIndicate);
		if(emailInput.isDisplayed()) {
			emailInput.clear();
			emailInput.sendKeys(email);
		}

		WebElement passInput = driver.findElement(passIndicate);
		if(passInput.isDisplayed()) {
			passInput.clear();
			passInput.sendKeys(pass);
		}

		WebElement buttonLogin = driver.findElement(loginButton);
		if(buttonLogin.isEnabled()) {
			buttonLogin.click();
		}
	}

	public boolean isDisplay() {
		WebElement loginTitle = driver.findElement(By.xpath("//h4[contains(normalize-space(), 'Đăng nhập')]"));
		return loginTitle.isDisplayed();
	}

	public String notice() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement errorDiv = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fl-message']")));
		return errorDiv.getText();
	}
}
