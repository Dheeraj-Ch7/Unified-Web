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
	@FindBy(xpath ="//a[text()=' Sign in ']") public WebElement VerifyHomePage;				//Sign In via OTP text verification
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

	@FindBy(xpath ="//a[text()='sign in']")
	public WebElement Signuptxtbtn;
	@FindBy(xpath="//label[text()='The OTP is incorrect, please enter again']")
	public WebElement IncorrectOTP;
	@FindBy(xpath ="//a[text()='EDIT']")
	public WebElement OTPEditbtn;
	@FindBy(xpath ="//descendant::input[@type='tel']") 
	public WebElement otp1;
	@FindBy(xpath ="//descendant::input[@type='tel'][2]")
	public WebElement otp2;
	@FindBy(xpath ="//descendant::input[@type='tel'][3]")
	public WebElement otp3;
	@FindBy(xpath ="//descendant::input[@type='tel'][4]")
	public WebElement otp4;
	
	@FindBy(xpath ="//label[text()='*Seems like you are a new user, please click ']")
	public WebElement InvalidUn;
	@FindBy(xpath ="//label[text()=' User does not exist for this user id /phone ']")
	public WebElement Invalidunandpwd;
	
	
	
// 	Profile
	@FindBy(xpath ="//button[contains(text(),'Profile')]") public WebElement ProfileBtn;
	@FindBy(xpath ="//h2[(text()='My Profile')]") public WebElement VerifyProfile;
	@FindBy(xpath ="//a[(text()='CHANGE PASSWORD')]") public WebElement ChangePassBtn;
	@FindBy(xpath ="//mat-dialog-container//input[@formcontrolname='currentPassword']") public WebElement CurrentPassTxb;
	@FindBy(xpath ="//mat-dialog-container//input[@formcontrolname='newPassword']") public WebElement NewPasswordTxb;
	@FindBy(xpath ="//mat-dialog-container//input[@formcontrolname='confirmPassword']") public WebElement ConfirmPassTxb;
	@FindBy(xpath ="//mat-dialog-container//h3[text()='Password updated']") public WebElement PassUpdatedPopUp;
	@FindBy(xpath ="//h3[contains(text(),'Academic Details')]/a[text()='EDIT']") public WebElement AcademicEdit;
	@FindBy(xpath ="//button[text()='CHANGE PASSWORD VIA OTP']")
	public WebElement ChangepwdviaOTP;
	@FindBy(xpath ="//input[@placeholder='Enter New Password']")
	public WebElement Enternewpwd;
	@FindBy(xpath ="//button[text()='SEND OTP TO MOBILE NUMBER']")
	public WebElement Sendotptomobile;
	@FindBy(xpath ="//button[text()='CLOSE']")
	public WebElement Passwordclose;
	@FindBy(xpath ="//descendant::img[@class='ng-star-inserted'][2]")
	public WebElement pwdenablebtn;
	@FindBy(xpath ="//mat-error[@role='alert']")
	public WebElement pwddoesntmatchbtn;
	
	
	//UPDATE PROFILE PICTURE
		@FindBy(xpath ="//a[@class='UNFAPP-edtprfle-btn']")
		public WebElement editprofilepicbtn;
		@FindBy(xpath ="//button[text()='REMOVE PHOTO']")
		public WebElement removephotobtn;
		@FindBy(xpath ="//button[text()='CLOSE']")
		public WebElement removephotoclosebtn;
		@FindBy(xpath ="//descendant::img[10]")
		public WebElement slt2ndphoto;
		@FindBy(xpath ="//button[text()='SELECT']")
		public WebElement Photosltbtn;
//	Grades
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'1st')]") public WebElement Grade1;
	@FindBy(xpath ="//div[@class='UNFAPP-grd-radiobx' and contains(text(),'2nd')]") public WebElement Grade2;
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
	@FindBy(xpath ="//button[text()='SAVE']")  public WebElement saveafterboards;
	@FindBy(xpath ="//button[text()=' BACK ']")  public WebElement clkBack;
