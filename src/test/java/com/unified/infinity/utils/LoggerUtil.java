package com.unified.infinity.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.unified.infinity.utils.DriverManager;
import com.qa.unified.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class LoggerUtil {

static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("devpinoyLogger");
	
	public static void logConsoleMessage(String message) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new Date()) +" "+ message);
		
	}
	public static void printExtentLog(String status, String message) {
		logConsoleMessage(message);
		
		switch(status.toUpperCase()) {
		
		case "PASS":
			ExtentTestManager.getTest().log(LogStatus.PASS, message);
			break;
			
		case "FAIL":
			ExtentTestManager.getTest().log(LogStatus.FAIL, message);
			break;
			
		case "SKIP":
			ExtentTestManager.getTest().log(LogStatus.SKIP, message);
			break;
			
		case "ERROR":
			ExtentTestManager.getTest().log(LogStatus.ERROR, message);
			break;
			
		case "INFO":
			ExtentTestManager.getTest().log(LogStatus.INFO, message);
			break;
			
		case "WARNING":
			ExtentTestManager.getTest().log(LogStatus.WARNING, message);
			break;
		}

	}
	
	public static void printExtentLogWithScreenshot(String status, String message) throws IOException {
		logConsoleMessage(message);
		
		switch(status.toUpperCase()) {
		
		case "PASS":
			ExtentTestManager.getTest().log(LogStatus.PASS, message);
			ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.Capturefullscreenshot()));
			break;
			
		case "FAIL":
			ExtentTestManager.getTest().log(LogStatus.FAIL, message);
			ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.Capturefullscreenshot()));
			break;
			
		case "SKIP":
			ExtentTestManager.getTest().log(LogStatus.SKIP, message);
			ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.Capturefullscreenshot()));
			break;
			
		case "ERROR":
			ExtentTestManager.getTest().log(LogStatus.ERROR, message);
			ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.Capturefullscreenshot()));
			break;
			
		case "INFO":
			ExtentTestManager.getTest().log(LogStatus.INFO, message);
			ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.Capturefullscreenshot()));
			break;

			
		case "WARNING":
			ExtentTestManager.getTest().log(LogStatus.WARNING, message);
			ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.Capturefullscreenshot()));
			break;
		}}
//	Print Screenshot
		public static void printExtentLogWithScreenshot1(String status, String message) throws IOException {
			logConsoleMessage(message);
			
			switch(status.toUpperCase()) {
			
			case "PASS":
				ExtentTestManager.getTest().log(LogStatus.PASS, message);
				ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.CaptureElementscreenshot()));
				break;
				
			case "FAIL":
				ExtentTestManager.getTest().log(LogStatus.FAIL, message);
				ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.CaptureElementscreenshot()));
				break;
				
			case "SKIP":
				ExtentTestManager.getTest().log(LogStatus.SKIP, message);
				ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.CaptureElementscreenshot()));
				break;
				
			case "ERROR":
				ExtentTestManager.getTest().log(LogStatus.ERROR, message);
				ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.CaptureElementscreenshot()));
				break;
				
			case "INFO":
				ExtentTestManager.getTest().log(LogStatus.INFO, message);
				ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.CaptureElementscreenshot()));
				break;
				
			case "WARNING":
				ExtentTestManager.getTest().log(LogStatus.WARNING, message);
				ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addBase64ScreenShot(DriverManager.CaptureElementscreenshot()));
				break;
			}
	} 
	
}
