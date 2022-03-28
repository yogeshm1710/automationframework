package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgMsgTextPage {
	public OrgMsgTextPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgMsgTextPage;
     // getters
	public WebElement getOrgMsgTextPage() {
		return OrgMsgTextPage;
	}
	//business 
		public String getTextmsg() {
			return OrgMsgTextPage.getText();
		}
}
