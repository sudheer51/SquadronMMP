package org.iit.mmp.patient.tests;

import org.iit.mmp.patient.pages.LoginPage;
import org.iit.mmp.patient.pages.ViewHistoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * 
 * @author Sirisha
 *
 */
public class LoginTest {
	WebDriver driver;

	@Test(description = "US_001 Validating the Login Page for ViewHistory")
	public void login() throws Exception {
		SoftAssert sa = new SoftAssert();
		// calling Patient login page and its methods
		LoginPage lp = new LoginPage(driver);
		// Validation for url
		boolean res = lp.patientUrl();
		sa.assertTrue(res);

		// Validate patient login logo
		boolean result1 = lp.validatelogo();
		sa.assertTrue(result1);

		// Validation for login and Patient name
		boolean result = lp.login("ria1", "Ria12345");
		sa.assertTrue(result);
		// lp.login("summer", "Test123@");
		// lp.login("winben", "Test123@");

		/* Validation for Module Tab */
		boolean result2 = lp.navigateToModule("Profile");
		sa.assertTrue(result2);

		// Validation for SubModule Tab List
		boolean result3 = lp.viewHistory();
		sa.assertTrue(result3);

//		ViewHistoryPage vhp = new ViewHistoryPage(driver);
//		  vhp.viewHistory();

		// Validation for Logout
		boolean result4 = lp.logout();
		sa.assertTrue(result4);

		// Validation for browser close
		boolean result5 = lp.windowClose();
		sa.assertTrue(result5);

		sa.assertAll();
	}
}
