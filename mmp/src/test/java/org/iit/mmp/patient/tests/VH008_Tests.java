package org.iit.mmp.patient.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Sirisha
 *
 */
public class VH008_Tests {
	WebDriver driver;

	@Test
	public void validateViewHistoryTab() {
		launchBrowser();

		SoftAssert sa = new SoftAssert();
		boolean result = login("ria1", "Ria12345");
		sa.assertTrue(result);

		boolean result1 = navigateToAModule("Profile");
		sa.assertTrue(result1);

		boolean result2 = navigateToAModule1("View History");
		sa.assertTrue(result2);

		verifyPastTransaction("Past Transaction");

		boolean result3 = verifyPastAppointments("Past Appointments");
		sa.assertTrue(result3);

		boolean result4 = navigateToUrl(
				"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/viewhistory.php");
		sa.assertTrue(result4);

		boolean result5 = verifyPastDiagnosis("Past Diagnosis");
		sa.assertTrue(result5);

		boolean result6 = navigateToUrl(
				"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/viewhistory.php");
		sa.assertTrue(result6);

		boolean result7 = verifyPastPrescription("Past Prescription");
		sa.assertTrue(result7);

		sa.assertAll();

	}

	public void launchBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		String title = driver.getTitle();
		System.out.println("Title :" + title);

	}

	public boolean login(String username, String password) {
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		boolean result = driver.findElement(By.xpath("//h3[@class='page-header']")).getText().contains("ria1");
		return result;

	}

	public boolean navigateToAModule(String moduleName) {
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println(
				"String length " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText()
				.contains("Personal Details");
		return result;

	}

	public boolean navigateToAModule1(String moduleName) {
		driver.findElement(By.xpath("//button[contains(text(),'View History')]")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println(
				"String length " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("View History");
		return result;

	}

	public void verifyPastTransaction(String pasttransaction) {
		driver.findElement(By.xpath("//input[@value='Past Transaction']")).click();

	}

	public boolean verifyPastAppointments(String appointments) {
		driver.findElement(By.xpath("//input[@value='Past Appointments']")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println(
				"String length " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText()
				.contains("Patient Portal");
		return result;

	}

	public boolean navigateToUrl(String url) {
		driver.navigate().to("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/viewhistory.php");
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println(
				"String length " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("View History");
		return result;

	}

	public boolean verifyPastDiagnosis(String diagnosis) {
		driver.findElement(By.xpath("//input[@value='Past Diagnosis']")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println(
				"String length " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText()
				.contains("View Past Diagnosis");
		return result;
	}

	public boolean navigateToUrl1(String url) {
		driver.navigate().to("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/viewhistory.php");
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println(
				"String length " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("View History");
		return result;

	}

	public boolean verifyPastPrescription(String prescription) {
		driver.findElement(By.xpath("//input[@value='Past Prescription']")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println(
				"String length " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText()
				.contains("View Past Prescription");
		return result;

	}

}
