 package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import utils.ExtentManager;

public class TestListeners extends ExtentManager implements ITestListener  {
	
	
	ExtentTest test;
	String screenshotPath ;

	public void onTestStart(ITestResult result) {

		test =report.createTest(result.getMethod().getMethodName());
		ExtentManager.getInstance().setTest(test);;
	}

	public void onTestSuccess(ITestResult result) {
	ExtentManager.getInstance().getTest().log(Status.PASS,MarkupHelper.createLabel("The Test Case :  "+result.getMethod().getMethodName()+" is Passed.", ExtentColor.GREEN)).addScreenCaptureFromBase64String(Basetest.getBase64());
	}

	public void onTestFailure(ITestResult result) {
		
	ExtentManager.getInstance().getTest().log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case is :  "+result.getMethod().getMethodName(), ExtentColor.RED)).addScreenCaptureFromBase64String(Basetest.getBase64());	
	}

	public void onTestSkipped(ITestResult result) {
	ExtentManager.getInstance().getTest().log(Status.SKIP,MarkupHelper.createLabel("Name of the Skipped test case is :  "+result.getMethod().getMethodName(), ExtentColor.YELLOW)).addScreenCaptureFromBase64String(Basetest.getBase64());	
	}

	public void onStart(ITestContext context) {
		configureExtentReport();	
	}

	public void onFinish(ITestContext context) {
		report.flush();	
	}
	
	
	


	
	 
}
