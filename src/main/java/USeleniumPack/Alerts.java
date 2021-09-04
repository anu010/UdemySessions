package USeleniumPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException, IOException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println( driver.getTitle());
		
		driver.findElement(By.id("name")).sendKeys("WORLD");
		
		driver.findElement(By.id("alertbtn")).click();

	    System.out.println(	driver.switchTo().alert().getText()); 
		
	    Thread.sleep(2000);
	    
		//accept() to click ok button
	
		driver.switchTo().alert().accept();
	
		Thread.sleep(2000);
		
	
		//another type of alert type by clicking on cancel btn
		
		driver.findElement(By.id("confirmbtn")).click();
		
	    System.out.println(	driver.switchTo().alert().getText()); 
		
	    Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
		
		
		driver.quit();
	
	}

}
