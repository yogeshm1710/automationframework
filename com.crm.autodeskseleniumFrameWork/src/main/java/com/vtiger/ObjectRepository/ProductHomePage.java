package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHomePage {
	public ProductHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement clickONCreateProduct;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement msgTextPage;
	
	public WebElement getMsgTextPage() {
		return msgTextPage;
	}
	public WebElement getClickONCreateProduct() {
		return clickONCreateProduct;
	}
	public void productclick()
	{
		clickONCreateProduct.click();
	}
	public String verifymsg()
	{
		return msgTextPage.getText();
	}
}
