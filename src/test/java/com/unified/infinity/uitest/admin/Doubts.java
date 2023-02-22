package com.unified.infinity.uitest.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.unified.reporting.ExtentManager;
import com.qa.unified.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.unified.infinity.libraries.UnifiedLibrary;
import com.unified.infinity.utils.DriverManager;
import com.unified.infinity.utils.ExcelUtil;

public class Doubts extends DriverManager {

	protected static String className;
	protected static HashMap<Integer, HashMap<String, String>> testData;
	protected UnifiedLibrary UnifiedLibrary;
	private ThreadLocal<String> testName = new ThreadLocal<>();
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeMethod
	public void methodsetup() throws Exception {
		UnifiedLibrary = new UnifiedLibrary();
	}

	@DataProvider(name = "getData", parallel = false)
	public Iterator<Object[]> getTestData() throws IOException {
		className = this.getClass().getSimpleName();
		testData = ExcelUtil.getTestData(className);
		ArrayList<Object[]> dataProvider = new ArrayList<Object[]>();
		for (Integer currentKey : testData.keySet()) {
			dataProvider.add(new Object[] { testData.get(currentKey) });
		}
		return dataProvider.iterator();
	}
	
	@Test(priority = 0, dataProvider = "getData")
	public void DoubtsSignUp(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Doubts SingUp Verification", "hey");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.DoubtsSignUp(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	}
	@Test(priority = 1, dataProvider = "getData")
	public void DoubtsSignIn(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Doubts SignIn Verification", "hey");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.DoubtsSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}}
		
	@Test(priority = 2, dataProvider = "getData")
	public void DoubtsSignInwithOTP(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Doubts SignInWithOTP Verification", "hey");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.DoubtsSigninwithOTP(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		sResult = UnifiedLibrary.DoubtsLogout(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		}
		
		
		@Test(priority = 3, dataProvider = "getData")
		public void DoubtsTakeup(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Doubts Takeup Verification", "hey");
			UnifiedLibrary.WebBrowser(testdata);

			
		sResult = UnifiedLibrary.DoubtsTakeup(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

	}
		@Test(priority = 4, dataProvider = "getData")
		public void DoubtsLogout(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Doubts Logout Verification", "hey");
			UnifiedLibrary.WebBrowser(testdata);

			
		sResult = UnifiedLibrary.DoubtsLogout(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

	}

	private void TearDown() throws Exception {
		throw new Exception("Test can't continue,  fail here!");
	}

	@AfterMethod
	public static void EndMethod() {
		ExtentManager.getReporter().flush();
		ExtentTestManager.endTest();
	}

	@AfterSuite
	public static void endSuite() {
		ExtentManager.getReporter().flush();
		ExtentTestManager.endTest();
	  }	
  }
