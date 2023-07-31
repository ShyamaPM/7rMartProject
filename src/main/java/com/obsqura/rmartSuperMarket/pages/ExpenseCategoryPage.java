package com.obsqura.rmartSuperMarket.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ExpenseCategoryPage 
{
	public WebDriver driver;
	
	public ExpenseCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll(@FindBy (xpath = "//table[contains(@class,'table-bordered')]//tr")) private List<WebElement> titleNames;
	@FindAll(@FindBy (xpath = "//i[contains(@class,'fa-trash-alt')]")) private List<WebElement> deleteIcon;
	@FindBy(xpath = "(//a[contains(@class,'btn-danger')])[2]") private WebElement delete;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	@FindBy(xpath = "(//a[contains(@href,'1661&page_ad=1') and contains(@class,'btn-primary')])") private WebElement edit;
	@FindBy(xpath = "//input[@id='name']") private WebElement titleTextBox;
	@FindBy(xpath = "//i[contains(@class,'fa-save')]") private WebElement updateButton;
	
	public void deletTheTitle()
	{
		for(WebElement title : titleNames)
		{
			String getTitleText = title.getText();
			if(getTitleText.contains("mysample0.4"))
			{
				delete.click();
				PageUtility pageUtility = new PageUtility();
				pageUtility.alertHandlingaccept(driver);
				break;
			}
		}
	}
	public boolean deleteAlertMessageIsDisplayed()
	{
		return alertMessage.isDisplayed();
	}
	
	public void editTheTitle()
	{
		for(WebElement title : titleNames)
		{
			String getTitleText = title.getText();
		
			if(getTitleText.contains("New"))
			{
				edit.click();
				titleTextBox.clear();
				titleTextBox.sendKeys("Reyan");
				updateButton.click();
				break;
			}
		}
	}
	public boolean editAlertMessageIsDisplayed()
	{
		return alertMessage.isDisplayed();
	}

}
