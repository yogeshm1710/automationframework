package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToCrm {
	public static void main(String[] args) throws IOException {
		WebDriver driver= null;

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
		
	}

}
  