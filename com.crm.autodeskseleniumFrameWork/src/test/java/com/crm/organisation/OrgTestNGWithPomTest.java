package com.crm.organisation;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.ObjectRepository.CraetionOfHomeOrgPage;
import com.vtiger.ObjectRepository.CreatingNewOrganisationPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.OrgMsgTextPage;
import com.vtiger.comcast.genericUtility.BaseClass;
/**
 * 
 * @author yogesh
 *
 */
@Listeners(com.vtiger.comcast.genericUtility.ListenersImplementation.class)
public class OrgTestNGWithPomTest extends BaseClass {
	@Test(groups = "EndToEndTest")
	public void createOrg() throws Throwable
	{
		int random = jLib.getRanDomNumber();

		//test script data
		String orgName= eLib.getDataFromExcel("sheet1", 1, 0)+random;
		String industry= eLib.getDataFromExcel("sheet1", 1, 3);

		//navigate to Org
		HomePage hp = new HomePage(driver); 
		hp.clickOnOrganisation();

		// navigate to create organization
		CraetionOfHomeOrgPage neworg = new CraetionOfHomeOrgPage(driver);
		neworg.CreateHomeOrgPage();

		//enter organization name and select industry type
		CreatingNewOrganisationPage org = new CreatingNewOrganisationPage(driver);
		org.createOrganization(orgName,industry);

		// verify the msg
		OrgMsgTextPage msg = new OrgMsgTextPage(driver); 
		String text=msg.getTextmsg(); 
		Assert.assertEquals(text.contains(orgName), true);
		Reporter.log("Organization is created with industry type",true);


	}
}
