package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateBackandForthClass {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://www.google.com");
		System.out.println( driver.getTitle());
		
		
		//can also use driver.navigate().to();						
		 
		driver.get("https://en.wikipedia.org/wiki/Main_Page"); //going to wikipedia page 																																							
		
		System.out.println(driver.getTitle());
		
		//NAVIGATE().BACK();
		
		driver.navigate().back();  //going BACK to google
				
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();  //going again forward to wikipedia
		
		System.out.println(driver.getTitle());
		
		driver.close(); //closes the current window
		
		//driver.quit();  // quits all the windows opened
		

	}

}
