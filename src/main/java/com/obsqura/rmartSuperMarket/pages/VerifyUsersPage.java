package com.obsqura.rmartSuperMarket.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class VerifyUsersPage 
{
	public WebDriver driver;
	
	public VerifyUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(@class,'btn-rounded')]") private WebElement searchBox;
	@FindBy ( xpath = "//input[@id='un']") private WebElement nameTextField;
	@FindBy (xpath = "//button[@name='Search']") private WebElement searchButton;
	@FindBy (xpath = "//table[contains(@class,'table-bordered')]//td") public WebElement tableValues;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td")) private List<WebElement> tableData;
	
	
	public VerifyUsersPage clickOnSearchBox()
	{
		searchBox.click();
		return this;
	}

	public VerifyUsersPage enterNameinSearchField(String name)
	{
		nameTextField.sendKeys(name);
		return this;
	}
	
	public VerifyUsersPage clickOnSearchButton()
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,searchButton);
		searchButton.click();
		return this;
	}
	
	public VerifyUsersPage isTheSearcNameExistsInTheVerifyUsersList(String name, boolean flag) 
	{
		List<String> nameList = new ArrayList<>();
		for(WebElement rowValue:tableData)
		{
			String getTextData = rowValue.getText();
			nameList.add(getTextData);
			if(nameList.contains(name))
			{
				flag = true;
			    break;
			}
		}
		return this;
	}
	
	public String isTheSearcNameExistsInTheVerifyUsersList() 
	{
		return tableValues.getText();	
	}	
}
