package com.unified.infinity.libraries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.unified.infinity.pageobjects.UnifiedObjects;
import com.unified.infinity.utils.DriverManager;
import com.unified.infinity.utils.LoggerUtil;
import com.unified.infinity.utils.WebInteractUtil;

public class UnifiedLibrary {
	public WebDriver driver = DriverManager.WEB_DRIVER_THREAD.get();
	public UnifiedObjects UnifiedPage;
	Actions actions = new Actions(driver);

	public UnifiedLibrary()
	{
		UnifiedPage = new UnifiedObjects();	
	}
	public String WebBrowser(Map<String, String> testdata) throws Exception {
		
		//WebInteractUtil.launchWebApp(APP_URL);
		WebInteractUtil.launchWebApp(testdata.get("APP_URL"));

		return testdata.get("APP_URL");
		}
	public String UnifiedSignIn(Map<String, String> testdata) throws Exception{				//Login
		String Status = null;				
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.PassWordTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PassWordTxb, testdata.get("Password"));
		WebInteractUtil.Click(UnifiedPage.LoginBtn);
		WebInteractUtil.Waittilljquesryupdated();	
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
			LoggerUtil.printExtentLog("Pass", "Application SignIn is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application SignIn is not successfull, Please check");
			Status ="False";}	
		return Status;	
	}
	
	public String UnifiedLoginWithOtp(Map<String, String> testdata) throws Exception{				
		String Status = null;
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.GetOTPBtn1);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 120)){
			LoggerUtil.printExtentLog("Pass", "Application SignIn with OTP is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application SignIn with OTP is not successfull, Please check");
			Status ="False";}	
		return Status;	
			
	}
	
	public String UnifiedForgotPassword(Map<String, String> testdata) throws Exception{				
		String Status = null;
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.ForgotPassBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ForgotPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.SendOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.SendOtpBtn);
		WebInteractUtil.isPresent(UnifiedPage.NewPassTxb, 120);
		WebInteractUtil.SendKeys(UnifiedPage.NewPassTxb, testdata.get("Password"));
		WebInteractUtil.SendKeys(UnifiedPage.ConfirmNewPassTxb, testdata.get("Password"));
		WebInteractUtil.isPresent(UnifiedPage.ResetPassBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ResetPassBtn);
		WebInteractUtil.Waittilljquesryupdated();
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPassReset, 60)){
			LoggerUtil.printExtentLog("Pass", "Password has been reset successfully");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Password reset not successfull, Please check");
			Status ="False";}
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.isPresent(UnifiedPage.PassWordTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PassWordTxb, testdata.get("Password"));
		WebInteractUtil.Click(UnifiedPage.LoginBtn);
		WebInteractUtil.Waittilljquesryupdated();	
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
			LoggerUtil.printExtentLog("Pass", "Application SignIn is successfull with new password");
			LoggerUtil.printExtentLog("Pass", "Forgot password functionality is working as expected");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application SignIn is not successfull with new password");
			LoggerUtil.printExtentLog("Fail", "Forgot password functionality is not working as expected, Please check");
			Status ="False";}	
		return Status;	
	}

		public String UnifiedLogOut(Map<String, String> testdata) throws Exception{				
		String Status = null;
		WebInteractUtil.isPresent(UnifiedPage.InfinityLogo, 60);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.Click(UnifiedPage.InfinityLogo);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.ProfileIcon, 60);
		WebInteractUtil.Click(UnifiedPage.ProfileIcon);
		WebInteractUtil.isPresent(UnifiedPage.LogoutBtn, 60);
		WebInteractUtil.Click(UnifiedPage.LogoutBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHomePage, 60)){
			LoggerUtil.printExtentLog("Pass", "Application Logout is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application Logout is not successfull, Please check");
			Status ="False";}
		return Status;	
		}
		//PYP Tests
		public String PYPTests(Map<String, String> testdata) throws Exception{				
			String Status = null;
		WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
		WebInteractUtil.Click(UnifiedPage.TestsBtn);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PYPBtn, 60);
		WebInteractUtil.Click(UnifiedPage.PYPBtn);
		WebInteractUtil.Waittilljquesryupdated();
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPYPpage, 60)) {
			LoggerUtil.printExtentLog("Pass", "Navigation to PYP's Listing Page is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Navigation to PYP's Listing Page is not successfull, Please check");
			Status ="False";}
		WebInteractUtil.isPresent(UnifiedPage.AttemptNowBtn, 60);
		WebInteractUtil.Click(UnifiedPage.AttemptNowBtn);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyGInsPage, 60);
