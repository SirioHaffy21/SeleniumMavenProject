package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_HandleDropdownList extends CommonBase {
	@Test
	public void handleDropdownList() {
		driver = initChromeDriver(CT_PageURL.CODESTAR_URL);
		WebElement dropCatg = driver.findElement(By.id("product_categories_filter"));
		Select catgSelect = new Select(dropCatg);
		// 0. check số lượng options
		int size = catgSelect.getOptions().size();
		System.out.println(size);
		assertEquals(size, 5);
		// 1. Chọn aws bằng hàm selectVisibleText()
		catgSelect.selectByVisibleText("AWS");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String actualText1 = catgSelect.getFirstSelectedOption().getText();
		assertEquals(actualText1, "AWS");
		// 2. Chọn Lập trình web bằng hàm selectByValue
		catgSelect.selectByValue("https://codestar.vn/product-category/lap-trinh-web/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String actualText2 = catgSelect.getFirstSelectedOption().getText();
		assertEquals(actualText2, "Lập trình web");
		// 3. chọn programing course băng hàm index
		catgSelect.selectByIndex(4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String actualText3 = catgSelect.getFirstSelectedOption().getText();
		assertEquals(actualText3, "Programming courses");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.close();
	}

}
