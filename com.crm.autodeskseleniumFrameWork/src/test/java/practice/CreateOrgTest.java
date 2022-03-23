package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.ObjectRepository.CraetionOfHomeOrgPage;
import com.vtiger.ObjectRepository.CreatingNewOrganisationPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import com.vtiger.ObjectRepository.OrgMsgTextPage;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest {
	public static void main(String[] args) throws Throwable {
		
	
	/*create object to libraries*/
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	int randomNum = jLib.getRanDomNumber();
	
	WebDriver driver= null;
	
	//read common data 
	String Browser = fLib.getPropertyKeyValue("browser");
	String Url = fLib.getPropertyKeyValue("url");
	String username = fLib.getPropertyKeyValue("username");
	String password = fLib.getPropertyKeyValue("password");
	
	// read test data
	String orgName= eLib.getDataFromExcel("sheet1", 1, 0)+randomNum;
	String industry= eLib.getDataFromExcel("sheet1", 1, 3);

	// run time polymorphism
			
	if(Browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				
			}
			else if(Browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("specify a valid browser");
			}
			
		// login to app
	driver.get(Url);
	wLib.waitForPageToLoad(driver);
    LoginPage lp = new LoginPage(driver);
    lp.login(username, password);
    
    //navigate to Org
    HomePage hp = new HomePage(driver); 
    hp.clickOnOrganisation();
    	
    CraetionOfHomeOrgPage neworg = new CraetionOfHomeOrgPage(driver);
    neworg.CreateHomeOrgPage();
    
   CreatingNewOrganisationPage org = new CreatingNewOrganisationPage(driver);
   org.createOrganization(orgName,industry);
    
	
	 OrgMsgTextPage msg = new OrgMsgTextPage(driver); 
	 String text=msg.getTextmsg(); 
	 if(text.contains(orgName)) {
	 System.out.println("pass"); 
	 } else { 
		 System.out.println("fail"); 
	 }
	
   //Thread.sleep(3000);
    hp.logout(driver);
   //driver.quit();
    
	}
}
