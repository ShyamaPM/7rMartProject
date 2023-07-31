package com.obsqura.rmartSuperMarket.testscript;

import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class MenuSelectionTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether user able to select the Menu")
	public void verifyWhetehrUserAbleToSelectTheMenu()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnDashBoard().clickOnManageOrders().clickOnManageExpense().clickOnManageProduct().clickOnVerifyUsers()
		.clickOnManageUsers().clickOnPushNotification().clickOnManageContent().clickOnManageSlider().clickOnMobileSlider()
		.clickOnManageCategory().clickOnManageOfferCode().clickOnManageDeliveryBoy().clickOnManagePaymentMethod().clickOnAdminUsers()
		.clickOnSettings();
	}

}
