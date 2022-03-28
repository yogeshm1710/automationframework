package practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrganisationMand {
	public static void main(String[] args) {
		
	
	
	Random random = new Random();
	int ranNum = random.nextInt(1000);
	
	WebDriver driver = new ChromeDriver();
	String orgName = "tyMyntra_"+ranNum;
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://localhost:8888/");
	//login to app
	 driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.TAB, Keys.ENTER);
	// navigate to organ
	driver.findElement(By.linkText("Organizations")).click();
	
	//navigate to create org
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName);
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
   Actions actt=new Actions(driver);
   actt.moveToElement(imgg).perform();
   driver.findElement(By.linkText("Sign Out")).click();
   driver.close();
}
}
