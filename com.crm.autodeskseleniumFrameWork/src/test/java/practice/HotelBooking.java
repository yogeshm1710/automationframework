package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBooking {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		//click on hotel
		driver.findElement(By.xpath("//a[text()='Hotels']")).click();
		//click on India
		driver.findElement(By.xpath("//h4[text()='India']")).click();
		
		//select place
		WebElement ele=driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']"));
		 ele.click();
		 ele.sendKeys("Bengaluru");
		 
		List<WebElement> autosuggestion=driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		for(WebElement wb:autosuggestion) {
			String suggestionlist=wb.getText();
			if(suggestionlist.contains("(Bengaluru)")) {
				wb.click();
				break;
			}
		}
			
		driver.findElement(By.xpath("//div[@data-testid=\"openCheckinCalendar\"]")).click();
		driver.findElement(By.xpath("//span[text()='March 2022']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='31']")).click();
		//checkout	
		driver.findElement(By.xpath("//div[@data-testid=\"openCheckoutCalendar\"]")).click();
		driver.findElement(By.xpath("//span[text()='April 2022']/ancestor::div[@class=\"dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq\"]/descendant::span[text()='1']")).click();
		//children
		driver.findElement(By.xpath("//input[@class=\"SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH\"]")).click();
		WebElement ele1=driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']"));
		Actions a= new Actions(driver);
		a.doubleClick(ele1).click().perform();
		

		//child1
		
		driver.findElement(By.xpath("//p[text()='1']/preceding::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='10']")).click();
		//child2
		driver.findElement(By.xpath("//p[text()='2']/preceding::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='8']")).click();
		//child3
		driver.findElement(By.xpath("//span[text()='3']/following::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='12']")).click();
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		
		List<WebElement> hotels=driver.findElements(By.xpath("//h4[@itemprop=\"name\"]"));
		for(WebElement w:hotels) {
			System.out.println(w.getText());
	}
		driver.close();
	}
}