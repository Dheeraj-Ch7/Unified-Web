
package com.unified.infinity.utils;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;	

public class DriverManager {

	public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD = new InheritableThreadLocal<WebDriver>();
	public static RemoteWebDriver Driver;
	public static ChromeDriver driver;
	String baseURL, nodeURL;

	@BeforeMethod // --Use this For Local system
	public void setup() throws InterruptedException, MalformedURLException {
		// Set the notification setting it will override the default setting
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("profile.default_content_setting_values.popups", 1);
		prefs.put("download.default_directory", System.getProperty("user.dir") + "\\src\\Data\\Downloads");

		// Create object of ChromeOption class
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
		// options.addArguments("--force-device-scale-factor=0.75");
		options.addArguments("high-dpi-support=0.75");
		options.addArguments("--force-device-scale-factor=1.30");
		options.addArguments("--disable-dev-shm-usage--");
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("--window-size=1980,1020");
		options.addArguments("enable-automation");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--incognito"); // to run script in incognito window

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
		
		//--------------------------
		
		
		
		//------------------------
	}

	public void waitfordriverload() throws InterruptedException {
		boolean Status = false;
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.WEB_DRIVER_THREAD.get();
		for (int i = 1; i < 10; i++) {
			if (js == null) {
				Thread.sleep(250);
				js = (JavascriptExecutor) DriverManager.WEB_DRIVER_THREAD.get();
				continue;
			} else {
				try {
					while (!(js.executeScript("return document.readyState").equals("complete"))) {
						// System.out.println("dom state is" +(js.executeScript("return
						// document.readyState")));
						Thread.sleep(500);
					}
					Status = true;
					if (Status = true) {
						Thread.sleep(250);
						break;
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
	}

	public static String Capturefullscreenshot() throws IOException {
		String screenshot2;
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(DriverManager.WEB_DRIVER_THREAD.get());
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


	@AfterSuite
	public void sendEmail() {
		
		final String username = "praveenreddy.t@infinitylearn.com"; 
		final String password = "Praveenkr@55";	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");
		
	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("c_praveenreddy.t@infinitylearn.com")); //From email
	        message.setRecipients(Message.RecipientType.TO,
	        		InternetAddress.parse("dheeraj.ch@infinitylearn.com"));
	              /*  InternetAddress.parse("venkataramireddy@infinitylearn.com"+","+
	                		              "anil.kommineni@infinitylearn.com"+","+ 
	                		              "dheeraj.ch@infinitylearn.com"+","+ 
	                		              "mohit.sharma@infinitylearn.com"+","+ 
	                		              "ramesh.naidu@infinitylearn.com"+","+ 
	                		              "ram.sb@infinitylearn.com"+","+ 
	                		              "shwetabh.garg@infinitylearn.com"+","+              // To emailss
	                		              "sivakumar.vaddi@infinitylearn.com"+","+ 
	                		              "sivakuru.natarajan@infinitylearn.com"+","+ 
	                		              "sowmika.venkatesh@infinitylearn.com"+","+ 
	                		              "subramanyam.kasichayanula@infinitylearn.com"+","+ 
	                		              "varsha.agarwal@infinitylearn.com"));;*/
                                        
	        
	        message.setSubject("UAM Sanity Automation Report-Preprod");
	        message.setText("PFA");
	        
	        //--------------------Folder--------------
	        //C:\Users\Admin\eclipse-workspace\Pravin_PreProd\ExtentReports
	        File dir1 = new File(System.getProperty("user.dir")+"\\ExtentReports");
	        File[] folders = dir1.listFiles(File::isDirectory);
	     // sort folders based on the last modified time
	        Arrays.sort(folders, new Comparator<File>(){
	            public int compare(File f1, File f2) {
	                return Long.compare(f2.lastModified(), f1.lastModified());
	            }
	        });
	        // the latest folder will be at the first index of the sorted list
	        File latestFolder = folders[0];
	        System.out.println("Latest folder: " + latestFolder.getName());
	        String ReportFolder = latestFolder.getName();
	        
	        
	        
	        //--------------------File----------------
	        File dir = new File(System.getProperty("user.dir")+"\\ExtentReports\\"+ReportFolder);
	        File[] files = dir.listFiles();

	        // sort files based on the last modified time
	        Arrays.sort(files, new Comparator<File>(){
	            public int compare(File f1, File f2) {
	                return Long.compare(f2.lastModified(), f1.lastModified());
	            }
	        });
	        // the latest file will be at the first index of the sorted list
	        File file = files[0];
	        System.out.println("Latest file: " + file.getName());    
	        String FileName = file.getName();
	        System.out.println(FileName);        
	        BodyPart messageBodyPart = new MimeBodyPart();
	        //messageBodyPart.setText("C:\\Users\\Admin\\git\\repository\\Jenkins_PreProd_IL\\ExtentReports\\"+ReportFolder+"\\"+FileName);
	        messageBodyPart.setText("Hi Team,\n\nPlease find Automation report attached,\n\n\nKind Regards,\nTeam Automation");
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        messageBodyPart = new MimeBodyPart();
	        String fileName1 = System.getProperty("user.dir")+"\\ExtentReports\\"+ReportFolder+"\\"+FileName;
	        DataSource source = new FileDataSource(fileName1);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName1);
	        multipart.addBodyPart(messageBodyPart);
	        message.setContent(multipart);
	        Transport.send(message);
	        System.out.println("Done");

	    } catch (MessagingException e) {
	    
	        throw new RuntimeException(e);
	    }
	}	
}