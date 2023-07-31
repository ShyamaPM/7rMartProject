package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import retry.Retry;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	
	@Test(retryAnalyzer = Retry.class,description="Verify whether user is able to login using valid username and password")
	public void verifyTheUserAbleToLoginWithValidCredentials()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isNavigatedToHomePage = loginPage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"Not navigated to homepage");
	}
	
	@Test
	@Parameters("password")
	public void verifyTheUserCannotLoginWithValidUserNameandInvalidPassword(String password)
	{
		String username = ExcelUtility.getString(1, 0,"LoginPage");
		//String password = ExcelUtility.getString(2, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswrodOnPasswrodField(password);
		loginPage.clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User able to navigate to homepage");
	}

	@Test
	public void verifyTheUserCannotLoginWithInvalidUserNameandValidPassword()
	{
		String userName = ExcelUtility.getString(2, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswrodOnPasswrodField(password);
		loginPage.clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User able to navigate to homepage");
	}
	
	@Test
	public void verifyTheUserCannotLoginWithInvalidUserNameandInvalidPassword()
	{
		String userName = "Tester";
		String password = "test";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswrodOnPasswrodField(password);
		loginPage.clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User able to navigate to homepage");
	}
	
}
