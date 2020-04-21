package org.iit.mmp.patient.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddPrescriptionPage extends BasePage {
	WebDriver driver;

	public AddPrescriptionPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addPresciptionDetails() throws InterruptedException {

		driver.findElement(By.xpath("//table//tr//td/a[contains(text(),'Winter')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a//input[@value='Add Precription']")).click();
		Thread.sleep(5000);
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='app_date']")));
		sel.selectByIndex(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='p_name']")).sendKeys("Aleve");
		driver.findElement(By.xpath("//textarea[@name='p_desc']"))
				.sendKeys("Take 1 pill for every 6 hours ---Chest pain");
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		Alert alt = driver.switchTo().alert();
		Thread.sleep(4000);
		System.out.println(alt.getText());
		alt.accept();

	}
}
