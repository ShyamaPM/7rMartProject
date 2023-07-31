package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.ManageLocationPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether user able to submit the Manage Location page after adding all the field values")
	public void verifyWhetherUserAbletoSubmitTheManageLocationAfterAddingAllTheValues()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageLocation();
		
		ManageLocationPage manageLocationPage = new ManageLocationPage(driver);
		manageLocationPage.clickOnNewButton().selectContryFromDropDown().selectStateFromDropDown().enterLocation()
		.enterDeliveryCharge().clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageLocationPage.successalertMessageDisplay();
		assertTrue(isAlertMessageDisplayed, "Unable to submit Manage Location");
			
	}

}
