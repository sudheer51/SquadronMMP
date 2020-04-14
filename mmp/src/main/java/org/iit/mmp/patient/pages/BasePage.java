package org.iit.mmp.patient.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	
	public void adminUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		System.out.println("Inside the admin url");
	}

	public void navigatetoDoctorLoginButton() throws InterruptedException {
		WebElement e = driver.findElement(By.xpath("//a[contains(text(),'Office Login')]"));
		e.getText();
		System.out.println(e.getText());
		e.click();

		WebElement myelement = driver.findElement(By.xpath("//div[@id='welcome']//a[text()='Login']"));
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView();", myelement);
		Thread.sleep(5000);
		myelement.click();
		System.out.println("inside office login");
		Thread.sleep(4000);
	}

	/*
	 * Login with Admin credentials
	 */
	public void adminLogin(String adUname, String adPassword) throws InterruptedException {
		WebElement e1 = driver.findElement(By.id("username"));
		e1.sendKeys(adUname);
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys(adPassword);
		Thread.sleep(4000);
		driver.findElement(By.name("admin")).click();
		System.out.println("Entering username and password");

	}

	public void approvePatient(String name) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(), 'Users')] ")).click();

		Select dd = new Select(driver.findElement(By.id("search")));
		dd.selectByVisibleText("Pending");
		Thread.sleep(5000);
		WebElement unameElement = driver
				.findElement(By.xpath("//table//tbody//tr//td//a[contains(text(), '" + name + "')]"));
		unameElement.click();

		Select status2 = new Select(driver.findElement(By.xpath("//select[@id='sapproval']")));
		status2.selectByVisibleText("Accepted");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(4000);
		System.out.println(alert1.getText());
		alert1.accept();

	}

	public void navigateToPatientsTab() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Winter");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='search']")).click();
		Thread.sleep(4000);
		System.out.println("Entering name in searchbox");
	}


}
