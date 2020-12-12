package net.medavante.mobile.testscripts;

import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

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

	@BeforeMethod
	public void getTestData() throws Exception {	
		
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		visitName = properties.getProperty("EPROMandatoryVisit");

		reportLog("Go to Portal Side to Create Subject and complete visit for displaying questionnaires");
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.creatingSubjectForPreRequisite(studyName, Constants.testSite,
				subjectName);
		System.out.println(subjectName);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		subjectDetailPage.verifyNewSubjectDetailPage();
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon();
		registrationCode = subjectDetailPage.getRegistrationCodeOfSubject();
		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();
		
		getTestDataForStep92();
		
		getTestDataForStep99();
		
		addAnObserverToSubject();
		
		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
		
	}
	
	public void getTestDataForStep92() throws Exception {	
		
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		visitName = properties.getProperty("EPROMandatoryVisit");

		reportLog("Go to Portal Side to Create Subject for Step no 92");
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
	
	public void disableSubject(String subjectName) {
		
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
		
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);

		studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject,
				subjectName);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject(subjectName);
		
		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.selectMobileProSubjectOption("Disabled");
		subjectDetailPage.enterReasonIntoMobileProSubjectReasonTextBoxField("Disabling the subject");
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		subjectDetailPage.verifyReasonIntoMobileProObserverReasonTextBoxField("Data entry error");
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(FormUserName, Form_Password);
	}
	
	public void enableSubject(String subjectName) {
		
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
		
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);

		studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject,
				subjectName);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject(subjectName);
		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.selectMobileProSubjectOption("Enabled");
		subjectDetailPage.enterReasonIntoMobileProSubjectReasonTextBoxField("Enabling the subject");
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		subjectDetailPage.verifyReasonIntoMobileProObserverReasonTextBoxField("Data entry error");
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(FormUserName, Form_Password);
	}

	/**
	 * ====================================================================================================================
	 * eCOA Handheld Script Workflow
	 * ====================================================================================================================
	 * 
	 * 
	 */

	@Test(description = "eCOA Handheld Script Workflow", groups = { "Mobile" })

	public void eCOAHandheldScriptWorkflow() throws Exception {

		reportLog("1.1:MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();
		
		reportLog("1.2:MobileView Application launch and verify Register screen with instruction message,register the subject");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject(registrationCode);
		
		reportLog("2: MobileView Select Accept");
		mobileLoginPage.clickOnAcceptBtn(); 	
		
		reportLog("4:MobileView Enter numerical value ‘1234’ in ‘PIN’ and ‘1235’ in ‘Confirm PIN’ and select Next");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.verifyPinDontMatchTextDisplay();
		
		reportLog("5:MobileView Enter numerical value ‘1234’ in ‘PIN’ and ‘1234’ in ‘Confirm PIN’ Select ‘Next’ ");
		mobileLoginPage.clearConfirmPINBox();
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog("6:MobileView Select a security question and provide answer (black) and select next.");
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButton();

		reportLog("7:MobileView Select Continue");
		mobileLoginPage.clickOnContinueButton();
		
		reportLog("8:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		reportLog("8.1:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();
		
		reportLog("8.2:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();
		
		reportLog("8.3:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		reportLog("9:MobileView Enter numerical value ‘1234’ and select ‘Submit’");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
//		reportLog("10:MobileView Stay inactive for 15 mins");
//		Thread.sleep(150000);
		
		reportLog("11:MobileView Disconnect from the internet and repeat step 9");
		mobileLoginPage.WifiOff();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		reportLog("12:MobileView Connect to the internet");
		mobileLoginPage.WifiOn();
		sideMenu.verifyHomePageDisplay();
	
		reportLog("13:MobileView - Select ‘Questionnaires’ tab. Questionnaires page is displayed.");
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
		
		reportLog("14:MobileView Select the questionnaire");
		questionnairesPage.clickOnFirstQuestionnairesInTheList();
		
		reportLog("15:MobileView Select ‘Start’ button and The questionnaire is displayed to complete.");
		questionnairesPage.clickOnStartQuestion();
		
		reportLog("16:MobileView Thank you message is displayed for completing the questionnaire along with continue option.");
		//questionnairesPage.
		
		reportLog("21:MobileView Select ‘Messages’ and refresh");
		messgaePage = dashborad.clickOnMessageTab();
		
		reportLog("22:MobileView Send a message to the subject from the portal");
		subjectDetailPage.sendMessage();
			
		reportLog("23:MobileView Refresh Messages screen. ‘{0} new messages’ pop-up message is displayed if there’s a new message.");
		messgaePage.verifyMessageListPresent();
		
		reportLog("24:MobileView Select a ‘Messages’. User is navigated to the ‘Messages’ page and message is displayed with subject and message body and time stamp.");
		messgaePage.verifyMessageListPresent();
		
		reportLog("25:MobileView Select (+) compose icon. ‘Compose’ message page is displayed.");
		messgaePage.clickOnComposeMessageIcon();
		messgaePage.verifyComposeMsgScreen();
		
		reportLog("26:MobileView Type ‘abcd’ in the message body and select back icon. Exit warning message is displayed along with yes/no options.");
		messgaePage.inputTxtInMsgSubjectField("abcd");
		messgaePage.clickOnBackbtnOnComposeScreen();
		messgaePage.verifyExitPopUp();
		
		reportLog("27.1:MobileView Select ‘No’.");
		messgaePage.clickOnNoOnExitPopUp();
		
		reportLog("27.2:MobileView The user stays in Compose message page.");
		messgaePage.verifyComposeMsgScreen();
		
		reportLog("28.1:MobileView Select ‘Yes’.");
		messgaePage.clickOnYesOnExitPopUp();
		
		reportLog("28.2:MobileView The user is navigated back to the Messages page.");
		messgaePage.verifyMessageListPresent();
		
		reportLog("29:MobileView Select (+) compose icon and write ‘abcd’ in the subject and select send icon. Message content cannot be empty text is displayed.");
		messgaePage.clickOnComposeMessageIcon();
		messgaePage.verifyComposeMsgScreen();
		messgaePage.inputTxtInMsgSubjectField("abcd");
		messgaePage.clickOnSendMsgBtn();
		
		reportLog("30.1:MobileView Select (+) compose icon and write ‘abcd’ in the subject and ‘efgh’ in the body and select send icon.");
		messgaePage.inputTxtInMsgSubjectField("abcd");
		messgaePage.inputTxtInMsgBodyField("efgh");
		messgaePage.clickOnSendMsgBtn();
		
		reportLog("30.2:MobileView Sending message pop-up message is displayed and subsequently Message successfully sent pop-up message is displayed and the user is navigated back to the Messages page. ");
		messgaePage.verifyMessageListPresent();
		
		reportLog("31:MobileView Select a message from the message list and select the delete icon ");
		messgaePage.clickDeletebtnOnMessageListScreen();
		
		reportLog("32:MobileView Send a message to the subject from the portal ");
		subjectDetailPage.sendMessage();
		
		reportLog("33:MobileView Select a message and select the reply icon");
		messgaePage.clickReplyIcon();
		messgaePage.verifyReplyInputAndSendButton();
		
		reportLog("34.1:MobileView Select back icon");
		messgaePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("34.2:MobileView Verify that Exit warning message is displayed along with yes/no options");
		messgaePage.verifyWarningpopupWithButtons();
		
		reportLog("35:MobileView Exit from reply message and go to Messages page, disconnect from the internet and refresh immediately");
		messgaePage.clickOnYesOnExitPopUp();
		messgaePage = dashborad.clickOnMessageTab();
		mobileLoginPage.WifiOff();
		
		reportLog("36:MobileView Connect to the internet, compose a message, select send and immediately disconnect from the internet");
		mobileLoginPage.WifiOn();
		messgaePage.clickOnComposeMessageIcon();
		messgaePage.verifyComposeMsgScreen();
		messgaePage.inputTxtInMsgSubjectField("abcd");
		messgaePage.clickOnSendMsgBtn();
		mobileLoginPage.WifiOff();

		reportLog("37:MobileView Connect to the internet Select ‘Log an Event’");
		mobileLoginPage.WifiOn();
		logAnEvent= dashborad.clickOnLogAnEventTab();
		
		reportLog("38:MobileView Select an event’");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("39:MobileView Select Start");
		logAnEvent.clickStartBtn();
		
		reportLog("40:MobileView Complete the Event");
		logAnEvent.clickStartBtn();
		
		reportLog("41:MobileView Select Continue");
		logAnEvent.clickContinueBtn();
		
		reportLog("42.1:MobileView Open an event and start it and select back icon on the top left");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("42.2:MobileView Open an event and start it");
		logAnEvent.clickStartBtn();
		
		reportLog("42.3:MobileView select back icon on the top left");
		messgaePage.clickOnBackbtnOnComposeScreen();
		messgaePage.verifyWarningpopupWithButtons();
		
		reportLog("43:MobileView Select No");
		messgaePage.clickOnNoOnExitPopUp();
		
		reportLog("44:MobileView Select Yes");
		messgaePage.clickOnYesOnExitPopUp();
		
		reportLog("45:MobileView Select ‘JK_Mob’ event from the event list. ");
		logAnEvent.clickOnEvent("jk_mob");
		
		reportLog("46:MobileView Disconnect from the internet and repeat step 45");
		mobileLoginPage.WifiOff();
		logAnEvent.clickOnEvent("jk_mob");
		
		reportLog("47.1:MobileView Connect to the internet and select the side menu icon.");
		sideMenu = dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		
		reportLog("47.2:MobileView Verify side menu");
		mobileLoginPage.WifiOn();
		sideMenu.verifySideMenuOptions();
		
		reportLog("48:MobileView Select ‘My Account’ from the side menu");
		sideMenu.clickOnMyAccount();
		
		reportLog("49:MobileView Select ‘My Schedule’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.clickOnMySchedule();
		
		reportLog("50:MobileView Select ‘Study Information’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.clickOnStudyInformation();
		
		reportLog("51:MobileView Select ‘Contact Us’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.clickOnContacts();
		
		reportLog("52:MobileView Select ‘Settings’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.clickOnSettings();
		
		reportLog("53:MobileView Tap to change the color theme");
		sideMenu.clickOnChangeColorTheme();
		
		reportLog("54:MobileView Exit from the color theme and Select ‘Help & Tutorials’ from the side menu");
		sideMenu.exitFromColorThemePopup();
		sideMenu.clickOnBackIcon();
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.helpAndTutorials();
		
		reportLog("55:MobileView Select ‘About Us’ from the side menu");
		sideMenu.clickOnAboutUs();
		
		reportLog("56:MobileView Exit the application and re-launch it");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel();
		sideMenu.clickOnExitApplication();
		mobileLoginPage = androidSetUp();
		
		reportLog("57:MobileView Select the forgot PIN link");
		mobileLoginPage.clickOnForgetPINLink();

		reportLog(("58.1:MobileView Answer to the security question stored in Step#6"));
		mobileLoginPage.enterAnAnswer(Choose_QuestionAnswer);
		
		reportLog(("58.2:MobileView Use the same PIN of Step#5 to create identity"));
		mobileLoginPage.enterPINCode(Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(Mobile_Pin);
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
		mobileLoginPage = androidSetUp();
		
		reportLog(("61:MobileView Provide wrong answer of the security question in all the attempts"));
		mobileLoginPage.clickOnForgetPINLink();
		mobileLoginPage.enterIncorrectPINCode(Mobile_PinInCorrect);
		
		reportLog(("62:MobileView From the portal deactivate the subject whose account is locked "));
		deactivateSubject(subjectName);
		
		reportLog(("65:MobileView Disable the subject from the portal"));
		disableSubject(subjectName);
			
		reportLog(("66:MobileView Go to questionnaire tab and refresh "));
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
		
		reportLog(("67:MobileView Enable the subject from the portal"));
		enableSubject(subjectName);
		
		reportLog(("68:MobileView Relaunch the VirgilPRO application"));
		mobileLoginPage = androidSetUp();
		
		reportLog(("69:MobileView Sign-in to the application"));
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		
//		reportLog(("74:MobileView Select to go back to questionnaire tab"));
//		questionnairesPage = dashborad.clickOnQuestionnairesTab();
//		
//		reportLog(("75:MobileView Select a questionnaire and start completing"));
//		questionnairesPage.clickOnFirstQuestionnairesInTheList();
//		questionnairesPage.clickOnStartQuestion();
		
//		reportLog(("76:MobileView Leave one or two question(s) unanswered and go to the last page of the questionnaire"));
//		
//		
//		reportLog(("77:MobileView Complete the questionnaire and submit"));
//		
//		
//		reportLog(("78:MobileView Select Continue"));
//		
//		
//		reportLog(("80:MobileView Select Continue"));
		
		
		reportLog(("81:MobileView Go to Messages and Select to compose a message"));
		messgaePage = dashborad.clickOnMessageTab();
		messgaePage.clickOnComposeMessageIcon();
		
		reportLog(("82:MobileView Press and hold the send icon"));
		messgaePage.longPressOnSendMsgBtn();
		
		reportLog(("83: MobileView Select back to the home page"));
		messgaePage.clickOnBackbtnOnComposeScreen();
		sideMenu.clickHomePageIcon();
		
		reportLog(("87:MobileView Go to the Questionnaire Tab and refresh"));
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
		
		reportLog(("90:MobileView Refresh the questionnaire page and immediately disconnect from the internet"));
		mobileLoginPage.WifiOff();
		
		//reportLog(("91:MobileView Select the added questionnaire"));
		
		
		reportLog(("92:MobileView Deactivate the subject from the portal and add a new subject"));
		disableSubject(subjectName);
			
		reportLog(("93:MobileView Relaunch the application, complete Registration process. "));
		mobileLoginPage = androidSetUp();
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject(registrationCodeForStep92);
			
		reportLog(("94:MobileView Disconnect from the internet and accept the terms and conditions"));
		mobileLoginPage.WifiOff();
		mobileLoginPage.clickOnAcceptBtn();
		
		reportLog(("95:MobileView Provide PIN and try to create the subject identity"));
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();
		
		reportLog(("96:MobileView Connect to the internet and create the PIN"));
		mobileLoginPage.WifiOn();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("97:MobileView Disconnect from the internet, select and answer the security question and select next "));
		mobileLoginPage.WifiOff();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();
		
		reportLog(("98:MobileView Connect to the internet, complete the registration procedure and Login"));
		mobileLoginPage.WifiOff();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButton();
		sideMenu.verifyHomePageDisplay();
		
		reportLog(("99:MobileView Deactivate the subject from the portal and add a new subject."));
		disableSubject(registrationCodeForStep92);
		
		reportLog(("100:MobileView Relaunch the application, complete Registration process."));
		mobileLoginPage = androidSetUp();
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject(registrationCodeForStep99);
			
		reportLog(("101:MobileView Accept the terms and condition and create a PIN and answer the security questions"));
		mobileLoginPage.clickOnAcceptBtn();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		
		reportLog(("102:MobileView Disconnect from the internet and try to login"));
		mobileLoginPage.WifiOff();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
			
		reportLog(("103:MobileView Connect to the internet and try to login"));
		mobileLoginPage.WifiOff();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnSubmitButton();
		sideMenu.verifyHomePageDisplay();
		
		reportLog(("104:MobileView Deactivate the subject and add an observer for the subject from the portal."));
		disableSubject(subjectNameforStep99);
		
		reportLog(("105:MobileView Relaunch the application, complete Registration process for the observer."));
		mobileLoginPage = androidSetUp();
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject(registrationCodeForObserver);
		mobileLoginPage.clickOnAcceptBtn();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnChooseAQuestionOption();
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnContinueButton();
		
	}
		
	public void deactivateSubject(String subjectName) throws InterruptedException {
			reportLog("Deactivate Subject");
			dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);
			studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
			
			studyNavigatorDashBoardPage
					.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, subjectName);
			subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject(subjectName);
			subjectDetailPage.deactivateSubjectConfiguration(FormUserName, Form_Password);
			loginPage.logoutApplication();
			loginPage.verifyUserLogout();
	}
	
}
