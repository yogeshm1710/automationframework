package contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.ObjectRepository.ContactHomePage;
import com.vtiger.ObjectRepository.CreateNewContactPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.OrgMsgTextPage;
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
public class CreateContactTest extends BaseClass {
	@Test(groups="FunctionalTest")
	public void crateContact() throws Throwable {
		
		int randomNum = jLib.getRanDomNumber();
  
		String conName = eLib.getDataFromExcel("sheet2", 1, 1) + randomNum;
		
		HomePage homepage = new HomePage(driver);
		homepage.clickoncontacts();
		
		ContactHomePage createcontact = new ContactHomePage(driver);
		createcontact.createContact();

		CreateNewContactPage contactname = new CreateNewContactPage(driver);
		contactname.contactLastName(conName);
	
		contactname.saveButton();
		OrgMsgTextPage msg = new OrgMsgTextPage(driver);
		 String text=msg.getTextmsg(); 
		 Assert.assertEquals(text.contains(conName), true);
		 Reporter.log("Contact name is correct",true);
					
		driver.close();
	}

}
