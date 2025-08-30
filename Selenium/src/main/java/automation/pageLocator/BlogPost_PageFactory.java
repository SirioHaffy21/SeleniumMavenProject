package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import automation.common.CommonBase;

public class BlogPost_PageFactory extends CommonBase {
	private WebDriver driver;
	private WebDriverWait wait;
	By tryItBtn = By.xpath("//button[text()='Try it']");

	public BlogPost_PageFactory(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void testTryIt() {
		click(tryItBtn);
	}
}
