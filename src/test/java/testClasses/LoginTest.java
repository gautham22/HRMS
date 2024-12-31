package testClasses;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Basetest;

import pomclass.Loginpage;
import utils.Constants;
import utils.ExcelUtility;


public class LoginTest extends Basetest {
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
	
	//@DataProvider(name ="LoginData")
    //public Object [][] getData1() throws IOException{
	//ExcelUtility xceluti= new ExcelUtility();
    //int totrows=xceluti.getRowCount("Login");
    //int totcol =xceluti.getCellCount("Login",1);
    //String loginData[][]=new String[totrows][totcol];

/*for(int i=1;i<=totrows;i++) //1
{
	for(int j=0;j<totcol;j++) //0
	{loginData[i-1][j]=xceluti.getCellData("Login", i, j);}
}
    return loginData;
}*/

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




















