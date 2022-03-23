package practice;

import java.io.FileInputStream;
import java.io.IOException;
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

public class CreatecontactWithoutMn {
	public static void main(String[] args) throws Throwable {
		
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		int randomNum = jLib.getRanDomNumber();
		
		String conName = eLib.getDataFromExcel("sheet2", 1, 1)+randomNum;
		/*
		 * FileInputStream fil = new
		 * FileInputStream("./src/test/resources/testdata/testdata.xlsx"); Workbook wb=
		 * WorkbookFactory.create(fil); Sheet sheet = wb.getSheet("sheet2"); int
		 * rowcount = sheet.getLastRowNum(); int columncount =
		 * sheet.getRow(0).getLastCellNum();
		 * System.out.println("total number of rows:"+rowcount);
		 * System.out.println("total number of :"+columncount); for(int i=0; i<rowcount;
		 * i++) { for(int j=0; j<columncount; j++) { Row row = sheet.getRow(i); Cell
		 * cell = row.getCell(j); String data = cell.getStringCellValue();
		 * System.out.println(data+"  "); } System.out.println();
		 * 
		 * } System.out.println("============="); String conName =
		 * sheet.getRow(1).getCell(1).getStringCellValue();
		 * System.out.println("con name is "+conName);
		 * 
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
				wLib.waitForPageToLoad(driver);
				/*
				 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 */				
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				//create contact link
				driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
				//click on "+" img
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				//enter contact name
				/*
				 * Random r = new Random(); 
				 * int randomnum = r.nextInt(1000);
				 */
				//conName = conName+randomNum;
				driver.findElement(By.name("lastname")).sendKeys(conName);
				driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
				/*
				 * //windowhandling String mainId = driver.getWindowHandle(); Set<String> allId
				 * = driver.getWindowHandles(); for(String id:allId) { if(!mainId.equals(id)) {
				 * driver.switchTo().window(id);
				 * 
				 * }
				 * 
				 * }
				 */
				wLib.switchToWindow(driver, "Accounts");
				driver.findElement(By.linkText("vtiger")).click();
				//driver.switchTo().window(mainId);
				wLib.switchToWindow(driver, "Contacts");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				 String act= driver.findElement(By.className("dvHeaderText")).getText();
				    if(act.contains(conName))
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
