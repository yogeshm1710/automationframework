package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author yogesh
 *
 */
public class CalenderPopupGenericTest {
public static void main(String[] args) {
	String MonthandYear = "January 2023";
	String day = "17";
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");	
	Actions action = new Actions(driver);
	action.moveByOffset(10, 10).click().perform();
	driver.findElement(By.className("langCardClose")).click();

	driver.findElement(By.xpath("//label[@for='departure']")).click();
//	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//
//	driver.findElement(By.xpath("//div[text()='"+MonthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
//	
	
	for(int i=1; i<=2; i++)
	{
		try {
			driver.findElement(By.xpath("//div[text()='"+MonthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
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
