package listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import basetest.BaseClass2;

public class ListenerImplementation implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report config",true);
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report backup",true);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log("=="+testName+"Execution STARTED",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log("=="+testName+"Execution SUCCESS",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log("====="+testName+" FAILURE=====",true);
		Date d=new Date();
		String newDate = d.toString().replace(" ","_").replace(":","_");
		TakesScreenshot ts=(TakesScreenshot)BaseClass2.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./screenshots/"+testName+" "+newDate+".png");
		try {
		FileHandler.copy(temp, perm);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		Reporter.log("=="+testName+"Execution failed",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log("=="+testName+"Execution skipped",true);
		
	}

	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


