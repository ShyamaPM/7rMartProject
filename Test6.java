package com.obsqura.rmartSuperMarket.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 {
	
	public static void main (String args[]) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.navigate().to("url");
		System.out.println("Navigated to URL");
		
		WebElement btnClick = driver.findElement(By.id(""));
		btnClick.click();
		System.out.println("Button clicked");
		
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		
		boolean childWindowWithText = false;
		
		for(String window: childWindow)
		{
			driver.switchTo().window(window);
			if(!parentWindow.equals(window))
			{
				//System.out.println("Selected window:" +window.getTitle());
				WebElement elementText = driver.findElement(By.id(""));
				if(elementText.isDisplayed())
				{
					String text = elementText.getText();
					System.out.println(text);
					childWindowWithText = true;
					break;
				}
			}
		}
		driver.switchTo().window(parentWindow);
	}
}
