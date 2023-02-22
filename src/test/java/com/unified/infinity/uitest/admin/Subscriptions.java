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

public class Subscriptions extends DriverManager {
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

	@Test(priority = 1, dataProvider = "getData")
	public void Subscriptions(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Subscriptions", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

		sResult = UnifiedLibrary.Select11Grade(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

//		sResult = UnifiedLibrary.SubscriptionsPage(testdata);
//		if (sResult.equalsIgnoreCase("False")) {TearDown(); };

		sResult = UnifiedLibrary.Subscriptions(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
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
		ExtentTestManager.endTest();
	}
}
