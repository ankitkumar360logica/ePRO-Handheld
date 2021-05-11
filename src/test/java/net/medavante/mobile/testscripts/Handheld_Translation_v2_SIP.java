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

public class Handheld_Translation_v2_SIP extends BaseTest {

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
	public Handheld_Translation_v2_SIP(String driver) {
		super(driver);
	}
	
	// Image sequence in Chronological order without any gap

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
	
	public void disableSubject(String subjectName) throws Exception {
		
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("HandheldTranslationStudy");
		
//		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
//		
//		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
//				Constants.NavigateText, Constants.StudyText);
//		studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
//		studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject,
//				"SwedishSweden1");
//		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("SwedishSweden1");
		
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
//				"ABFDG");
//		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("ACFDVV");
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
	 * 
	 *  */
	

	@Test(description = "eCOA Handheld Script Workflow", groups = { "Mobile" })

	public void eCOAHandheldScriptWorkflow() throws Exception {
		//reportLog("1.1:MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();
		
	    reportLog("Verify the registration instruction message");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Image 1");
		mobileLoginPage.configurationForRegisterTheSubject("D029-DB16-47FC-BC4D");
			
		reportLog("Click on Accept button at Terms and Condition page");
		mobileLoginPage.clickOnAcceptBtn(false);  
		
		reportLog("Image 2");
		mobileLoginPage.verifyPinAndConfirmPINEditBoxesAreDisplay();
		
		reportLog("Image 3");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
        Thread.sleep(2000);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.verifyPinDontMatchTextDisplay();
		
		reportLog("3.1:MobileView Enter numerical value ‘1234’ in ‘PIN’ and ‘1234’ in ‘Confirm PIN’ Select ‘Next’ ");
		Thread.sleep(1000);
		mobileLoginPage.clearConfirmPINBox();
		Thread.sleep(1000);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin);

		mobileLoginPage.clickOnNextButton();
		
		reportLog("Image 4");
		mobileLoginPage.verifyChooseAQuestionDisplay(true);
		
		reportLog("Image 5a");
		mobileLoginPage.clickOnChooseAQuestionOption(true);
		mobileLoginPage.clickOnCancelButton();
		
		reportLog("Image 5b");
		mobileLoginPage.clickOnChooseAQuestion(true);
		
		reportLog("MobileView Select a question");
		mobileLoginPage.chooseAQuestion();
		Thread.sleep(1000);
		
		mobileLoginPage.enterAnAnswer("Black");
		reportLog("Image 6");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();

		reportLog("6.1:MobileView Select Continue");
		mobileLoginPage.clickOnContinueButton(false);
		
		reportLog("Image 7");
		mobileLoginPage.verifySignInScreenWithPINEditBox();
		
		reportLog("Image 8");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		reportLog("8.1:MobileView Keep entering the wrong pin");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();
		
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButton();		
		
		reportLog("Image 9");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_PinInCorrect);
		mobileLoginPage.clickOnSubmitButtonToCaptureScreenshot();
		
		reportLog("9.1:MobileView Enter correct pin");
		dashborad = mobileLoginPage.loginUser(Mobile_Pin);
		sideMenu = mobileLoginPage.mobileSideMenu();
		
//		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
//		mobileLoginPage.clickOnSubmitButton();
		sideMenu = mobileLoginPage.mobileSideMenu();
		Thread.sleep(3000);
		
		reportLog("Image 10");
		sideMenu.verifyHomePageDisplay();	
		
//	   reportLog("10.1:MobileView Connect to the internet");
	   dashborad = mobileLoginPage.mobiledashboard();
	
