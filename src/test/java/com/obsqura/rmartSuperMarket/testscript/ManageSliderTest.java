package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.ManageSliderPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify whether user able to submit the Manage slider page after filling all the field values")
	public void verifyWhetherTheUserAbleToSubmitTheManageSliderPagAfterFillingAllTheFieldValues()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageSlider();
		
		ManageSliderPage manageSilderPage = new ManageSliderPage(driver).newButtonClick().uploadFileByCLickingOnFileUplaodButton().enterTextDataInLinkTextField()
		      .clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageSilderPage.successalertMessageDisplay();
		assertTrue(isAlertMessageDisplayed, "Some issue while adding the doc or link");	
	}

}
