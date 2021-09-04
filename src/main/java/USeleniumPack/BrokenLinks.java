package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

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
		
		/*
		 *
		 * 	Broken Links
		 * 	
		 * 	means when u click the link the shows error link not working
		 * 
		 * ===
		 * 	
		 * 	1. to get all the urls tied up to the links using Selenium
		 * 		Java methods will call url's and gets you the status code
		 * 
		 * So, we have to create a logic like
		 * 	
		 * 	2. if status code >400 then url is not working -> link which tied to url is broken link
		 * 
		 * 
		 * --
		 * 
		 * -> 	call the openConnection() method that is present in URL class
		 * So, we are creating object to call the method object.method
		 * 
		 * -> After calling this url it return HttpURLConnection and casting it
		 * 
		 * HttpURLConnection conn = (HttpURLConnection)new URL(path of links).openConnection();
		 * 
		 * 
		 * 	-> Now we have to call . there are many http method calls like get , post ,delete, head etc.,
		 * 
		 * 
		 * 
		 */
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/* 
		 *
		 *  -> checking single link
		 *
		 *	String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
         */
		
		//multiplelinks
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a =  new SoftAssert();
		
		for(WebElement link : links)
		{
		
		String url = link.getAttribute("href");
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		
		conn.setRequestMethod("HEAD");
		conn.connect(); //makes a call to that url and get a response back
		//to get the response status code
		int respcode = conn.getResponseCode();
		
		System.out.println(respcode);
		
		a.assertTrue(respcode<400, "the text of the broken link is"+" : "+ link.getText()+" "+"with status code"+" : "+respcode);
		
//		if(respcode>400)
//		{
//			System.out.println("the text of the broken link is"+" : "+ link.getText()+" "+"with status code"+" : "+respcode);
//			
//			Assert.assertTrue(false); //Hard Assertion: which stops the execution code immediately  
//		
//		}
		
		
		}
		
		a.assertAll(); //so , it checks all the links and after total program is done then it will show the error which which links are broken
		
		
		
		
		driver.quit();
		
		
		
	}

}
