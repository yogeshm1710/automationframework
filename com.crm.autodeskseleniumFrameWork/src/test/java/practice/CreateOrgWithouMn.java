package practice;

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
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithouMn {
	public static void main(String[] args) throws Throwable {
		
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		int randomNum = jLib.getRanDomNumber();
		
		
		/*
		 * FileInputStream fil = new
		 * FileInputStream("./src/test/resources/testdata/testdata.xlsx"); Workbook wb=
		 * WorkbookFactory.create(fil); Sheet sheet = wb.getSheet("sheet1"); int
		 * rowcount = sheet.getLastRowNum(); int columncount =
		 * sheet.getRow(0).getLastCellNum();
		 * System.out.println("total number of rows:"+rowcount);
		 * System.out.println("total number of :"+columncount); for(int i=0; i<rowcount;
		 * i++) { for(int j=0; j<columncount; j++) { Row row = sheet.getRow(i); Cell
		 * cell = row.getCell(j); String data = cell.getStringCellValue();
		 * System.out.println(data+"  "); } System.out.println();
		 * 
		 * } System.out.println("============="); String orgName =
		 * sheet.getRow(1).getCell(0).getStringCellValue();
		 * System.out.println("org name is "+orgName);
		 */
		String orgName =eLib.getDataFromExcel("sheet1", 1, 0)+randomNum;
		/*
		 * FileInputStream fis=new
		 * FileInputStream("./src/main/resources/CommonData/credential.property");
		 * Properties pro_obj = new Properties(); pro_obj.load(fis);
		 */
		String browser= fLib.getPropertyKeyValue("browser");
		String url= fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
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
				
				
				//click on org link
				driver.findElement(By.linkText("Organizations")).click();
				
				//click on create img
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				//enter orgname
				/*
				 * Random r = new Random(); int randomNum = r.nextInt(1000);
				 */
				orgName = orgName + randomNum;
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				WebElement drp = driver.findElement(By.name("industry"));
				/*
				 * String industryType=sheet.getRow(1).getCell(3).getStringCellValue(); Select s
				 * = new Select(drp); s.selectByValue(industryType);
				 */
				String industryType = eLib.getDataFromExcel("sheet1", 1, 3);
				wLib.select(drp, industryType);
			    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			  
			    
			    
			    
			    String act= driver.findElement(By.className("dvHeaderText")).getText();
			    if(act.contains(orgName))
			    {
			 	   System.out.println("pass");
			 	   
			    }
			    else
			    {
			 	   System.out.println("fail");
			    }
			    WebElement imgg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				/*
				 * Actions actt=new Actions(driver); actt.moveToElement(imgg).perform();
				 */
			    wLib.mouseOverOnElement(driver, imgg);
			    driver.findElement(By.linkText("Sign Out")).click();
			    driver.close();
			 
				
				
				
                
	}

}
