package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemsToCartECom {

public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		int j=0;
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		System.out.println( driver.getTitle());

		String[] items = {"Cucumber","Cashews","Carrot"};
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size(); i++) 
		{
			//get(i) -- get the control of the products and index
			String[] name = products.get(i).getText().split("-");
			
			String formattedName =  name[0].trim();
			
			//convert array into arrayList
			List al = Arrays.asList(items);
			
			
			
			if(al.contains(formattedName))
			{
				j++;
				Thread.sleep(2000);
				//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				
				if(j== items.length)
					break;
				
				
				
			}
			
			
		}
		
		Thread.sleep(2000);
		
		
		driver.quit();
	}

}