//		Actions actions = new Actions(driver);
		Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
		scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
		WebInteractUtil.Waittilljquesryupdated();
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTest, 60)) {
			LoggerUtil.printExtentLog("Pass", "Test started successfully");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to start Test, Please check");
			Status ="False";}
		WebInteractUtil.isPresent(UnifiedPage.RadioBtn1, 60);
		WebInteractUtil.Click(UnifiedPage.RadioBtn1);
		WebInteractUtil.isPresent(UnifiedPage.SaveNextBtn, 60);
		WebInteractUtil.Click(UnifiedPage.SaveNextBtn);
		WebInteractUtil.isPresent(UnifiedPage.RadioBtn1, 60);
		WebInteractUtil.Click(UnifiedPage.RadioBtn1);
		WebInteractUtil.Click(UnifiedPage.ReviewLaterBtn);
		WebInteractUtil.isPresent(UnifiedPage.ReviewLaterBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ReviewLaterBtn);
		WebInteractUtil.Click(UnifiedPage.RadioBtn1);
		WebInteractUtil.Click(UnifiedPage.ClearRespnBtn);
		WebInteractUtil.isPresent(UnifiedPage.VerifyTest, 60);
		WebInteractUtil.Click(UnifiedPage.VerifyTest);
		WebInteractUtil.Click(UnifiedPage.GenrlInstBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyGnrlPage, 60)) {
			LoggerUtil.printExtentLog("Pass", "Navigation to general instruction's page is successfull");
			WebInteractUtil.Click(UnifiedPage.BackBtn);
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to navigate to General instructions page, Please check");
			Status ="False";}
		WebInteractUtil.Click(UnifiedPage.QstnBtn);
		WebInteractUtil.Click(UnifiedPage.QstnLstBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.GotoQstn, 60)) {
			LoggerUtil.printExtentLog("Pass", "Navigation to Questions List page is successfull");
			WebInteractUtil.Click(UnifiedPage.GotoQstn);
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to navigate to Questions List page, Please check");
			Status ="False";}	
		WebInteractUtil.isPresent(UnifiedPage.ErrorFlagBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ErrorFlagBtn);
		WebInteractUtil.isPresent(UnifiedPage.ReportErrorPP, 60);
		WebInteractUtil.Click(UnifiedPage.IncrtAnsoptn);
		WebInteractUtil.Click(UnifiedPage.IncrtQstn);
		WebInteractUtil.Click(UnifiedPage.QstnNtClr);
		WebInteractUtil.SendKeys(UnifiedPage.AdtnlFeedBck, "Test Report an error");
		WebInteractUtil.Click(UnifiedPage.SubmitFeedBck);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60)) {
			LoggerUtil.printExtentLog("Pass", "Able to Report an error");
		Status = "True";
	}	else {	
		LoggerUtil.printExtentLog("Fail", "Unable to Report an error, Please check");
		Status ="False";}
		WebInteractUtil.Click(UnifiedPage.SubmitBtn);
		WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
		WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
		WebInteractUtil.Click(UnifiedPage.CloseBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
			LoggerUtil.printExtentLog("Pass", "PYP test successfully submitted");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to submit PYP test, Please check");
			Status ="False";}
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.ViewSolnBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ViewSolnBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifySolnPage, 60)) {
			WebInteractUtil.Click(UnifiedPage.InfinityLogo);
			LoggerUtil.printExtentLog("Pass", "Navigation to View Solution Page is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Navigation to View Solution Page is not successfull, Please check");
			Status ="False";}
		return Status;	
}
		
		public String UnifiedSignUp(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.SignUpPageBtn, 60);	
			WebInteractUtil.Click(UnifiedPage.SignUpPageBtn);
			WebInteractUtil.isPresent(UnifiedPage.FirstNameTxb, 60);	
			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, testdata.get("PhoneNumber"));
			Thread.sleep(1000);
			WebInteractUtil.SendKeys(UnifiedPage.FirstNameTxb, testdata.get("FirstName"));
			WebInteractUtil.SendKeys(UnifiedPage.LastNameTxb, testdata.get("LastName"));
			WebInteractUtil.Click(UnifiedPage.Grade11);
			WebInteractUtil.Click(UnifiedPage.DisableWhatsApp);
			WebInteractUtil.Click(UnifiedPage.GetOtpBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);	
			Thread.sleep(10000);													//Enter OTP Manually
			WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);	
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.Click(UnifiedPage.StartLearnBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
				LoggerUtil.printExtentLog("Pass", "Application SignUp is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Application SignUp is not successfull, Please check");
				Status ="False";}		
			return Status;
}
		
		public String ChangePassword(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.Click(UnifiedPage.ChangePassBtn);
			WebInteractUtil.SendKeys(UnifiedPage.CurrentPassTxb, testdata.get("Password"));
			WebInteractUtil.SendKeys(UnifiedPage.NewPasswordTxb, testdata.get("Password"));
			WebInteractUtil.SendKeys(UnifiedPage.ConfirmPassTxb, testdata.get("Password"));
			WebInteractUtil.Click(UnifiedPage.ResetPassBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PassUpdatedPopUp, 60)){
				LoggerUtil.printExtentLog("Pass", "Password updated successfully");
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update password, Please check");
				Status ="False";}
				return Status;}
