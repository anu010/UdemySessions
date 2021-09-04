package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownStatic {

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
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println( driver.getTitle());
		
		//The constructor Select() is undefined -- fixing Add argument to match Select(WebElement)
		//so, created a webelement of dropdown
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		
		Select dropdown = new Select(staticDropdown);
		Thread.sleep(2000);
		dropdown.selectByVisibleText("USD");
//	(or)	dropdown.selectByIndex(2);
//	(or)	dropdown.selectByValue("AED");
		
		Thread.sleep(2000);
		System.out.println( dropdown.getFirstSelectedOption().getText());
		
		driver.quit();

	}
	
	
}
	
	
	
	
	
	
