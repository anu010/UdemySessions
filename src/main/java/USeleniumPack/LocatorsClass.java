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

public class LocatorsClass {

	public static void main(String[] args) throws IOException , FileNotFoundException, InterruptedException{


		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		System.out.println( driver.getTitle());
		
		      								
		
		
										//LOCATORS//				
		
		
						// 1)  using ' ID ' attribute from HTML DOM page as LOCATOR
		
		driver.findElement(By.id("mobno")).sendKeys("987654321");
		
		
		
						// 2)  using ' NAME ' attribute from HTML DOM page as LOCATOR
		
		//driver.findElement(By.name("name76316a1e")).sendKeys("yippie");  
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys("Yippie");
		driver.findElement(By.xpath("//input[starts-with(@name,'login')]")).sendKeys("yippieworld");
		// in this case showing error :NoSuchElementException  -- name value is not dynamic in nature 
		// i.e; presence of nbrs in the value as it will be changing some times					
		
		
		
						//	3)	using 'XPATH' LOCATOR  combination with (starts-with, ends-with , contains)
		
		System.out.println("3) display of register using XPATH" +" -- " +  driver.findElement(By.xpath("//input[@id='Register']")).isDisplayed() );
		
		
		
						//	4)	using 'Class' attribute from HTML DOM page as LOCATOR
		
		System.out.println("4) display of check availability button using CLASSNAME" + " -- " + driver.findElement(By.className("btn_checkavail")).isDisplayed());
		
		
		
						//	5)	 using 'TagName' attribute from HTML DOM page as LOCATOR
		
		//storing the number of links in list
        List<WebElement> links= driver.findElements(By.tagName("a"));
        
        //storing the size of the links
        int i= links.size();
        
        //Printing the size of the string
        System.out.println(i +" links available");
        
        for(int j=0; j<i; j++)
        {
            //Printing the links
            System.out.println("5) using TAGNAME" + " :: " +links.get(j).getText());
        }
		
		
        
        				//	6)	using ' LINKTEXT ' attribute from HTML DOM page as LOCATOR
        
        System.out.println("6) using LINKTEXT" + " :: " +driver.findElement(By.linkText("Home")).getText());
        
        
        				//	7)	using ' PartialLinkText ' attribute from HTML DOM page as LOCATOR
        
        System.out.println("7) using PartialLinkText" + " :: " +driver.findElement(By.partialLinkText("policy")).getText());
        
        
        				//	8)	using ' CSS Selector ' attribute from HTML DOM page as LOCATOR
        
        System.out.println("8) using CSS Selector" + " :: " +driver.findElement(By.cssSelector("#Register")).isDisplayed());
        
		Thread.sleep(2000);
		

		driver.quit();
		
	}

}
