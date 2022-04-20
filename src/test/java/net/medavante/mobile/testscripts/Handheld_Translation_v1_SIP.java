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
import  net.medavante.mobile.appium.core.MobileCoreFunctions;

public class Handheld_Translation_v1_SIP extends BaseTest {

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
	public Handheld_Translation_v1_SIP(String driver) {
		super(driver);
	}
	
	// Image sequence in Random order with gap


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
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon(false);
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
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon(false);
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
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon(false);
		registrationCodeForObserver = subjectDetailPage.getRegistrationCodeOfSubject();
		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();

		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.clickOnAddObserverBtN();
		subjectDetailPage.inputObserverRelationName(observerRelation1);
		subjectDetailPage.inputObserverAliasName(observerAlias);
		subjectDetailPage.clickOnObserverSaveBTN();
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		
	}
	
	public void disableSubject(String subjectName) throws Exception {
		
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		
//		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
//		
//		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
//				Constants.NavigateText, Constants.StudyText);
//		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
//		studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject,
//				"SpanishUS8");
//		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("SpanishUS8");
		
		subjectDetailPage.clickOnReportedOutComeButton();
		Thread.sleep(3000);
		subjectDetailPage.selectMobileProSubjectOption("Disabled");
		Thread.sleep(2000);
		
		subjectDetailPage.enterReasonIntoMobileProSubjectReasonTextBoxField("Data entry error");
		Thread.sleep(2000);
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		Thread.sleep(2000);
		subjectDetailPage.selectReasonForChangeOption("Data entry error");
		Thread.sleep(2000);
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(FormUserName, Form_Password);
		Thread.sleep(3000);
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		Thread.sleep(5000);
//		loginPage.logoutApplication();
//		loginPage.verifyUserLogout();
	}
	
	public void enableSubject(String subjectName) throws Exception {
		
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
//		
//		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
//		
//		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
//				Constants.NavigateText, Constants.StudyText);
//		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);

//		studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject,
//				"SpanishUS8");
//		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("SpanishUS8");
		subjectDetailPage.clickOnReportedOutComeButton();
		Thread.sleep(3000);
		subjectDetailPage.selectMobileProSubjectOption("Enabled");
		Thread.sleep(2000);
		//subjectDetailPage.enterReasonIntoMobileProSubjectReasonTextBoxField("Enabling the subject");
		subjectDetailPage.clickOnReportedOutComePopUpSaveBTN();
		Thread.sleep(3000);
		subjectDetailPage.selectReasonForChangeOption("Data entry error");
		Thread.sleep(2000);
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(FormUserName, Form_Password);
		Thread.sleep(2000);
//		loginPage.logoutApplication();
//		loginPage.verifyUserLogout();
	}

	/**
	 * ====================================================================================================================
	 * eCOA Handheld Script Workflow
	 * ====================================================================================================================
	 * 
	 * Require 3 Subjects now to overcome Unlock subject issue
	 *  */
	

	@Test(description = "eCOA Handheld Script Workflow", groups = { "Mobile" })

	public void eCOAHandheldScriptWorkflow() throws Exception {
		//reportLog("1.1:MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();
		
	    reportLog("Verify the registration instruction message");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Image 5");
		mobileLoginPage.configurationForRegisterTheSubject("0774-487F-4831-B943");
			
		reportLog("MobileView: Click on Accept button at Terms and Condition page");
		mobileLoginPage.clickOnAcceptBtn(false); 
		
		reportLog("Image 6");
		mobileLoginPage.verifyPinAndConfirmPINEditBoxesAreDisplay();
		
		reportLog("Image 7");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);

		Thread.sleep(2000);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_PinInCorrect, false);
		mobileLoginPage.verifyPinDontMatchTextDisplay();
		
		reportLog("7.1:MobileView Enter numerical value ‘1234’ in ‘PIN’ and ‘1234’ in ‘Confirm PIN’ Select ‘Next’ ");
		Thread.sleep(1000);
		mobileLoginPage.clearConfirmPINBox();
		Thread.sleep(1000);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin, false);

		mobileLoginPage.clickOnNextButton();
		
		reportLog("Image 8");
		mobileLoginPage.verifyChooseAQuestionDisplay(true);
		
		reportLog("Image 9a");
		mobileLoginPage.clickOnChooseAQuestionOption(true);
		mobileLoginPage.clickOnCancelButton();
		
		reportLog("Image 9b");
		mobileLoginPage.clickOnChooseAQuestion(true);
		
		reportLog("");
		mobileLoginPage.chooseAQuestion();
		Thread.sleep(1000);
		
		mobileLoginPage.enterAnAnswer("Black", false);
		reportLog("Image 10");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();

		reportLog("10.1:MobileView Select Continue");
		mobileLoginPage.clickOnContinueButton(false);
		
		reportLog("Image 11");
		mobileLoginPage.verifySignInScreenWithPINEditBox();
		
		reportLog("Image 12");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.clickOnSubmitButton();
		sideMenu = mobileLoginPage.mobileSideMenu();
		Thread.sleep(3000);
		
		reportLog("Image 13");
		sideMenu.verifyHomePageDisplay();
		
		mobileLoginPage = androidSetUpWithoutReset();
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();		
		
		reportLog("13.1:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();
		
		reportLog("13.2:MobileView Keep providing wrong PIN until 1attempt is left");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();
	
		reportLog("Image 15");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		dashborad = mobileLoginPage.loginUser(Mobile_Pin);
		sideMenu = mobileLoginPage.mobileSideMenu();	
		
//		reportLog("15.1:MobileView Connect to the internet");
	    dashborad = mobileLoginPage.mobiledashboard();
	
		reportLog("Image 18\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
	
		reportLog("Image 19\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage.selectQuestionForms("Diary1", true);

		reportLog("click on Start button");
		questionnairesPage.clickOnStartQuestion();
		
		reportLog("Image 20\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage.testLMNMobileQuestionnaire(true);
		
		reportLog("Image 21\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage	 = dashborad.clickOnQuestionnairesTab();
		Thread.sleep(3000);
		
		reportLog("Image 22\nNote:\nAll Questionnaire Names: Place-\nholder text, no translation needed");
		questionnairesPage = dashborad.clickOnQuestionnairesScrollFromTopToBottom(); 
		
		reportLog("22.1:Click questionnaire Test_LMN Mobile");
		questionnairesPage.selectQuestionForms("Test_LMN Mobile", false);
		Thread.sleep(10000);
		questionnairesPage.clickOnStartQuestion();
		
		
		reportLog("Image 23\nNote:\nBackground English Text: Placeholder text, \nno translation needed.");
		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
		questionnairesPage.clickOnYesOption();
		
		messagePage = dashborad.clickOnMessageTab(false);
		messagePage = dashborad.clickOnMessageTab(false);
        Thread.sleep(5000);
	
		reportLog("Image 24");
		messagePage = dashborad.clickOnMessageTab(true);
		
		reportLog("Image 25");
		mobileLoginPage.scrollDownToRefreshPage();
			
		sendingMessage();

		reportLog("Image 26\nNote:\nmorning Diary: Placeholder\ntext, no translation needed.");
		mobileLoginPage.scrollDownToRefreshPage();
			
		reportLog("26.1:MobileView Click on Message tab and click on the first message");
		messagePage = dashborad.clickOnMessageTab(false);
		messagePage.clickFirstMsgOnMessageListScreen(false);
		
		reportLog("Image 27\nNote:\nmorning Diary: Placeholder\ntext, no translation needed.");
		messagePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		
		reportLog("Image 28");
		mobileLoginPage.tapByCoordinate(1295, 2634, true);
		
		reportLog("28.1:MobileView Type ‘abcd’ in the message body and select back icon. Exit warning message is displayed along with yes/no options.");
		messagePage.inputTxtInMsgSubjectField("abcd");
		
		reportLog("Image 29");
		messagePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		
		reportLog("29.1:MobileView Select ‘No’.");
		messagePage.clickOnNoOnExitPopUp();
		messagePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("29.2:MobileView Select ‘Yes’.");
		messagePage.clickOnYesOnExitPopUp();
		
		reportLog("29.3:MobileView Select (+) compose icon and write ‘abcd’ in the subject and select send icon. Message content cannot be empty text is displayed.");
		mobileLoginPage.tapByCoordinate(1295, 2634, false);
		messagePage.inputTxtInMsgSubjectField("abcd");
		
		reportLog("Image 30");
		messagePage.clickOnSendMsgBtn(true);
		
		reportLog("30.1:MobileView Select (+) compose icon and write ‘abcd’ in the subject and ‘efgh’ in the body and select send icon.");
		messagePage.inputTxtInMsgSubjectField("abcd");
		messagePage.inputTxtInMsgBodyField("efgh");
		
		reportLog("Image 31");
		messagePage.clickOnSendMsgBtn(true);
		
		reportLog("Image 32\nNote:\nmorning Diary: Placeholder\ntext, no translation needed.");
		mobileLoginPage.tapByCoordinate(1295, 2634, false);
		messagePage.inputTxtInMsgSubjectField("abcd");
		messagePage.inputTxtInMsgBodyField("efgh");
		messagePage.clickOnSendMessageBtnForMultiCapture();
		
		reportLog("Select the First message");
		messagePage.clickFirstMsgOnMessageListScreen(false);
		
		reportLog("Image 33");
		messagePage.clickOnDeleteMessageButton();    
		
		sendingMessage();
		
		reportLog("33.1:Go to Message tab");
		messagePage = dashborad.clickOnMessageTab(false);
		Thread.sleep(1000);
		
		reportLog("33.2:Refresh the page");
		mobileLoginPage.scrollDownToRefreshPage();
		
		reportLog("33.3:MobileView Select a message and select the reply icon");
		messagePage.clickFirstMsgOnMessageListScreen(false);
		Thread.sleep(2000);
		
		reportLog("Image 34\nNote:\nmorning Diary: Placeholder\ntext, no translation needed");
		messagePage.clickReplyIcon();
		
		reportLog("34.1:MobileView Select back icon");
		messagePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("Image 35\nNote:\nmorning Diary: Placeholder\ntext, no translation needed");
		messagePage.verifyWarningpopupWithButtons(true);
		
		reportLog("35.1:MobileView Exit from reply message and go to Messages page, disconnect from the internet and refresh immediately");
		messagePage.clickOnYesOnExitPopUp();
		messagePage.clickOnBackbtnOnComposeScreen();
		messagePage = dashborad.clickOnMessageTab(false);
		
		reportLog("36:MobileView Connect to the internet, compose a message, select send and immediately disconnect from the internet");
		mobileLoginPage.tapByCoordinate(1295, 2634, false);

		messagePage.inputTxtInMsgSubjectField("abcd");
		messagePage.inputTxtInMsgBodyField("efgh");
		messagePage.clickOnSendMsgBtn(false);
		Thread.sleep(3000);

		reportLog("Image 38\nNote:\nEQ-5D-5L and jk_mob:\nPlaceholder text,\nno translation needed.");
		logAnEvent= dashborad.clickOnLogAnEventTab();
		
		reportLog("Image 39\nNote:\nEQ-5D-5L: Placeholder text,\nno translation needed.");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("39.1:MobileView Select Start");
		logAnEvent.clickStartBtn();
		
		reportLog("Image 40\nNote:\nEQ-5D-5L: Placeholder text,\nno translation needed.");
		logAnEvent.completeEvent();
		Thread.sleep(2000);
		
		reportLog("40.1:MobileView Select Continue");
		logAnEvent.clickContinueBtn();
		
		//reportLog("42.1:MobileView Open an event and start it and select back icon on the top left");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("40.2:MobileView Open an event and start it");
		logAnEvent.clickStartBtn();
		
		reportLog("Image 41\nNote:\nEQ-5D-5L: Placeholder text, \nno translation needed.");
		messagePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		
		reportLog("Verify popup buttons");
		messagePage.verifyWarningpopupWithButtons(false);
		
		reportLog("41.1:MobileView Select No");
		messagePage.clickOnNoOnExitPopUp();
		
		reportLog("41.2:MobileView Select Yes");
		messagePage.clickOnBackbtnOnComposeScreen();
		messagePage.clickOnYesOnExitPopUp();
		
		reportLog("Image 42\nNote:\nEQ-5D-5L and jk_mob: Placeholder text, \nno translation needed.");
		logAnEvent.clickOnEventWithoutStartBtnVisible("jk_mob");
		
		reportLog("Image 43\nNote:\nEQ-5D-5L and jk_mob: Placeholder text, no translation needed.");
		logAnEvent.clickOnEvent1WithoutStartBtnVisible("jk_mob");
		
		reportLog("43.1:MobileView Connect to the internet and select the side menu icon.");
		sideMenu = dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 45");
		sideMenu.verifySideMenuOptions();
		
		reportLog("Image 46");
		sideMenu.clickOnMyAccount();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		reportLog("Image 60\nNote:\nvisit1: Placeholder text, \nno translation needed");
		sideMenu.clickOnMySchedule();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("60.1:MobileView Select ‘Study Information’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 61");
		sideMenu.clickOnStudyInformation();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("61.1:MobileView Select ‘Contact Us’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 62");
		sideMenu.clickOnContacts();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("62.1:MobileView Select ‘Settings’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 63");
		sideMenu.clickOnSettings();
		
		reportLog("Image 64");
		sideMenu.clickOnChangeColorTheme();
		
		reportLog("64.1:MobileView Exit from the color theme and Select ‘Help & Tutorials’ from the side menu");
		sideMenu.exitFromColorThemePopup();
		sideMenu.clickOnBackIcon();
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 65");
		sideMenu.helpAndTutorials();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("65.1:MobileView Select ‘About Us’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 66");
		sideMenu.clickOnAboutUs();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
//		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
//		reportLog("Image 66b");
//		sideMenu.clickOnAboutUs2();
//		
//		reportLog("Click back icon");
//		sideMenu.clickOnBackIcon();
	
		reportLog("66.1:MobileView Exit the application and re-launch it");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		sideMenu.clickOnExitApplication();

		mobileLoginPage = androidSetUpWithoutReset();
		
		reportLog("Image 67");
		mobileLoginPage.clickOnForgetPINLink(true);
		
		reportLog("Selected question is showing");
		mobileLoginPage.verifyChooseAQuestionShowing(false);

		reportLog(("67.1:MobileView Answer to the security question stored in Step#6"));
		mobileLoginPage.enterAnAnswer(Choose_QuestionAnswer, false);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("67.2:MobileView Use the same PIN of Step#5 to create identity"));
		mobileLoginPage.enterPINCode(Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(Mobile_Pin, false);
		
		reportLog("Image 68");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();
		Thread.sleep(2000);
		
		reportLog(("68.1:MobileView Use a different PIN to create identity"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(New_Mobile_Pin, false);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("68.2:MobileView And then login using the new PIN"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		Thread.sleep(2000);
		
		reportLog(("68.3:MobileView Repeat Step 56 and 57"));
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		sideMenu.clickOnExitApplication();
		
		mobileLoginPage = androidSetUpWithoutReset();
	
		reportLog(("68.4:MobileView Provide wrong answer of the security question in all the attempts"));
		mobileLoginPage.clickOnForgetPINLink(false);
		
		reportLog("Image 69");
		mobileLoginPage.enterIncorrectAnswer(Enter_IncorrectQuestionAnswer);
		mobileLoginPage.clickOnNextButton();
		
		reportLog("69.1:MobileView Unlock the subject");
		deactivateSubject("SpanishUS8");
		
		mobileLoginPage = androidSetUp();	
		
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject("BE99-C567-4B8F-92F4");
		mobileLoginPage.clickOnAcceptBtn(false); 
				
		mobileLoginPage.enterPINCode(MobileConstants.New_Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.New_Mobile_Pin, false);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.verifyChooseAQuestionDisplay(false);
		mobileLoginPage.clickOnChooseAQuestionOption(false);
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black", false);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnContinueButton(false);
		
		mobileLoginPage = androidSetUpWithoutReset();
		mobileLoginPage.enterPINCode(MobileConstants.New_Mobile_Pin);
		mobileLoginPage.clickOnSubmitButton();
		
		questionnairesPage = dashborad.clickOnQuestionnaires();
		
		reportLog("Click on Diary1");
		questionnairesPage.selectQuestionForms("Diary1", false);

		reportLog("click on Start button");
		questionnairesPage.clickOnStartQuestion();
		
		reportLog("Complete the questionnaire");
		questionnairesPage.testLMNMobileQuestionnaire(false);
		
		reportLog(("75:MobileView Select a questionnaire and start completing"));
		questionnairesPage.selectQuestionForms("Parent Diary 24hr", false);
		Thread.sleep(3000);
		questionnairesPage.clickOnStartQuestion();
		
		reportLog("Image 75\nNote:\nBackground English Text: Placeholder text, \nno translation needed.");
		questionnairesPage.NotFinishQuestionnaire();
		
		reportLog("click on OK button");
		questionnairesPage.clickOnOkBtn();
		
		Thread.sleep(2000);
		
		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
		
		questionnairesPage.clickOnYesOption();
		
		reportLog(("MobileView Deactivate the subject from the portal and add a new subject"));
		deactivateSubject("SpanUS8");
		
		reportLog(("MobileView Relaunch the application, complete Registration process. "));
		mobileLoginPage = androidSetUp();

		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Image 81");
		mobileLoginPage.configurationForRegisterTheSubject("0185-6229-4A7B-B325");
		
		reportLog("MobileView Click on Accept and complete the registration process for Observer");
		mobileLoginPage.clickOnAcceptBtn(false);
/*		
		reportLog(("68.1:MobileView Use a different PIN to create identity"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("68.2:MobileView And then login using the new PIN"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("68.3:MobileView Repeat Step 56 and 57"));
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		sideMenu.clickOnExitApplication();
		
		mobileLoginPage = androidSetUpWithoutReset();
	
		reportLog(("68.4:MobileView Provide wrong answer of the security question in all the attempts"));
		mobileLoginPage.clickOnForgetPINLink(false);
		//mobileLoginPage.enterIncorrectPINCode(Mobile_PinInCorrect);
		
		reportLog("Image 69");
		mobileLoginPage.enterIncorrectAnswer(Enter_IncorrectQuestionAnswer);
		mobileLoginPage.clickOnNextButton();
		
		reportLog("69.1:MobileView Unlock the subject");
		unlockSubject();
		
		//reportLog(("62:MobileView From the portal deactivate the subject whose account is locked "));
		//deactivateSubject("16Dec_3");
		//Thread.sleep(100000);
		
		//reportLog(("65:MobileView Disable the subject from the portal"));
		//disableSubject("16Dec_3");

		mobileLoginPage = androidSetUpWithoutReset();
	
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin_AfterLock);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin_AfterLock);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.verifyChooseAQuestionDisplay();
		mobileLoginPage.clickOnChooseAQuestionOption(false);
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.clickOnContinueButton(false);
			
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin_AfterLock);
		mobileLoginPage.clickOnSubmitButton();
		
//		disableSubject("16Dec_3");
//		
//		questionnairesPage	 = dashborad.clickOnQuestionnairesTab();
//
//		reportLog("Image 71");
//		mobileLoginPage.scrollDownToRefreshPage();
//		
//		enableSubject("16Dec_3");
		
		reportLog(("MobileView Deactivate the subject from the portal and add a new subject"));
		deactivateSubject("16Dec_3");
		
		reportLog(("MobileView Relaunch the application, complete Registration process. "));
		mobileLoginPage = androidSetUp();

		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Image 81");
		mobileLoginPage.configurationForRegisterTheSubject("507E-F7A2-4280-8D74");
		
		reportLog("MobileView Click on Accept and complete the registration process for Observer");
		mobileLoginPage.clickOnAcceptBtn();
//		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.clickOnNextButton();
//		mobileLoginPage.clickOnChooseAQuestionOption(false);
//		mobileLoginPage.chooseAQuestion();
//		mobileLoginPage.enterAnAnswer("Black");
//		mobileLoginPage.clickOnNextButton();
//		mobileLoginPage.clickOnContinueButton(false);
		
		//disableSubject("16Dec_3");
			
		//reportLog(("Image 71"));
		//questionnairesPage = dashborad.clickOnQuestionnaires();
		//mobileLoginPage.scrollDownToRefreshPage();
		//Thread.sleep(100000);
	
//		reportLog(("67:MobileView Enable the subject from the portal"));
		//enableSubject("16Dec_3");
	/*
		reportLog(("68:MobileView Relaunch the VirgilPRO application"));
		mobileLoginPage = androidSetUpWithoutReset();	
		
		reportLog(("69:MobileView Sign-in to the application"));
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin_AfterLock);
		mobileLoginPage.clickOnSubmitButton();	
		
		*/
		
//		reportLog(("74:MobileView Select to go back to questionnaire tab"));
//		questionnairesPage = dashborad.clickOnQuestionnairesTab();
//		
//		reportLog(("75:MobileView Select a questionnaire and start completing"));
//		questionnairesPage.selectQuestionForms("Parent Diary 24hr");
//		Thread.sleep(3000);
//		questionnairesPage.clickOnStartQuestion();
//		
//		reportLog("Image 75");
//		questionnairesPage.NotFinishQuestionnaire();
//		
//		reportLog("click on OK button");
//		questionnairesPage.clickOnOkBtn();
//		
//		Thread.sleep(2000);
//		
//		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
//		
//		questionnairesPage.clickOnYesOption();
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
/*		
	    dashborad = mobileLoginPage.mobiledashboard();

		reportLog(("81:MobileView Go to Messages and Select to compose a message"));
		messagePage = dashborad.clickOnMessageTab(false);
		mobileLoginPage.tapByCoordinate(1295, 2634, false);
		
		reportLog(("Image 82"));
		messagePage.longPressOnSendMsgBtn();
		
		reportLog(("83: MobileView Select back to the home page"));
		messagePage.clickOnBackbtnOnComposeScreen();
		//sideMenu.clickHomePageIcon();
		
		reportLog(("87:MobileView Go to the Questionnaire Tab and refresh"));
		//questionnairesPage = dashborad.clickOnQuestionnairesTab();
		
		reportLog(("90:MobileView Refresh the questionnaire page and immediately disconnect from the internet"));
		//mobileLoginPage.WifiOff();		
		
//		reportLog(("92:MobileView Deactivate the subject from the portal and add a new subject"));
//		deactivateSubject("16Dec_3");
//		
//		reportLog(("93:MobileView Relaunch the application, complete Registration process. "));
//		mobileLoginPage = androidSetUp();
//
//		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
//		
//		reportLog("Image 81");
//		mobileLoginPage.configurationForRegisterTheSubject("FA56-09BF-42B3-8D29");
//		
//		reportLog("Click on Accept and complete the registration process for Observer");
//		mobileLoginPage.clickOnAcceptBtn();
//		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.clickOnNextButton();
//		mobileLoginPage.clickOnChooseAQuestionOption(false);
//		mobileLoginPage.chooseAQuestion();
//		mobileLoginPage.enterAnAnswer("Black");
//		mobileLoginPage.clickOnNextButton();
//		mobileLoginPage.clickOnContinueButton(false);
		
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
		deactivateSubject("16Dec_3");

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
			dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
			studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
			studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
			studyNavigatorDashBoardPage
					.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, subjectName);
			subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject(subjectName);
			subjectDetailPage.deactivateSubjectConfiguration(TRNUserName, TRN_Password);
			loginPage.logoutApplication();
			loginPage.verifyUserLogout();
	}
	
	public void sendingMessage() throws Exception {
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
		studyNavigatorDashBoardPage
				.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, "SpanishUS8");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("SpanishUS8");
		subjectDetailPage.sendMessage();
		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
	}
	
	public void unlockSubject() throws Exception {
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
		studyNavigatorDashBoardPage
				.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, "SpanishUS8");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("SpanishUS8");
		
		subjectDetailPage.clickOnReportedOutComeButton();
		subjectDetailPage.clickOnSubjectUnLockButtonDisplayedOnReportedOutcomePopUp();
		subjectDetailPage.selectReasonForChangeOption("Technical difficulties");
		
		subjectDetailPage.inputCredentialsInReasonForChangePopUp(TRNUserName, TRN_Password);
        Thread.sleep(5000);
		
		subjectDetailPage.clickOnReportedOutComePopUpCancelBTN();
        Thread.sleep(5000);

		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
	}
	
}
