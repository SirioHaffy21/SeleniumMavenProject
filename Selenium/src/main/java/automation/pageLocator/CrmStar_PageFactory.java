package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import automation.common.CommonBase;

public class CrmStar_PageFactory extends CommonBase {
	WebDriver driver;
	WebDriverWait wait;

	By email = By.xpath("//input[@placeholder='Email']");
	By pass = By.xpath("//input[@placeholder='Mật khẩu']");
	By buttonLogin = By.xpath("//button[text()='Đăng nhập']");
	By khuLamViec = By.xpath("//li//a[contains(normalize-space(), 'khu làm việc')]");
	By addNew = By.xpath("//button[contains(normalize-space(), 'Thêm mới')]");
	By workAreasCode = By.name("work_areas_code");
	By workAreasName = By.name("name");
	By saveButton = By.xpath("//button[contains(normalize-space(), 'Lưu')]");
	By modal = By.id("MyModal");
	By addBtn = By.xpath("//button[text()='Thêm']");
	By searchInput = By.xpath("//input[@placeholder='Nhập từ khóa cần tìm kiếm']");
	By btnSearch = By.xpath("//button[contains(normalize-space(), 'Tìm kiếm')]");
	By successToast = By.xpath("//div[@toast-message='Thêm mới khu vực làm việc thành công']");
	By listResult = By.xpath("//tr//td[@class='name-work-area']");
	By timeElementAdd = By.xpath("(//tr//td[@class='time_create'])[last()]");
	By deleteBtn = By
			.xpath("(//tr//td[@class='time_create'])[last()]/following-sibling::td//a[contains(text(),'Xóa')]");

	public CrmStar_PageFactory(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void loginFunction(String email, String pass) {
		type(this.email, email);
		type(this.pass, pass);
		click(buttonLogin);
	}

	public void addNewWorkArea(String code, String name) {
		click(khuLamViec);
		click(addNew);
		type(workAreasCode, code);
		type(workAreasName, name);
		click(saveButton);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
		click(addBtn);
	}

	public void deleteWorkAreas(String code) {
		if (isFindElementAdd(code)) {
			click(deleteBtn);
			driver.switchTo().alert().accept();
		}
	}

	public boolean isFindElementAdd(String code) {
		// td[text()='newHanoi1']/following-sibling::td[text()='Hanoi1']/following-sibling::td/a[normalize-space()='Xóa']
		By elementAdd = By.xpath("//td[text()='" + code
				+ "']/following-sibling::td[text()='Hanoi1']/following-sibling::td/a[normalize-space()='Xóa']");
		return isElementDisplayed(elementAdd);
	}

	public void searchWorkArea(String name) {
		type(searchInput, name);
		click(btnSearch);
	}

	public boolean isLoginSuccess() {
		return isElementDisplayed(khuLamViec);
	}
}
