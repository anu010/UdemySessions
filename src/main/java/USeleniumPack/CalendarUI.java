package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

	public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.

		driver.get("https://www.path2usa.com/travel-companions");

		
		/*
		 * GRAB COMMON ATTRIBUTE 
		 *  PUT INTO LIST 
		 *   & ITERATE
		 * 
		 */
		
		
		
		//Date selection
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		
		
		
		/*
		 * ? How it works
		 *	when 1st it shows January as it does not match with october
		 * it will click execute the code inside while loop
		 * !month means false: which means true when jan comes in checking so it executes the code inside the loop
		 *		when it reaches October: as it is saying !month means false i.e; it got matched so it wont execute the code inside the loop
		 *
		 */
		
		
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
		{
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		
		
		List<WebElement> dates = driver.findElements(By.className("day"));
		
		int count = driver.findElements(By.className("day")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			
			if(text.equalsIgnoreCase("29"))
			{
				driver.findElements(By.className("day")).get(i).click();
			break;
			}
		}
		
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
