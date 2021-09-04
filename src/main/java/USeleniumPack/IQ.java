package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IQ {

	public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1. Give me the count of links on the page?
		
		driver.findElements(By.tagName("a")).size();
		
		
		//2. count of links only from footer section?
		//A: 		limiting webdriver scope means :: creating a mini driver and then getting the links list

		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println( footerdriver.findElements(By.tagName("a")).size());
		
		
		//3. count of links of one column from footer section

		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));		
		System.out.println( columndriver.findElements(By.tagName("a")).size());
			
		
		//4. click on each link in the column and check if the pages are opening
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) 
		{
			//opening all links in new tabs
			String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			
			Thread.sleep(5000);
		}
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			
			/*  hasNext() - checks whether next() is present or not
			 *  next()    - actually moves to next window
			 */
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
		}
	
		
		
	}


