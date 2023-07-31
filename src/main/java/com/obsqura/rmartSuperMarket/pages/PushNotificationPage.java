package com.obsqura.rmartSuperMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.WaitUtility;

public class PushNotificationPage 
{
	public WebDriver driver;
	
	public PushNotificationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='title']") private WebElement titleTextField;
	@FindBy(xpath = "//input[@id='description']") private WebElement descriptionTextField;
	@FindBy(xpath = "//button[@name='create']") private WebElement sendButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	public PushNotificationPage enterTitle()
	{
		titleTextField.sendKeys(ExcelUtility.getString(0, 1, "PushNotification"));
		return this;
	}
	public PushNotificationPage enterDescripiton()
	{
		descriptionTextField.sendKeys(ExcelUtility.getString(1, 1, "PushNotification"));
		return this;
	}
	public PushNotificationPage clickOnSaveButton()
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,sendButton);
		sendButton.click();
		return this;
	}
	public boolean alertMessageIsDisplayed()
	{
		return alertMessage.isDisplayed();
	}

}
