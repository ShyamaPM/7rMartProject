package com.obsqura.rmartSuperMarket.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EPAMLoginTest extends DriverManager{
	private WebDriver driver;
	private static EPAMLoginPage loginPage;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver("chrome");
		driver.get("url");
		loginPage = new EPAMLoginPage(driver);
	}
	
	@Test
	public static void loginTest()
	{
		loginPage.login("admin","secret");
	}

	@AfterClass
	public void tearDown1()
	{
		tearDown();
	}
}


