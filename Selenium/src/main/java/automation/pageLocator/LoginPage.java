package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	// 1 page là 1 đối tượng cần test cho hệ thống web
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Tìm locator của từng element trên page, rồi thực hiện các steps cho tính năng.
	public void loginFunction(String email, String pass) {
		WebElement textEmail =  driver.findElement(By.id("txtLoginUsername"));
		if(textEmail.isDisplayed()) {
			textEmail.clear();
			textEmail.sendKeys(email);
		}

		WebElement textPassword =  driver.findElement(By.id("txtLoginPassword"));
		if(textPassword.isDisplayed()) {
			textPassword.clear();
			textPassword.sendKeys(pass);
		}

		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='frmLogin']//button"));
		if(buttonLogin.isEnabled()) {
			buttonLogin.click();
		}
	}
}
