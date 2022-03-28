package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author yogesh
 *
 */
public class OpportunitiesHomePage {
	//initialiaztion of web elemenet
	public OpportunitiesHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration of webelement
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement OpportunitiesHomePagelink;

	public WebElement getOpportunitiesHomePagelink() {
		return OpportunitiesHomePagelink;
	}
	
	//business logic
	public void clickonOpportunities() {
		OpportunitiesHomePagelink.click();
	}
}
