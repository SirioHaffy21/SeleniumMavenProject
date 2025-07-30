package automation.common;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonBase {

	public static WebDriver driver;

	public WebDriver initChromeDriver(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}
}
