package net.medavante.mobile.testscripts;

import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.medavante.mobile.appium.core.MobileDriver;
import net.medavante.mobile.pages.MobileDashBoardPage;
import net.medavante.mobile.pages.MobileLoginPage;
import net.medavante.portal.dataproviders.DataProviders;
import net.medavante.portal.pages.studynavigator.StudyDashBoardPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.selenium.core.Configuration;
import net.medavante.portal.utilities.Constants;
import net.medavante.portal.utilities.MobileConstants;

public class Handheld_Translation_SIP extends BaseTest {

	private String subjectName = "AutomationEpro" + generateRandomString(5);
	private String subjectNameforStep92 = "AutomationEpro" + generateRandomString(5);
	private String subjectNameforStep99 = "AutomationEpro" + generateRandomString(5);
	private String subjectNameforObserver = "AutomationEpro" + generateRandomString(5);
	private String registrationCodeForStep92, registrationCodeForStep99, registrationCodeForObserver;
	private String observerRelation1, observerAlias = "Auto" + generateRandomString(2);

	public int DEFAULT_WAIT_ELEMENT = 3000;

	@BeforeClass
	public void executionOn() {
		exceutionOn = "MobileAndWebExecution";
	}

	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public Handheld_Translation_SIP(String driver) {
		super(driver);
	}

//	@BeforeMethod
//	public void getTestData() throws Exception {	
//		
//		System.setProperty("className", getClass().getSimpleName());
//		Properties properties = Configuration.readTestData("RegressionTestData");
//		studyName = properties.getProperty("HandheldTranslationStudy");
//		visitName = properties.getProperty("EPROMandatoryVisit");
//
//		reportLog("Go to Portal Side to Create Subject and complete visit for displaying questionnaires");
//		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
//		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
//				Constants.NavigateText, Constants.StudyText);
//		studyNavigatorDashBoardPage.creatingSubjectForPreRequisite(studyName, Constants.testSite,
//				subjectName);
//		System.out.println(subjectName);
//		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
//		subjectDetailPage.verifyNewSubjectDetailPage();
//		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon();
//		registrationCode = subjectDetailPage.getRegistrationCodeOfSubject();
//		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();
//		
//		getTestDataForStep92();
//		
//		getTestDataForStep99();
//		
//		addAnObserverToSubject();
//		
//		//sendingMessage();
//		
//		loginPage.logoutApplication();
//		loginPage.verifyUserLogout();
//		
//	}
	
	public void getTestDataForStep92() throws Exception {	
		
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		visitName = properties.getProperty("EPROMandatoryVisit");

		reportLog("Go to Portal Side to Create Subject for Step no 92");
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.creatingSubjectForPreRequisite(studyName, Constants.testSite,
				subjectNameforStep92);
		System.out.println(subjectNameforStep92);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		subjectDetailPage.verifyNewSubjectDetailPage();
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon();
		registrationCodeForStep92 = subjectDetailPage.getRegistrationCodeOfSubject();
		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();
				
	}
	
	public void getTestDataForStep99() throws Exception {	
		
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		visitName = properties.getProperty("EPROMandatoryVisit");

		reportLog("Go to Portal Side to Create Subject for Step no 99");
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.creatingSubjectForPreRequisite(studyName, Constants.testSite,
				subjectNameforStep99);
		System.out.println(subjectNameforStep99);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		subjectDetailPage.verifyNewSubjectDetailPage();
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon();
		registrationCodeForStep99 = subjectDetailPage.getRegistrationCodeOfSubject();
		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();

	}
	
