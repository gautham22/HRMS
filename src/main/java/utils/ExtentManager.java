package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.ExtentManager;

public class ExtentManager {
	
	
	 public   ExtentSparkReporter spark; 
	 public  ExtentReports report;
   protected static ThreadLocal<ExtentTest> extent= new ThreadLocal<ExtentTest>();
   
   
   
  
	 
	 public void configureExtentReport() {
		 
		 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		 Date date = new Date();
		 String actualDate = format.format(date);
		 
		 String reportPath = System.getProperty("user.dir")+"/Reports/Automation_Report_"+actualDate+" .html";
		 
		 		 
		    spark= new ExtentSparkReporter(reportPath);
			report = new ExtentReports();
			report.attachReporter(spark);
			
			//Set Environment
			report.setSystemInfo("Machine","TestPc1");
			report.setSystemInfo("OS","Windows10");
			report.setSystemInfo("Browser","ChromeBrowser");
			report.setSystemInfo("User","QA");
		
		    //Set LookandFeel Of Report
		spark.config().setDocumentTitle("Automation Testing Report");
		spark.config().setTheme(Theme.DARK);
		}
	
	
	private static ExtentManager instance=new ExtentManager();
	
	public static  ExtentManager getInstance() {
		return instance;
	}
	
	
	
	public void setTest(ExtentTest testObject) {
		extent.set(testObject);
	}
	
	
	 public ExtentTest getTest() {
	       return extent.get();
	    }
}
	
	
	
	
	
	
	
	
	
	
	
	
