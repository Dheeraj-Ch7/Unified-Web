package com.unified.infinity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unified.infinity.utils.DriverManager;

public class UnifiedObjects{
	
//	Unified SignIn Page
//	@FindBy(xpath ="//img[@src='assets/img/logo-jee.png']") public WebElement InfinityLogo;			//Infinity Logo
	@FindBy(xpath ="//img[contains(@class,'logo')]") public WebElement InfinityLogo;
	@FindBy(xpath ="//descendant::a[text()='Home'][1]") public WebElement VerifyHomePage;				//Sign In via OTP text verification
	@FindBy(xpath ="//descendant::input[@placeholder='Phone Number'][2]") public WebElement PhoneNumberTxb;
	@FindBy(xpath ="//a[contains(text(),'LOGIN WITH P')]") public WebElement LoginWPassBtn;
	@FindBy(xpath ="//input[@placeholder='Password']") public WebElement PassWordTxb;
	@FindBy(xpath ="//button[text()='LOGIN']") public WebElement LoginBtn;
	@FindBy(xpath ="//descendant::button[text()='GET OTP'][2]") public WebElement GetOTPBtn1;
	
//	Forgot Password	
	@FindBy(xpath ="//a[text()='FORGOT PASSWORD?']") public WebElement ForgotPassBtn;
	@FindBy(xpath ="//button[text()='SEND OTP']") public WebElement SendOtpBtn;
	@FindBy(xpath ="//h3[text()='Phone Number Verified']") public WebElement PhoneVerified;
	@FindBy(xpath ="//input[@placeholder='New Password']") public WebElement NewPassTxb;
	@FindBy(xpath ="//input[@placeholder='Confirm New Password']") public WebElement ConfirmNewPassTxb;
	@FindBy(xpath ="//button[text()='RESET PASSWORD']") public WebElement ResetPassBtn;
	@FindBy(xpath ="//h3[text()='Great! Password has been reset.']") public WebElement VerifyPassReset;

	
	
	
//	Logout
	@FindBy(xpath ="//button[@data-toggle='dropdown']") public WebElement ProfileIcon;
	@FindBy(xpath ="//button[contains(text(),'Logout')]") public WebElement LogoutBtn;

//	SignUp
	@FindBy(xpath ="//a[text()='Sign up']") public WebElement SignUpPageBtn;
	@FindBy(xpath ="//input[@placeholder='First Name']") public WebElement FirstNameTxb;
	@FindBy(xpath ="//input[@placeholder='Last Name']") public WebElement LastNameTxb;
	@FindBy(xpath ="//descendant::input[@placeholder='Phone Number'][1]") public WebElement SignupPhoneNumberTxb;
	@FindBy(xpath ="//input[@name='grade']//following-sibling::div[text()='11']") public WebElement Grade11;
	@FindBy(xpath ="//span[contains(text(),'Whatsapp')]") public WebElement DisableWhatsApp;
	@FindBy(xpath ="//descendant::button[text()='GET OTP'][1]") public WebElement GetOtpBtn;
	@FindBy(xpath ="//h3[text()='Verify OTP']") public WebElement VerifyOtpPage;
	@FindBy(xpath ="//button[text()='VERIFY OTP']") public WebElement VerifyOtpBtn;
	@FindBy(xpath ="//h3[contains(text(),'targetting')]") public WebElement VerifyTargetExams;
	@FindBy(xpath ="//button[text()='START LEARNING']") public WebElement StartLearnBtn;


	//Home Page Tests
	@FindBy(xpath ="//span[text()='Home']") public WebElement VerifyHome;							//Verify Home Page
	@FindBy(xpath ="//span[text()='Tests']") public WebElement TestsBtn;							
	@FindBy(xpath ="//h3[text()='Tests']") public WebElement VerifyTestsPage;							
	@FindBy(xpath ="//span[contains(text(),'PYP')]") public WebElement PYPBtn;
	@FindBy(xpath ="//h3[contains(text(),'PYP')]") public WebElement VerifyPYPpage;
	@FindBy(xpath ="//button[text()='Attempt now']") public WebElement AttemptNowBtn;
	@FindBy(xpath ="//h3[text()='General Instructions']") public WebElement VerifyGInsPage;
	@FindBy(xpath ="//button[text()='BEGIN TEST']") public WebElement BeginTestBtn;
	@FindBy(xpath ="//button[text()='SUBMIT']") public WebElement SubmitBtn;
	@FindBy(xpath ="//button[text()='Finish test']") public WebElement FinishTstBtn;
	@FindBy(xpath ="//button[text()='Submit']") public WebElement FinalSubmitBtn;
	@FindBy(xpath ="//mat-dialog-container//button[text()='CLOSE']") public WebElement CloseBtn;
	@FindBy(xpath ="//button[text()='VIEW SOLUTIONS']") public WebElement ViewSolutionBtn;
	@FindBy(xpath ="//h3[text()='Your trial has expired!']") public WebElement SubscribeExpire;
	
