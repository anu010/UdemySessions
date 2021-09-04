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

public class DropdownAutoSuggestive {

	//AutoSuggestive dropdown means like search box in google shows  the list according to letters u entered

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

		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		//to get all the elements in the list we are using - driver.findElements  (which returns List of webelemenets)
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
		
		//in n number of options get one option each time. stores in option and it returns webelement
		for(WebElement option : options) 
		{
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
