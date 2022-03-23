package com.campaign;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.ObjectRepository.CreateNewProduct;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.ProductHomePage;
import com.vtiger.comcast.genericUtility.BaseClass;

/**
 * 
 * @author yogesh
 *
 */
@Listeners(com.vtiger.comcast.genericUtility.ListenersImplementation.class)
public class CreateCampaignWithProductTest extends BaseClass {
	@Test
	public void Campaign () throws Throwable
	{
	
		int random = jLib.getRanDomNumber();		
		
		String proName = eLib.getDataFromExcel("sheet3", 1, 0) +"_"+random;
		HomePage homepage = new HomePage(driver);
		   homepage.clickOnProduct();
			   ProductHomePage createproduct = new ProductHomePage(driver);
		   createproduct.productclick();
				//Assert.fail();
		   CreateNewProduct name = new CreateNewProduct(driver);
		   name.productname(proName);
		   name.saveButton();
			 String text=createproduct.verifymsg();
			 Assert.assertEquals(text.contains(proName), true);
			 Reporter.log("Product name is correct",true);
				   
				// homepage.clickoncampaign();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
