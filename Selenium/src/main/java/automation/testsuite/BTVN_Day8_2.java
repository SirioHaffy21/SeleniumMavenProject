package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVN_Day8_2 extends CommonBase {
	@Test
	public void findFirstElement_Name() {
		driver = initChromeDriver(CT_PageURL.AUTOMATIC_FC_URL);
		WebElement firstNameElement = driver.findElement(By.id("name"));
		firstNameElement.sendKeys("Captain America");
	}

	@Test
	public void findSecondElement_Address() {
		driver = initChromeDriver(CT_PageURL.AUTOMATIC_FC_URL);
		WebElement secondAddressElement = driver.findElement(By.name("address"));
		secondAddressElement.sendKeys("USA");
	}

	@Test
	public void findThirdElement_Email() {
		driver = initChromeDriver(CT_PageURL.AUTOMATIC_FC_URL);
		WebElement thirdEmailElement = driver.findElement(By.cssSelector("input#email"));
		thirdEmailElement.sendKeys("captain@avenger.us");
	}

	@Test
	public void findFouthElement_Pass() {
		driver = initChromeDriver(CT_PageURL.AUTOMATIC_FC_URL);
		WebElement fouthPassElement = driver.findElement(By.xpath("//*[@id='password']"));
		fouthPassElement.sendKeys("1947_peggy_carter");
	}
}
