package practice;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMytripTodaysDate {
public static void main(String[] args) {
	LocalDateTime dateandtime = LocalDateTime.now();
	String month = dateandtime.getMonth().toString();
      int day = dateandtime.getDayOfMonth();	
	int year = dateandtime.getYear();
	String actualmonth = month.substring(0, 1)+month.substring(1).toLowerCase();
	String monthAndYear=actualmonth+" "+year;
	System.out.println(monthAndYear);
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	 driver.get("https://www.makemytrip.com");
	
	 Actions action = new Actions(driver);
	 action.moveByOffset(10, 10).click().perform();
	 driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	 driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
	 driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
	 driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
	driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	 List<WebElement> name = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
	  
	 for(WebElement i: name)
	{
		System.out.println(i.getText());
	}
	driver.close();
	 
}
}

