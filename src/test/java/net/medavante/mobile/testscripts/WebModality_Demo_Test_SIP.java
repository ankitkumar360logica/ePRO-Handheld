package net.medavante.mobile.testscripts;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.medavante.portal.dataproviders.DataProviders;
import net.medavante.portal.pages.studynavigator.StudyDashBoardPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.selenium.core.Configuration;
import net.medavante.portal.utilities.Constants;


public class WebModality_Demo_Test_SIP extends BaseTest {
	
	public int DEFAULT_WAIT_ELEMENT = 3000;
	private String subjectName1 = "AJTest" + generateRandomString(5);
	private String userNameForsubject3 = "S-9016-C5C8";
	//String userNameForSubject1 = "S-525F-4493";
	private String applcationURL= "https://siteportaltest.medavante.net";
	private String passwordExpirationUrl= "https://subjectportaltest.medavante.net/en-us/Authorization/login";
	private String formAssessmentUrl= "https://formapptest.medavante.net/form-viewer-v1";
	private String browserVersionNotSupportedUrl= "https://subjectportaltest.medavante.net/browser-not-supported";

	@BeforeClass
	public void executionOn() {
		exceutionOn = "MobileAndWebExecution";
	}

	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public WebModality_Demo_Test_SIP(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("WebModalityUpdatedStudy");
		
		reportLog("Go to Portal Side to Create Subject");
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudyNew(studyName, Constants.All_SiteText);
		studyNavigatorDashBoardPage.addSubject(subjectName1);
		loginPage.logoutApplication();
	}

	/**
	 * ====================================================================================================================
	 * Web Modality Script Workflow
	 * ====================================================================================================================
	 * 
	 * 
	 *  */
	

	@Test(description = "Web Modality Script Workflow", groups = { "Web" })

