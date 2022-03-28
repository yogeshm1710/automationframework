package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
public static void main(String[] args) { 
	ChromeOptions options= new ChromeOptions();
	WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver(options);
  driver.get("https://www.flipkart.com/");
}
}
 