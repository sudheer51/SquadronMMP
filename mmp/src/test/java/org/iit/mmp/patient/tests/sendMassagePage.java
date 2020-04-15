    package org.iit.mmp.patient.tests;
    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
/*patient sending massage to Doctor*/    
	public class sendMassagePage {
		
		
		
	public static WebDriver driver;
	
	@BeforeMethod

	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "./MMP.browsers/chromedriver1.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/index.php");
	}

		@Test
				
				public  void Testsendmassagefunction() throws InterruptedException {
					
					    driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
						driver.findElement(By.id("subject")).sendKeys("To meet doctor Mr.Kevin");
						driver.findElement(By.id("message")).sendKeys("I have cold and cough");
						driver.findElement(By.xpath("//tr[4]//td[1]//input[1]")).click();
						
					
			           Alert alert = driver.switchTo().alert();
			           Thread.sleep(3000);
			          
			          String actual = alert.getText();
			           System.out.println(actual);
			           
			           alert.accept();
			           
			           Assert.assertEquals(actual,"Messages Successfully sent.");
			           
			         //  alert.dismiss();
			          
			           
				}
	@AfterMethod
					 public void posttest()
			            
			            {
				driver.close();
			            }
	}
	
			
