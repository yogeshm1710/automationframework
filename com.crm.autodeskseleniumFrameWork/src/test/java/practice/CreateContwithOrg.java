package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
public class CreateContwithOrg {
	public static void main(String[] args) throws Throwable {
		
		//read  common data from properties file
		FileInputStream fil = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
     	Workbook	wb= WorkbookFactory.create(fil);
     	Sheet sheet = wb.getSheet("sheet1");
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
	 String orgName = sheet.getRow(1).getCell(0).getStringCellValue();
	 String conName = sheet.getRow(1).getCell(1).getStringCellValue();

	 System.out.println("org name is "+orgName);
	 
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
				driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
				driver.get(url);
				
				//login to app
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
				
				//click on org link
				driver.findElement(By.linkText("Organizations")).click();
				
				//click on create img
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				//enter orgname
				Random r = new Random();
				int randomNum = r.nextInt(1000);
				orgName = orgName + randomNum;
			    conName = conName+randomNum;

				driver.findElement(By.name("accountname")).sendKeys(orgName);
			
                //click on save
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
		
		//wait
			    WebDriverWait wait = new WebDriverWait(driver, 20);
			    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Contacts"))));
			    
			  //create contact link
				driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
				//click on "+" img
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
				//navigate to contact
				driver.findElement(By.name("lastname")).sendKeys(conName);
				driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		         // capture all window id
			Set<String>	set= driver.getWindowHandles();
			 Iterator<String> it = set.iterator();
			 while(it.hasNext())
			 {
			String	window_id = it.next();
			driver.switchTo().window(window_id);
			if(driver.getTitle().contains("Accounts"))
			{
				break;
			}
			 }
	driver.findElement(By.id("search_txt")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	 
	Set<String>	set1 = driver.getWindowHandles();
	 Iterator<String> it1 = set1.iterator();
	 while(it1.hasNext())
	 {
	String	window_id = it1.next();
	driver.switchTo().window(window_id);
	if(driver.getTitle().contains("Contacts"))
	{
		break;
	}
	 }
	//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation
		 String act1 = driver.findElement(By.className("dvHeaderText")).getText();
		    if(act1.contains(conName))
		    {
		 	   System.out.println("pass");
		 	   
		    }
		    else
		    {
		 	   System.out.println("fail");
		    }
		    
		    //logout
		    WebElement imgg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		    Actions actt=new Actions(driver);
		    actt.moveToElement(imgg).perform();
		    driver.findElement(By.linkText("Sign Out")).click();
		    
		    //close
		    driver.close();
		    
		
	}

} 
