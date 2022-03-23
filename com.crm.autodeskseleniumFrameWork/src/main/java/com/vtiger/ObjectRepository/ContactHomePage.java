package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHomePage {
	public ContactHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement clickOnCreateContact;

		public WebElement getClickOnCreateContact() {
			return clickOnCreateContact;
		}
	
		public void createContact()
		{
			clickOnCreateContact.click();
		}
		
}
