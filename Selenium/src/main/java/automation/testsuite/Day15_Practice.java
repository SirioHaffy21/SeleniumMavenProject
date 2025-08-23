package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;

public class Day15_Practice extends CommonBase {
	private WebDriverWait wait;

	TEDU_PageFactory tedu;
	private String pass = "spiderman_12345";
	private String newPass = "spiderman_1234";
	private String searchText = "ASP Net";

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.TEDU_URL);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		tedu = new TEDU_PageFactory(driver);
	}

	@Test
	public void loginSuccessfully() throws InterruptedException {

		tedu.login("spiderman123@gmail.com", pass);
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
	}

	@Test
	public void updatePassSuccess() throws InterruptedException {
		loginSuccessfully();
		tedu.updatePassword(pass, newPass);
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());
	}

	@Test
	public void search() throws InterruptedException {
		loginSuccessfully();
		tedu.search(searchText.toUpperCase());
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		@SuppressWarnings("unchecked")
		List<WebElement> results = (List<WebElement>) js.executeScript(
				"var xpath = \"//h3//a[contains(@title,'"+searchText.toUpperCase()+"')]\";" +
	            "var iterator = document.evaluate(xpath, document, null, XPathResult.ORDERED_NODE_ITERATOR_TYPE, null);" +
	            "var nodes = [];" +
	            "var thisNode = iterator.iterateNext();" +
	            "while (thisNode) {" +
	            "  nodes.push(thisNode);" +
	            "  thisNode = iterator.iterateNext();" +
	            "}" +
	            "return nodes;"
	        );

		assertTrue(results.size() > 0);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
