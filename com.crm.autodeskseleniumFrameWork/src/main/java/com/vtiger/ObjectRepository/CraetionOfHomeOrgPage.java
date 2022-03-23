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
public class CraetionOfHomeOrgPage {
	//Initialization a webElement 
		public CraetionOfHomeOrgPage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
    //Declaration of webElement
	private WebElement CreationOfHomeOrgPageLink;

	

	//providing getters

	


	public WebElement getCreationOfHomeOrgPageLink() {
		return CreationOfHomeOrgPageLink;
	}


	//provide business of CreateHomepageLink
	/**
	 * This method is use to create homepage link
	 */
	public void CreateHomeOrgPage() {
		CreationOfHomeOrgPageLink.click();
	}
     
	

	}



