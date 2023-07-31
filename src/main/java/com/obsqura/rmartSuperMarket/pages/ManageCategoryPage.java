package com.obsqura.rmartSuperMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.UploadFileUtility;
import utilities.WaitUtility;

public class ManageCategoryPage 
{
	public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='category']") private WebElement categoryTextField;
	@FindBy(xpath = "//li[@id='134-selectable']") private WebElement selectDiscount;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement chooseFileButton;
	@FindBy(xpath = "//input[@name='top_menu' and @value='no']") private WebElement showOnTopMenuNoRadioButton;
	@FindBy(xpath = "//input[@name='show_home' and @value='no']") private WebElement showOnLeftMenuNoRadioButton;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	public ManageCategoryPage clickOnNewButton() 
	{
		newButton.click();
		return this;
	}
	public ManageCategoryPage enterValueInCategoryField()
	{
		categoryTextField.sendKeys(ExcelUtility.getString(0, 0,"ManageCategory"));
		return this;
	}
	public ManageCategoryPage clickOnSelectGroup() 
	{
		selectDiscount.click();
		return this;
	}
	public ManageCategoryPage uploadFile() 
	{
		UploadFileUtility uploadFileUtility = new UploadFileUtility();
		uploadFileUtility.fileUploadUsingSendKeys(chooseFileButton,GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		return this;
	}
	public ManageCategoryPage clickOnNoRadioButtonOfShowOnTopMenuField() 
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,showOnTopMenuNoRadioButton);
		showOnTopMenuNoRadioButton.click();
		return this;
	}
	public ManageCategoryPage clickOnNoRadioButtonOfShowOnLeftMenuField() 
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,showOnLeftMenuNoRadioButton);
		showOnLeftMenuNoRadioButton.click();
		return this;
	}
	public ManageCategoryPage clickOnSaveButton() 
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,saveButton);
		saveButton.click();
		return this;
	}
	public boolean successalertMessageDisplay() 
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, alertMessage);
		return alertMessage.isDisplayed();
	}

}
