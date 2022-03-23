package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrCampaignwithproduct {
	public static void main(String[] args) throws Throwable {
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		int randomNum = jLib.getRanDomNumber();
		
		FileInputStream fil = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
	 	Workbook	wb= WorkbookFactory.create(fil);
	 	Sheet sheet = wb.getSheet("sheet4");
	 	int rowcount = sheet.getLastRowNum();
	 	int columncount = sheet.getRow(0).getLastCellNum();
	 	System.out.println("total number of rows:"+rowcount);
	    System.out.println("total number of :"+columncount);
	 for(int i=0; i<rowcount; i++)
	 {
		 for(int j=0; j<columncount; j++)
		 {
			 Row row = sheet.getRow(i);
			 Cell cell = row.getCell(j);
			 String data = cell.getStringCellValue();
			 System.out.println(data+"  "); 
	     }
		 System.out.println();
			 
	 }
	 System.out.println("=============");
	 String campaignName = sheet.getRow(1).getCell(0).getStringCellValue();
	 System.out.println("campaign name is "+campaignName);
	 
	 FileInputStream fis=new FileInputStream("./src/main/resources/CommonData/credential.property");	
		Properties pro_obj = new Properties();
		pro_obj.load(fis);
		String browser= pro_obj.getProperty("browser");
		String url= pro_obj.getProperty("url");
		String username = pro_obj.getProperty("username");
		String password = pro_obj.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		// run time polymorphism
		WebDriver driver = null;
				if(browser.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver();
					
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					 driver = new FirefoxDriver();
				}
				else
				{
					System.out.println("specify a valid browser");
				}
				
				driver.manage().window().maximize();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
		
	//navigate to more
	WebElement more = driver.findElement(By.linkText("More"));
	Actions act = new Actions(driver);
	act.moveToElement(more).perform();
	//click on campaign
	driver.findElement(By.name("Campaigns")).click();
	//create campaign
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	//enter campaign name
	Random r = new Random();
	int randomnum = r.nextInt(1000);
	campaignName = campaignName+randomnum;
	
	driver.findElement(By.name("campaignname")).sendKeys(campaignName);
	//choose product
	driver.findElement(By.xpath("//input[@name='product_id']/following-sibling::img")).click();
	//windowHandling
			String mainId = driver.getWindowHandle();
			Set<String> allId = driver.getWindowHandles();
			for(String id:allId) {
				if(!mainId.equals(id)) {
					driver.switchTo().window(id);
				}
			}
		
			driver.findElement(By.xpath("//table[@class='small' and @Style]/tbody/tr[12]/td/a")).click();
			driver.switchTo().window(mainId);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(ele).perform();
			driver.findElement(By.linkText("Sign Out")).click();

}
}
