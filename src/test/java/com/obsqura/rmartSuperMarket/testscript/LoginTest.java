package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import retry.Retry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	
	@Test(retryAnalyzer = Retry.class,description="Verify whether user is able to login using valid username and password",groups = {"regression"})
	public void verifyTheUserAbleToLoginWithValidCredentials()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isNavigatedToHomePage = loginPage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"After entering valid credentionals in Login page user is not navigated to the home page");
	}
	
	@Test(retryAnalyzer = Retry.class,description="Verify whether user should not be able to login using valid username and invalid password",groups = {"smoke"})
	@Parameters("password")
	public void verifyTheUserCannotLoginWithValidUserNameandInvalidPassword(String password)
	{
		String username = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User should not be able to navigate to Home page after entering invalid credentials");
	}

	@Test(retryAnalyzer = Retry.class,description="Verify whether user shoul not be able to login using invalid username and valid password", groups = {"regression","smoke"})
	public void verifyTheUserCannotLoginWithInvalidUserNameandValidPassword()
	{
		String userName = ExcelUtility.getString(2, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User should not be able to navigate to Home page after entering invalid credentials");
	}
	
	@Test(dataProvider="LoginProvider", retryAnalyzer = Retry.class,description="Verify whether user should not be able to login using invalid credentials")
	public void verifyTheUserCannotLoginWithInvalidUserNameandInvalidPassword(String userName, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User should not be able to navigate to Home page after entering invalid credentials");
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() 
	{
		return new Object[][] { { ExcelUtility.getString(2, 0,"LoginPage"), ExcelUtility.getString(3, 0, "LoginPage") },};
	}
	
}
