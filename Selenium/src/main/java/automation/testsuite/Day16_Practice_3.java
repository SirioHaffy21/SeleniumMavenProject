package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_Practice_3 extends CommonBase {
	private String name = "Monkey D. Luffy";

	@BeforeMethod
	public void initProcess() {
		driver = initChromeDriver(CT_PageURL.GURU_URL);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Test
	public void deleteCustomer() {
		type(By.name("cusid"), name);
		click(By.name("submit"));
		String actual1 = driver.switchTo().alert().getText();
		assertEquals(actual1, "Do you really want to delete this Customer?");
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.alertIsPresent());
		String actual2 = driver.switchTo().alert().getText();
		assertEquals(actual2, "Customer Successfully Delete!");
		driver.switchTo().alert().accept();
	}

	@AfterMethod
	public void endProcess() {
		driver.quit();
	}
}
