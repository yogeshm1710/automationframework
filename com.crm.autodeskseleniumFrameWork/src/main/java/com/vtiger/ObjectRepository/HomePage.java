package com.vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//Initialization of web Element	
	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration of web element
	@FindBy(linkText ="Organizations")
	private WebElement Organizationslink ;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	
	@FindBy (linkText= "Campaigns")
	private WebElement campaignlink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement SignoutIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOut;

	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement Opportunitieslink;

	@FindBy(xpath="//a[text()='Products']")
	private WebElement clickOnPrpduct;

	public WebElement getClickOnPrpduct() {
		return clickOnPrpduct;
	}
	
	 
	public WebElement getContactslinl() {
		return contactslink;
	}


	public WebElement getCampaignlink() {
		return campaignlink;
	}
	
	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}
	
	public WebElement getSignOut() {
		return SignOut;
	}


	public WebElement getOrganizations() {
		return Organizationslink;
	}


	public WebElement getSignoutIcon() {
		return SignoutIcon;
	}

	//business logic for utilization

	/**
	 * This method is use to click organisation link
	 */
	public void clickOnOrganisation() {
		Organizationslink.click();
	}
	public void logout(WebDriver driver) {
		wLib.mouseOverOnElement(driver,SignoutIcon );
		SignOut.click();
	}
	public void clickonOpportunities()
	{
		Opportunitieslink.click();
	}
	public void clickoncontacts() {
		contactslink.click();
	}
	
	public void clickoncampaign() {
		campaignlink.click();
	}
	
	public void clickOnProduct()
	{
		clickOnPrpduct.click();
	}
	
	}




