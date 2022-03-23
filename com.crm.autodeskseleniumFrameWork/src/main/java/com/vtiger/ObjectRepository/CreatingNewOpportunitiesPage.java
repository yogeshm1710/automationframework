 package com.vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreatingNewOpportunitiesPage {
	
	//initialization of web element
	public CreatingNewOpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	//declaration of web element
	
	
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement OpportunityTextField;
	
	@FindBy(xpath="//b[.='Opportunity Information:']/preceding::input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement clickcreatebutton;
	 
	@FindBy(xpath="//input[@value='T']")
	private WebElement clickradiobutton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement assignedToListBox;
	
	//getters
	public WebElement getOpportunityTextField() {
		return OpportunityTextField;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getClickcreatebutton() {
		return clickcreatebutton;
	}

	public WebElement getClickradiobutton() {
		return clickradiobutton;
	}
	

	//Business logic
	public void createopportunity(String opportunityName)
	{
	OpportunityTextField.sendKeys(opportunityName);
	}
	
	public void savebutton() {
	SaveButton.click();
	}
	
	public void radiobutton() {
		clickradiobutton.click();	
	}
	
	public void clickcreatebutton() {
		clickcreatebutton.click();
	}
	public void selectAssignedToGroup(WebDriver driver) throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		assignedToListBox.click();
		String sheetnum = eLib.getDataFromExcel("Sheet5", 2, 1);
		driver.findElement(By.xpath("//option[text()='"+sheetnum+"']")).click();

	}
	public void selectAssignedToTeamSelling(WebDriver driver) throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		assignedToListBox.click();
		String sheetnum = eLib.getDataFromExcel("Sheet5", 1, 1);
		driver.findElement(By.xpath("//option[text()='"+sheetnum+"']")).click();

	}
	
}
