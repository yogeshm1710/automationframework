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
public class SelectOrganizationWindow {
	
	public SelectOrganizationWindow(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchbar;
	
	@FindBy(name="search")
	private WebElement searchicon;
	
	public WebElement getSearchbar() {
		return searchbar;
	}

	public WebElement getSearchicon() {
		return searchicon;
	}

	//busines logic
	public void searchbartext(String orgName)
	{
		searchbar.sendKeys(orgName);
	}
	
	public void searchbutton() {
		searchicon.click();
	}
	
}
