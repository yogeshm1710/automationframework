package practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OraganizatiSelectAndDelete {
	public static void main(String[] args) throws InterruptedException {
		Random ran=new Random();
		int ranNum=ran.nextInt(100000);
		 String orgName = "headway"+ranNum;
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 driver.get("http://localhost:8888/");
		
		 driver.findElement(By.name("user_name")).sendKeys("admin");

		 driver.findElement(By.name("user_password")).sendKeys("root");

		 driver.findElement(By.id("submitButton")).click();
		 	
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 driver .findElement(By.cssSelector("[src='themes/softed/images/btnL3Add.gif']")).click();
		 
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 
		 driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		 Thread.sleep(1000);
		 WebElement wb= driver.findElement(By.linkText("Organizations"));
			wb.click();
//		 WebDriverWait wait=new WebDriverWait(driver,20);
//		 wait.until(ExpectedConditions.elementToBeClickable(wb));
		

			
			for(;;) {
				try {
				driver.findElement(By.xpath("//table[@class='lvtBg']//tbody/tr[*]/td[3]/a[text()='"+orgName+"']")).click();		
							 break;

				}catch(Exception e) {
					driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
				}
				}
		
		driver.findElement(By.cssSelector("[title='Delete [Alt+D]']")).click();
		driver.switchTo().alert().accept();
		System.out.println("created product deleted successfully");

	WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));



	Actions action=new Actions(driver);
	action.moveToElement(ele).perform();

	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
		
		
		 
	}
}
