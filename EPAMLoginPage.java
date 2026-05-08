package com.obsqura.rmartSuperMarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EPAMLoginPage {
	private WebDriver driver;
	
	public EPAMLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By userName = By.id("user");
	private By passFiled = By.id("pass");
	private By loginBtn = By.id("login");

	public void login(String username, String password)
	{
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passFiled).sendKeys(password);
		driver.findElement(loginBtn).click();
	}
}