	public void subjectRegistration_WebModality() throws Exception {
		
		//**************** Web Modality function ************************************
		clickSearchedSubject(subjectName1);
		
		reportLog("Get the userName");
		String userNameForSubject1 = subjectDetailPage.getUserName();
		
		subjectDetailPage.initiateSecondVisit();
		reasonOfChangePopUpWindow();
		subjectDetailPage.clickSbjectDetailsRefreshIcon();
		
		reportLog("Click on Register button at Subject details page");
		subjectDetailPage.clickOnRegister(false);
		
		reportLog("Verify Register Subject pop up window open");
		subjectDetailPage.verifyRegisterSubPopUpWindowOpen(false);
		
		reportLog("Select Site Device Radio button");
		subjectDetailPage.selectSiteDeviceRadioBtn();
		
		reportLog("Click on Start Registration button");
		subjectDetailPage.clickOnRegisterSubjectBtn();
		
		reportLog("Verify Terms and Condition page open");
		subjectDetailPage.verifyTermsAndConditionPageOpen(false);
		
		reportLog("Image 1\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		Thread.sleep(4000);
		setBrowserWindowTo80();
		subjectDetailPage.verifyTermsAndConditionPageOpen(true);
	
		reportLog("Click on Next button");
		subjectDetailPage.clickAcceptBtn(false);
		
		reportLog("Image 2\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.verifyCreatePasswordFormShowing(true);
		
		reportLog("Enter password and click show password icon");
		subjectDetailPage.enterPassword("Welcome@123", false);
		subjectDetailPage.enterConfirmPassword("Welcome@123", false);
		
		reportLog("Image 3\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter mismatch PIN and Confirm Pin and click show icon");
		subjectDetailPage.enterPinForSubject("1234", false);
		subjectDetailPage.enterConfirmPinForSubject("1234", false);
		
		reportLog("Image 4\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Click on question drop down to show the questions list");		
		subjectDetailPage.clickQuestionDropDown(true);
		
		reportLog("Scroll te question list and select a question");
		subjectDetailPage.scrollTheQuestionListAndSelectAQuestion(true);
		
		reportLog("Enter answer for the selected question");
		subjectDetailPage.provideAnswerForSelectedQuestion("1", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Image 5\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.verifyRegistrationCompletePageShowing();
		
		reportLog("Click on Open Web App button");
		subjectDetailPage.clickOpenWebAppBtn();

		reportLog("Image 6");
		subjectDetailPage.verifyLoginFormShowing();
		
		reportLog("Enter username");
		subjectDetailPage.enterUserNameInField(userNameForSubject1);

		reportLog("Enter password");
		subjectDetailPage.enterPassword("Welcome@123", false);
		
		reportLog("Image 7\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter PIN");
		subjectDetailPage.enterCorrectPin("1234");
		
		reportLog("Click Sign In Button");
		subjectDetailPage.clickSignInBtn(false);	
		
		reportLog("Image 8");
		subjectDetailPage.verifyTabs();
		
		reportLog("Open new tab and switch to child window");
		subjectDetailPage.switchToParentWindowWithoutClosingChildWindow();
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);

		Thread.sleep(10000);
		//subjectDetailPage.refreshPage();

		reportLog("Select Visit 3 and Initiate it");
		subjectDetailPage.selectVisit3();
		Thread.sleep(3000);
		subjectDetailPage.clickInitiateIcon();
		
		reportLog("Switch to child window");
		subjectDetailPage.switchToChildWindow();
		subjectDetailPage.refreshPage();
		
		reportLog("Click on Available Visits tab");
		subjectDetailPage.clickAvailableVisitsTab();

		reportLog("Refresh the page");
		subjectDetailPage.refreshPage();
		Thread.sleep(4000);
		
		reportLog("Image 10");
		subjectDetailPage.scrollToTheLastVisit();
		
		reportLog("Switch to parent window");
		subjectDetailPage.switchToParentWindowWithoutClosingChildWindow();
		
		subjectDetailPage.clickActionIconForAssessment();
		
		reasonOfChangePopUpWindow();
		Thread.sleep(3000);
		
		subjectDetailPage.clickSbjectDetailsRefreshIcon();
		
		reportLog("Logout from the application");
		loginPage.logoutApplication();

		reportLog("Switch to child window");
		subjectDetailPage.switchToChildWindow();
		
		reportLog("Refresh the page");
		subjectDetailPage.refreshPage();
		Thread.sleep(2000);
		subjectDetailPage.refreshPage();
		Thread.sleep(10000);
		
		reportLog("Click Start button of Assessment");
		subjectDetailPage.clickStartButtonForVisit(false);
		
		setBrowserWindowTo80();
		
		reportLog("Click at Next pagination button");
		subjectDetailPage.clickNextAtPagination();
		
		reportLog("Image 11\n\nNote:\nBackground texts are placeholders.\nNo translation needed.");
		subjectDetailPage.clickIAmDoneBtn();
	} 
		
	public void clickSearchedSubject(String subjectName) throws Exception {
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("WebModalityUpdatedStudy");
		
		reportLog("Go to Portal Side to Create Subject");
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
		//studyNavigatorDashBoardPage.selectStudyNew(studyName, Constants.All_SiteText);
		studyNavigatorDashBoardPage
					.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, subjectName);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject(subjectName);			
	}
	
	public void clickSearchedSubjectWithoutLogin(String subjectName) throws Exception {
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("WebModalityUpdatedStudy");
		
		reportLog("Go to Portal Side to Create Subject");
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.All_SiteText);
		studyNavigatorDashBoardPage
					.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, subjectName);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject(subjectName);			
	}
	
	@AfterMethod
	public void quit() {
		
	}
	
	//@BeforeMethod
	public void setBrowserWindowTo80() throws AWTException, InterruptedException {
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_MINUS);
		 
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_MINUS);
		 
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_MINUS);
	 
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_MINUS);
		 Thread.sleep(5000);
	}
	
	public void openNewTab() throws AWTException {
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_T);
		 
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_T);
	}
	
	public void initiateVist3() throws InterruptedException {

		subjectDetailPage.selectVisit3();
		Thread.sleep(3000);
		subjectDetailPage.clickInitiateIcon();
	}
	
	public void reasonOfChangePopUpWindow( ) throws InterruptedException {
		subjectDetailPage.setCurrentDate();
		subjectDetailPage.selectReasonForChangeOption("Technical Difficulties");
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(TRNUserName, TRN_Password);
	}
	
	public void addAnObserver() throws InterruptedException {
		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.clickOnAddObserverBtN();
		reportLog("Enter required Observer data and click on 'Save' control");
		subjectDetailPage.inputObserverRelationName("Test");
		subjectDetailPage.inputObserverAliasName("Observer");
		subjectDetailPage.clickOnObserverSaveBTN();		
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
//		subjectDetailPage.selectReasonForChangeOption(Constants.Subject_Reason_For_Change);
//		subjectDetailPage.inputCredentialsInReasonForChangePopUp(TRNUserName, TRN_Password);
	}
}