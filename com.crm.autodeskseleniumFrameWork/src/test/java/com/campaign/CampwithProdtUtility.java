package com.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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
public class CampwithProdtUtility {
public static void main(String[] args) throws Throwable {
	
	 /* creating object of utility libraries*/
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	/*get random data from java utility*/
	int randomnum= jLib.getRanDomNumber();
	
	/*get test data from excel file*/
	String productName = eLib.getDataFromExcel("sheet3", 1, 0) +"_"+randomnum;
	System.out.println("Product name is : "+productName);
	String CampaignName = eLib.getDataFromExcel("sheet4", 1, 0) +"_"+randomnum;
	System.out.println("Campaign name is : "+CampaignName);
	
	/*read common data from property file*/ 
	String browser = fLib.getPropertyKeyValue("browser");
	String url   =	fLib.getPropertyKeyValue("url");
	String username = fLib.getPropertyKeyValue("username");
	String password =  fLib.getPropertyKeyValue("password");
	
	/*launch the browser*/
	WebDriver driver = null;
	
	/*global variable as driver and default value is null*/
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		System.out.println("launched browser is: "+browser);
		
	}else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
	 driver = new EdgeDriver();
	System.out.println("launched browser is : " + browser);
	
	}else {
		
		System.out.println("specify a valid browser");
	}
	
	wLib.waitForPageToLoad(driver);
	driver.get(url);
	driver.manage().window().maximize();
	/*Step 1: login to app*/
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
			
	/*navigate to Product link*/
	driver.findElement(By.xpath("//a[text()='Products']")).click();
	
	/*create product*/
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			
	/*enter product name*/
	driver.findElement(By.name("productname")).sendKeys(productName);
			
	/* click on save*/
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	/*verify*/
	String actheadermsg1 = driver.findElement(By.className("lvtHeaderText")).getText();
	if(actheadermsg1.contains(productName)) {
		System.out.println(productName+ " is verified== pass");
		}else {
		System.out.println(productName+ " is not verified== fail");
		}
			
	/*navigate to more*/
	wLib.mouseOverOnElement(driver,driver.findElement(By.linkText("More")));
			
	/*click on campaign*/
	driver.findElement(By.name("Campaigns")).click();
			
	/*create campaign*/
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			
	/*enter campaign name*/
	driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
	
	/*choose product*/
	driver.findElement(By.xpath("//input[@name='product_id']/following-sibling::img")).click();
			
	/*window handles*/
	wLib.switchToWindow(driver, "Products");
			
	driver.findElement(By.id("search_txt")).sendKeys(productName);
	driver.findElement(By.name("search")).click();
			
	/*dynamic xpath*/
	driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	
	/*main window*/
	wLib.switchToWindow(driver, "Campaigns");
			
			
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	/*verify*/
	String actheadermsg = driver.findElement(By.className("dvHeaderText")).getText();
			if(actheadermsg.contains(CampaignName)) {
				System.out.println(CampaignName+ " is verified== pass");
			}else {
				System.out.println(CampaignName+ " is not verified== fail");

			}
			
	/*sign out*/
		wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));			
			
		driver.findElement(By.linkText("Sign Out")).click();
	
}
}
