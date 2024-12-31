package base;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Browsersetup;
import utils.Constants;

public class Basetest extends TestListeners {
	 protected static WebDriver driver;
	 public static String getBase64() {
    	 return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
     }

//@Parameters("browserName")
@BeforeClass
public void opentheBrowser() throws InterruptedException{
	
	//configureExtentReport();
	//if (browser.equals("Firefox"))
	//    {driver= Browsersetup.openfirefoxbrowser();}
	//if (browser.equals("Edge"))
	  //  {driver = Browsersetup.openedgebrowser();}
	//else{driver= Browsersetup.openchromebrowser();}
	driver= Browsersetup.openchromebrowser();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		Thread.sleep(3000);
		driver.get(Constants.base_url);
}



@AfterClass
public void closetheBrowser() {
   // extent.flush();
	driver.close();
	System.gc();
}

}