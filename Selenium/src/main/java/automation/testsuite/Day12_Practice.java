package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Practice extends CommonBase {
	@Test
	public void dropdownListSelectCountry() {
		driver = initChromeDriver(CT_PageURL.GLOBALQA_URL);
		WebElement dropCountry = driver.findElement(By.xpath("//div[@rel-title='Select Country']/descendant::select"));
		Select selCountry = new Select(dropCountry);
		// check length
		int size = selCountry.getOptions().size();
		assertEquals(size, 249);
		// get a vakue in dropDownList
		selCountry.selectByVisibleText("Viet Nam");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String country1 = selCountry.getFirstSelectedOption().getText();
		assertEquals(country1, "Viet Nam");
		// get a vakue in dropDownList
		selCountry.selectByValue("USA");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String country2 = selCountry.getFirstSelectedOption().getText();
		assertEquals(country2, "United States");
	}

	@Test
	public void chooseUnder18() {
		driver = initChromeDriver(CT_PageURL.AUTOMATION_FC_URL);
		WebElement under18 = driver.findElement(By.xpath("//label[@for='under_18']"));

		assertEquals(under18.isSelected(), false);

		if(under18.isEnabled() == true) {
			under18.click();
			System.out.println("Under 18 options was choosen.");
		}
	}

	@Test
	public void chooseOver18() {

		driver = initChromeDriver(CT_PageURL.AUTOMATION_FC_URL);
		WebElement over18 = driver.findElement(By.xpath("//label[@for='over_18']"));

		assertEquals(over18.isSelected(), false);

		if(over18.isEnabled() == true) {
			over18.click();
			System.out.println("Over 18 options was choosen.");
		}
	}

	@Test
	public void chooseDisableRadio() {
		driver = initChromeDriver(CT_PageURL.AUTOMATION_FC_URL);
		WebElement radioDisable = driver.findElement(By.xpath("//label[@for='radio-disabled']"));

		assertEquals(radioDisable.isSelected(), false);

		if(radioDisable.isEnabled() == true) {
			radioDisable.click();
			System.out.println("Radio disable options was choosen.");
		}
	}

	@AfterMethod
	public void endProcess() {
		driver.close();
	}
}
