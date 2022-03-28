package com.vtiger.comcast.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * 
 * @author yogesh
 *
 */
public class ListenersImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"======> start");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"======> execution successfull");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"======> execution failed");
		System.out.println(result.getThrowable());
		
		try {
			new WebDriverUtility().takeScreenShot(BaseClass.sDriver, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"======> skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("start");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("finish");
		
	}
	

}
