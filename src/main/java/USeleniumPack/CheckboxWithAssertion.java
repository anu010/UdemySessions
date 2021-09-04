package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxWithAssertion {

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

		Assert.assertFalse(	driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		
		
		Assert.assertTrue(	driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
	
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		//Using WHILE loop
		int i=1;
		while(i<5) {
			Thread.sleep(2000);
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
			
		}
				
				
				driver.findElement(By.id("btnclosepaxoption")).click();
				
		
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		System.out.println("matched");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.quit();
		
	}

}
