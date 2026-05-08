package com.obsqura.rmartSuperMarket.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {
	public static void main (String args[])
	{
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("url");
			
		} catch(Exception e)
		{
			WebElement dropDownElement = driver.findElement(By.xpath(""));
			Select select = new Select(dropDownElement);
			
			List<WebElement> allOptions = select.getOptions();
			
			List<String> optionValue = new ArrayList<>();
			for(WebElement option:allOptions)
			{
				optionValue.add(option.getText().trim());
			}
			
			System.out.println("Unique dropdown values");
			Set<String> uniqueValues = new HashSet<>(optionValue);
			for(String value:uniqueValues)
			{
				System.out.println(value);
			}
		}
	}
	
	public class Test1 {
	    public static void main(String[] args) {
	        // Set path to chromedriver if required
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.get("https://example.com"); // replace with your actual URL

	            // Locate the dropdown element
	            WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='yourDropdownId']"));

	            // Create Select object
	            Select select = new Select(dropDownElement);

	            // Get all options
	            List<WebElement> allOptions = select.getOptions();

	            // Use a Set to store unique values
	            Set<String> uniqueValues = new HashSet<>();

	            for (WebElement option : allOptions) {
	                uniqueValues.add(option.getText().trim()); // get visible text
	            }

	            System.out.println("Unique dropdown values:");
	            for (String value : uniqueValues) {
	                System.out.println(value);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}


}
