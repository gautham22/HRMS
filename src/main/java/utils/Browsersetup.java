package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsersetup {
	
	public static WebDriver openchromebrowser() {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver(co);
		return driver;  }
		
		public static WebDriver openedgebrowser() {
			 WebDriverManager.edgedriver().setup();
			 WebDriver driver = new EdgeDriver();
			 return driver;}
		
		public static WebDriver openfirefoxbrowser() {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
		    return driver;}
		
		
		public static WebDriver opensafaribrowser() {
			WebDriverManager.safaridriver().setup();
			WebDriver driver = new SafariDriver();
			return driver;
		}

}
