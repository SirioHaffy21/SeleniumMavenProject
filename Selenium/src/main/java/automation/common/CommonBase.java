package automation.common;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.*;

public class CommonBase {

	public static WebDriver driver;

	public WebDriver initChromeDriver(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}

	public WebDriver initFireFoxDriver(String url) {
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		// Disable the “Insecure form submission” warning popup
		options.addPreference("security.warn_submit_insecure", false);
		// (Optional) disable insecure field warnings
		options.addPreference("security.insecure_field_warning.contextual.enabled", false);
		driver = new FirefoxDriver(options);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}

	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElementPresentDOM(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
}
