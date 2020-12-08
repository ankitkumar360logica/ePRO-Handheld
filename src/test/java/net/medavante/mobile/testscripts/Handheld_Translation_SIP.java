package net.medavante.mobile.testscripts;

import java.util.Properties;

import org.jfree.util.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import App.MultiLingual;
import App.PropReader;
import net.medavante.portal.dataproviders.DataProviders;
import net.medavante.portal.pages.studynavigator.NewSubjectDetailPage;
import net.medavante.portal.pages.studynavigator.StudyDashBoardPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.selenium.core.Configuration;
import net.medavante.portal.utilities.Constants;
import net.medavante.portal.utilities.MobileConstants;

public class Handheld_Translation_SIP extends BaseTest {

	private String subjectName = "AutomationEpro" + generateRandomString(5), questionnairesValue;

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
		
		String abc=	MultiLingual.locallang("Accept");
				
		System.out.println(abc);	
		
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
//		
//		loginPage.logoutApplication();
//		loginPage.verifyUserLogout();	
		
		/* Subject Created Successfully */
	}

	/**
	 * ====================================================================================================================
	 * Test Case Id: FP-TC-794 Test Case Name: Questionnaires Navigation
	 * ====================================================================================================================
	 * 
	 * 
	 */

	@Test(description = "Accept Terms and Condition", groups = { "Mobile" })

	public void AcceptTermsConditions() throws Exception {

		reportLog("1.1:MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();
		
		reportLog(
				"1.2:MobileView Application launch and verify Register screen with instruction message,register the subject");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.configurationForRegisterTheSubject("811D-8179-481A-9165");
		
		reportLog("2: MobileView Create Identity' screen is displayed with instruction message.");
		//mobileLoginPage.verifyTitleOnScreen();
		//mobileLoginPage.verifyInstructionMessageText();
			
		reportLog("2.1: MobileView Pin and Confirm Pin edit boxes shall be displayed.");
		//mobileLoginPage.verifySignInScreenWithPINEditBox();
		
		reportLog("MobileView deactivate subject from device");
		updateSubjectValueInPropertiesFile();
		
		reportLog("2.2: MobileView Click I forgot PIN link.");
		mobileLoginPage.clickOnForgetPINLink();
		
		reportLog("2.3: MobileView Keep providing wrong PIN until 1attempt is left.");
		mobileLoginPage.provideWrongPINUntil1Attemptleft(MobileConstants.Mobile_PinInCorrect);
		
		reportLog("2.4: MobileView Enter correct PIN’ and select ‘Submit’");
		//mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterAnAnswer(MobileConstants.Choose_QuestionAnswer);

		mobileLoginPage.clickSubmitBtn();
		
//		reportLog("2.2: MobileView Next button shall be displayed in disabled state");
//		mobileLoginPage.verifyNextButtonIsDisabled();
//		
//		reportLog("2.3: MobileView Avatar and Participant version label shall be displayed");
//		mobileLoginPage.verifyAvatarAndVersionLabelIsDisplay();
//		
//		reportLog("3: MobileView Enter different identity. ( pin and non-matching confirm pin details).");
//		mobileLoginPage.enterPINCode(Mobile_Pin);
//		mobileLoginPage.enterConfirmPINCode(Mobile_PinInCorrect);
//		
//		reportLog("3.1: MobileView Next button shall be displayed in disabled state");
//		mobileLoginPage.verifyNextButtonIsDisabled();
//
//		reportLog("1.5:MobileView Login with configured Pin");
//		mobileLoginPage.verifySignInScreenDisplayed();
//		dashborad = mobileLoginPage.loginUser(Mobile_Pin);
//
//		reportLog("1.6:MobileView Check top menu configured with home,questionnaries,message,log an event");
//		dashborad.verifyUserLogin();
//		dashborad.verifyTopMenuOptions();
	}

		
	@AfterMethod
	public void deactivateUser(ITestResult result) throws InterruptedException {

		if (ITestResult.SUCCESS == result.getStatus()) {

			reportLog("Deactivate Subject");
			dashBoardPage = loginPage.loginInApplication(formAdminUN, formAdminPW);
			studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
			studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, subjectName);
			subjectDetailPage = studyNavigatorDashBoardPage.selectByFirstCell(NewSubjectDetailPage.class);
			subjectDetailPage.deactivateSubjectConfiguration(formAdminUN, formAdminPW);
			loginPage.logoutApplication();
			loginPage.verifyUserLogout();
		} else {
			Log.error("Deactivation Not needed");
		}
	}
	
	public void updateSubjectValueInPropertiesFile() throws InterruptedException {
		//if(ITestResult.SUCCESS==result.getStatus()) {
			
			reportLog("Deactivate Subject");
			dashBoardPage = loginPage.loginInApplication(formAdminUN, formAdminPW);
			studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
			
			studyNavigatorDashBoardPage
					.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, screeningNum);
			subjectDetailPage = studyNavigatorDashBoardPage.selectByFirstCell(NewSubjectDetailPage.class);
			subjectDetailPage.deactivateSubjectConfiguration(formAdminUN, formAdminPW);
			loginPage.logoutApplication();
			loginPage.verifyUserLogout();
			
			
		
	}
}
