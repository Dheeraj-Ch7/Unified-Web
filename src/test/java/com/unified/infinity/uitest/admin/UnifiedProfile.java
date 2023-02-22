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

public class UnifiedProfile extends DriverManager
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
//	Profile Test Cases
	
	@Test(priority=0,dataProvider = "getData")
	public void Onlylogin(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("just  login","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		//sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		//if (sResult.equalsIgnoreCase("False")) {TearDown(); }
	}
	
	@Test(priority=1,dataProvider = "getData")
	public void ChangeProfilePicture(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Profile Picture Update","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		sResult = UnifiedLibrary.ChangeProfilepicture(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
	}
	
	@Test(priority=2,dataProvider = "getData")
	public void ChangePassword(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Change password","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		sResult = UnifiedLibrary.ChangePassword(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
	}
	
	@Test(priority=3,dataProvider = "getData",enabled=false)
	public void ChangePasswordOTP(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Change Password with OTP","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		sResult = UnifiedLibrary.ChangePasswordwithOTP(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
	}
	
	@Test(priority=4,dataProvider = "getData")
	public void ResetPassWithIncorrectData(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Reset Password with incorrect data","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		sResult = UnifiedLibrary.ResetPassWithIncorrectData(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }	
	 }
	@Test(priority=4,dataProvider = "getData")
	public void ResetPassWithIncorrectExistingPass(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Reset Password with incorrect existing password","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
		sResult = UnifiedLibrary.ResetPassWithIncorrectExistingPass(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		}
	
	@Test(priority=5,dataProvider = "getData")
	public void ProfilePage(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Profile Page-Grades,Streams and Boards Verification","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.VerifyGrades(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.VerifyStream(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
	
		sResult = UnifiedLibrary.VerifyBoard(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };	
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };	
	}
	
	@Test(priority=6, dataProvider = "getData", enabled = false)
	public void SelectGrade11(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{	
		String sResult = null;
		ExtentTestManager.startTest("Grade 11 Verfication","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.Select11Grade(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };	
	}
	
	@Test(priority=7,dataProvider = "getData")
	public void ProfileUpdate(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
	{			
		String sResult = null;
		ExtentTestManager.startTest("Profile Update","");		
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
		sResult = UnifiedLibrary.ProfileUpdate(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown(); };
		
	//	sResult = UnifiedLibrary.UnifiedLogOut(testdata);
	//	if (sResult.equalsIgnoreCase("False")) {TearDown(); };	
		
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
