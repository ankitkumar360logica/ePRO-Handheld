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


public class WebModality_Updated_Translation_SIP extends BaseTest {
	
	public int DEFAULT_WAIT_ELEMENT = 3000;
	private String subjectName1 = "AutoWebModality01822";
	private String userNameForsubject3 = "S-9016-C5C8";

	@BeforeClass
	public void executionOn() {
		exceutionOn = "MobileAndWebExecution";
	}

	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public WebModality_Updated_Translation_SIP(String browser) {
		super(browser);
	}
/*	
	@BeforeMethod
	public void getTestData() throws Exception {
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("WebModalityUpdatedStudy");
		
		reportLog("Go to Portal Side to Create Subject");
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		//studyNavigatorDashBoardPage.clickOnAddSubjectBTN();
		//studyNavigatorDashBoardPage.clickChooseSiteDrpDownToCreateSubject(studyName, Constants.All_Sites, subjectName);
		studyNavigatorDashBoardPage.creatingSubjectForPreRequisite(studyName, Constants.All_Sites,
				subjectName);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		subjectDetailPage.verifyNewSubjectDetailPage();
	}
*/
	/**
	 * ====================================================================================================================
	 * Web Modality Script Workflow
	 * ====================================================================================================================
	 * 
	 * 
	 *  */
	

	@Test(description = "Web Modality Script Workflow", groups = { "Web" })

	public void VirgilWebScreenshots_() throws Exception {
		
		//**************** Web Modality function ************************************
		clickSearchedSubject(subjectName1);
		
		reportLog("Get the userName");
		String userNameForSubject1 = subjectDetailPage.getUserName();
		
		reportLog("Click on Register button at Subject details page");
		subjectDetailPage.clickOnRegister(false);
		
		reportLog("Verify Register Subject pop up window open");
		subjectDetailPage.verifyRegisterSubPopUpWindowOpen(false);
	
		reportLog("Select Subject device radio button");
		subjectDetailPage.selectSubjectDeviceRadioBtn(false);
		
		reportLog("Copied url details is:");
		subjectDetailPage.getCopiedData(false);
		
		reportLog("Select Site Device Radio button");
		subjectDetailPage.selectSiteDeviceRadioBtn();
		
		reportLog("Click on Start Registration button");
		subjectDetailPage.clickOnRegisterSubjectBtn();
		
		reportLog("Verify Terms and Condition page open");
		subjectDetailPage.verifyTermsAndConditionPageOpen(false);
		
		reportLog("Image 1");
		subjectDetailPage.enterURLInBrowserAddressBar(true);
		Thread.sleep(2000);
		
		reportLog("Switch to Parent window and login into application");				
		subjectDetailPage.switchToParentWindow();
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);

		reportLog("Click on Register button at Subject details page");
		subjectDetailPage.clickOnRegister(false);
		
		reportLog("Select Site Device Radio button");
		subjectDetailPage.selectSiteDeviceRadioBtn();
		
		reportLog("Click on Start Registration button");
		subjectDetailPage.clickOnRegisterSubjectBtn();
		
