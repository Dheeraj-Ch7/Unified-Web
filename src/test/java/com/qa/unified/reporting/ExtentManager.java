package com.qa.unified.reporting;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.unified.infinity.utils.DriverManager;

public class ExtentManager extends DriverManager {

	//  private static String filename;

	  private static ExtentReports extent;
	  @BeforeSuite
	  public synchronized static ExtentReports getReporter(){
	      if(extent == null){
	          //Set HTML reporting file location
	          String workingDir = System.getProperty("user.dir");
	          DateFormat df = new SimpleDateFormat("dd-MM-yyyy-HH_mm_ss");
	          DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
	          //File config=new File();   
	         //filename = workingDir+"\\ExtentReports\\InfinityLearn-"+df1.format(new Date())+"\\ExtentTest -"+df.format(new Date())+".html";
	        //  extent = new ExtentReports(filename , true);

	          extent = new ExtentReports(workingDir+"\\ExtentReports\\Unified-"+df1.format(new Date())+"\\ExtentTest -"+df.format(new Date())+".html", true);
	          extent.loadConfig(new File(workingDir+"\\config-report.xml"));
	          
	      }	
	      return extent;
	      
	  }}
