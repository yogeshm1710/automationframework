package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct {
	public CreateNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement clickonProductName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSaveButton;

	public WebElement getClickonProductName() {
		return clickonProductName;
	}

	public WebElement getClickOnSaveButton() {
		return clickOnSaveButton;
	}
	
	public void productname(String proName)
	{
		clickonProductName.sendKeys(proName);
	}
	
	public void saveButton()
	{
		clickOnSaveButton.click();
	}
}