		reportLog("Image 13\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage = dashborad.clickOnQuestionnairesTab();
	
		reportLog("Image 14\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage.selectQuestionForms("Diary1", true);

		reportLog("click on Start button");
		questionnairesPage.clickOnStartQuestion();
		
		reportLog("Image 15\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage.testLMNMobileQuestionnaire(true);
		
		reportLog("Image 16\nNote:\nDiary1: Placeholder text,\nno translation needed.");
		questionnairesPage	 = dashborad.clickOnQuestionnairesTab();
		Thread.sleep(3000);
		
		reportLog("Image 17\nNote:\nAll Questionnaire Names: Place-\nholder text, no translation needed");
		questionnairesPage = dashborad.clickOnQuestionnairesScrollFromTopToBottom();
		//Thread.sleep(4000);
		
		reportLog("17.1:MobileView Exit the application and re-launch it");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		sideMenu.clickOnExitApplication();

		mobileLoginPage = androidSetUpWithoutReset();
		dashborad = mobileLoginPage.loginUser(Mobile_Pin);
		
		questionnairesPage	 = dashborad.clickOnQuestionnaires();
		
		reportLog("17.1:Click questionnaire Test_LMN Mobile");
		questionnairesPage.selectQuestionForms("Test_LMN Mobile", false);
		Thread.sleep(2000);
		questionnairesPage.clickOnStartQuestion();
		
		reportLog("Image 18\nNote:\nBackground English Text: Placeholder text, \nno translation needed.");
		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
		questionnairesPage.clickOnYesOption();
		//Thread.sleep(20000);
		
		messagePage = dashborad.clickOnMessageTab(false);
		messagePage = dashborad.clickOnMessageTab(false);
        Thread.sleep(5000);
/*	
		reportLog("Image 19");
		messagePage = dashborad.clickOnMessageTab(true);
		
		reportLog("Image 20");
		mobileLoginPage.scrollDownToRefreshPage();
		
		sendingMessage();

		reportLog("Image 21\nNote:\nmorning Diary: Placeholder\ntext, no translation needed.\ntest123: Placeholder text, no \ntranslation needed");
		mobileLoginPage.scrollDownToRefreshPage();
			
		reportLog("21.1:MobileView Click on Message tab and click on the first message");
		messagePage = dashborad.clickOnMessageTab(false);
		messagePage.clickFirstMsgOnMessageListScreen(false);
		
		reportLog("Image 22\nNote:\nmorning Diary: Placeholder\ntext, no translation needed.\ntest123: Placeholder text, no \ntranslation needed");
		messagePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		
		reportLog("Image 23");
		mobileLoginPage.tapByCoordinate(1295, 2634, true);
		
		reportLog("28.1:MobileView Type ‘abcd’ in the message body and select back icon. Exit warning message is displayed along with yes/no options.");
		messagePage.inputTxtInMsgSubjectField("abcd");
		
		reportLog("Image 24");
		messagePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		
		reportLog("23.1:MobileView Select ‘No’.");
		messagePage.clickOnNoOnExitPopUp();
		messagePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("23.2:MobileView Select ‘Yes’.");
		messagePage.clickOnYesOnExitPopUp();
		
		reportLog("23.3:MobileView Select (+) compose icon and write ‘abcd’ in the subject and select send icon. Message content cannot be empty text is displayed.");
		mobileLoginPage.tapByCoordinate(1295, 2634, false);
		messagePage.inputTxtInMsgSubjectField("abcd");
		
		reportLog("Image 25");
		messagePage.clickOnSendMsgBtn(true);
		
		reportLog("25.1:MobileView Select (+) compose icon and write ‘abcd’ in the subject and ‘efgh’ in the body and select send icon.");
		messagePage.inputTxtInMsgSubjectField("abcd");
		messagePage.inputTxtInMsgBodyField("efgh");
		
		reportLog("Image 26");
		messagePage.clickOnSendMsgBtn(true);
		
		reportLog("Image 27\nNote:\nmorning Diary: Placeholder\ntext, no translation needed.\ntest123: Placeholder text, no \ntranslation needed");
		mobileLoginPage.tapByCoordinate(1295, 2634, false);
		messagePage.inputTxtInMsgSubjectField("abcd");
		messagePage.inputTxtInMsgBodyField("efgh");
		messagePage.clickOnSendMessageBtnForMultiCapture();
		
		reportLog("27.1:MobileView: Select the First message");
		messagePage.clickFirstMsgOnMessageListScreen(false);
		
		reportLog("Image 28");
		messagePage.clickOnDeleteMessageButton();    
		
		sendingMessage();
				
		reportLog("28.1:Go to Message tab");
//		messagePage = dashborad.clickOnMessageTab(false);
//		Thread.sleep(1000);
		
		reportLog("28.2:Refresh the page");
		mobileLoginPage.scrollDownToRefreshPage();
		
		reportLog("28.3:MobileView Select a message and select the reply icon");
		messagePage.clickFirstMsgOnMessageListScreen(false);
		Thread.sleep(2000);
		
		reportLog("Image 29\nNote:\nmorning Diary: Placeholder\ntext, no translation needed");
		messagePage.clickReplyIcon();
		
		reportLog("29.1:MobileView Select back icon");
		messagePage.clickOnBackbtnOnComposeScreen();
		
		reportLog("Image 30\nNote:\nmorning Diary: Placeholder\ntext, no translation needed");
		messagePage.verifyWarningpopupWithButtons(true);
		
		reportLog("30.1:MobileView Exit from reply message and go to Messages page, disconnect from the internet and refresh immediately");
		messagePage.clickOnYesOnExitPopUp();
		messagePage.clickOnBackbtnOnComposeScreen();
		messagePage = dashborad.clickOnMessageTab(false);
		
		reportLog("30.2:MobileView Connect to the internet, compose a message, select send and immediately disconnect from the internet");
		mobileLoginPage.tapByCoordinate(1295, 2634, false);

		messagePage.inputTxtInMsgSubjectField("abcd");
		messagePage.inputTxtInMsgBodyField("efgh");
		messagePage.clickOnSendMsgBtn(false);
		Thread.sleep(3000);
*/
		reportLog("Image 33\nNote:\nEQ-5D-5L and jk_mob:\nPlaceholder text,\nno translation needed.");
		logAnEvent= dashborad.clickOnLogAnEventTab();
		
		reportLog("Image 34\nNote:\nEQ-5D-5L and jk_mob:\nPlaceholder text,\nno translation needed.");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("34.1:MobileView Select Start");
		logAnEvent.clickStartBtn();
		
		reportLog("Image 35\nNote:\nEQ-5D-5L: Placeholder text,\nno translation needed.");
		logAnEvent.completeEvent();
		Thread.sleep(2000);
		
		reportLog("35.1:MobileView Select Continue");
		logAnEvent.clickContinueBtn();
		
		//reportLog("42.1:MobileView Open an event and start it and select back icon on the top left");
		logAnEvent.clickOnEvent("EQ-5D-5L");
		
		reportLog("35.2:MobileView Open an event and start it");
		logAnEvent.clickStartBtn();
		
		reportLog("Image 36\nNote:\nEQ-5D-5L: Placeholder text, \nno translation needed. \n\nBackground English Text: \nPlaceholder text, no translation \nneeded");
		messagePage.clickOnBackbtnOnComposeScreenToCaptureScreen();
		
		reportLog("36.1:MobileView Verify popup buttons");
		messagePage.verifyWarningpopupWithButtons(false);
		
		reportLog("36.2:MobileView Select No");
		messagePage.clickOnNoOnExitPopUp();
		
		reportLog("36.3:MobileView Select Yes");
		messagePage.clickOnBackbtnOnComposeScreen();
		messagePage.clickOnYesOnExitPopUp();
		
		reportLog("Image 37\nNote:\nEQ-5D-5L and jk_mob: Place-\nholder text, no translation needed");
		logAnEvent.clickOnEventWithoutStartBtnVisible("jk_mob");
		
		reportLog("Image 38\nNote:\nEQ-5D-5L and jk_mob: Place-\nholder text, no translation needed");
		logAnEvent.clickOnEvent1WithoutStartBtnVisible("jk_mob");
		
		reportLog("38.1:MobileView Connect to the internet and select the side menu icon.");
		sideMenu = dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 40");
		sideMenu.verifySideMenuOptions();
		
		reportLog("Image 41");
		sideMenu.clickOnMyAccount();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		reportLog("Image 42\nNote:\nvisit1: Placeholder text, \nno translation needed");
		sideMenu.clickOnMySchedule();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("42.1:MobileView Select ‘Study Information’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 43");
		sideMenu.clickOnStudyInformation();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("43.1:MobileView Select ‘Contact Us’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 44");
		sideMenu.clickOnContacts();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("44.1:MobileView Select ‘Settings’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 45");
		sideMenu.clickOnSettings();
		
		reportLog("Image 46");
		sideMenu.clickOnChangeColorTheme();
		
		reportLog("46.1:MobileView Exit from the color theme and Select ‘Help & Tutorials’ from the side menu");
		sideMenu.exitFromColorThemePopup();
		sideMenu.clickOnBackIcon();
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 47");
		sideMenu.helpAndTutorials();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		reportLog("47.1:MobileView Select ‘About Us’ from the side menu");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 48a");
		sideMenu.clickOnAboutUs();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
		
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		
		reportLog("Image 48b");
		sideMenu.clickOnAboutUs2();
		
		reportLog("Click back icon");
		sideMenu.clickOnBackIcon();
	
		reportLog("48.1:MobileView Exit the application and re-launch it");
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		sideMenu.clickOnExitApplication();

		mobileLoginPage = androidSetUpWithoutReset();
		
		reportLog("Image 49");
		mobileLoginPage.clickOnForgetPINLink(true);
		
		reportLog("Selected question is showing");
		mobileLoginPage.verifyChooseAQuestionShowing(false);

		reportLog(("49.1:MobileView Answer to the security question stored in Step#6"));
		mobileLoginPage.enterAnAnswer(Choose_QuestionAnswer);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("49.2:MobileView Use the same PIN of Step#5 to create identity"));
		mobileLoginPage.enterPINCode(Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(Mobile_Pin);
		
		reportLog("Image 50");
		mobileLoginPage.clickOnNextButtonToCaptureScreenshot();
		Thread.sleep(2000);
		
		reportLog(("50.1:MobileView Use a different PIN to create identity"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		
		reportLog(("50.2:MobileView And then login using the new PIN"));
		mobileLoginPage.enterPINCode(New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		Thread.sleep(2000);
		
		reportLog(("50.3:MobileView Repeat Step 56 and 57"));
		dashborad.clickOnHumBergerMenuAndOpenLeftPanel(false);
		sideMenu.clickOnExitApplication();
		
		mobileLoginPage = androidSetUpWithoutReset();
	
		reportLog(("50.4:MobileView Provide wrong answer of the security question in all the attempts"));
		mobileLoginPage.clickOnForgetPINLink(false);
		
		reportLog("Image 51");
		mobileLoginPage.enterIncorrectAnswer(Enter_IncorrectQuestionAnswer);
		mobileLoginPage.clickOnNextButton();
		
		reportLog("51.1:MobileView Unlock the subject");
		deactivateSubject("SwedishSweden1");
		
		mobileLoginPage = androidSetUp();	
		
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject("A3DB-AF25-4B21-979D"); //Span20Arg
		mobileLoginPage.clickOnAcceptBtn(false); 
				
		mobileLoginPage.enterPINCode(MobileConstants.New_Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.New_Mobile_Pin);
		mobileLoginPage.clickOnNextButton();
		mobileLoginPage.verifyChooseAQuestionDisplay(false);
		mobileLoginPage.clickOnChooseAQuestionOption(false);
		mobileLoginPage.chooseAQuestion();
		mobileLoginPage.enterAnAnswer("Black");
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
		
		reportLog("Image 57");
		questionnairesPage.NotFinishQuestionnaire();
		
		reportLog("MobileView Select a questionnaire and start completingclick on OK button");
		questionnairesPage.clickOnOkBtn();
		
		Thread.sleep(2000);
		
		questionnairesPage.clickOnBackButtonIconOnQuestionPage();
		
		questionnairesPage.clickOnYesOption();
		
		reportLog(("MobileView Deactivate the subject from the portal and add a new subject"));
		deactivateSubject("SwedishSweden2");
		
		reportLog(("MobileView Relaunch the application, complete Registration process. "));
		mobileLoginPage = androidSetUp();

		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Image 68");
		mobileLoginPage.configurationForRegisterTheSubject("7E7E-22A5-47EB-ABB1"); //SpanishMexico3
		
		reportLog("Image 69\nNote:\nEnglish text for Acknowledgement test:\nPlaceholder text, no translation needed.");
		mobileLoginPage.clickOnAcceptBtn(true);
		
	} 
		
	public void deactivateSubject(String subjectName) throws Exception {
			reportLog("Deactivate Subject");
			Properties properties = Configuration.readTestData("RegressionTestData");
			studyName = properties.getProperty("HandheldTranslationStudy");
			
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
				.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, "SwedishSweden1");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("SwedishSweden1");
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
				.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, "SwedishSweden1");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject("SwedishSweden1");
		
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
