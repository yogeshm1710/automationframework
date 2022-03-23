package com.Oppurtunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.ObjectRepository.CraetionOfHomeOrgPage;
import com.vtiger.ObjectRepository.CreatingNewOpportunitiesPage;
import com.vtiger.ObjectRepository.CreatingNewOrganisationPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.ObjectRepository.OpportunitiesHomePage;
import com.vtiger.ObjectRepository.OrgMsgTextPage;
import com.vtiger.ObjectRepository.SelectOrganizationWindow;
import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author yogesh
 *
 */
@Listeners(com.vtiger.comcast.genericUtility.ListenersImplementation.class)
public class OpportunityWithSupportSelling extends BaseClass {
	

	@Test(groups = "EndToEndTest")
	public void createOpportunityWithSupport() throws Throwable
	{
		int randomNum = jLib.getRanDomNumber();

	// read test data
	String orgName= eLib.getDataFromExcel("sheet1", 1, 0)+randomNum;

	
	// navigate to Org
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganisation();

	// navigate to create org
	CraetionOfHomeOrgPage neworg = new CraetionOfHomeOrgPage(driver);
	neworg.CreateHomeOrgPage();

	// enter org name
	CreatingNewOrganisationPage org = new CreatingNewOrganisationPage(driver);
	org.organizationName(orgName);
	//verify org name
	OrgMsgTextPage msg = new OrgMsgTextPage(driver);
	String text = msg.getTextmsg();
	Assert.assertEquals(text.contains(orgName), true);
	 Reporter.log("Organization is created succesfully",true);
	 
	 //navigate to opportunity
	OpportunitiesHomePage opgh = new OpportunitiesHomePage(driver);
	hp.clickonOpportunities();

	// navigate to create opportunitis
	opgh.clickonOpportunities();
	
	// enter opportunity name
	String opportunityName = eLib.getDataFromExcel("Sheet5", 1, 0) + randomNum;

	CreatingNewOpportunitiesPage opportunity = new CreatingNewOpportunitiesPage(driver);
	opportunity.createopportunity(opportunityName);

	opportunity.clickcreatebutton();
	
	// get window handles
	wLib.switchToWindow(driver,"Accounts");

	SelectOrganizationWindow SelectOrganization = new SelectOrganizationWindow(driver);
	SelectOrganization.searchbartext(orgName);
	
	//select organization name
	SelectOrganization.searchbutton();
	
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	wLib.switchToWindow(driver,"Potentials");
	
	//navigate to group button
	opportunity.radiobutton();
	opportunity.selectAssignedToGroup(driver);
		opportunity.savebutton();
	
	//verify the opportunity
	String opportunitycreated = msg.getTextmsg();
	Assert.assertEquals(opportunitycreated.contains(opportunityName), true);
	 Reporter.log("Opportunity is created with Support group",true);
		
		driver.close();
}
}