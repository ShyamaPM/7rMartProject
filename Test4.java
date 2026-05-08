package com.obsqura.rmartSuperMarket.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 {
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("");
		try {
			driver.findElement(By.linkText("")).click();
			
			String parentWindow = driver.getWindowHandle();
			
			Set<String> windows = driver.getWindowHandles();
			
			for(String singleWindow:windows)
			{
				if(!parentWindow.equals(singleWindow))
				{
					driver.switchTo().window(singleWindow);
					System.out.println("Title of the current window:" +driver.getTitle());
					driver.close();
				}		
				driver.switchTo().window(parentWindow);
				System.out.println(driver.getTitle());	
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