//	Target Exams
	@FindBy(xpath ="//h3[text()='NEET']") public WebElement SelectNeet;
	@FindBy(xpath ="//h3[text()='Aptitude Test']") public WebElement SelectApt;
	@FindBy(xpath ="//h3[text()='JEE Main']") public WebElement SelectJee;
	@FindBy(xpath ="//h3[text()='Foundation Test']") public WebElement SelectFound;
	@FindBy(xpath ="//h3[text()='JEE Advanced']") public WebElement SelectJeeAdv;
	@FindBy(xpath ="//h3[text()='CBSE']") public WebElement SelectCbse;
	@FindBy(xpath ="//h3[text()='CUET']") public WebElement SelectCUET;
	
	@FindBy(xpath ="//button[text()='SAVE']")
	public WebElement saveaftertargetexams;
	@FindBy(xpath ="//a[@class='logo withtoolbar']")
	public WebElement srichaitnyaicon;
	//@FindBy(xpath ="(//div[@class='UNFAPP-tests-hwrp'])[2]")
	@FindBy(xpath ="//descendant::h2[contains(text(),'CBSE Mock Tests')][1]")
	public WebElement CBSEMockTestGrade6;
	@FindBy(xpath ="//h2[text()='All India CBSE Board Test Series']")
	public WebElement allIndiaCBSEBoardTestSeriesGrade6;
	//@FindBy(xpath ="(//button[text()='Attempt now'])[1]")
	@FindBy(xpath ="//descendant::button[contains(text(),'Attempt now')][1]")
	public WebElement attempnowbtn6thgrade;
	@FindBy(xpath ="(//descendant::div[@class='nav-btn-right'])[1]")
	public WebElement viewsolutionsforwardbtn;
	@FindBy(xpath ="(//descendant::img[@class='icon'])[1]")
	public WebElement viewsolutionsflagbtn;
	@FindBy(xpath ="//input[@value='Incorrect Question']")
	public WebElement viewsolutionsincorrrectqstn;
	@FindBy(xpath ="//button[text()='Submit']")
	public WebElement viewsolutionssubmitbtn;
	@FindBy(xpath ="//button[text()='BACK']")
	public WebElement viewsolutionsBackbtn;
	@FindBy(xpath ="//div[text()='Uh-uh! No tests here yet!']")
	public WebElement NoTestBtn;
	//CBSE to FOUNDATION 6th GRADE
	@FindBy(xpath ="(//button[text()='CBSE - Grade 6'])[2]")
	public WebElement changegradefoundation;
	@FindBy(xpath ="//h3[text()='Foundation Test']")
	public WebElement founationTestgrade6;
	@FindBy(xpath ="//button[text()='CONFIRM']")
	public WebElement foundationConfirmbtn;
	
	//Personal Details   ---@Praveen changes
	@FindBy(xpath ="//h3[text()='Personal Details ']") 
	public WebElement persnldtlsbtn;
	@FindBy(xpath ="(//a[text()='EDIT'])[3]") 
	public WebElement persnalEdit;
	@FindBy(xpath ="//h3[text()='Basic Details']")
	public WebElement basicdetilsbtn;
	
	@FindBy(xpath ="//input[@placeholder='Email ID']")
	public WebElement emailID;
	@FindBy(xpath ="//h3[text()='Address']")
	public WebElement Addressbtn;
	@FindBy(xpath ="//input[@formcontrolname='addressLine1']")
	public WebElement enteraddress;
	//@FindBy(xpath ="//select[@placeholder='Select State']")
	//public WebElement clkstate;
	@FindBy(xpath ="//input[@formcontrolname='city']")
	public WebElement clkcity;
	@FindBy(xpath ="//input[@name='pincode']")
	public WebElement clkpincode;
	@FindBy(xpath ="//input[@formcontrolname='guardiansName']")
    public WebElement clkparentName;
	@FindBy(xpath ="//input[@formcontrolname='guardianPhone']")
	public WebElement clkparentNumber;
	@FindBy(xpath ="//button[text()='SAVE']")
	public WebElement saveebtn;
	@FindBy(xpath ="//button[text()='CLOSE']")
	public WebElement clkclose;
	
	//SELF LEARN
	@FindBy(xpath ="//span[text()='Learn']")
	public WebElement Learn;
	//FOR CHEMISTRY SUBJECT
	@FindBy(xpath ="//p[text()='Chemistry']")
	public WebElement Chemistrybtn;
	@FindBy(xpath ="//div[text()=' 01 ']")
	public WebElement clk1stchapter;
	@FindBy(xpath ="//a[text()='Learn']")
	public WebElement Learnbtn;
	
	@FindBy(xpath ="//span[text()='All Topics']")
	public WebElement allTopics;
	@FindBy(xpath ="(//div[@class='overlay'])[1]")
	public WebElement playvedio;
	@FindBy(xpath ="//video[@id='videoTag']")
	public WebElement leftsidedownplaybtn;
	@FindBy(xpath ="//video[@class='video-player']")
	public WebElement resumevideo;
	@FindBy(xpath ="//span[text()=' BACK ']")
	public WebElement backkbtnn;
	
	@FindBy(xpath ="//span[text()=' Flashcards ']")
	public WebElement Flashcardsbtn;
	@FindBy(xpath ="(//div[@class='shape_inner ng-star-inserted'])[1]")
	public WebElement clk1stChapter;
	@FindBy(xpath ="//button[text()=' START LEARNING ']")
	public WebElement clkStartLEarning;
	@FindBy(xpath ="//span[text()='Know more']")
	public WebElement knwmorebtn;
	@FindBy(xpath ="//img[@alt='Right Arrow']")
	public WebElement rightarrow;
	@FindBy(xpath ="//button[text()=' START REVISION ']")
	public WebElement strRevision;
	@FindBy(xpath ="//div[@class='select-answers']//p[1]")
	//@FindBy(xpath ="(//input[@type='radio'])[3]")
	public WebElement sltoption1;
	@FindBy(xpath ="(//button[text()='SUBMIT'])[1]")
	public WebElement answersubmtbtn;
	@FindBy(xpath ="(//button[text()='FINISH'])[1]")
	public WebElement answerfinishbtn;
	@FindBy(xpath ="(//button[text()='QUIT'])[1]")
	public WebElement quitbtn;
	@FindBy(xpath ="//div[text()=' My Chapter progress ']")
	public WebElement chapterprogressbtn;
	@FindBy(xpath ="//span[text()=' Stories ']")
	public WebElement Stories;
	@FindBy(xpath ="//div[@class='article']")
	public WebElement clkArticle;
	@FindBy(xpath ="//a[text()='Practice']")
	public WebElement LearnPractisebtn;
	@FindBy(xpath ="(//span[@class='mat-radio-container'])[1]")
	public WebElement Learnsltoptn1;
	@FindBy(xpath ="(//span[text()='Solution'])[1]")
	public WebElement LearnSoultinbtn;
	@FindBy(xpath ="//button[text()=' BACK ']")
	public WebElement SelfLrnbackbtn;
	@FindBy(xpath ="//button[text()='QUIT PRACTICE ']")
	public WebElement Quitpractisebtn;
	@FindBy(xpath ="//span[text()='Home']")
	public WebElement homebtn;
	
	//FOR PHYSICS SUBJECT
	@FindBy(xpath ="//p[contains(text(),'Physics')]")
	public WebElement Physicsbtn;
	
	//FOR BOTANY SUBJECT
	@FindBy(xpath ="//p[text()='Botany']")
	public WebElement Botanybtn;
	
	//FOR ZOOLOGY SUBJECT
	@FindBy(xpath ="//p[text()='Zoology']")
	public WebElement Zoologybtn;
	
	//ILTS OBjects
	@FindBy(xpath ="//button[text()=' REGISTER NOW ']")
	public WebElement registernoww;
	@FindBy(xpath ="//button[text()=' ATTEMPT NOW FOR FREE ']")
	public WebElement attemptttnoww;
	@FindBy(xpath ="//label[@id='2']")
	public WebElement firstqstnopt2;
	@FindBy(xpath ="//button[text()='SAVE ']")
	public WebElement clkkSaveandNext;
	@FindBy(xpath ="//span[text()='MARK FOR ']")
	public WebElement markforReviewBtnn;
	@FindBy(xpath ="//button[@class='btn-login']")
	public WebElement clksubmitttbtn;
	@FindBy(xpath ="//button[text()='Finish test']")
	public WebElement FinishTestt;
	@FindBy(xpath ="//button[text()='MEDIUM']")
	public WebElement sltMedium;
	@FindBy(xpath ="//button[text()='Submit']")
	public WebElement clkkksubmitt;
	@FindBy(xpath ="//button[text()='CLOSE']")
	public WebElement clkkclose;
	@FindBy(xpath ="//span[@class='score-prize']//b")
	public WebElement yourscore;
	@FindBy(xpath ="//button[text()=' BACK']")
	public WebElement clkkbacckkbtn;
	
	//RAPDailyTest
	@FindBy(xpath ="//h2[text()='Rank Assurance Program Daily Tests (RAPDT)']")
	public WebElement RAPDT;
	@FindBy(xpath ="(//button[text()='Attempt now'])[1]")
	public WebElement RAPDTAttemptnow;
	
	
	//Score
	@FindBy(xpath ="//h2[text()='SCORE']") public WebElement ScoreBtn;
	@FindBy(xpath ="//h3[text()='SCORE']") public WebElement VerifyScorePage;	
	@FindBy(xpath ="//button[text()='REGISTER NOW']") public WebElement RegisterBtn;
	
	//MCT's
	@FindBy(xpath ="//h2[contains(text(),'MCT')][1]") public WebElement MctBtn;
	@FindBy(xpath ="//h3[contains(text(),'MCT')]") public WebElement VerifyMCTpage;
	
	//CYOT
	@FindBy(xpath ="//h2[text()='Create Your Own Tests (CYOT)']")
	public WebElement clkcYOT;
	@FindBy(xpath ="//button[text()='Create a new test']")
	public WebElement clkcreatnewtest;
	@FindBy(xpath ="//div[text()=' Chemistry ']")
	public WebElement Chemistry;
	@FindBy(xpath ="//div[text()=' Physics ']")      
	public WebElement Physics;
	@FindBy(xpath ="//div[text()=' Botany ']")
	public WebElement Botany;
	@FindBy(xpath ="//div[text()=' Zoology ']")
	public WebElement Zoology;
	@FindBy(xpath ="//button[@class='btn CYOT-stepbtnpopup']")
    public WebElement clkNext;
	@FindBy(xpath ="(//div[text()=' Select all '])[1]")
	public WebElement sltChemsistryall;
	@FindBy(xpath ="(//div[text()=' Select all '])[2]")
	public WebElement sltPhysicsall;
	@FindBy(xpath ="(//div[text()=' Select all '])[3]")
	public WebElement sltBotanyall;
	@FindBy(xpath ="(//div[text()=' Select all '])[4]")
	public WebElement sltZoologyall;
	@FindBy(xpath ="//button[@class='btn CYOT-stepbtnpopup']")
    public WebElement clksecondNext;
	@FindBy(xpath ="//div[text()='30 mins ']")
	public WebElement clk30min;
	@FindBy(xpath ="//div[text()='20 ']")
	public WebElement slt20qstn;
	@FindBy(xpath ="//button[text()='Create Test']")
	public WebElement clkcreteTest;
	@FindBy(xpath ="//button[text()=' ATTEMPT TEST']")
	public WebElement attempttestbtn;
	//@FindBy(xpath ="(//button[@type='button'])[7]")
	@FindBy(xpath ="//img[@class='CYOT-steps-crossimg']")
	public WebElement clkCancelBtn;
	@FindBy(xpath ="//button[text()='Attempt now']")
	//@FindBy(xpath ="(//button[text()='Attempt now'])[1]")
	public WebElement clkAttemptNow;
	@FindBy(xpath ="//h3[text()='Test Taking Instructions']")
	public WebElement CYOTTestInstructions;
	
