package com.vtiger.comcast.genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	// object creation for utility classes
	public  JavaUtility jLib= new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();	
	public WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups={"FunctionalTest","EndToEndTest"})
public void bs() {
		System.out.println("connect to database");
	}
	
	@BeforeTest(groups={"FunctionalTest","EndToEndTest"})
	public void bt()
	{
		System.out.println("execute script in parallel mode");
	}
	//@Parameters("browser")
	@BeforeClass(groups={"FunctionalTest","EndToEndTest"})
	public void bc() throws Throwable
	//public void bc(String browser)
	{
		String browser = fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("specify a valid browser");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sDriver = driver;
	}
	
	@BeforeMethod(groups={"FunctionalTest","EndToEndTest"})
	public void bm() throws Throwable
	{
		String username= fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);
	}
	
	@AfterClass(groups={"FunctionalTest","EndToEndTest"})
	public void ac() {
		driver.quit();
	}
	
	@AfterTest(groups={"FunctionalTest","EndToEndTest"})
	public void at()
	{
		System.out.println("close parallel mode execution");
	}
	
	@AfterSuite(groups={"FunctionalTest","EndToEndTest"})
	public void as()
	{
		System.out.println("disconnect database");
	}
		
}
