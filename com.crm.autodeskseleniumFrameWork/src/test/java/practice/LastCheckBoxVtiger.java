package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LastCheckBoxVtiger {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	driver.get("http://localhost:8888/");
	 driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.TAB, Keys.ENTER);
	
	driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
 driver.findElement(By.xpath("(//input[@onclick='check_object(this)'])[last()]")).click();
	
	
}
}