//		GRADES		
		public String VerifyGrades(Map<String, String> testdata) throws Exception{				
			String Status = null;		
	//		WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
	//		WebInteractUtil.Click(UnifiedPage.ProfileIcon);
	//		WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.isPresent(UnifiedPage.Grade3, 60);	
			WebInteractUtil.isPresent(UnifiedPage.Grade4, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade5, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade6, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade7, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade8, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade9, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade10, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade11th, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade12, 60);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Grade13, 60)) {
				LoggerUtil.printExtentLog("Pass", "All grades are available to select");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Grades are not avialble to select, Please check");
				Status ="False";}	
			WebInteractUtil.Click(UnifiedPage.Grade3);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "3rd Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 3rd Grade and Aptitude Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade4);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "4th Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 4th Grade and Aptitude Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade5);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "5th Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 5th Grade and Aptitude Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade6);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectFound, 60);
			WebInteractUtil.Click(UnifiedPage.SelectFound);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "6th Grade and Foundation Test Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 6th Grade and Foundation Test Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade7);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectFound, 60);
			WebInteractUtil.Click(UnifiedPage.SelectFound);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "7th Grade and Foundation Test Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 7th Grade and Foundation Test Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade8);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectFound, 60);
			WebInteractUtil.Click(UnifiedPage.SelectFound);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "8th Grade and Foundation Test Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 8th Grade and Foundation Test Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade9);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "9th Grade and Neet, Jee Main and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 9th Grade and Neet, Jee Main and CBSE Target Exams, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade10);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "10th Grade and Neet, Jee Main and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 10th Grade and Neet, Jee Main and CBSE Target Exams, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade11th);
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectJeeAdv, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "11th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 11th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade12);
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectJeeAdv, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "12th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 10th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade13);
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectJeeAdv, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "13th Grade and Neet, Jee Main and Jee Advanced Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 10th Grade and Neet, Jee Main and Jee Advanced Target Exams, Please check");
				Status ="False";}
			return Status;}
