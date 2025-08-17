package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVN_Day8_1 extends CommonBase{
	@Test
	public void findUserEmail() {
		driver = initChromeDriver(CT_PageURL.SELECTORS_HUB_URL);
		WebElement userEmailElement = driver.findElement(By.name("email"));
		userEmailElement.sendKeys("admin@codestar.com.vn");
		System.out.println("Email: " + userEmailElement.getText());
	}

	@Test
	public void findPassword() {
		driver = initChromeDriver(CT_PageURL.SELECTORS_HUB_URL);
		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys("password");
		System.out.println("Pass: " + passElement.getText());
	}

	@Test
	public void findCompany() {
		driver = initChromeDriver(CT_PageURL.SELECTORS_HUB_URL);
		WebElement companyElement = driver.findElement(By.name("company"));
		companyElement.sendKeys("Codestar");
		System.out.println("Company: " + companyElement.getText());
	}

	@Test
	public void findMobileNumber() {
		driver = initChromeDriver(CT_PageURL.SELECTORS_HUB_URL);
		WebElement mobileElement = driver.findElement(By.name("mobile number"));
		mobileElement.sendKeys("0333666999");
		System.out.println("Phone Number: " + mobileElement.getText());
	}

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}
