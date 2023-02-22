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

public class UnifiedSignInUp extends DriverManager {
	
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
		
		@Test( priority=0,dataProvider = "getData",enabled=false)
		public void SignUP(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("SignUp Verification", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignUp(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}

		}

		@Test( priority=2,dataProvider = "getData")
		public void VerifyPhoneSignUp(HashMap<String, String> testdata) throws Exception 
		{
			String sResult = null;
			ExtentTestManager.startTest("Verify Phone number functinality", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.VerifyPhoneSignUp(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
		  }	
		
		@Test( priority=3,dataProvider = "getData")
		public void SignUpIncorrectOTP(HashMap<String, String> testdata) throws Exception 
		{
			String sResult = null;
			ExtentTestManager.startTest("SignUp with Incorrect OTP functionlality", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.SignUpIncorrectOTP(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
		  }	
		
		@Test( priority=4,dataProvider = "getData")
		public void SignUpIncorrectOtpEdit(HashMap<String, String> testdata) throws Exception 
		{
			String sResult = null;
			ExtentTestManager.startTest("SignUp with Incorrect OTP Edit Button", "");
			UnifiedLibrary.WebBrowser(testdata);
	       
			sResult = UnifiedLibrary.SignUpIncorrectOtpEdit(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
		  }	
		
		@Test(priority = 5, dataProvider = "getData",enabled=false)
		public void UnifiedOtp(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Unified SignIn with OTP", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedLoginWithOtp(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();
			}

			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
			
		}
		
		@Test(priority = 6, dataProvider = "getData")
		public void IncorrectOtp(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("SignIn with Incorrect OTP functionality", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedLoginWithIncorrectOtp(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
		   }

		@Test(priority = 7, dataProvider = "getData")
		public void UnifiedOtp3(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Edit OTP functionality", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.EditOTP(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
		   }
		
		@Test(priority = 8, dataProvider = "getData",enabled=false)
		public void UnifiedForgotPass(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Unified Forgot Password", "");
			UnifiedLibrary.WebBrowser(testdata);
			sResult = UnifiedLibrary.UnifiedForgotPassword(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}

			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();
			}
		}
		
		@Test(priority = 9, dataProvider = "getData")
		public void ForgotPassIncorrectOtp(HashMap<String, String> testdata) throws Exception
		{
			String sResult = null;
			ExtentTestManager.startTest("Forgot Password with Incorrect OTP verification", "");
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.ForgotPassIncorrectOtp(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
		  }

		@Test(priority = 10, dataProvider = "getData")
		public void ForgotPassEdit(HashMap<String, String> testdata) throws Exception 
		{
			String sResult = null;
			ExtentTestManager.startTest("Forgot Password Edit functionality", "");
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.ForgotPassEdit(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
		}
	
		@Test(priority = 11, dataProvider = "getData")
		public void SignInPassword(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("SignIn with Password", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}

			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}				
		}
	   
		@Test(priority = 12, dataProvider = "getData")
		public void SignInwithInvalidPhone(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Invalid SignIn functionality", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignInwithInValidUn(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();}
			}
		
		
		@Test(priority = 13, dataProvider = "getData")
		public void SignInwithInvalidPass(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Unified Login with Invalid Phonenumber and Password", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignInwithInValidUnandPwd(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}}
				
		

	
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
