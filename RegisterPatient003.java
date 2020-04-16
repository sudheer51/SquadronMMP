/**
 * This code is meant to fulfill the needs of registering a patient on the North American Medical Tech group MMP portal.
 * 
 * The steps are as follows:
 * 
 * 1. Open a Chrome Browser
 * 2. Navigate to the website address and verify the correct page is loaded
 * 3. Click on the "Patient Login" tab
 * 4. Click on the "Register" button
 * 5. Fill in the information on the registration window
 * 6. Click on "Submit" to create the account.
 * 7. Navigate to the alert screen that verifies the successful account creation message and click on "OK".
 * 
 * Post script steps will be to log into the admin portal to verify the account was successfully created and to activate the account.
 * @author hidayah
 *
 */
package com.iit.selenium.mavenprojects.registerPatient;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatient003 {
	
	public static void main(String[] args) throws InterruptedException {
		//Initial setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//saving the url in a variable for ease of use
		String mmpUrl = "http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/";
		//setting property and opening Web Browser		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hidayah\\eclipse-workspace\\registerPatient\\src\\test\\java\\com\\iit\\selenium\\mavenprojects\\registerPatient\\chromedriver.exe");
		driver.get(mmpUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//This section is to confirm the page successfully loaded
		String verifyPage = driver.getCurrentUrl();
		try {
			Assert.assertEquals(verifyPage, mmpUrl);
			System.out.println("The page was successfully opened");
		} catch (AssertionError e) {
			e.printStackTrace();
			System.out.println("The page was not successfully opened");
		}
		
		//Click on Patient Login
		WebElement patientLogin = driver.findElement(By.xpath("//a[contains(text(),'Patient Login')]"));
		patientLogin.click();
		
		Thread.sleep(3000);
		//Click on Register Button
		WebElement registerButton = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
		registerButton.click();
		
		
//	public HashMap<String, String> registerPatient(String userName,String pword); throws InterruptedException
				
		
				//Initiate the Hashmap to store all the information entered into the form
				HashMap<String,String> hMap = new HashMap<String,String>();
		
				//Fill out the required information of the registration form    
				WebElement firstName = driver.findElement(By.id("firstname"));
				firstName.sendKeys("Covid");
				hMap.put("firstname", firstName.getAttribute(("value")));
				
				WebElement lastname = driver.findElement(By.id("lastname"));
				lastname.sendKeys("Virus");
				hMap.put("lastname", lastname.getAttribute(("value")));
				
				WebElement license = driver.findElement(By.id("license")); 
	 			license.sendKeys("12124567");
				hMap.put("license", license.getAttribute(("value")));
								
				Thread.sleep(3000);
				
				WebElement ssn = driver.findElement(By.id("ssn")); 
				ssn.sendKeys("333256999");
				hMap.put("ssn", ssn.getAttribute(("value")));
				ssn.click();
				
				WebElement state = driver.findElement(By.id("state")); 
				state.sendKeys("Virginia");
				hMap.put("state", state.getAttribute(("value")));
			 
				WebElement city = driver.findElement(By.id("city")); 
				city.sendKeys("Annandale");
				hMap.put("city", city.getAttribute(("value")));
				
				WebElement address = driver.findElement(By.id("address")); 
				address.sendKeys("4523 Little River Street");
				hMap.put("address", address.getAttribute(("value"))); 
				
				WebElement zipcode = driver.findElement(By.id("zipcode"));
				zipcode.sendKeys("12345");
				hMap.put("zipcode", zipcode.getAttribute(("value")));
								 
				WebElement age = driver.findElement(By.id("age"));
				age.sendKeys("50");
				hMap.put("age", age.getAttribute(("value")));
				
				WebElement height = driver.findElement(By.id("height"));
				height.sendKeys("54");
				hMap.put("height", height.getAttribute(("value")));
				
				WebElement weight = driver.findElement(By.id("weight"));
				weight.sendKeys("120");
				hMap.put("weight", weight.getAttribute(("value")));
				
				WebElement pharmacy = driver.findElement(By.id("pharmacy"));
				pharmacy.sendKeys("Covid Center");
				hMap.put("pharmacy", pharmacy.getAttribute(("value")));
				
				WebElement pharmacyAddress = driver.findElement(By.id("pharma_adress"));
				pharmacyAddress.sendKeys("1 Covid Lane Annandale");
				hMap.put("pharmacyAddress", pharmacyAddress.getAttribute(("value")));
			
				WebElement email = driver.findElement(By.id("email"));
				email.sendKeys("covidvirus@gmail.com");
				hMap.put("email", email.getAttribute(("value")));
				
				WebElement pword = driver.findElement(By.id("password"));
				pword.sendKeys("pa$$W0rd");
				hMap.put("pword", pword.getAttribute(("value")));
				
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("covid19");
				hMap.put("username", username.getAttribute(("value")));
								 
				WebElement confirmpassword = driver.findElement(By.id("confirmpassword"));
				confirmpassword.sendKeys("pa$$W0rd");
				hMap.put("confirmpassword", confirmpassword.getAttribute(("value")));
				 
				new Select(driver.findElement(By.id("security"))).selectByVisibleText("what is your pet name");			
				 
				WebElement answer = driver.findElement(By.id("answer"));
				answer.sendKeys("jackie");
				hMap.put("answer", answer.getAttribute(("value")));
				  
				//Finding and clicking on the "Save" button on the registration page after filling
				driver.findElement(By.name("register")).click();
				
				//Pop up alert about successful registration with an "OK" button to click
				Alert registrationConfirmation = driver.switchTo().alert();
				Thread.sleep(5000); //just so the alert is visible
				String successful = registrationConfirmation.getText();
				registrationConfirmation.accept();
				
			    hMap.put("message", successful);
			    
			//	return hMap; I had trouble combining the return code with the void return in the main method.
			
		}	
	
	}
	
	
	
	
	

