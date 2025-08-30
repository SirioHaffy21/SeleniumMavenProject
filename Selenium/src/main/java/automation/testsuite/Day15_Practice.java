package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;

public class Day15_Practice extends CommonBase {
	TEDU_PageFactory tedu;
	private String pass = "spiderman_1234";
	private String newPass = "spiderman_12345";
	private String searchText = "Web API";

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.TEDU_URL);
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
		tedu.search(searchText);
		Thread.sleep(6000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// div[@class='post-title']//h3/a]
		// Thread.sleep(3000);
//		@SuppressWarnings("unchecked")
//		List<WebElement> resultsTitle = (List<WebElement>) js.executeScript(
//				"var xpath = \"//h3//a[contains(@title,'" + searchText.toUpperCase() + "')]\";" +
//	            "var iterator = document.evaluate(xpath, document, null, XPathResult.ORDERED_NODE_ITERATOR_TYPE, null);" +
//	            "var nodes = [];" +
//	            "var thisNode = iterator.iterateNext();" +
//	            "while (thisNode) {" +
//	            "  nodes.push(thisNode);" +
//	            "  thisNode = iterator.iterateNext();" +
//	            "}" +
//	            "return nodes;"
//	        );
//		
//		
//		// //div[@class='post-content']//p[contains(text(), 'Web API')]
//		
//		@SuppressWarnings("unchecked")
//		List<WebElement> resultsContent = (List<WebElement>) js.executeScript(
//				"var xpath = \"//div[@class='post-content']//p\";" +
//	            "var iterator = document.evaluate(xpath, document, null, XPathResult.ORDERED_NODE_ITERATOR_TYPE, null);" +
//	            "var nodes = [];" +
//	            "var thisNode = iterator.iterateNext();" +
//	            "while (thisNode) {" +
//	            "  nodes.push(thisNode);" +
//	            "  thisNode = iterator.iterateNext();" +
//	            "}" +
//	            "return nodes;"
//	        );
		List<WebElement> resultsTitle = driver.findElements(By.xpath("//div[@class='post-title']/h3/a"));
		List<WebElement> resultsContent = driver.findElements(By.xpath("//div[@class='post-content']/p"));

		assertTrue(resultsTitle.size() > 0);

		int i = 0, j = 0;

		for (WebElement content : resultsTitle) {
			String titleText = content.getText().toLowerCase();
			if (!titleText.contains(searchText.toLowerCase()))
				for (WebElement content2 : resultsContent) {
					if (j != i) {
						j++;
					} else {
						String contentText = content2.getText().toLowerCase();
						assertTrue(contentText.contains("Web API".toLowerCase())
								| contentText.contains("WebAPI".toLowerCase()));
						break;
					}
				}
			else {
				assertTrue(titleText.contains("Web API".toLowerCase()));
			}
			i++;
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
