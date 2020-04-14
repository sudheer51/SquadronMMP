package org.iit.mmp.patient.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewHistoryPage {
	WebDriver driver;
	public ViewHistoryPage(WebDriver driver) {
		this.driver = driver;
	}
	public void viewHistory() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		System.out.println("Inside the Login Page");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'View History')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p//a//input[@value='Past Prescription']")).click();
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//table//ul//li"));
		int size = list.size();
		System.out.println("The List size is " +size );
		for (int i = 0; i < size; i++) {
			// list.get(i).click();
			System.out.println("The Value of " + i + " is :" + list.get(i).getText());

		}
	}
}