	@FindBy(xpath ="//button[contains(text(),'Instructions')]") public WebElement VerifyTest;
	@FindBy(xpath ="//input[@id='click1']//parent::div/child::label/p") public WebElement RadioBtn1;
	@FindBy(xpath ="//button[contains(text(),'SAVE')]/span") public WebElement SaveNextBtn;
	@FindBy(xpath ="//img[@src='assets/img/next-blue-line-arrow.svg']") public WebElement FrwdArwBtn;
	@FindBy(xpath ="//button[contains(text(),'REVIEW')]") public WebElement ReviewLaterBtn;
	@FindBy(xpath ="//button[contains(text(),'CLEAR')]") public WebElement ClearRespnBtn;
	@FindBy(xpath ="//a[text()='General Instructions']") public WebElement GenrlInstBtn;
	@FindBy(xpath ="//h3[text()='General Instructions']") public WebElement VerifyGnrlPage;
	@FindBy(xpath ="//a[contains(text(),'BACK')]") public WebElement BackBtn;
	@FindBy(xpath ="//descendant::button[2]/img[@alt='Question List']") public WebElement QstnBtn;
	@FindBy(xpath ="//a[text()='Question List']") public WebElement QstnLstBtn;
	@FindBy(xpath ="//a[text()='Go To Question']") public WebElement GotoQstn;
	
	@FindBy(xpath ="//descendant::img[@class='icon ng-star-inserted'][2]") public WebElement ErrorFlagBtn;
	@FindBy(xpath ="//mat-dialog-container//h3[text()='Report an error']") public WebElement ReportErrorPP;
	@FindBy(xpath ="//div[text()='Incorrect Answers Options']") public WebElement IncrtAnsoptn;
	@FindBy(xpath ="//div[text()='Incorrect Question']") public WebElement IncrtQstn;
	@FindBy(xpath ="//div[text()='Question not clear']") public WebElement QstnNtClr;
	@FindBy(xpath ="//input[@placeholder='Add additional feedback here']") public WebElement AdtnlFeedBck;
	@FindBy(xpath ="//button[text()='Submit']") public WebElement SubmitFeedBck;

	
	
	//Daily Goal Progress
	@FindBy(xpath ="//button[text()='EDIT']") public WebElement EditGoalBtn;
	@FindBy(xpath ="//mat-dialog-container//h3[text()='Set Your Goal']") public WebElement VerifyGoalPp;
	@FindBy(xpath ="//mat-dialog-container//input[@type='text']") public WebElement EnterMinBx;
	@FindBy(xpath ="//mat-dialog-container//button[text()='SET NEW GOAL']") public WebElement SetNewGoalBtn;
	@FindBy(xpath ="//div[text()='120 mins']") public WebElement Verify120min;

	
	
	
	
// 	Profile
	@FindBy(xpath ="//button[contains(text(),'Profile')]") public WebElement ProfileBtn;
	@FindBy(xpath ="//h2[(text()='My Profile')]") public WebElement VerifyProfile;
	@FindBy(xpath ="//a[(text()='CHANGE PASSWORD')]") public WebElement ChangePassBtn;
	@FindBy(xpath ="//mat-dialog-container//input[@formcontrolname='currentPassword']") public WebElement CurrentPassTxb;
	@FindBy(xpath ="//mat-dialog-container//input[@formcontrolname='newPassword']") public WebElement NewPasswordTxb;
	@FindBy(xpath ="//mat-dialog-container//input[@formcontrolname='confirmPassword']") public WebElement ConfirmPassTxb;
	@FindBy(xpath ="//mat-dialog-container//h3[text()='Password updated']") public WebElement PassUpdatedPopUp;
	@FindBy(xpath ="//h3[contains(text(),'Academic Details')]/a[text()='EDIT']") public WebElement AcademicEdit;
//	Grades
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'3rd')]") public WebElement Grade3;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'4th')]") public WebElement Grade4;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'5th')]") public WebElement Grade5;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'6th')]") public WebElement Grade6;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'7th')]") public WebElement Grade7;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'8th')]") public WebElement Grade8;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'9th')]") public WebElement Grade9;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'10th')]") public WebElement Grade10;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'11th')]") public WebElement Grade11th;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'12th')]") public WebElement Grade12;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'13th')]") public WebElement Grade13;
//	Streams
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'PCM')]") public WebElement SelectPCM;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'PCB')]") public WebElement SelectPCB;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'PCMB')]") public WebElement SelectPCMB;
//	Boards
	@FindBy(xpath ="//h3[text()='CBSE']") public WebElement BoardCBSE;
	@FindBy(xpath ="//h3[text()='ICSE']") public WebElement BoardICSE;
	@FindBy(xpath ="//h3[text()='Karnataka Board']") public WebElement BoardKarnataka;
	@FindBy(xpath ="//h3[text()='Andhra Pradesh Board']") public WebElement BoardAndhra;
	@FindBy(xpath ="//h3[text()='Rajasthan Board']") public WebElement BoardRajasthan;
	@FindBy(xpath ="//h3[text()='Madhya Pradesh Board']") public WebElement BoardMadhya;
	@FindBy(xpath ="//h3[text()='West Bengal Board']") public WebElement BoardWestBengal;
	@FindBy(xpath ="//h3[text()='Goa Board']") public WebElement BoardGoa;
	@FindBy(xpath ="//h3[text()='Jammu and Kashmir Board']") public WebElement BoardJammu;
	@FindBy(xpath ="//h3[text()='Bihar Board']") public WebElement BoardBihar;
	@FindBy(xpath ="//h3[text()='Chhattisgarh Board']") public WebElement BoardChhattisgarh;
	@FindBy(xpath ="//h3[text()='Gujarat Board']") public WebElement BoardGujarat;
	@FindBy(xpath ="//h3[text()='Haryana Board']") public WebElement BoardHaryana;
	@FindBy(xpath ="//h3[text()='Jharkhand Board']") public WebElement BoardJharkhand;
	@FindBy(xpath ="//h3[text()='Kerala Board']") public WebElement BoardKerala;
	@FindBy(xpath ="//h3[text()='Orissa Board']") public WebElement BoardOrissa;
	@FindBy(xpath ="//h3[text()='Punjab Board']") public WebElement BoardPunjab;
	@FindBy(xpath ="//h3[text()='Tamil Nadu Board']") public WebElement BoardTamil;
	@FindBy(xpath ="//h3[text()='Telangana Board']") public WebElement BoardTelangana;
	@FindBy(xpath ="//h3[text()='Uttarakhand Board']") public WebElement BoardUttarakhand;
	@FindBy(xpath ="//h3[text()='Uttar Pradesh Board']") public WebElement BoardUttar;
	@FindBy(xpath ="//button[text()='SAVE']") public WebElement SaveGrade;
	@FindBy(xpath ="//h2[text()='Edit Target Exams']") public WebElement VerifyTargetExam;
	@FindBy(xpath ="//h3[contains(text(),'Target Exams updated')]") public WebElement VerifyTargetUpdated;
