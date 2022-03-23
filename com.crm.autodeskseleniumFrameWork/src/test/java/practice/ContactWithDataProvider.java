package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactWithDataProvider {
	@Test(dataProvider="getlastnameandMobile")
	public void contact(String lastname, String mobilename)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.TAB, Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(mobilename);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String act1 = driver.findElement(By.className("dvHeaderText")).getText();
	    if(act1.contains(lastname))
	    {
	 	   System.out.println("pass");
	 	   
	    }
	    else
	    {
	 	   System.out.println("fail");
	    }
	    
	    //logout
	    WebElement imgg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(imgg).perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    
		driver.close();
	}
	
	@DataProvider	
	public Object[][] getlastnameandMobile() {
		Object[][] array = new Object[3][2];

		array[0][0]="Iron Man";
        array[0][1]="9108234666";

        array[1][0]="Dr Strange";
        array[1][1]="1234567890";
        
        array[2][0]="Hulk";
        array[2][1]="7728786268";
        return array;	
	}

}
