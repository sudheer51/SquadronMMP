package com.iit.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExample {
	WebDriver driver;
	
	 
	@Test
	public void validateSearchResults()
	{
		/*
		 * 1. Enter the url https://www.yahoo.com/
		 * 2. Enter the text Selenium in the Textbox
		 * 3. Select "Selenium Interview Questions" from the List
		 * 4. Check the search results page is displayed
		 * 5. Expected Result : Validate the Search results contains "Selenuim Interview Questions".
		 * 6. Expected Result : Validate the Search REsults in first 5 pages contains "Selenium Inteview Questions"
		 * 
		 */
		
		SoftAssert sa = new SoftAssert();
		
		 
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.yahoo.com/");
	 
	    Utility util = new Utility(driver);
	    List<WebElement> list =  util.retrieveSearchList("selenium");
	    int actualSize = list.size();
	    int expectedSize = 10;
	    sa.assertEquals(actualSize,expectedSize);
	    
	    boolean result = util.
	    		selectRequiredSearchPattern("selenium interview questions","selenium");
	    sa.assertTrue(result);
	    /*
	     * Search PAttern : Questions
	     * Number of PAges: 5
	     * title: selenium interview questions
	     * 
	     */
	    result = util.validateLinkText("Questions",5,"selenium interview questions");
	    sa.assertTrue(result);
	    sa.assertAll();
	    
	    
	    
	}
	 

}

/*
 * 

long endTime = Calendar.getInstance().getTimeInMillis();
long totaltime = endTime-startTime;
System.out.println("Time Taken::" + totaltime );
long startTime = Calendar.getInstance().getTimeInMillis();

https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
static ExpectedCondition<java.util.List<WebElement>>	visibilityOfAllElementsLocatedBy(By locator)
An expectation for checking that all elements present on the web page that match the locator are visible.
*/