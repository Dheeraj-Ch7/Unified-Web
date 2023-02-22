package com.unified.infinity.utils;

import java.io.File;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.unified.infinity.utils.DriverManager;
import com.unified.infinity.utils.LoggerUtil;

public class WebInteractUtil extends DriverManager {
//	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("devpinoyLogger");

//	To Launch the WebApplication
	public static void launchWebApp(String APP_URL) throws Exception {
		
		try {
			
			DriverManager.WEB_DRIVER_THREAD.get().navigate().to(APP_URL);		
		} catch (Exception e) {
			LoggerUtil.printExtentLogWithScreenshot("Fail","Could not launch the application: "+APP_URL+ " due to the exception "+e.toString());
			TearDown(e.toString());
		}
	}
//	To Enter the Values to the Input fields
	public static void SendKeys(WebElement webElement, String text) throws Exception {
		try {
			waitForElementToBeVisible(webElement, 60);
			webElement.sendKeys(text);
			LoggerUtil.logConsoleMessage("Value "+text+" Passed to the webelement "+webElement.toString().split("xpath: //")[1] + "Successfully");
		} catch (Exception e) {
			LoggerUtil.printExtentLogWithScreenshot("Fail","Unable to Enter Value to the Object  "+ webElement.toString().split("xpath: //")[1] +" due to the exception "+e.toString());
			TearDown(e.toString());
		}
	}

	public static void Click(WebElement webElement) throws Exception {
		boolean status = false;
		int j = 0;
		
		String sException = null;
			try {
				webElement.click();
				status = true;
			} catch (Exception e1) {
				for (int i = 0; i <= 10; ++i) {
					try {
							Thread.sleep(3000);
							waitForElementToBeVisible(webElement, 5);
							Thread.sleep(250);
			    			webElement.click();
			    			status = true;
							break;
					} catch (Exception e) {
						sException = e.toString();
						j = i+1;
						continue;
					}	
				}
			}
			if (j > 10) {
				LoggerUtil.printExtentLogWithScreenshot("Fail","Unable to click webelement: " + webElement.toString()+ "due to " +sException);
				TearDown(sException);
			}
	}
	
//	Wait for element to Display
	public static boolean waitForElementToBeVisible(WebElement webElement, int timeout) {
		boolean status = false;
		
		try {
			FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverManager.WEB_DRIVER_THREAD.get())
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(Exception.class);
			fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));
			LoggerUtil.logConsoleMessage("WebElement "+webElement.toString().split("xpath: //")[1] +" was Visible");
			status = true;
		} catch (Exception e) {
			
		}
		
		return status;
	}
	
	public static boolean isPresent(WebElement webElement, int timeout) throws Exception {
		boolean status = false;
		
		try {
			FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverManager.WEB_DRIVER_THREAD.get())
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(Exception.class);
			fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));
			LoggerUtil.logConsoleMessage("WebElement "+webElement.toString().split("xpath: //")[1] +" was Present");
			status = true;
		} catch (Exception e) {
			LoggerUtil.printExtentLogWithScreenshot("Fail","Unable to find the element "+ webElement.toString().split("xpath: //")[1] +" due to the exception "+e.toString());
			TearDown(e.toString());
		}	
		return status;
	}

	public static boolean selectByValue(WebElement webElement, String value) throws Exception {
    	boolean status = false;
      	
    	try {
    			waitForElementToBeVisible(webElement, 60);					
				List<WebElement> options = webElement.findElements(By.tagName("option"));
				for (WebElement option: options) {
					String CurrentValue = option.getText();
					if (CurrentValue.equals(value)) {
						option.click();
						LoggerUtil.logConsoleMessage("The Value "+value+ " was selected from the dropdown "+webElement.toString().split("xpath: //")[1] + " Successfully");
				//		LoggerUtil.printExtentLog("Pass", "The Value "+value+ " was selected from the dropdown "+webElement.toString().split("xpath: //")[1] + " Successfully");
						status = true;
						break;
					}
				}
				
		} catch (Exception e) {
			LoggerUtil.printExtentLogWithScreenshot("Fail","Unable to select the value from listbox: "+ webElement.toString().split("xpath: //")[1] +" due to the exception "+ e.toString());
			TearDown(e.toString());
		}
		
		return status;
	}
	
	
	public static String getWebElementText(WebElement webElement) {
		
		String sText = webElement.getText();
		return sText;
		
	}
	
	public static void Waittilljquesryupdated() throws InterruptedException, SocketTimeoutException {
//		JavascriptExecutor js = null;
		boolean Status = false;
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.WEB_DRIVER_THREAD.get();
		for (int i=1; i<10; i++) {
			if (js == null) {
				Thread.sleep(250);
				js = (JavascriptExecutor) DriverManager.WEB_DRIVER_THREAD.get();
				continue;
			} else {
				try {
					while(!(js.executeScript("return document.readyState").equals("complete")))
					{
	//					System.out.println("dom state is" +(js.executeScript("return document.readyState")));
						Thread.sleep(500);
					}
					Status = true;
					if (Status = true) { Thread.sleep(250); break; }
				} catch (Exception e) {
					continue;
				}
			}
			}
		}	
//	Added for Invoice downloaded file
	public static void TearDown(String Message) throws Exception {
		throw new Exception("Test can't continue, fail here!");
	}
/*	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}*/
}