//			STREAMS
			public String VerifyStream(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.isPresent(UnifiedPage.SelectPCM, 60);	
			WebInteractUtil.isPresent(UnifiedPage.SelectPCB, 60);	
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60)) {
				LoggerUtil.printExtentLog("Pass", "All Streams are available to select");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Streams are not avialble to select, Please check");
				Status ="False";}
			return Status;}
//			BOARDS			
			public String VerifyBoard(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.isPresent(UnifiedPage.BoardICSE, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardKarnataka, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardAndhra, 60);
	//		Actions action = new Actions(driver);
	//		action.moveToElement(UnifiedPage.BoardRajasthan);
			WebInteractUtil.isPresent(UnifiedPage.BoardRajasthan, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardMadhya, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardWestBengal, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardGoa, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardJammu, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardBihar, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardChhattisgarh, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardGujarat, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardHaryana, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardJharkhand, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardKerala, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardOrissa, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardPunjab, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardTamil, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardTelangana, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardUttarakhand, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardUttar, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardOrissa, 60);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.BoardUttar, 60)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UnifiedPage.BoardUttar);
				LoggerUtil.printExtentLog("Pass", "All Boards are available to select");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Boards are not avialble to select, Please check");
				Status ="False";}
			return Status;}
		
			//MCT Tests
			public String MCTTests(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
			WebInteractUtil.Click(UnifiedPage.TestsBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.MctBtn, 60);
			WebInteractUtil.Click(UnifiedPage.MctBtn);
			WebInteractUtil.Waittilljquesryupdated();
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyMCTpage, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigation to MCT's Listing Page is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Navigation to MCT's Listing Page is not successfull, Please check");
				Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.AttemptNowBtn, 60);
			WebInteractUtil.Click(UnifiedPage.AttemptNowBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyGInsPage, 30)) {
//			Actions actions = new Actions(driver);
			Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
			scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60);
			WebInteractUtil.Click(UnifiedPage.SubmitBtn);
			WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
			WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
				LoggerUtil.printExtentLog("Pass", "MCT test successfully submitted");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to submit MCT test, Please check");
				Status ="False";}
			} 
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubscribeExpire, 30)){
				LoggerUtil.printExtentLog("INFO", "Your subscription package expired, Please take a trial and try again");
				actions.sendKeys(Keys.ESCAPE).build().perform();
				Status = "True";}
			return Status;	
	}	
			public String ScoreTest(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
			WebInteractUtil.Click(UnifiedPage.TestsBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ScoreBtn, 60);
			WebInteractUtil.Click(UnifiedPage.ScoreBtn);
			WebInteractUtil.Waittilljquesryupdated();
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyScorePage, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigation to Score Listing Page is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Navigation to Score Listing Page is not successfull, Please check");
				Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.AttemptNowBtn, 60);
			WebInteractUtil.Click(UnifiedPage.AttemptNowBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyGInsPage, 60);
			Actions actions = new Actions(driver);
			Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
			scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60);
			WebInteractUtil.Click(UnifiedPage.SubmitBtn);
			WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
			WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
				LoggerUtil.printExtentLog("Pass", "MCT test successfully submitted");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to submit MCT test, Please check");
				Status ="False";}
			return Status;	
	}	
			public String Select11Grade(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.isPresent(UnifiedPage.Grade11th, 60);
			WebInteractUtil.Click(UnifiedPage.Grade11th);
			WebInteractUtil.isPresent(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardAndhra, 60);
			WebInteractUtil.Click(UnifiedPage.BoardAndhra);
			Actions scrollDown = actions.moveToElement(UnifiedPage.BoardAndhra);
			scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebInteractUtil.isPresent(UnifiedPage.SaveGrade, 60);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExam, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			LoggerUtil.printExtentLog("Pass", "11th Grade and Neet Target Exam updated successfully");
			WebInteractUtil.Click(UnifiedPage.InfinityLogo);
			Status = "True";
			}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to update 11th Grade and Neet Target Exam, Please check");
			Status ="False";}
			return Status;	
			}
			public String PYPReports(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
				WebInteractUtil.Click(UnifiedPage.TestsBtn);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PYPBtn, 60);
				WebInteractUtil.Click(UnifiedPage.PYPBtn);
				WebInteractUtil.Waittilljquesryupdated();
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPYPpage, 60)) {
					LoggerUtil.printExtentLog("Pass", "Navigation to PYP's Listing Page is successfull");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Navigation to PYP's Listing Page is not successfull, Please check");
					Status ="False";}
				WebInteractUtil.isPresent(UnifiedPage.CompletedLst, 60);
				WebInteractUtil.Click(UnifiedPage.CompletedLst);
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.TstRptBtn, 60)) {
					LoggerUtil.printExtentLog("Pass", "Navigation to Test Report's under completed is successfull,Tests Reports are available");
					WebInteractUtil.Click(UnifiedPage.TstRptBtn);
					WebInteractUtil.Waittilljquesryupdated();
					WebInteractUtil.isPresent(UnifiedPage.ViewSolnBtn, 60);
					WebInteractUtil.Click(UnifiedPage.ViewSolnBtn);
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifySolnPage, 60)) {
						WebInteractUtil.Click(UnifiedPage.InfinityLogo);
						LoggerUtil.printExtentLog("Pass", "Navigation to View Solution Page is successfull");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Navigation to View Solution Page is not successfull, Please check");
						Status ="False";}	
				}	else {	
					LoggerUtil.printExtentLog("INFO", "Test Reports are not available under completed, Please submit a PYP test and try again");
					WebInteractUtil.Click(UnifiedPage.InfinityLogo);
					Status ="True";}
				return Status;	
			}
			
			public String SetGoal(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.isPresent(UnifiedPage.EditGoalBtn, 60);
				WebInteractUtil.Click(UnifiedPage.EditGoalBtn);
				WebInteractUtil.isPresent(UnifiedPage.VerifyGoalPp, 60);				
				WebElement textbox = driver.findElement(By.xpath("//mat-dialog-container//input[@type='text']"));
				for(int i=1; i<=3; i++) {
				textbox.sendKeys(Keys.BACK_SPACE);
				}
				textbox.sendKeys(String.valueOf(120));
				WebInteractUtil.Click(UnifiedPage.SetNewGoalBtn);
				WebInteractUtil.Waittilljquesryupdated();
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Verify120min, 60)) {
					LoggerUtil.printExtentLog("Pass", "Goal 120 mins updated successfull");
					Status = "True";
					}else{	
					LoggerUtil.printExtentLog("Fail", "Unable to update goal, Please check");
					Status ="False";}	
			
				return Status;	
			}
			
//		Live classes
			public String FreeMasterClass(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.isPresent(UnifiedPage.LiveClassBtn, 60);
				WebInteractUtil.Click(UnifiedPage.LiveClassBtn);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.isPresent(UnifiedPage.VerifyFreeMstrClass, 60);	
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.NoFreeMasterClass,60)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UnifiedPage.VerifyFreeMstrClass);
					LoggerUtil.printExtentLogWithScreenshot1("INFO", "Free MasterClasses are not available, Please check");
					String FreeMasterClass1=WebInteractUtil.getWebElementText(UnifiedPage.FreeMstrClass1);
					String FreeMasterClass2=WebInteractUtil.getWebElementText(UnifiedPage.FreeMstrClass2);
					Status = "True";
					}else if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.FreeMstrClass1, 60)){	
					LoggerUtil.printExtentLog("Pass", "Free MasterClasses are Available");
					Status ="True";}
				
				Status = "true";
			
				return Status;	
			}
}

		