	public void addAnObserverToSubject() throws Exception {	
		
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		visitName = properties.getProperty("EPROMandatoryVisit");
		observerRelation1 = properties.getProperty("Auto_Observer_Relation1");

		reportLog("Go to Portal Side to Create Subject for Observer");
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.creatingSubjectForPreRequisite(studyName, Constants.testSite,
				subjectNameforObserver);
		System.out.println(subjectNameforObserver);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		subjectDetailPage.verifyNewSubjectDetailPage();
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon();
		registrationCodeForObserver = subjectDetailPage.getRegistrationCodeOfSubject();
		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();

		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.clickOnAddObserverBtN();
		subjectDetailPage.inputObserverRelationName(observerRelation1);
		subjectDetailPage.inputObserverAliasName(observerAlias);
		subjectDetailPage.clickOnObserverSaveBTN();
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		
	}
	
	public void disableSubject(String subjectName) throws InterruptedException {
		
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
		
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
		studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject,
				"Russian1");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("Russian1");
		
		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.selectMobileProSubjectOption("Disabled");
		Thread.sleep(2000);
		
		subjectDetailPage.enterReasonIntoMobileProSubjectReasonTextBoxField("Data entry error");
		Thread.sleep(2000);
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		Thread.sleep(2000);
		subjectDetailPage.selectReasonForChangeOption("Data entry error");
		Thread.sleep(2000);
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(FormUserName, Form_Password);
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		Thread.sleep(2000);
		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
	}
	
	public void enableSubject(String subjectName) throws InterruptedException {
		
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
		
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);

		studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject,
				"Russian1");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("Russian1");
		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.selectMobileProSubjectOption("Enabled");
		Thread.sleep(2000);
		//subjectDetailPage.enterReasonIntoMobileProSubjectReasonTextBoxField("Enabling the subject");
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		Thread.sleep(2000);
		subjectDetailPage.selectReasonForChangeOption("Data entry error");
		Thread.sleep(2000);
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(FormUserName, Form_Password);
		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
	}

	/**
	 * ====================================================================================================================
	 * eCOA Handheld Script Workflow
	 * ====================================================================================================================
	 * 
	 *  */
	

	@Test(description = "eCOA Handheld Script Workflow", groups = { "Mobile" })

	public void eCOAHandheldScriptWorkflow() throws Exception {

		//reportLog("1.1:MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();
		//mobileLoginPage.WifiOn();
		
	    reportLog("Verify the registeration instruction message");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Image 5");
		mobileLoginPage.configurationForRegisterTheSubject("67BD-3B3E-4A9A-BC21");
		
		//reportLog("2: MobileView Select Accept");
		reportLog("Click on Accept button");
		mobileLoginPage.clickOnAcceptBtn(); 
		
		reportLog("Image 6");
		mobileLoginPage.verifyPinAndConfirmPINEditBoxesAreDisplay();

//		reportLog("3: MobileView Enter numerical value ‘1234’ in ‘PIN’ and ‘1234’ in ‘Confirm PIN’ and select view option.");
//		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.tapOnViewIcon(920, 728);
//		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.tapOnViewIcon(923, 901);
//		
//		mobileLoginPage.tapOnViewIcon(920, 728);
//		mobileLoginPage.tapOnViewIcon(923, 901);

		
		reportLog("Image 7");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.verifyPinDontMatchTextDisplay();
		
		reportLog("5:MobileView Enter numerical value ‘1234’ in ‘PIN’ and ‘1234’ in ‘Confirm PIN’ Select ‘Next’ ");
		mobileLoginPage.clearConfirmPINBox();
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog("Image 8");
		mobileLoginPage.verifyChooseAQuestionDisplay();
		
		reportLog("Image 9");
		mobileLoginPage.clickOnChooseAQuestionOption();
		
		reportLog("");
		mobileLoginPage.chooseAQuestion();
		
		//reportLog("Image 10");
		mobileLoginPage.enterAnAnswer("Black");
		reportLog("Image 10");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();

		reportLog("7:MobileView Select Continue");
		mobileLoginPage.clickOnContinueButton();
		
		reportLog("Image 11");
		mobileLoginPage.verifySignInScreenWithPINEditBox();
		
		reportLog("Image 12");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		reportLog("8.1:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();
		
		reportLog("8.2:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();
		
		reportLog("Image 15");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		//reportLog("9:MobileView Enter numerical value ‘1234’ and select ‘Submit’");
		//mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		//mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		//reportLog("Image 13");
		dashborad = mobileLoginPage.loginUser(Mobile_Pin);
		sideMenu = mobileLoginPage.mobileSideMenu();
		
		reportLog("Image 13");
		sideMenu.verifyHomePageDisplay();		
		
		reportLog("Go to Message tab");
		messgaePage = dashborad.clickOnMessageTab();
			
		//reportLog("11:MobileView Disconnect from the internet and repeat step 9");
		//mobileLoginPage = androidSetUpWithoutReset();
	
		//mobileLoginPage.WifiOff();
		//mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		//mobileLoginPage.clickOnSubmitButton();
		
		reportLog("12:MobileView Connect to the internet");
		//mobileLoginPage.WifiOn();
		//sideMenu.verifyHomePageDisplay();
	    dashborad = mobileLoginPage.mobiledashboard();
	
		reportLog("Image 18");
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
//		
//		reportLog(("75:MobileView Select a questionnaire and start completing"));
		reportLog("Image 19");
		questionnairesPage.selectQuestionForms("Diary 1");
		Thread.sleep(20000);
		//questionnairesPage.selectQuestionForms("Diary 1");
		//Thread.sleep(2000);

		questionnairesPage.clickOnStartQuestion();
		
		reportLog("Image 23");
		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
		//questionnairesPage.clickOnNoOption();
		questionnairesPage.clickOnYesOption();

		
		reportLog("Image 20");
		questionnairesPage.completeQuestionnaire();
		
		reportLog("Image 23");
		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
		Thread.sleep(2000);
		mobileLoginPage.scrollDownToRefreshPage();
		
		
		reportLog("Image 21");
		Thread.sleep(10000);
		questionnairesPage	 = dashborad.clickOnQuestionnairesTab();
		
		reportLog("Image 22");
		questionnairesPage	 = dashborad.clickOnQuestionnairesTab();
		
		reportLog("Image 24");
		messgaePage = dashborad.clickOnMessageTab();
		
		reportLog("Image 25");
		mobileLoginPage.scrollDownToRefreshPage();
			
		//reportLog("22:MobileView Send a message to the subject from the portal");
		sendingMessage();
		
	    //reportLog("Message already send from portal in previous step");
		mobileLoginPage = androidSetUpWithoutReset();
//	
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnSubmitButton();
			
		//reportLog("23:MobileView Refresh Messages screen. ‘{0} new messages’ pop-up message is displayed if there’s a new message.");
		reportLog("Image 26");
		messgaePage = dashborad.clickOnMessageTab();
		//mobileLoginPage.scrollDownToRefreshPage();
			
		reportLog("scrolling");
		mobileLoginPage.scrollDownToRefreshPage();
		//messgaePage= dashborad.clickOnMessageTab();

		//messgaePage.verifyMessageListPresent();
		
		reportLog("Image 27");
		messgaePage= dashborad.clickOnMessageTab();
		
		reportLog("24:MobileView Select a ‘Messages’. User is navigated to the ‘Messages’ page and message is displayed with subject and message body and time stamp.");
		//messgaePage.verifyMessageListPresent();
		
		reportLog("Image 28");
		mobileLoginPage.tapByCoordinate(970, 1680);
		
		reportLog("26:MobileView Type ‘abcd’ in the message body and select back icon. Exit warning message is displayed along with yes/no options.");
		messgaePage.inputTxtInMsgSubjectField("abcd");
		
		reportLog("Image 29");
		messgaePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		//messgaePage.verifyExitPopUp();
		
		reportLog("27.1:MobileView Select ‘No’.");
		messgaePage.clickOnNoOnExitPopUp();
		messgaePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("27.2:MobileView The user stays in Compose message page.");
		//messgaePage.verifyComposeMsgScreen();
		
		reportLog("28.1:MobileView Select ‘Yes’.");
		messgaePage.clickOnYesOnExitPopUp();
		
		reportLog("28.2:MobileView The user is navigated back to the Messages page.");
		//messgaePage.verifyMessageListPresent();
		
		reportLog("29:MobileView Select (+) compose icon and write ‘abcd’ in the subject and select send icon. Message content cannot be empty text is displayed.");
		mobileLoginPage.tapByCoordinate(970, 1680);

		//messgaePage.verifyComposeMsgScreen();
		messgaePage.inputTxtInMsgSubjectField("abcd");
		
		reportLog("Image 30");
		messgaePage.clickOnSendMsgBtn();
		
		reportLog("30.1:MobileView Select (+) compose icon and write ‘abcd’ in the subject and ‘efgh’ in the body and select send icon.");
		messgaePage.inputTxtInMsgSubjectField("abcd");
		messgaePage.inputTxtInMsgBodyField("efgh");
		
		reportLog("Image 31 and Image 32");
		messgaePage.clickOnSendMessageBtnForMultiCapture();
		
		reportLog("30.2:MobileView Sending message pop-up message is displayed and subsequently Message successfully sent pop-up message is displayed and the user is navigated back to the Messages page. ");
		//messgaePage.verifyMessageListPresent();
		
		reportLog("Select the irst message");
		messgaePage.clickFirstMsgOnMessageListScreen();
		
		reportLog("Image 33");
		messgaePage.clickOnDeleteMessageButton();
		//messgaePage.clickOnBackbtnOnComposeScreen();
		
		//reportLog("Image 33");
		//messgaePage= dashborad.clickOnMessageTab();
         
	
		
		reportLog("32:MobileView Send a message to the subject from the portal ");
		//subjectDetailPage.sendMessage();
		sendingMessage();
		
		mobileLoginPage = androidSetUpWithoutReset();
	//	
			mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
			mobileLoginPage.clickOnSubmitButton();
		
			messgaePage = dashborad.clickOnMessageTab();

		mobileLoginPage.scrollDownToRefreshPage();
		Thread.sleep(1000);
		
		reportLog("33:MobileView Select a message and select the reply icon");
		messgaePage.clickFirstMsgOnMessageListScreen();
		
		reportLog("Image 34");
		messgaePage.clickReplyIcon();
		//messgaePage.verifyReplyInputAndSendButton();
		
		reportLog("34.1:MobileView Select back icon");
		messgaePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("Image 35");
		messgaePage.verifyWarningpopupWithButtons();
		
		reportLog("35:MobileView Exit from reply message and go to Messages page, disconnect from the internet and refresh immediately");
		messgaePage.clickOnYesOnExitPopUp();
		messgaePage.clickOnBackbtnOnComposeScreen();
		messgaePage = dashborad.clickOnMessageTab();
		//mobileLoginPage.WifiOff();
		
		reportLog("36:MobileView Connect to the internet, compose a message, select send and immediately disconnect from the internet");
		//mobileLoginPage.WifiOn();
		mobileLoginPage.tapByCoordinate(970, 1680);

		//messgaePage.verifyComposeMsgScreen();
		messgaePage.inputTxtInMsgSubjectField("abcd");
		messgaePage.inputTxtInMsgBodyField("efgh");
		messgaePage.clickOnSendMsgBtn();
		Thread.sleep(3000);
		//mobileLoginPage.WifiOff();

		reportLog("Image 38");
		//mobileLoginPage.WifiOn();
		//messgaePage.clickOnBackbtnOnComposeScreen();
		logAnEvent= dashborad.clickOnLogAnEventTab();
		
		reportLog("Image 39");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("39:MobileView Select Start");
		logAnEvent.clickStartBtn();
		
		reportLog("Image 40");
		logAnEvent.completeEvent();
		
		reportLog("41:MobileView Select Continue");
		logAnEvent.clickContinueBtn();
		
		reportLog("42.1:MobileView Open an event and start it and select back icon on the top left");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("42.2:MobileView Open an event and start it");
		logAnEvent.clickStartBtn();
		
		reportLog("Image 41");
		messgaePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		
		reportLog("Verify popup buttons");
		messgaePage.verifyWarningpopupWithButtons();
		
		reportLog("43:MobileView Select No");
		messgaePage.clickOnNoOnExitPopUp();
		
		reportLog("44:MobileView Select Yes");
		messgaePage.clickOnBackbtnOnComposeScreen();
		messgaePage.clickOnYesOnExitPopUp();
		
		//reportLog("45:MobileView Select ‘JK_Mob’ event from the event list. ");
		//logAnEvent.clickOnEvent("jk_mob");
		
		//reportLog("46:MobileView Disconnect from the internet and repeat step 45");
		//mobileLoginPage.WifiOff();
		
		//reportLog("Image 41");
		//messgaePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("Image 42 and Image 43");
		logAnEvent.clickOnEventWithoutStartBtnVisible("jk_mob");
		
		reportLog("47.1:MobileView Connect to the internet and select the side menu icon.");
		//messgaePage.clickOnBackbtnOnComposeScreen();
		sideMenu = dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		
		reportLog("47.2:MobileView Verify side menu");
		//mobileLoginPage.WifiOn();
		
		reportLog("Image 45");
		sideMenu.verifySideMenuOptions();
		
		reportLog("Image 46");
		sideMenu.clickOnMyAccount();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		reportLog("Image 60");
		sideMenu.clickOnMySchedule();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("50:MobileView Select ‘Study Information’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		
		reportLog("Image 61");
		sideMenu.clickOnStudyInformation();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("51:MobileView Select ‘Contact Us’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		
		reportLog("Image 62");
		sideMenu.clickOnContacts();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("52:MobileView Select ‘Settings’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		
		reportLog("Image 63");
		sideMenu.clickOnSettings();
		
		reportLog("Image 64");
		sideMenu.clickOnChangeColorTheme();
		
		reportLog("54:MobileView Exit from the color theme and Select ‘Help & Tutorials’ from the side menu");
		sideMenu.exitFromColorThemePopup();
		sideMenu.clickOnBackIcon();
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		
		reportLog("Image 65");
		sideMenu.helpAndTutorials();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("55:MobileView Select ‘About Us’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		
		reportLog("Image 66");
		sideMenu.clickOnAboutUs();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
	
		reportLog("56:MobileView Exit the application and re-launch it");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.clickOnExitApplication();

		mobileLoginPage = androidSetUpWithoutReset();
		
		//reportLog("57:MobileView Select the forgot PIN link");

		
		reportLog("Image 67");
		mobileLoginPage.clickOnForgetPINLink();
		
		reportLog("Selected question is showing");
		mobileLoginPage.verifyChooseAQuestionShowing();

		reportLog(("58.1:MobileView Answer to the security question stored in Step#6"));
		mobileLoginPage.enterAnAnswer(Choose_QuestionAnswer);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("58.2:MobileView Use the same PIN of Step#5 to create identity"));
		mobileLoginPage.enterPINCode(Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(Mobile_Pin);
		
		reportLog("Image 68");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();
		
		reportLog(("59.1:MobileView Use a different PIN to create identity"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("59.2:MobileView And then login using the new PIN"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("60:MobileView Repeat Step 56 and 57"));
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.clickOnExitApplication();
		
		mobileLoginPage = androidSetUpWithoutReset();
	
		reportLog(("61:MobileView Provide wrong answer of the security question in all the attempts"));
		mobileLoginPage.clickOnForgetPINLink();
		//mobileLoginPage.enterIncorrectPINCode(Mobile_PinInCorrect);
		
		reportLog("Image 69");
		mobileLoginPage.enterIncorrectAnswer(Enter_IncorrectQuestionAnswer);
		mobileLoginPage.clickOnNextButton();
		
		unlockSubject();
		
		reportLog(("62:MobileView From the portal deactivate the subject whose account is locked "));
		//deactivateSubject("Russian1");
		//Thread.sleep(100000);
		
		reportLog(("65:MobileView Disable the subject from the portal"));
		//disableSubject("Russian1");

		mobileLoginPage = androidSetUpWithoutReset();
	
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin_AfterLock);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin_AfterLock);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.verifyChooseAQuestionDisplay();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnContinueButton();
		
		
		
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin_AfterLock);
		mobileLoginPage.clickOnSubmitButton();
//		disableSubject("Russian1");
//			
//		//reportLog(("Image 71"));
//		questionnairesPage = dashborad.clickOnQuestionnaires();
//		
//		reportLog("Image 71");
//		mobileLoginPage.scrollDownToRefreshPage();
//		//Thread.sleep(100000);
//		
//		reportLog(("67:MobileView Enable the subject from the portal"));
//		enableSubject("Russian1");
	
//		reportLog(("68:MobileView Relaunch the VirgilPRO application"));
//		mobileLoginPage = androidSetUpWithoutReset();
//	
//				//sideMenu.clickOnExitApplication();
//				//MobileDriver.closeApp();
//				//mobileLoginPage = androidSetUpWithoutReset();
//				
//		
//		reportLog(("69:MobileView Sign-in to the application"));
//		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin_AfterLock);
//		mobileLoginPage.clickOnSubmitButton();

		
		
		reportLog(("74:MobileView Select to go back to questionnaire tab"));
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
		
		reportLog(("75:MobileView Select a questionnaire and start completing"));
		questionnairesPage.selectQuestionForms("1");
		Thread.sleep(3000);
		questionnairesPage.clickOnStartQuestion();
		
		reportLog("Image 75");
		questionnairesPage.NotFinishQuestionnaire();
		
		reportLog("click on OK button");
		questionnairesPage.clickOnOkBtn();
		
		Thread.sleep(2000);
		
		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
		
		questionnairesPage.clickOnYesOption();
		reportLog(("76:MobileView Leave one or two question(s) unanswered and go to the last page of the questionnaire"));
//		
//		
//		reportLog(("77:MobileView Complete the questionnaire and submit"));
//		
//		
//		reportLog(("78:MobileView Select Continue"));
//		
//		
//		reportLog(("80:MobileView Select Continue"));
		
	    dashborad = mobileLoginPage.mobiledashboard();

		reportLog(("81:MobileView Go to Messages and Select to compose a message"));
		messgaePage = dashborad.clickOnMessageTab();
		mobileLoginPage.tapByCoordinate(970, 1680);
		
		reportLog(("Image 82"));
		messgaePage.longPressOnSendMsgBtn();
		
		reportLog(("83: MobileView Select back to the home page"));
		messgaePage.clickOnBackbtnOnComposeScreen();
		//sideMenu.clickHomePageIcon();
		
		reportLog(("87:MobileView Go to the Questionnaire Tab and refresh"));
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
		
		reportLog(("90:MobileView Refresh the questionnaire page and immediately disconnect from the internet"));
		//mobileLoginPage.WifiOff();
		
		//reportLog(("91:MobileView Select the added questionnaire"));
		
		
		reportLog(("92:MobileView Deactivate the subject from the portal and add a new subject"));
		//disableSubject("Russian1");
		deactivateSubject("Russian1");
		
		//dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		//sideMenu.clickOnExitApplication();
		
		reportLog(("93:MobileView Relaunch the application, complete Registration process. "));
		mobileLoginPage = androidSetUp();
		
		
		//reportLog(("105:MobileView Relaunch the application, complete Registration process for the observer."));
		//mobileLoginPage = androidSetUpWithoutReset();
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Image 81");
		mobileLoginPage.configurationForRegisterTheSubject("92A4-AEAD-44D7-8D1C");
		
		reportLog("Click on Accept and complete the registration process for Observer");
		mobileLoginPage.clickOnAcceptBtn();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnContinueButton();
		
/*
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject("3E2A-1C86-4926-804D");
			
		reportLog(("94:MobileView Disconnect from the internet and accept the terms and conditions"));
		//mobileLoginPage.WifiOff();
		mobileLoginPage.clickOnAcceptBtn();
		
		reportLog(("95:MobileView Provide PIN and try to create the subject identity"));
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();
		
		reportLog(("96:MobileView Connect to the internet and create the PIN"));
		//mobileLoginPage.WifiOn();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("97:MobileView Disconnect from the internet, select and answer the security question and select next "));
		//mobileLoginPage.WifiOff();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();
		
		reportLog(("98:MobileView Connect to the internet, complete the registration procedure and Login"));
		//mobileLoginPage.WifiOff();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButton();
		sideMenu.verifyHomePageDisplay();
		
		//reportLog(("99:MobileView Deactivate the subject from the portal and add a new subject."));
		deactivateSubject("16Dec_2");

		reportLog(("100:MobileView Relaunch the application, complete Registration process."));
		mobileLoginPage = androidSetUpWithoutReset();
	
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject("D46C-D63D-4524-BD53");
			
		reportLog(("101:MobileView Accept the terms and condition and create a PIN and answer the security questions"));
		mobileLoginPage.clickOnAcceptBtn();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		
//		reportLog(("102:MobileView Disconnect from the internet and try to login"));
//		//mobileLoginPage.WifiOff();
//		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
			
		reportLog(("103:MobileView Connect to the internet and try to login"));
		//mobileLoginPage.WifiOn();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnSubmitButton();
		sideMenu.verifyHomePageDisplay();
		
		//reportLog(("104:MobileView Deactivate the subject and add an observer for the subject from the portal."));
		deactivateSubject("16Dec_3"); */
	
//		reportLog(("105:MobileView Relaunch the application, complete Registration process for the observer."));
//		mobileLoginPage = androidSetUpWithoutReset();
//		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
//		
//		reportLog("Image 81");
//		mobileLoginPage.configurationForRegisterTheSubject("3955-05D4-4B31-B59D");
//		
//		reportLog("Click on Accept and complete the registration process for Observer");
//		mobileLoginPage.clickOnAcceptBtn();
//		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.clickOnNextButton();
//		mobileLoginPage.clickOnChooseAQuestionOption();
//		mobileLoginPage.chooseAQuestion();
//		mobileLoginPage.enterAnAnswer("Black");
//		mobileLoginPage.clickOnNextButton();
//		mobileLoginPage.clickOnContinueButton();
		
	} 
		
	public void deactivateSubject(String subjectName) throws InterruptedException {
			reportLog("Deactivate Subject");
			dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
			studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
			studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
			studyNavigatorDashBoardPage
					.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, "Russian1");
			subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("Russian1");
			subjectDetailPage.deactivateSubjectConfiguration(FormUserName, Form_Password);
			loginPage.logoutApplication();
			loginPage.verifyUserLogout();
	}
	//@BeforeMethod
	public void sendingMessage() {
		reportLog("Sending Message from portal for step 22");
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
		studyNavigatorDashBoardPage
				.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, "Russian1");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("Russian1");
		subjectDetailPage.sendMessage();
		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
	}
	
	public void unlockSubject() throws InterruptedException {
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
		studyNavigatorDashBoardPage
				.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, "Russian1");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("Russian1");
		
		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.clickOnSubjectUnLockButtonDisplayedOnReportedOutcomePopUp();
		subjectDetailPage.selectReasonForChangeOption("Technical difficulties");
		
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(FormUserName, Form_Password);
        Thread.sleep(5000);
		
		subjectDetailPage.clickOnReportedOutComePopUpCancelBTN();
        Thread.sleep(5000);

		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
	}
	
}
