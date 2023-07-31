package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.ManageExpensePage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageExpenseTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether user able to submit the Manage Expense agter filling all the vaulues in the correspo ding field")
	public void verifyWhetherUserAbletoSubmitTheManageExpenceAfterFillingAllFieldData()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageExpense().clickOnSubMenuManageExpense();
		
		ManageExpensePage manageExpensePage = new ManageExpensePage(driver);
		manageExpensePage.clickOnNewButton().selectUserDropDown().selectCategory().selectOrderId().selectPurchaseId()
		   .selectExpenseType().enterAmount().enterRemarksData().uploadFile().clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageExpensePage.alertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed, "Manage suer pages submission failed");
	}

}
