package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidateError {

	public static void main(String[] args) throws FileNotFoundException , IOException, InterruptedException{
		
		
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		//by using this driver reference name we get all the methods which webdriver supports
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		System.out.println( driver.getTitle());
		
		//div[@id='div_login_error']
		
		
		driver.findElement(By.xpath("//input[starts-with(@id , 'login')]")).sendKeys("testcaseselenium");
		
		//using CSS Selector
		driver.findElement(By.cssSelector("#password")).sendKeys("wrongpassword");
		
		 
		driver.findElement(By.cssSelector("input[class='signinbtn']")).click();
		
		//to verify the error is visible or not
		System.out.println(driver.findElement(By.xpath("//div[@id='div_login_error']")).getText());
		Thread.sleep(2000);
		
		driver.quit();

	}

}