//	PYP REPORTS
	@FindBy(xpath ="//button[@class='SC-GFTCPN-cross']") public WebElement cancelpopup;
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
	
	

//	Subscriptions
	@FindBy(xpath ="//span[text()=' Subscriptions']") public WebElement Subscriptions;
	@FindBy(xpath ="//div[@class='SUBCRP-list-box']//h3") public WebElement GetPackageName;
	@FindBy(xpath ="//descendant::button[contains(@class,\"UNFAPP-tpblu-subjctlink\")][1]") public WebElement SelectTrgt;
	@FindBy(xpath ="//h3[text()='CBSE']") public WebElement SlctCBSE;
	@FindBy(xpath ="//h3[text()='NEET']") public WebElement SlctNEET;
	@FindBy(xpath ="//h3[text()='JEE Main']") public WebElement SlctMain;
	@FindBy(xpath ="//h3[text()='JEE Advanced']") public WebElement SlctAdvcd;
	@FindBy(xpath ="//button[text()='CONFIRM']") public WebElement ConfirmGrde;
	@FindBy(xpath ="//h3[@class='SUBCRP-price-hdng']") public WebElement PackagePrice;
	@FindBy(xpath ="//h3[contains(text(),'47198')]//parent::div[@class='pricehdng-only']//parent::div//following-sibling::button") public WebElement Add47198ToCart;
	@FindBy(xpath ="//h3[contains(text(),'34999')]//parent::div[@class='pricehdng-only']//parent::div//following-sibling::button") public WebElement Add34999ToCart;
	//@FindBy(xpath ="//h3[contains(text(),'29999')]//parent::div[@class='pricehdng-only']//parent::div//following-sibling::button") public WebElement Add29999ToCart;
	@FindBy(xpath ="//h3[contains(text(),'18999')]//parent::div[@class='pricehdng-only']//parent::div//following-sibling::button") public WebElement Add18999ToCart;
	@FindBy(xpath ="//h3[contains(text(),'125')]//parent::div[@class='pricehdng-only']//parent::div//following-sibling::button") public WebElement Add125ToCart;
	@FindBy(xpath ="//h3[text()='Select Course']") public WebElement VerifySlctCourse;
	@FindBy(xpath ="//button[text()='NEXT']") public WebElement NxtBtn;
	@FindBy(xpath ="(//button[text()='NEXT'])[2]") public WebElement MyCartpageNxtBtn;
	@FindBy(xpath ="//button[text()=' NEXT ']") public WebElement BillingPageNxtBtn;
	
	@FindBy(xpath ="//h3[text()='Already in cart!']") public WebElement AlreadyInCart;
	@FindBy(xpath ="//button[text()='View Cart']") public WebElement ViewCart;
	@FindBy(xpath ="//h3[contains(text(),'My Cart')]//span") public WebElement NofItems;

	@FindBy(xpath ="//descendant::span[@class='rupee-txt'][2]//parent::div") public WebElement MyCartGrandTotal;
	@FindBy(xpath ="//descendant::span[@class='rupee-txt'][10]//parent::div") public WebElement BillingGrandTotal;
	
	@FindBy(xpath ="//h3[text()='Billing Information']") public WebElement VerifyBilling;

	@FindBy(xpath ="//h3[text()='Select a Payment Type']") public WebElement VerifyPymtPage;
	
	//new  changes
	@FindBy(xpath ="//h3[text()='Card']")  
	public WebElement Cardbtn;
	@FindBy(xpath ="//h4[text()=' Enter Debit / Credit / ATM Card ']")
	public WebElement EnterCardtn;
	@FindBy(xpath ="//input[@placeholder='Name on Card']")
	public WebElement nameoncard;
	@FindBy(xpath ="//input[@placeholder='Card Number']")
	public WebElement Cardnumber;
	@FindBy(xpath ="//input[@name='expiryAutofillDoesntKnow']")
	public WebElement Expirydate;
	@FindBy(xpath ="//input[@type='password']")
	public WebElement CVV;
	@FindBy(xpath ="//button[@class='pymnt-blue-btn full-width']")
	public WebElement paybtn;
	
	@FindBy(xpath="//h3[text()='Net Banking']")
	public WebElement netbanking;
	@FindBy(xpath="//h4[text()='ICICI Bank']")
	public WebElement ICICIBank;
	@FindBy(xpath ="//h4[text()='IDBI']")
	public WebElement IDBiBank;
	@FindBy(xpath ="//h4[text()='BOB']")
	public WebElement BOBbank;
	@FindBy(xpath ="//button[@class='pymnt-blue-btn']")
	public WebElement payusingNetbanking;
	
	@FindBy(xpath ="//h3[text()='UPI/QR']")
	public WebElement UPIQRbtn;
	@FindBy(xpath ="//h3[text()='Enter UPI ID']")
	public WebElement enterUPIbtn;
	@FindBy(xpath ="//h3[text()='Show QR Code']")
    public WebElement showQRCodebtn;	
	@FindBy(xpath ="//button[@class='pymnt-blue-btn mid-width']")
	public WebElement payusingUPIbtn;
	
	
	@FindBy(xpath ="//h3[text()='Wallet']")
	public WebElement Walletbtn;
	@FindBy(xpath ="//h3[text()='Mobikwik']")
	public WebElement mobikwikbtn;
	@FindBy(xpath ="//h3[text()='Payzapp']")
	public WebElement Payzappbtn;
	@FindBy(xpath ="//h3[text()='Olamoney']")
	public WebElement Olamoneybtn;
	@FindBy(xpath ="//button[@class='pymnt-blue-btn mid-width']")
	public WebElement PayusingWalletbtn;
	
	
	@FindBy(xpath ="//h3[text()='EMI']")
	public WebElement EMIbtn;
	@FindBy(xpath ="Cardless EMI")
	public WebElement CardlessEMI;
	@FindBy(xpath ="//h3[text()='Debit Card EMI']")
	public WebElement DebitcardEMI;
	@FindBy(xpath ="//h3[text()='Credit Card EMI']")
	public WebElement CreditcardEMI;
	
	
	@FindBy(xpath ="//h3[text()='Pay in Parts']")
	public WebElement payinParts;
	@FindBy(xpath ="(//button[@class='payment-btn'])[2]")
	public WebElement payusingpartsbtn;
	
	
	@FindBy(xpath ="//h3[text()='Pay Later']")
	public WebElement PayLaterbtn;
	@FindBy(xpath ="//h3[text()='ICICI Bank']")
	public WebElement icicibank;
	@FindBy(xpath ="//h3[text()='Simpl']")
	public WebElement Simpl;
	
	
	
	@FindBy(xpath ="//descendant::button[contains(text(),'Pay')][1]") public WebElement PayFull;

	@FindBy(xpath ="//div[contains(text(),'UPI / QR')]//parent::div") public WebElement UPIGPay;

	@FindBy(xpath ="//div[contains(text(),'Show QR Code')]") public WebElement ShowQRCode;
	@FindBy(xpath ="//h3[contains(text(),'Congratulation')]") public WebElement SuccessPage;

	@FindBy(xpath ="//button[contains(text(),'Download invoice')]") public WebElement DownloadInv;

	@FindBy(xpath ="//a[contains(text(),'EXPLORE OTHER')]//parent::a//parent::div") public WebElement ExploreOtherPack;
	
