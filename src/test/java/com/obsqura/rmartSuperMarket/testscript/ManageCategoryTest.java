package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.ManageCategoryPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether user able to add values in Manage Category")
	public void verifyWhetherTheUserAbleToAddValuesInManageCategory()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageCategory().clickOnCategorySubMenuOfManageCategory();
		
		ManageCategoryPage manageCategoryPage = new ManageCategoryPage(driver);
		manageCategoryPage.clickOnNewButton().enterValueInCategoryField().clickOnSelectGroup().uploadFile().clickOnNoRadioButtonOfShowOnTopMenuField()
		      .clickOnNoRadioButtonOfShowOnLeftMenuField().clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageCategoryPage.successalertMessageDisplay();
		assertTrue(isAlertMessageDisplayed, "Unable to submit manage category");
	}
}
