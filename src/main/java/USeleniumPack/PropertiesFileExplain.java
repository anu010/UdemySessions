package USeleniumPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileExplain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip);
		
		System.out.println( prop.getProperty("getsetProp"));

		
		prop.setProperty("getsetProp", "changedProperty");

		System.out.println(prop.getProperty("getsetProp"));

		FileOutputStream fos =new FileOutputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");

		prop.store(fos, null);
	}

}
