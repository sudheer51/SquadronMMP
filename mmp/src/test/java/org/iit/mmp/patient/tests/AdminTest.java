package org.iit.mmp.patient.tests;

//import org.iit.mmp.patient.pages.*;
import org.iit.mmp.patient.pages.AddPrescriptionPage;
import org.iit.mmp.patient.pages.AdminPage;
import org.iit.mmp.patient.pages.ViewHistoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * 
 * @author Sirisha
 *
 */
public class AdminTest {
	WebDriver driver;
	AddPrescriptionPage app = new AddPrescriptionPage(driver);

	@Test(description = "US_002 Validating the Admin Login Page")
	public void adminLogin() throws Exception {

		// calling admin login page and its methods
		AdminPage ap = new AdminPage(driver);
		ap.adminUrl();
		ap.navigatetoDoctorLoginButton();
		ap.adminLogin("Thomas_444", "Edison_444");
		// ap.approvePatient("qwee");
		ap.navigateToPatientsTab("ria");
		ap.addPresciptionDetails("Ria","AlevePM","Take 1 pill at night for cold");
		ap.logout();
		/*
		 * AddPrescriptionPage app = new AddPrescriptionPage(driver); app.adminUrl();
		 * app.navigatetoDoctorLoginButton(); app.adminLogin("Thomas_444","Edison_444");
		 * app.navigateToPatientsTab(); Thread.sleep(4000); app.addPresciptionDetails();
		 */
//		ViewHistoryPage vhp = new ViewHistoryPage(driver);
//		vhp.viewHistory();

	}

}
