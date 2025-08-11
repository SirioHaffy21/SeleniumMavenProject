package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_HandleCheckBox extends CommonBase {
	@Test
	public void chooseHobbies() {
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		scrollToElement(By.id("userNumber"));

		WebElement sport = driver.findElement(By.xpath("//label[text()='Sports']"));

		if (sport.isSelected() == false) {
			sport.click();
			System.out.println("Checkbox sport has been selected.");
		}

		WebElement reading = driver.findElement(By.xpath("//label[text()='Reading']"));
		if (reading.isSelected() == false) {
			reading.click();
			System.out.println("Checkbox reading has been selected.");
		}

		WebElement music = driver.findElement(By.xpath("//label[text()='Music']"));
		if (music.isSelected() == false) {
			music.click();
			System.out.println("Checkbox sport has been selected.");
		}
	}
}
