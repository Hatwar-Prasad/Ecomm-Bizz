package Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BaseClass.baseClass;

public class Listners extends baseClass implements ITestListener{

	public Listners() throws IOException {
		super();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test has been started: "+result.getName() );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test has been passed: "+result.getName() );
		
		try {
			captureImages.takeScreenShots_pass(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test has been failed: "+result.getName() );
		try {
			captureImages.takeScreenShots_failure(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("test has been skipped: "+result.getName() );
		try {
			captureImages.takeScreenShots_skipped(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log("Execution started:");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Execution FInished:");
	}

	
	

}
