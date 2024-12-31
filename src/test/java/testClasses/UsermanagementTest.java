package testClasses;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Basetest;

import pomclass.Loginpage;
import utils.Constants;
import utils.ExcelUtility;


public class UsermanagementTest extends Basetest {
	Loginpage lpage;
	
	
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		Thread.sleep(1000);
		driver.get(Constants.base_url);
	}
	
	

	@Test
	public void VerifyLogin() throws InterruptedException {
	lpage = new Loginpage(driver);
    lpage.Login();
	Thread.sleep(2000);
	
	}
	
}
