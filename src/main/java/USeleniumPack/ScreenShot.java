package USeleniumPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.igp.com/");
		
		/*
		 *	ScreenShot
		 *
		 *	==> Actually WebDriver driver object knows how to atomate the browser.
		 *		So, we have to change that driver behaviour to takeScreenshot .
		 *	
		 *	 1. we have to convert WebDriver driver object to TakeScheenshot driver object 
		 *		this process called as Type casting
		 *
		 *	 2. we asking webdriver to save output it as file format so, we can view it
		 *
		 *	 3. store in the src object
		 *
		 *	 4. to see the screenshot physically on the local machine 
		 *		So, we are copying the file src and storing it in our local machine c:drive (or) any other location u want to include
		 */
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//now copy the screenshot to desired location using copyfile //method
		FileHandler.copy(src, new File("D:\\Selenium Stuff\\UdemySessions\\src\\main\\java\\USeleniumPack\\screenshot.png"));
		System.out.println("took screeshot");
		
		
		driver.quit();
		
	}

}
