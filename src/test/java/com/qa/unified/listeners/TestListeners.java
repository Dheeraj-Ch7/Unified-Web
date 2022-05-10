package com.qa.unified.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.unified.infinity.utils.DriverManager;
import com.unified.infinity.utils.LoggerUtil;

public class TestListeners  implements IRetryAnalyzer, ITestListener{

	int counter = 0;
	int retryLimit = 1;
	
	@Override
    public void onStart(final ITestContext context) {
		//TODO Auto-generated method stub
    }

    @Override
    public void onTestStart(final ITestResult result) {
   	
    }

    @Override
    public void onFinish(final ITestContext context) {       
		
	
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
    	teardownTest(result);
       
    }
    
    public void onTestError(final ITestResult result) {
    	teardownTest(result);
       
    }
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    	teardownTest(result);
    	
    }

    @Override
    public void onTestFailure(final ITestResult result) {
    	teardownTest(result);
        
    }

    @Override
    public void onTestSkipped(final ITestResult result) {
    	teardownTest(result);
        
    }

    private void teardownTest(ITestResult result) {    		
    	String status = result.isSuccess() ? "SUCCESS" : "FAILURE";
    	LoggerUtil.logConsoleMessage(status);
    	try {
    		DriverManager.WEB_DRIVER_THREAD.get().close();
    	} catch (Exception e) {
//    		Unable to Close the driver as it might got closed already
    	}
    	
//    	try {
//    		ExtentManager.getReporter().flush();
//    		ExtentTestManager.endTest();
//    	} catch (Exception e) {
//    		
//    	}
       	
    }

	@Override
	public boolean retry(ITestResult result) {
		if(counter < retryLimit)
		{
			counter++;
			return true;
		}		
		return false;		
	}
	

	
	
	
	
}
