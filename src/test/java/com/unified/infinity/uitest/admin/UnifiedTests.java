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

import com.unified.infinity.libraries.UnifiedLibrary;
import com.unified.infinity.utils.DriverManager;
import com.unified.infinity.utils.ExcelUtil;
import com.qa.unified.reporting.ExtentManager;
import com.qa.unified.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class UnifiedTests extends DriverManager
{
	protected static String className;
	protected static HashMap<Integer, HashMap<String, String>> testData;
	protected UnifiedLibrary UnifiedLibrary;
	private ThreadLocal<String> testName = new ThreadLocal<>();
	static ExtentTest test;
	static ExtentReports report;

	
	@BeforeMethod
	public void methodsetup() throws Exception{
	UnifiedLibrary = new UnifiedLibrary();
	}
	@DataProvider(name = "getData", parallel = false)
	public Iterator<Object[]> getTestData() throws IOException {
		className = this.getClass().getSimpleName();
		testData = ExcelUtil.getTestData(className);	
		ArrayList <Object[]> dataProvider = new ArrayList<Object[]>();
		for (Integer currentKey : testData.keySet()) {
			dataProvider.add(new Object[] { testData.get(currentKey)});		
		}
		return dataProvider.iterator();}
	
//		Test Cases
	
	@Test(enabled=false,dataProvider = "getData")
	public void SignUpIn(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("SignUp Verification","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignUp(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };

	}
	@Test(priority=1,dataProvider = "getData")
	public void UnifiedOtp(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified SignIn with OTP","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedLoginWithOtp(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };	
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
	}
	
	@Test(priority=2,dataProvider = "getData")
	public void UnifiedForgotPass(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Forgot Password","");		
		UnifiedLibrary.WebBrowser(testdata);
		sResult = UnifiedLibrary.UnifiedForgotPassword(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };	
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
	}
	@Test(priority=3,dataProvider = "getData")
	public void SignWithPassword(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Unified Login with Password","");		
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };	
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
	}
	@Test(priority=4,dataProvider = "getData")
	public void PYPTests(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("PYP Test Verification","");		
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		 
	
		sResult = UnifiedLibrary.Select11Grade(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.PYPReports(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.PYPTests(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		
	}
	@Test(priority=5,dataProvider = "getData")
	public void MCTTests(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("MCT Test Verification","");		
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		 
	
		sResult = UnifiedLibrary.MCTTests(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		
	}
	
	@Test(priority=6,dataProvider = "getData")
	public void HomePage(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Home Page Verfication","");		
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		
		
		sResult = UnifiedLibrary.SetGoal(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		
		
	}
	@Test(priority=7,dataProvider = "getData")
	public void FreeMasterClass(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Free MasterClass Verfication","");		
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		
		
		sResult = UnifiedLibrary.FreeMasterClass(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };		
		
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
		ExtentTestManager.endTest();}
}
