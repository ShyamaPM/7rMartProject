package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import com.obsqura.rmartSuperMarket.pages.VerifyUsersPage;
import retry.Retry;
import utilities.ExcelUtility;

public class VerifyUsersTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether search user exists in the Verify User list")
	public void verifyTheUserExistsInTheVerifyUsersList()
	{
		String name = ExcelUtility.getString(0, 0,"VerifyUserPage");
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnVerifyUsers();
		
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox().enterNameinSearchField(name).clickOnSearchButton();
		String actualResult = verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList();
		assertEquals(name, actualResult,"The entered name is not exists in the actual result");	
	}
	
	@Test
	public void checkingSearchFunctioanlity() throws InterruptedException
	{
		String name = ExcelUtility.getString(0, 0,"VerifyUserPage");
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnVerifyUsers();
		
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox();
		verifyUsersPage.enterNameinSearchField(name);
		verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList(name, false);
		verifyUsersPage.clickOnSearchButton();
	}

}
