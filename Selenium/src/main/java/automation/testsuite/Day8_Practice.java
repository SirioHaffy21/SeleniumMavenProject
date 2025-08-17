package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day8_Practice extends CommonBase {
	/**
	 *
	 */
	@Test
	public void getElementById() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
		WebElement emailElement = driver.findElement(By.id("txtLoginUsername"));
		emailElement.sendKeys("abc@email.com");
		System.out.println("Email element: " + emailElement.getText());
	}

	@Test
	public void getElementByName() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
		WebElement passElement = driver.findElement(By.name("txtLoginPassword"));
		passElement.sendKeys("123456");
		System.out.println("Pass element: " + passElement.getText());
	}

	@Test
	public void getElementByLinkText() {
		driver = initChromeDriver(CT_PageURL.SELECTORS_HUB_URL);
		WebElement textFindOut = driver
				.findElement(By.linkText("Find out how to automate these controls without XPath"));
		System.out.println("Find out: " + textFindOut);
	}

	@Test
	public void getElementByPartialLinkText() {
		driver = initChromeDriver(CT_PageURL.SELECTORS_HUB_URL);
		WebElement textCourse = driver.findElement(By.partialLinkText("A course with complex scenarios"));
		System.out.println("Find out: " + textCourse);
	}

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}
