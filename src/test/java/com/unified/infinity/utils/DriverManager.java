package com.unified.infinity.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class DriverManager {

	public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD = new InheritableThreadLocal<WebDriver>();
	public static RemoteWebDriver Driver;
	public static ChromeDriver driver;
	String baseURL, nodeURL;
	

	@BeforeMethod																		//--Use this For Local system
	public void setup() throws InterruptedException, MalformedURLException
	{
		// Set the notification setting it will override the default setting
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("profile.default_content_setting_values.popups", 1);
		prefs.put("download.default_directory", System.getProperty("user.dir")+"\\src\\Data\\Downloads");
		
        // Create object of ChromeOption class
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
//		options.addArguments("--force-device-scale-factor=0.75");
		options.addArguments("--force-device-scale-factor=1.25");
		options.addArguments("--disable-dev-shm-usage--");
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("enable-automation");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-browser-side-navigation");		
		
		List<String> experimentalFlags = new ArrayList<String>();
		experimentalFlags.add("same-site-by-default-cookies@2");
		experimentalFlags.add("cookies-without-same-site-must-be-secure@1");
		experimentalFlags.add("enable-removing-all-third-party-cookies@2");
		
		HashMap<String, Object> chromeLocalStatePrefs = new HashMap<String, Object>();
		chromeLocalStatePrefs.put("browser.enabled_labs_experiments", experimentalFlags);
		options.setExperimentalOption("localState", chromeLocalStatePrefs);
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("applicationCacheEnabled", false);
		
		String path = System.getProperty("user.dir") + "\\chromedriver_win32\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver(capabilities);
    	driver.manage().window().maximize();
		WEB_DRIVER_THREAD.set(driver);
		Thread.sleep(2000);
	}
	public WebDriver getwebdriver() {
		WebDriver driver = WEB_DRIVER_THREAD.get();
		return driver;
	}
	public void waitfordriverload() throws InterruptedException {
		boolean Status = false;
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
	public static String Capturefullscreenshot() throws IOException {
		String screenshot2;
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(DriverManager.WEB_DRIVER_THREAD.get());		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(screenshot.getImage(), "png", bos);
		byte[] imageBytes = bos.toByteArray();
		screenshot2 = "data:image/png;base64," + Base64.getMimeEncoder().encodeToString(imageBytes);
		bos.close();
		return screenshot2;
	}	
	public static String CaptureElementscreenshot() throws IOException {
		String screenshot2;
		Screenshot screenshot = new AShot().takeScreenshot(DriverManager.WEB_DRIVER_THREAD.get());		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(screenshot.getImage(), "png", bos);
		byte[] imageBytes = bos.toByteArray();
		screenshot2 = "data:image/png;base64," + Base64.getMimeEncoder().encodeToString(imageBytes);
		bos.close();
		return screenshot2;
	}
//	@AfterMethod 																//--Use this For Local system
	public void closebrowser() {
	WEB_DRIVER_THREAD.get().close();		
	}
}
