package com.obsqura.rmartSuperMarket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
	
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("url");
			
			//get all frames on the page
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			System.out.println("Number of frames: " +frames.size());
			
			//loop through all frames
			boolean textboxFound = false;
			for(int i=0;i<frames.size();i++)
			{
				//switch to the current frame
				driver.switchTo().frame(i);
				System.out.println("Switched to frame:" +i);
				
				try {
					//check if the checkbox is present in the current frame
					WebElement textbox = driver.findElement(By.id("textBoxId"));
					
					//if the textbox is found, enter text
					textbox.sendKeys("Hello World");
					System.out.println("Text entered in the text box");
					textboxFound = true;
					--__
					//break the loop once the text is found
					break;
				}catch(Exception e)
				{
					//if no textbox found catch the exception and and continue
					System.out.println("Text box not found in the frame "+i);					
				}
				
				//Swith back to the main page before moving to the next frame
				driver.switchTo().defaultContent();				
			}
			if(!textboxFound)
			{
				System.out.println("Textbox was not found in any of the frame");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}

}
