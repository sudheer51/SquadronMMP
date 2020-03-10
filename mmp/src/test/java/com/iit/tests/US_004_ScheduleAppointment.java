package com.iit.tests;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class US_004_ScheduleAppointment {

	WebDriver driver;
	@Test
	public void validateScheduleAppointment() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();

		
		WebDriverManager.chromedriver().setup();
		HashMap<String,String> hMap = new HashMap<String,String>();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/sheduleappointments.php");
		driver.findElement(By.xpath(" //input[@type='submit']")).click();
		driver.findElement(By.xpath("//h4[text()='Dr.Beth']//ancestor::ul/following-sibling::button")).click();
		hMap.put("doctor","Beth");
		
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).sendKeys("02/25/2020");
		hMap.put("date","02/25/2020");
		new Select(driver.findElement(By.id("time"))).selectByValue("10Am");
		hMap.put("time", "10Am");
		Thread.sleep(2000);
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("sym")).sendKeys("Fever");
		hMap.put("sym", "Fever");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String trData = driver.findElement((By.xpath("//table[@class='table']/tbody/tr[1]"))).getText();
		String tr[] = trData.split(" ");
		if(hMap.get("date").equals(tr[0]))
		{
			System.out.println("Date matching in HomePage");
		}
		else
		{
			System.out.println("Date not matching in HomePage");
		}
		//Click on ScheduleAppointments Tab
		driver.findElement(By.xpath("//li[4]//a[1]")).click();
		String date = driver.findElement(By.xpath("(//h3[@class='panel-title'])[2]")).getText();
		String time = driver.findElement(By.xpath("//a[contains(text(),'Time : 10Am')]")).getText().split("\\:")[1].trim();
		String doctor = driver.findElement(By.xpath("//a[contains(text(),'Provider:Beth')]")).getText().split("\\:")[1].trim();
		String sym = driver.findElement(By.xpath("//a[contains(text(),'Symptoms:Fever')]")).getText().split("\\:")[1].trim();
		if(hMap.get("date").equals(date))
		{
			System.out.println("Date matching in ScheduleAppointment Page");
		}
		else
		{
			System.out.println("Date not matching in ScheduleAppointment Page");
		}
	}

}
