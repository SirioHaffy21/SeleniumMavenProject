package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;
import automation.utils.Utils;

public class Day16_Practice_1 extends CommonBase {
	private String code;
	private String name = "Hanoi1";
	private String email = "admin@gmail.com";
	private String pass = "12345678";
	CrmStar_PageFactory crmStar;

	@BeforeMethod
	public void initProcess() {
		driver = initFireFoxDriver(CT_PageURL.STARCRM_URL);
		crmStar = new CrmStar_PageFactory(driver);
		code = Utils.generateRandomCode(3);
	}

	// Test login success
	@Test(priority = 1)
	public void loginSucess() throws InterruptedException {
		crmStar.loginFunction(email, pass);
		Thread.sleep(5000);
		assertTrue(crmStar.isLoginSuccess());
	}

	// Test add work areas
	@Test(priority = 2)
	public void addWorkAreas() throws InterruptedException {
		loginSucess();
		crmStar.addNewWorkArea(code, name);
		Thread.sleep(6000);
		crmStar.searchWorkArea(name);
		Thread.sleep(3000);
		assertTrue(crmStar.isFindElementAdd(code));
	}

	// Test delete work areas
	@Test(priority = 3)
	public void deleteWorkAreas() throws InterruptedException {
		loginSucess();
		crmStar.addNewWorkArea(code, name);
		Thread.sleep(6000);
		crmStar.searchWorkArea(name);
		Thread.sleep(3000);
		assertTrue(crmStar.isFindElementAdd(code));
		Thread.sleep(5000);
		crmStar.deleteWorkAreas(code);
		Thread.sleep(3000);
		assertTrue(crmStar.isFindElementAdd(code) == false);
	}

	@AfterMethod
	public void endProcess() {
		driver.quit();
	}
}
