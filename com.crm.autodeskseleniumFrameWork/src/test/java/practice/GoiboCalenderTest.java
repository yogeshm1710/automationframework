package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author yogesh
 *
 */
public class GoiboCalenderTest {
	public static void main(String[] args) {
		String monthandyear = "January 2023";
		String day = "12";
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib =new ExcelUtility();
		
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
         wLib.waitForPageToLoad(driver);
          driver.get("https://www.goibibo.com");
         driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for(int i=1; i<=2;i++)
		{
			try
			{
		 		driver.findElement(By.xpath("//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
                  break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		driver.close();
		
	}

}
