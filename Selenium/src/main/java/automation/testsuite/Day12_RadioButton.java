package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_RadioButton extends CommonBase {

	@Test
	public void chooseMale() {
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		WebElement radioMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));

		// 1. Kiem tra gia tri mac dinh
		assertEquals(radioMale.isSelected(), false);
		// 2. Click vao male
		System.out.println("radio male was clicked, result is " + radioMale.isSelected());
		if (radioMale.isEnabled() == true) {
			radioMale.click();
			System.out.println("radio male was clicked, result is " + radioMale.isSelected());
		}
	}

	@Test
	public void chooseFemale() {
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		WebElement radioFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));

		// 1. Kiem tra gia tri mac dinh
		assertEquals(radioFemale.isSelected(), false);
		// 2. Click vao male
		System.out.println("radio female was clicked, result is " + radioFemale.isSelected());
		if (radioFemale.isEnabled() == true) {
			radioFemale.click();
			System.out.println("radio female was clicked, result is " + radioFemale.isSelected());
		}
	}

	@Test
	public void chooseOther() {
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		WebElement radioOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

		// 1. Kiem tra gia tri mac dinh
		assertEquals(radioOther.isSelected(), false);
		// 2. Click vao male
		System.out.println("radio other was clicked, result is " + radioOther.isSelected());
		if (radioOther.isEnabled() == true) {
			radioOther.click();
			System.out.println("radio other was clicked, result is " + radioOther.isSelected());
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.quit();
	}
}
