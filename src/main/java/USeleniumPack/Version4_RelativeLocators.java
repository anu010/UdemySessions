package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class Version4_RelativeLocators {

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
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		/*
		 *	Relative locators - available only from selenium 4.0 version
		 *	
		 *		above(), below(), toLeftOf(), toRightOf(), near()
		 	
		 	above() – finds an element or elements located above a fixed element.
			below() – finds an element or elements located below a fixed element.
			near() – finds an element or elements located near a fixed element.
			toLeftOf() – finds an element or elements located to the left of a fixed element.
			toRightOf() – finds an element or elements located to the right of a fixed element.

		 *
		 *
		 */
		
		//above()
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		driver.findElement(RelativeLocator.withTagName("label")).above(nameEditBox)).getText();
		
		
		//below()
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateOfBirth']"));
		driver.findElement(RelativeLocator.withTagName("input")).below(dateOfBirth)).sendKeys("02/02/1992");
		
		
		//toLeftOf()
		WebElement iceCreamlabel = driver.findElement(By.xpath("//label[text()='Check me out ']"));
		driver.findElement(RelativeLocator.withTagName("input")).toLeftOf(iceCreamlabel)).click();
		
		
		//
		WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
		driver.findElement(RelativeLocator.withTagName("label")).toRightOf((radioBtn)).getText();
		
		
		
		
		
		
		driver.quit();
	}

}
