package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Scroll {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//to scroll the webpage upto given pixel values
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		
		//to scroll the seperate table present in web page at given piven pixel values
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		Thread.sleep(2000);
		
		
		//to get the elements of this table row
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		//to add the values in the row
		int sum=0;
		
		
		for(int i=0;i<values.size();i++)
		{
			//converting the string to integer using Integer.parseInt
			sum = sum +	Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println(sum);
		
		//as it is a string we have to covert it into integer by using Integer.parseInt
		
		int total = Integer.parseInt( driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		
		//comapring the value total we got v/s actually present
		
		//Assert.assertEquals(sum, total);
		
		
		
		
		driver.quit();
		
		
		
	}

}
