package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class e2eSpicejetWebsite {

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
		
		driver.get("https://www.spicejet.com/");
		System.out.println( driver.getTitle());

		// 1. Selecting city
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='COK'])[2]")).click();
		
		// 2. Selecting date
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		//3. Arrival calendar disable
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
		// 4. Checkbox selection
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();		
		
		
		// 5. Passenger List
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
			
		Select list = new Select( driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		Thread.sleep(2000);
		list.selectByValue("5");
		//driver.findElement(By.xpath("//option[@value='5']")).click();
		
		
		// 6. Selecting 
		
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		
		Select dropdown = new Select(staticDropdown);
		Thread.sleep(2000);
		dropdown.selectByVisibleText("USD");
		
		
		// 7. Clicking  on Search button
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		Thread.sleep(2000);
		
		
		
		
		driver.quit();
		
		
	}

}
