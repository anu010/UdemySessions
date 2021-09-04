

		/*      //Line breakpoint:DebugCode [line: 49] - main(String[])
		 
		   
		     1. Click Debug as
		     2. now chromedriver will be loaded but not the url
		     3. execution get stops at this point
		     4. after clicking on 'Step Over' the 49th line is executed and moves to next step to check
		     
		     
		 */


package USeleniumPack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DebugCode {

public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://www.spicejet.com/");
		System.out.println( driver.getTitle());

		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='COK'])[2]")).click();
		

		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
	
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();		
		

		
		Thread.sleep(2000);
		
		
		
		
		driver.quit();
		

	}

}
