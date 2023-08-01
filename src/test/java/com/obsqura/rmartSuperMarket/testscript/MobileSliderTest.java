package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import com.obsqura.rmartSuperMarket.pages.MobileSliderPage;
import retry.Retry;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether user able to submit the Mobile slider page after filling all the values",groups = {"regression"})
	public void checkWhetherTheUserAbletoSelectValueFromDropDownandUploadFile() throws InterruptedException
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnMobileSlider();
		
		MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
		mobileSliderPage.clickOnNewButton().clickOnTheCategoryDropDownBox().selectValueFromCategoryDropDown().uploadFileByClickingOnChooseFileButton().clickOnSaveButton();
		boolean isSuccessMessageDisplayed = mobileSliderPage.isSuccessAlertMessageDisplayed();
		assertTrue(isSuccessMessageDisplayed, "Not successfully saved");
	}
}