		reportLog("Image 2\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		Thread.sleep(4000);
		setBrowserWindowTo80();
		subjectDetailPage.verifyTermsAndConditionPageOpen(true);
	
		reportLog("Click on Next button");
		subjectDetailPage.clickAcceptBtn(false);
		
		reportLog("Image 3\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.verifyCreatePasswordFormShowing(true);
		
		reportLog("Enter password with unsupported characters");
		subjectDetailPage.enterPassword("Welcome @123", false);
		
		reportLog("Image 4\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickShowPasswordIcon(true);
		Thread.sleep(2000);
		
		reportLog("Enter password greater than 20 characters");
		subjectDetailPage.clickShowPasswordIcon(false);
		subjectDetailPage.enterPassword("Welcome@12345678901234", false);
		
		reportLog("Enter confirm password greater than 20 characters");
		subjectDetailPage.enterConfirmPassword("Welcome@12345678901234", false);
		
		reportLog("Image 5\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);

		reportLog("Enter password and click show password icon");
		subjectDetailPage.enterPassword("Welcome@123", false);

		reportLog("Enter mismatch confirm password and click show confirm password icon");
		subjectDetailPage.enterConfirmPassword("Welcome@124", false);
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Image 6\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickShowPasswordIcon(false);
		subjectDetailPage.clickShowConfirmPasswordIcon(true);
		
		reportLog("Enter password and click show password icon");
		subjectDetailPage.enterPassword("Welcome@123", false);
		subjectDetailPage.enterConfirmPassword("Welcome@123", false);
		
		reportLog("Image 7\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter mismatch PIN and Confirm Pin and click show icon");
		subjectDetailPage.enterPinForSubject("1234", false);
		subjectDetailPage.enterConfirmPinForSubject("1235", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Image 8\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickShowPinIcon(false);
		subjectDetailPage.clickShowConfirmPinIcon(true);

		reportLog("Enter correct confirm Pin to match with Pin field");
		subjectDetailPage.enterConfirmPinForSubject("1234", false);
		
		reportLog("Image 9\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Click Select A question drop down  and select question");
		subjectDetailPage.clickQuestionDropDown(false);
		subjectDetailPage.scrollTheQuestionListAndSelectAQuestion(false);
			
		reportLog("Enter answer for the selected question");
		subjectDetailPage.provideAnswerForSelectedQuestion("1", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Image 10\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.verifyRegistrationCompletePageShowing();
		
		reportLog("Click on Open Web App button");
		subjectDetailPage.clickOpenWebAppBtn();

		reportLog("Image 11");
		subjectDetailPage.verifyLoginFormShowing();
		
		reportLog("Image 12");
		subjectDetailPage.clickForgotUserNameLink();
		
		reportLog("Click on Back button");
		subjectDetailPage.clickBackBtn();
		
		reportLog("Click Forgot password link");
		Thread.sleep(2000);
		subjectDetailPage.clickForgotPasswordLink();
		
		reportLog("Image 13");
		subjectDetailPage.verifyRecoverUserNameFormShowing();
		
		reportLog("Enter userName in field");
		subjectDetailPage.enterUserNameInField("b-qwer-tyui");
		
		reportLog("Image 14\n\nNote:\nb-qwer-tyui: No translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter userName in field that is not registered");
		subjectDetailPage.enterUserNameInField(userNameForsubject3);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);

		reportLog("Image 15\n\nNote:\n"+userNameForsubject3+":\nNo translation needed.");
		subjectDetailPage.verifyUserNotRegisteredMessageShowing();
		
		reportLog("Enter username for subject1");
		subjectDetailPage.enterUserNameInField(userNameForSubject1);
		
		reportLog("Image 16\nNote:\n"+userNameForSubject1+":\nNo translation needed.\nAll secret questions are to be\ntranslated as part of a\nseparate initiate.\n(Global)\nAll secret questions are\ntranslated as part of a\nseparate initiative. The secret\nquestion is dynamic and may not\nmatch with the source. \nThe question(s) are part of a \nseparate translation initiative.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter answer for the selected question");
		subjectDetailPage.enterAnswerForSecurityQuestion("123");
		
		reportLog("Image 17\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.\n\n(Global)\n\nAll secret questions are\ntranslated as part of a\nseparate initiative. The secret\nquestion is dynamic and may not\nmatch with the source. \n\nThe question(s) are part of a \nseparate translation initiative.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter answer for the selected question");
		subjectDetailPage.enterAnswerForSecurityQuestion("125");
		
		reportLog("Image 18\n\nNote:\n"+userNameForSubject1+":\nNo translation needed. \n\nThe question(s) are part of a \nseparate translation initiative.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Login into application");
		subjectDetailPage.switchToParentWindowWithoutClosingChildWindow();
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		
		reportLog("Click on Reported Outcome icon");
		subjectDetailPage.clickReportedOutcomeIcon();
		
		reportLog("Click on Reset Credentials icon");
		subjectDetailPage.clickResetCredentialsIcon();
		
		reportLog("Select the reason for change");
		subjectDetailPage.selectReasonForChangeOption("Subject forgot the PIN");
		
		reportLog("Enter username and password");
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(TRNUserName, TRN_Password);
		
		reportLog("Switch to child window");
		subjectDetailPage.switchToChildWindow();
		
		reportLog("Image 19\n\nNote:\n404:No translation needed.");		
		subjectDetailPage.refreshThePage();

		reportLog("Switch to parent window");
		subjectDetailPage.switchToParentWindowWithoutClosingChildWindow();
		Thread.sleep(5000);
		
		reportLog("Refresh the browser");
		subjectDetailPage.refreshPage();
				
		reportLog("Click on Register button at Subject details page");
		subjectDetailPage.clickOnRegister(false);
		
		reportLog("Verify Register Subject pop up window open");
		subjectDetailPage.verifyRegisterSubPopUpWindowOpen(false);
		
		reportLog("Select Subject device radio button");
		subjectDetailPage.selectSubjectDeviceRadioBtn(false);
		
		reportLog("Click Regenerate link");
		subjectDetailPage.clickRegenerateLink();
		
		reportLog("Get the url link:");
		subjectDetailPage.getCopiedData(false);		
	
		reportLog("Switch to child window and click Accept button");
		subjectDetailPage.switchToChildWindow();
		
		subjectDetailPage.enterURLInBrowserAddressBar(false);

		subjectDetailPage.clickAcceptBtn(false);
		
		reportLog("Enter password and confirm password");
		subjectDetailPage.enterPassword("Welcome@12345", false);
		subjectDetailPage.enterConfirmPassword("Welcome@12345", false);
		
		reportLog("Click Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Enter mismatch PIN");
		subjectDetailPage.enterPinForSubject("1111", false);
		subjectDetailPage.enterConfirmPinForSubject("1111", false);
			
		reportLog("Click Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Click Select A question drop down  and select question");
		subjectDetailPage.clickQuestionDropDown(false);
		subjectDetailPage.scrollTheQuestionListAndSelectAQuestion(false);
		
		reportLog("Enter answer for the selected question");
		subjectDetailPage.provideAnswerForSelectedQuestion("1", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Click on Open Web App button");
		subjectDetailPage.clickOpenWebAppBtn();
		
		reportLog("Enter username for subject1 and incorrect password");
		subjectDetailPage.enterUserNameInField(userNameForSubject1);
		
		reportLog("Enter incorrect password");
		subjectDetailPage.enterPassword("Welcome@1234567", false);
		
		reportLog("Image 20\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter incorrect password");
		subjectDetailPage.enterIncorrectPassword("Welcome@12456");
		
		reportLog("Image 21\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.verifyRecoverPasswordLinkShowing();
		
		reportLog("Click on Recover pssword link");
		subjectDetailPage.clickRecoverPasswordLink();
		
		reportLog("Enter username for subject1");
		subjectDetailPage.enterUserNameInField(userNameForSubject1);
		
		reportLog("Click Next buttn");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Enter answer for the selected question");
		subjectDetailPage.enterAnswerForSecurityQuestion("1");

		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Enter password and confirm password");
		subjectDetailPage.enterPassword("Welcome@12345", false);
		subjectDetailPage.enterConfirmPassword("Welcome@12345", false);
		
		reportLog("Image 22\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter password and confirm password");
		subjectDetailPage.enterPassword("Welcome@1234567", false);
		subjectDetailPage.enterConfirmPassword("Welcome@1234567", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Image 23\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.verifySignInBtnShowing();
		
		reportLog("Click Sign In Button");
		subjectDetailPage.clickSignInBtn(false);
		
		reportLog("Enter only password as UserName field has already data");
		subjectDetailPage.enterPassword("Welcome@1234567", false);

		reportLog("Image 24\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter incorect PIN");
		subjectDetailPage.EnterPinAfterRecoverPin("3333");
			
		reportLog("Image 25\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickSignInBtn(true);
		
		reportLog("Enter incorect PIN");
		subjectDetailPage.enterIncorrectPin("4444");
		
		reportLog("Image 26\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.verifyRecoverPINLinkShowing();
		
		reportLog("Image 27\n\nNote:\n"+userNameForSubject1+":\nNo translation needed. \n\nThe question(s) are part of a \nseparate translation initiative.");
		subjectDetailPage.clickRecoverPINLink();
		
		reportLog("Enter answer for the selected question");
		subjectDetailPage.enterAnswerForSecurityQuestion("1");
		
		reportLog("Image 28\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Enter PIN and Confirm PIN");
		subjectDetailPage.enterPinForSubject("1111", false);
		subjectDetailPage.enterConfirmPinForSubject("1111", false);
			
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Image 29\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickShowPinIcon(false);
		subjectDetailPage.clickShowConfirmPinIcon(true);
		
		reportLog("Enter PIN and Confirm PIN");
		subjectDetailPage.enterPinForSubject("7777", false);
		subjectDetailPage.enterConfirmPinForSubject("7777", false);
			
		reportLog("Image 30\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Click Sign In Button");
		subjectDetailPage.clickSignInBtn(false);
		
		reportLog("Enter only password as UserName field has already data");
		subjectDetailPage.enterPassword("Welcome@1234567", false);

		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Enter correct PIN");
		subjectDetailPage.EnterPinAfterRecoverPin("7777");
			
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtnAndWaitForElementVisible();	
		
		reportLog("Image 31\nNote:\n"+userNameForSubject1+":\nNo translation needed.\n"+subjectName1+":\nNo translation needed.\n!Test_Virgil_Sponsor – New_\nWebModality_Test: No translation\nneeded.\nSite1: No translation needed.\n(Global)\nAll the texts in the Visit table/grid \nare dynamic and may vary based \non configuration. Please ignore any \ndeviation from the source, except \nthe specific texts, in scope for the \nrespective image.");
		subjectDetailPage.verifyTabs();
		
		reportLog("Click on Past Visits tab");
		subjectDetailPage.clickPastVisitsTab();
		
		reportLog("Image 32\nNote:\n"+userNameForSubject1+":\nNo translation needed.\n"+subjectName1+":\nNo translation needed.\n!Test_Virgil_Sponsor – New_\nWebModality_Test: No translation\nneeded.\nSite1: No translation needed.\nClinRoVisit1, ClinRoVisit2:\nNo translation needed.\nDate:\nSystem will translate automatically");
		subjectDetailPage.clickExpandButton();
		
		reportLog("Open new tab and switch to child window");
		subjectDetailPage.switchToParentWindowWithoutClosingChildWindow();
		Thread.sleep(10000);
		subjectDetailPage.refreshPage();

		reportLog("Select Visit 3 and Initiate it");
		subjectDetailPage.selectVisit3();
		Thread.sleep(3000);
		subjectDetailPage.clickInitiateIcon();
		
		reportLog("Initiate the visit3");
		subjectDetailPage.initiateVisitDate();
		Thread.sleep(5000);
		
		reportLog("Switch to child window");
		subjectDetailPage.switchToChildWindow();
		subjectDetailPage.refreshPage();

		reportLog("Image 33\n\nNote:\n"+userNameForSubject1+":\nNo translation needed.\n\n"+subjectName1+":\nNo translation needed.\n\n!Test_Virgil_Sponsor – New_\nWebModality_Test: No translation\nneeded.\n\nSite1: No translation needed.");
		subjectDetailPage.clickUpcomingVisitTab();
		
		reportLog("Click on Available Visits tab");
		subjectDetailPage.clickAvailableVisitsTab();

		reportLog("Refresh the page");
		subjectDetailPage.refreshPage();
		Thread.sleep(4000);
		
		reportLog("Image 34\n\nNote:\nAI (PRO): No translation needed.\n\nEQ-5D-5L (PRO): No Translation \nneeded.\n\n5D-ASC: No translation needed.\n\nCADSS: No translation needed.\n\nAES-S: No translation needed.");
		subjectDetailPage.scrollToTheLastVisit();
		
		reportLog("Image 35\n\nNote:\nAI (PRO): No translation needed.\n\nEQ-5D-5L (PRO): No Translation \nneeded.\n\n5D-ASC: No translation needed.\n\nCADSS: No translation needed.\n\nAES-S: No translation needed.");
		subjectDetailPage.moveCursorOnStartInfo();
		
		reportLog("Switch to parent window");
		subjectDetailPage.switchToParentWindowWithoutClosingChildWindow();
		
		subjectDetailPage.clickActionIconForAssessment();
		
		reasonOfChangePopUpWindow();
		Thread.sleep(3000);
		
		subjectDetailPage.clickSbjectDetailsRefreshIcon();

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
		
		reportLog("Image 36\n\nNote:\nAll texts appear on the background\n(EL_Web, protocol, Site Number, etc.): No translation needed.\n\nConclusion:\nNo translation needed");
		subjectDetailPage.formToggler(true);
		
		subjectDetailPage.formToggler(false);
		
		reportLog("Click at Next pagination button");
		subjectDetailPage.clickNextAtPagination();
		
		reportLog("Image 37\n\nNote:\nBackground texts are placeholders.\nNo translation needed.");
		subjectDetailPage.clickIAmDoneBtn();
		
		reportLog("Click on No button");
		subjectDetailPage.clickNoBtn();
		
		reportLog("Image 39\n\nNote:\nBackground texts are placeholders.\nNo translation needed.");
		subjectDetailPage.clickTakeABreak();
		
		reportLog("Click on Cancel button");
		subjectDetailPage.cancelBtnTakeABreak();
		
		reportLog("Image 40");
		subjectDetailPage.completeForm(true);
		
		reportLog("Click on Start button at Form Assessment");
		subjectDetailPage.clickStartButtonForVisit(false);
		
		reportLog("Image 42\n\nNote:\nAll background texts on\n“5-Dimensional Altered States…”\nare placeholders.\nNo translation needed.");
		subjectDetailPage.clickTakeABreak();
		
		reportLog("Click OK button");
		subjectDetailPage.oKBtnAtTakeABreak();
		
		reportLog("Image 43\n\nNote:\nAI (PRO): No translation needed.\n\nEQ-5D-5L (PRO): No Translation \nneeded.\n\n5D-ASC: No translation needed.\n\nCADSS: No translation needed.\n\nAES-S: No translation needed.");
		subjectDetailPage.scrollToTheLastVisit();
		
		reportLog("Wait for 2 minutes");
		Thread.sleep(120000);
		
		reportLog("Image 44\n\nNote:\nAll background texts on\n“5-Dimensional Altered States…”\nare placeholders.\nNo translation needed.");
		subjectDetailPage.clickStartButtonForVisit(true);
		
		reportLog("Click Ok button");
		subjectDetailPage.oKBtnAtTakeABreak();
		
//		reportLog("Complete the form");
//		subjectDetailPage.completeForm(false)
//		
//		reportLog("Click Ok button");
//		subjectDetailPage.clickOkBtnAtCompleteAssessment();
/*		
		reportLog("Switch to parent window and search the subject to add an observer");
		//subjectDetailPage.switchToParentWindowWithoutClosingChildWindow();
		//dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		clickSearchedSubject(subjectName1);
		
		reportLog("Clicked on Reported outcomes edit icon and add an Observer");
		subjectDetailPage.addObserver();

		reportLog("Click Register button for Observer");
		subjectDetailPage.registerBtnForObserver();
		
		reportLog("Click on Start Registration button");
		subjectDetailPage.clickOnRegisterSubjectBtn();
	
		reportLog("Click on Next button");
		subjectDetailPage.clickAcceptBtn(false);
		
		reportLog("Enter password and confirm password");
		subjectDetailPage.enterPassword("Welcome@1234", false);
		subjectDetailPage.enterConfirmPassword("Welcome@1234", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Enter PIN and Confirm Pin");
		subjectDetailPage.enterPinForSubject("2222", false);
		subjectDetailPage.enterConfirmPinForSubject("2222", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(true);
		
		reportLog("Click Select A question drop down  and select question");
		subjectDetailPage.clickQuestionDropDown(false);
		subjectDetailPage.scrollTheQuestionListAndSelectAQuestion(false);
		
		reportLog("Enter answer for the selected question");
		subjectDetailPage.provideAnswerForSelectedQuestion("1", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		Thread.sleep(3000);
		
		reportLog("Get the userName for Observer");
		String userNameForObserver = subjectDetailPage.getUserName();
		
		reportLog("Click on Open Web App button");
		subjectDetailPage.clickOpenWebAppBtn();
			
		reportLog("Enter password for Observer");
		subjectDetailPage.enterPassword("Welcome@1234", false);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Enter Pin for Observer");
		subjectDetailPage.enterPinForSubject("2222", false);

		reportLog("Click Sign In Button");
		subjectDetailPage.clickSignInBtn(false);

		reportLog("Image 45");
		subjectDetailPage.verifybserverKeywordShowing();
		
		reportLog("Click on Logout");
		subjectDetailPage.logout();
/*		
//		reportLog("Switch to parent window");
//		subjectDetailPage.switchToParentWindow();
//		
//		reportLog("Open password expiration screen");
//		subjectDetailPage.openApplicationInNewWindowTab(passwordExpirationUrl);
//		
//		reportLog("Enter user name");
//		subjectDetailPage.enterUserNameInField("S-C776-6E10");
//		
//		reportLog("Enter Password");
//		subjectDetailPage.enterPassword("Welcome@1234567", false);
//
//		reportLog("Image 47");
//		subjectDetailPage.clickNextBtn(true);
//		Thread.sleep(3000);
//		
//		reportLog("Click on Recover password link");
//		subjectDetailPage.clickRecoverPasswordLink();	
//		
//		reportLog("Enter user name");
//		subjectDetailPage.enterUserNameInField("S-C776-6E10");
//
//		reportLog("Click on Next button");
//		subjectDetailPage.clickNextBtn(false);
//		
//		reportLog("Enter answer for security question");
//		subjectDetailPage.enterAnswerForSecurityQuestion("1");
//
//		reportLog("Click on Next button");
//		subjectDetailPage.clickNextBtn(false);
//		
//		reportLog("Enter password and confirm password");
//		subjectDetailPage.enterPassword("Welcome@12345678", false);
//		subjectDetailPage.enterConfirmPassword("Welcome@12345678", false);
//		
//		reportLog("Click on Next button");
//		subjectDetailPage.clickNextBtn(false);
//		
//		reportLog("Click Sign In Button");
//		subjectDetailPage.clickSignInBtn(false);
//		
//		reportLog("Enter password");
//		subjectDetailPage.enterPassword("Welcome@12345678", false);
//
//		reportLog("Image 48");
//		subjectDetailPage.clickNextBtn(true);
		
		//reportLog("Open browser version not supported page");
		//subjectDetailPage.openApplicationInNewWindowTab(browserVersionNotSupportedUrl);
*/
	} 
		
	public void clickSearchedSubject(String subjectName) throws Exception {
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("WebModalityUpdatedStudy");
		
		reportLog("Go to Portal Side to Create Subject");
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.All_SiteText);
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
	
	public void reasonOfChangePopUpWindow( ) throws InterruptedException {
		subjectDetailPage.setCurrentDate();
		subjectDetailPage.selectReasonForChangeOption("Technical difficulties");
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