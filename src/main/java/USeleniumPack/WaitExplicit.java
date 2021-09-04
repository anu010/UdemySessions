package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExplicit {

public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver,5);
		
		String[] items = {"Cucumber","Cashews","Carrot"};
		
		
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		System.out.println( driver.getTitle());

		Thread.sleep(2000);
		
		addCartItems(driver, items);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		/* 
		 * Explicit Wait 
		 * 
		 * 	  Pros: wait is applied only at targeted elements
		 * 			So, no performance issues.
		 * 	  Cons: More Code
		 * 
		 * 
		 */
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); 
		
		System.out.println( driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		
	}

		
		

	//created this method outside the public static void main() and then we call undefined values by passing as parameters from main method  
		public static void addCartItems(WebDriver driver, String[] items) throws InterruptedException {

			List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
			
			for(int i=0; i<products.size(); i++) 
			{
				//get(i) -- get the control of the products and index
				String[] name = products.get(i).getText().split("-");
				
				String formattedName =  name[0].trim();
				
				//convert array into arrayList
				List al = Arrays.asList(items);
				
				
				int j=0;
				if(al.contains(formattedName))
				{
					j++;
//					Thread.sleep(2000);
					//click on Add to cart
					driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
					
					if(j== items.length)
						break;
					
					
					
				}
				
				
			}
		



	}

}
