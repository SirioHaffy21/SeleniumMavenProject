package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_AlertPractice extends CommonBase {
	private String name = "Monkey D. Luffy";

	@BeforeMethod
	public void initProcess() {
		driver = initChromeDriver(CT_PageURL.AUTOMATION_TEST);
	}

	@Test
	public void hanldeAlertWithOkCancel() {
		click(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]"));
		click(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
		String actual = driver.switchTo().alert().getText();
		assertEquals(actual, "Press a Button !");
		driver.switchTo().alert().accept();
		assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "You pressed Ok");
	}

	@Test
	public void hanldeAlertWithTextBox() {
		click(By.xpath("//a[contains(text(),'Alert with Textbox')]"));
		click(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box ')]"));
		String actual = driver.switchTo().alert().getText();
		assertEquals(actual, "Please enter your name");
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		assertTrue(isElementDisplayed((By.xpath("//p[text()='Hello " + name + " How are you today']"))));
	}

	@AfterMethod
	public void endProcess() {
		driver.quit();
	}
}
