package automation.pageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ALADA_HomePageFactory {
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

	public void logoutFunction() {
		accountImg.click();
		exitButton.click();
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
