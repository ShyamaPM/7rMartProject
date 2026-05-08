package com.obsqura.rmartSuperMarket.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3MultipleWindow {

    public static void main(String[] args) {
        // Set path to your ChromeDriver if needed
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Click a link that opens a new window
        driver.findElement(By.linkText("Open new window")).click();

        // Store the current window handle
        String parentWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Loop through handles and switch to the new one
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to new window: " + driver.getTitle());

                // Perform actions in new window
                driver.findElement(By.id("someElement")).click();

                // Close the new window
                driver.close();
            }
        }

        // Switch back to parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Back to parent window: " + driver.getTitle());

        // Close parent window
        driver.quit();
    }
}

