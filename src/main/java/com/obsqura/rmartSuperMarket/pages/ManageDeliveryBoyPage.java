package com.obsqura.rmartSuperMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageDeliveryBoyPage 
{
	public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']") private WebElement nameTextFeild;
	@FindBy(xpath = "//input[@id='email']") private WebElement emailFiled;
	@FindBy(xpath = "//input[@id='phone']") private WebElement phoneNumberField;
	@FindBy(xpath = "//textarea[@id='address']") private WebElement addressFiled;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath = "//input[@id='username']") private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordField;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	public ManageDeliveryBoyPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageDeliveryBoyPage enterName()
	{
		nameTextFeild.sendKeys(ExcelUtility.getString(0, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterEmailId()
	{
		emailFiled.sendKeys(ExcelUtility.getString(1, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNumber()
	{
		phoneNumberField.sendKeys(ExcelUtility.getNumeric(2, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterAddressField()
	{
		addressFiled.sendKeys(ExcelUtility.getString(3, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage clickOnSaveButton()
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,saveButton);
		saveButton.click();
		return this;
	}
	public ManageDeliveryBoyPage reenterUserName()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		userNameField.clear();
		userNameField.sendKeys(ExcelUtility.getString(4, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage reenterPassword()
	{
		passwordField.clear();
		passwordField.sendKeys(ExcelUtility.getString(5, 1,"ManageDeliveryBoy"));
		return this;
	}
	public boolean alertMessageIsDisplayed()
	{
		return alertMessage.isDisplayed();
	}

}
