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
}
