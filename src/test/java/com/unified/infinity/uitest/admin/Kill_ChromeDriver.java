package com.unified.infinity.uitest.admin;


import java.io.IOException;


public class Kill_ChromeDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		Process[] chromeDriverProcesses = Process.GetProcessesByName("chromedriver");
//		foreach(var chromeDriverProcess in chromeDriverProcesses){
//		 chromeDriverProcess.Kill();
//		}
		
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

	}
}

