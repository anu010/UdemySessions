package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.

		driver.get("https://jqueryui.com/droppable/");
		
		/*
		 * Frames
		 *
		 *	Web page (or) an inline frame which is embedded in another web page 
		 *	(or) an HTML document embedded inside another HTML document. 
		 *
		 *
		 */
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
	
		driver.findElement(By.id("draggable")).click();
		
		
		/*
		 * 
		 * ? if there are 3 frames how to switch into those
		 * driver.switchTo().frame(0) - gives u first frame
		 * driver.switchTo().frame(1) - gives u second frame
		 *    (0),(1),(2),(3) -- are indexes
		 * 
		 * 
		 * ? To know how many frames are present in the web page.
		 *  driver.findElements(By.tagName("iframe")).size();
		 * 
		 * 
		 * ? How to go back to parent page from frame
		 *  driver.switchTo().defaultContent();
		 * 
		 * 
		 */
		 
		driver.switchTo().defaultContent();
		
		driver.quit();
		
		

	}

}