//	Target Exams
	@FindBy(xpath ="//h3[text()='NEET']") public WebElement SelectNeet;
	@FindBy(xpath ="//h3[text()='Aptitude Test']") public WebElement SelectApt;
	@FindBy(xpath ="//h3[text()='JEE Main']") public WebElement SelectJee;
	@FindBy(xpath ="//h3[text()='Foundation Test']") public WebElement SelectFound;
	@FindBy(xpath ="//h3[text()='JEE Advanced']") public WebElement SelectJeeAdv;
	@FindBy(xpath ="//h3[text()='CBSE']") public WebElement SelectCbse;

	//Score
	@FindBy(xpath ="//h2[text()='SCORE']") public WebElement ScoreBtn;
	@FindBy(xpath ="//h3[text()='SCORE']") public WebElement VerifyScorePage;	
	@FindBy(xpath ="//button[text()='REGISTER NOW']") public WebElement RegisterBtn;
	
	//MCT's
	@FindBy(xpath ="//h2[contains(text(),'MCT')][1]") public WebElement MctBtn;
	@FindBy(xpath ="//h3[contains(text(),'MCT')]") public WebElement VerifyMCTpage;

//	PYP REPORTS
	@FindBy(xpath ="//div[text()='Completed']") public WebElement CompletedLst;
	@FindBy(xpath ="//button[contains(text(),'View Test Report')]") public WebElement TstRptBtn;
	@FindBy(xpath ="//button[(text()='VIEW SOLUTIONS')]") public WebElement ViewSolnBtn;
	@FindBy(xpath ="//h3[text()='Question Paper & Solutions']") public WebElement VerifySolnPage;

//	LIVE CLASSES
	
	@FindBy(xpath ="//descendant::h3[@class=\"UNFAPP-lvmtrcls-title\"][1]") public WebElement FreeMstrClass1;
	@FindBy(xpath ="//descendant::h3[@class=\"UNFAPP-lvmtrcls-title\"][2]") public WebElement FreeMstrClass2;
//	@FindBy(xpath ="//app-custom-button/button[contains(text(),'register')]") public WebElement FreeMstrClass;
	@FindBy(xpath ="//span[text()='Live Classes']") public WebElement LiveClassBtn;							
	@FindBy(xpath ="//h3[text()='Masterclasses']") public WebElement VerifyFreeMstrClass;
	@FindBy(xpath ="//p[contains(text(),'no live classes')]") public WebElement NoFreeMasterClass;

	
	
	
		public UnifiedObjects(){
		WebDriver driver = DriverManager.WEB_DRIVER_THREAD.get();				
		PageFactory.initElements(driver, this);	
		}
}
