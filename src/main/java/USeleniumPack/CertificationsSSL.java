package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CertificationsSSL {

public static void main(String[] args) throws FileNotFoundException ,IOException{


	//SSl certificates

	//Desired capabilities=
	//general chrome profile
		
	
	/*
	 *	shows a certification ur connection is private.
	 *in such cases to proceed anyway
	 *
	 */
	
	
	DesiredCapabilities ch=DesiredCapabilities.chrome();
		
		//ch.acceptInsecureCerts();
		
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


		//Below to your local browser
		
		ChromeOptions c= new ChromeOptions();
		c.merge(ch); //passing(ch) - to get all the values mentioned in desired capabilites
		
		
		
		
		//Chrome driver set property
		
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
		WebDriver driver = new ChromeDriver(c); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.




}

}