//	Subscriptions page
	@FindBy(xpath ="//button[@class='SUBCRP-mysubscrptn-yellow-btn']") public WebElement MySubstnpBtn;
	@FindBy(xpath ="//h3[contains(text(),'My Sub')]") public WebElement MySubstnpPageVerfy;
	@FindBy(xpath ="//img[@alt='Wishlist']") public WebElement WishListBtn;
	@FindBy(xpath ="//img[@alt='Cart']") public WebElement CartBtn;
	@FindBy(xpath ="//button[@class='SUBCRP-mysubscrptn-icn-btn active']//span[text()=1 or 2]") public WebElement AlreadyInCart2;
	@FindBy(xpath ="//button[@class='SUBCRP-mysubscrptn-icn-btn active']//span") public WebElement PackageNoinCart;

	
	
	
	@FindBy(xpath ="//a[@class='SUBCRP-mysubscrptn-yellow-btn']") public WebElement ExplorePackBtn;
	@FindBy(xpath ="//h3[text()='My Wishlist']") public WebElement MyWishListVerfy;
	@FindBy(xpath ="//button[contains(text(),'BACK')]") public WebElement WishLstBackBtn;
	@FindBy(xpath ="//h3[text()='My Cart']") public WebElement MyCartVerfy;
	@FindBy(xpath ="//img[@src='assets/img/trash-new-icon.svg']") public WebElement DeleteCart1;
	@FindBy(xpath ="//img[@src='assets/img/trash-new-icon.svg']") public WebElement DeleteCart2;

	@FindBy(xpath ="//button[text()='Buy subscriptions']") public WebElement BuySubscptn;

	@FindBy(xpath ="//h3[text()='This item has been added to your cart!']") public WebElement Itemsadded;

	@FindBy(xpath ="//button[text()='Proceed to Checkout']") public WebElement PrcdTochkout;

	
	@FindBy(xpath ="//div[contains(text(),'Got a Coupon?')]//button") public WebElement GotACouponBtn;
	@FindBy(xpath ="//input[@placeholder='Have a coupon code?']") public WebElement EnterCoupon;
	@FindBy(xpath ="//button[@class='cupon-submit-btn']") public WebElement ApplyCupn;

	
	
	
	//LIVE CLASS ATTEMPT
	@FindBy(xpath ="//button[text()=' register ']")
	public WebElement liveclsregisterbtn;
	@FindBy(xpath ="//button[text()=' join Now ']")
	public WebElement clsjoinnow;
	@FindBy(xpath ="(//span[@class='live-class-icon '])[1]")
	public WebElement Raisehandbtn;
	@FindBy(xpath ="//span[text()=' Leave class ']")
	public WebElement Leaveclsbtn;
	@FindBy(xpath ="(//span[@class='live-class-icon '])[2]")
	public WebElement Fullscreen;
	@FindBy(xpath ="//span[@class=\"live-class-icon active\"]")
	public WebElement exitbtn;
	@FindBy(xpath ="//div[text()='Activities']")
	public WebElement Activitiesbtn;
	@FindBy(xpath ="//div[text()='START A POLL']")
	public WebElement StartPollbtn;
	
	@FindBy(xpath ="//*[text()='Acricket']")
	public WebElement cricketoptn;
	@FindBy(xpath ="//button[text()='Submit']")
	public WebElement pollsubmitbtn;
	@FindBy(xpath ="//div[text()='START A QUIZ']")
	public WebElement Startquizbtn;
	
	//DOUBTS SINGNUP
	@FindBy(xpath ="//input[@formcontrolname='firstName']")
	public WebElement firstname;
	@FindBy(xpath ="//input[@formcontrolname='lastName']")
	public WebElement lastname;
	@FindBy(xpath ="//button[text()='Get OTP']")
	public WebElement DoubtGetOTP;
	@FindBy(xpath ="//button[text()=' SEND OTP ']")
	public WebElement SendOTP;
	@FindBy(xpath ="//button[text()='VERIFY OTP']")
	public WebElement VerifyOTP;
	@FindBy(xpath ="//h2[text()='Phone Number Verified, ']")
	public WebElement PasswordPage;
	@FindBy(xpath ="//input[@name='email']")
	public WebElement SetEmail;
	@FindBy(xpath ="//input[@name='password']")
	public WebElement SetPwd;
	@FindBy(xpath ="//input[@name='confirmpassword']")
	public WebElement Confirmpwd;
	@FindBy(xpath ="//button[text()='SAVE PASSWORD']")
	public WebElement Savepwdd;
	
	@FindBy(xpath ="//p[text()='Physics']")
	public WebElement DoubtsltPhysicssub;
	@FindBy(xpath ="//h3[text()='NEET']")
	public WebElement doubtNEET;
    @FindBy(xpath ="//button[text()='NEXT']")
    public WebElement doubtNextbtn;
    @FindBy(xpath ="//span[text()='Teacher']")
    public WebElement doubtsignupsltTeacher;
    @FindBy(xpath ="//button[text()='SAVE']")
    public WebElement doubtSavebtn;
    @FindBy(xpath ="//h4[text()='Thank you! Your application is under review, ']")
    public WebElement SignupThnxbtn;
    
	
	//DOUBTS OBJECTS
	@FindBy(xpath ="//button[@class='login-btn']")
	public WebElement DoubtLoginbtn;
	@FindBy(xpath ="//input[@id='phone']")
	public WebElement mobilenumber;
	@FindBy(xpath ="//button[text()='Start Teaching']")
	public WebElement Startteaching;
	@FindBy(xpath ="//span[text()='LOGIN WITH PASSWORD']")
	public WebElement LoginwithPwd;
	@FindBy(xpath ="//input[@name='password']")
	public WebElement Passwdbtn;
	@FindBy(xpath ="//button[text()='LOGIN']")
	public WebElement DoubtLOgin;
	@FindBy(xpath ="//a[text()='Doubts ']")
	public WebElement Doubtbtn;
	
	//DOUBTS LOGOUT
	@FindBy(xpath ="//div[@class='mat-select-arrow-wrapper ng-tns-c71-2']")
	public WebElement doubtprofile;
	@FindBy(xpath ="//span[text()='Logout']")
	public WebElement Logoutdoubt;
	
	//Doubts SigninwithOTP
    @FindBy(xpath ="//button[text()=' SEND OTP ']")
	public WebElement SendOTPbtn;
	@FindBy(xpath ="//button[text()='VERIFY OTP']")
	public WebElement doubtVerifyOtpbtn;
	
	//HomePAge
	@FindBy(xpath ="//h2[text()='Un-Assigned']")
	public WebElement Unassignedbtn;
	@FindBy(xpath ="//app-doubt-card[1]//div[1]//div[2]//a[1]")
	public WebElement takeup;
	@FindBy(xpath ="//descendant::button[text()='Accept'][1]")
	public WebElement DoubtAcceptbtn;
	@FindBy(xpath ="//label[@for='mat-radio-7-input']//span[@class='mat-radio-outer-circle']")
	//@FindBy(xpath ="(//span[@class='mat-radio-outer-circle'])[6]")
	public WebElement minutesbtn30;
	@FindBy(xpath ="//descendant::button[text()='Accept'][2]")
	public WebElement Accept2btn;
	@FindBy(xpath ="//button[text()='chat']")
	public WebElement doubtChatbtn;
	@FindBy(xpath ="//button[text()='Solution']")
	public WebElement doubtSolutionbtn;
	@FindBy(xpath ="//button[text()='Draft']")
	public WebElement doubtsDraftbtn;
	@FindBy(xpath ="//button[text()=' Send ']")
	public WebElement doubtsendbtn;
	@FindBy(xpath ="//a[contains(text(),'Sign in')][1]")
	public WebElement Signintxtbtn;
	//Profile picture available
		@FindBy(xpath ="//div[@class='UNFAPP-usr-prfl-pic']//img")
		public WebElement Profilepic;
		
		
	
	
	
	
		public UnifiedObjects(){
		WebDriver driver = DriverManager.WEB_DRIVER_THREAD.get();				
		PageFactory.initElements(driver, this);	
		}
}
