package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.ExpenseCategoryPage;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ExpenseCategoryTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether user able to to delete the mentioned title")
	public void verifyWhetherUserAbleToDeleteTheTitlefromExpenseCategory()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageExpense().clickOnExpenseCategorySubMenu();
		
		ExpenseCategoryPage expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.deletTheTitle();
		boolean isAlertMessageDisplayed = expenseCategoryPage.deleteAlertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed, "Unable to delete the title from the Expense Category Page");
	}
	
	@Test(retryAnalyzer = Retry.class,description="Verify whether user is able to edit the Title from Expense Category Page")
	public void verifyUserAbleToEditTheTileFromExpenseCategory()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageExpense().clickOnExpenseCategorySubMenu();
		ExpenseCategoryPage expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.editTheTitle();
		boolean isAlertMessageDisplayedForEdit = expenseCategoryPage.editAlertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayedForEdit, "Unable to edit the title in the from the Expense Category Page");
	}
	

}
