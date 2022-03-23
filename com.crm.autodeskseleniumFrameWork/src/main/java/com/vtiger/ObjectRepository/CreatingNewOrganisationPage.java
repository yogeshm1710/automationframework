package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreatingNewOrganisationPage extends WebDriverUtility {
	public CreatingNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNametextFild;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement selectIndustry;
	
	//@FindBy(xpath="//input[@title='Save [Alt+S]']")
	@FindBy(xpath="//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebElement getOrganizationNametextFild() {
		return organizationNametextFild;
	}

	public WebElement getSelectIndustry() {
		return selectIndustry;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	/*
	 * Business Logic
	 * this method is used to create organisation with industry 
	 * @param organizationName
	 * @param dropDownValue
	 */
	public void createOrganization(String organizationName, String  dropDownValue)
	{
		
		organizationNametextFild.sendKeys(organizationName);
		
		select(selectIndustry,dropDownValue);
		saveButton.click();
	}
	
	public void organizationName(String organizationName)

	{
		organizationNametextFild.sendKeys(organizationName);
		saveButton.click();

	}
}
