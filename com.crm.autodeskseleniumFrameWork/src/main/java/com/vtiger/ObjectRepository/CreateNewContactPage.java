package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement enterContactName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSaveButton;

	public WebElement getClickOnSaveButton() {
		return clickOnSaveButton;
	}

	public WebElement getEnterContactName() {
		return enterContactName;
	}
	
	public void contactLastName(String conName)
	{
		enterContactName.sendKeys(conName);
	}
	public void saveButton()
	{
		clickOnSaveButton.click();
	}
	
}
