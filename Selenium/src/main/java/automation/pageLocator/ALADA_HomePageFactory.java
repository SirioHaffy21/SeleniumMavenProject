package automation.pageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import automation.common.CommonBase;

public class ALADA_HomePageFactory extends CommonBase {
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='avatar2']")
	@CacheLookup
	private WebElement accountImg;

	@FindBy(xpath = "//a[text()='Thoát']")
	@CacheLookup
	private WebElement exitButton;

	@FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
	@CacheLookup
	private WebElement updateInfoButton;

	@FindBy(xpath = "//a[text() = 'Khóa học của tôi']")
	@CacheLookup
	private WebElement linkMyCourse;

	public ALADA_HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logoutFunction() throws InterruptedException {
		Thread.sleep(2000);
		clickByJS(By.xpath("//div[@class='avatar2']"));
		clickByJS(By.xpath("//a[text()='Thoát']"));
	}

	public boolean checkHomePage_Register(String email) {
		accountImg.click();
		WebElement emailUser = driver.findElement(By.xpath("//p[text()='" + email + "']"));
		return emailUser.isDisplayed();
	}

	public void updateInfoNavigate() {
		accountImg.click();
		updateInfoButton.click();
	}

	public boolean checkHomePage() {
		return linkMyCourse.isDisplayed();
	}
}
