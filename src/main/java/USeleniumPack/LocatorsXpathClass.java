package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsXpathClass {

	public static void main(String[] args) throws IOException , FileNotFoundException, InterruptedException{
		
		
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://www.toolsqa.com/selenium-certification/?q=Header");
		System.out.println( driver.getTitle());
		
		
		
		
					//using 'XPATH' LOCATOR  with Regular Expressions (starts-with, ends-with , contains)
		
		System.out.println("xpath combination -- using starts-with"+"::"+"displayed "+ driver.findElement(By.xpath("//button[starts-with(text(),'CAREER')]")).isDisplayed());
		
		
		//The ends-with function is part of xpath 2.0 but browsers (you indicate you're testing with chrome) generally only support 1.0. So you'll have to implement it yourself with a combination of string-length, substring and equals.											
		
		//System.out.println( "xpath combination -- using ends-with"+"::"+"displayed "+ driver.findElement(By.xpath("//button[substring(text(), string-length(text()) - string-length('DEMO') +1) = 'DEMO']")).isDisplayed());
							
													// OR //  instead of typing text() 2 times . use (.)

		System.out.println( "xpath combination -- using ends-with"+"::"+"displayed "+ driver.findElement(By.xpath("//button[text()[substring(., string-length(.) - string-length('DEMO') +1) = 'DEMO']]")).isDisplayed());

		
		System.out.println( "xpath combination -- using contains"+"::"+"displayed "+ driver.findElement(By.xpath("//button[contains(text(),'EN')]")).isDisplayed());
		
		Thread.sleep(2000);
		
		
		
		

		driver.quit();
		
		
		

	}

}
