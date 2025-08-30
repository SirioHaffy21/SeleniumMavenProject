package automation.common;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;

public class CommonBase {

	public static WebDriver driver;
	public int initWaitTime = 30;
	public static WebDriverWait wait;

	public WebDriver initChromeDriver(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-features=PasswordLeakDetection");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(initWaitTime));
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(initWaitTime));
		return driver;
	}

	public void inputTextJavaScriptInnerHTML(By inputElement, String companyName) {
		WebElement element = driver.findElement(inputElement);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + companyName + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptInnerHTML(inputElement, companyName);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return;
		} catch (TimeoutException e) {
			// TODO: handle exception
			return;
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}

	/**
	 * input text by javascript value
	 * 
	 * @param locator
	 * @param value
	 */
	public void inputTextJavaScriptValue(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptValue(locator, value);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return;
		} catch (TimeoutException e) {
			// TODO: handle exception
			return;
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}

	/**
	 * scroll to element
	 * 
	 * @param locator
	 */
	public void scrollToElement(By locator) {

		try {
			WebElement element = getElementPresentDOM(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return;
		} catch (TimeoutException e) {
			// TODO: handle exception
			return;
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
	}

	/**
	 * check element is displayed
	 * 
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(By locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
			return getElementPresentDOM(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return false;
		} catch (TimeoutException e) {
			// TODO: handle exception
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * check element is enabled
	 * 
	 * @param locator
	 * @return
	 */
	public boolean isElementEnabled(By locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
			return getElementPresentDOM(locator).isEnabled();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return false;
		} catch (TimeoutException e) {
			// TODO: handle exception
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * click to element
	 * 
	 * @param locator
	 */
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	/**
	 * type to element
	 * 
	 * @param locator
	 * @param value
	 */
	public void type(By locator, String value) {

		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}

	/**
	 * upload file
	 * 
	 * @param locator
	 * @param filePath
	 */
	public void uploadFile(By locator, String filePath) {

		WebElement uploadInput = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploadInput);

		uploadInput.sendKeys(filePath);

	}
	
	public String getText(By locator) {
		WebElement element = getElementPresentDOM(locator);
		return element.getText();
	}

	public WebElement getElementPresentDOM(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	/**
	 * pause driver in timeInMillis
	 * 
	 * @param timeInMillis
	 */
	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get absolute path of file
	 * 
	 * @param relativeFilePath
	 * @return
	 */
	public String getAbsoluteFilePath(String relativeFilePath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativeFilePath;
		return absolutePath;
	}

	public void quitDriver(WebDriver dr) {
		if (dr.toString().contains("null")) {
			System.out.print("All Browser windows are closed ");
		} else {
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(initWaitTime));
			dr.manage().deleteAllCookies();
			dr.close();
		}
	}
}
