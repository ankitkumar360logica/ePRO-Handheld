package net.medavante.mobile.testscripts;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.medavante.mobile.appium.core.MobileDriver;
import net.medavante.mobile.pages.MobileDashBoardPage;
import net.medavante.mobile.pages.MobileLoginPage;
import net.medavante.portal.dataproviders.DataProviders;
import net.medavante.portal.pages.studynavigator.NewSubjectDetailPage;
import net.medavante.portal.pages.studynavigator.StudyDashBoardPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.selenium.core.Configuration;
import net.medavante.portal.utilities.Constants;
import net.medavante.portal.utilities.MobileConstants;
import  net.medavante.mobile.appium.core.MobileCoreFunctions;

public class WebModality_Translation_SIP extends BaseTest {
	
	public int DEFAULT_WAIT_ELEMENT = 3000;

	@BeforeClass
	public void executionOn() {
		exceutionOn = "MobileAndWebExecution";
	}

	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public WebModality_Translation_SIP(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("WebModalityStudy");
		
	}

	/**
	 * ====================================================================================================================
	 * eCOA Handheld Script Workflow
	 * ====================================================================================================================
	 * 
	 * 
	 *  */
	

	@Test(description = "eCOA Handheld Script Workflow", groups = { "Mobile" })

	public void subjectRegistration_WebModality() throws Exception {
		//reportLog("1.1:MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();
		
	   // reportLog("Verify the registration instruction message");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		//reportLog("Image 1");
		//mobileLoginPage.configureForRegisterTheSubject("7627-EBE1-4862-BD33");
			
		//reportLog("Click on Accept button at Terms and Condition page");
		mobileLoginPage.clickOnAccept(false);  
		
		//reportLog("Image 2");
		mobileLoginPage.verifyPinAndConfirmPINEditBoxesAreDisplayed();
		
		//reportLog("Image 3");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
        Thread.sleep(2000);
        
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin, false);
		//mobileLoginPage.verifyPinDontMatchTextDisplay();
		
		//reportLog("3.1:MobileView Enter numerical value ‘1234’ in ‘PIN’ and ‘1234’ in ‘Confirm PIN’ Select ‘Next’ ");
		Thread.sleep(1000);

		mobileLoginPage.clickOnNextButton();
		
		//reportLog("Image 4");
		mobileLoginPage.verifyChooseAQuestionDisplay(false);
		
		//reportLog("Image 5");
		mobileLoginPage.clickOnChooseAQuestionOption(false);
		
		//reportLog("MobileView Select a question");
		mobileLoginPage.chooseAQuestion();
		Thread.sleep(1000);
		
		mobileLoginPage.enterAnAnswer("black", false);
		mobileLoginPage.clickOnNextButton();

		//reportLog("6.1:MobileView Select Continue");
		mobileLoginPage.clickOnContinueButton(false);
		
		//**************** Web Modality function ************************************
		
		reportLog("Image 1");
		webAssessmentSubject("ENUS18_1");
		
		reportLog("Image 2");
		subjectDetailPage.enterPin("2222");
		
		reportLog("Image 4\nNote:\nthe content inside the form \n“_EQ-5D-5L_” is placeholder, \nno translation needed");
		subjectDetailPage.enterCorrectPin("1234");
		Thread.sleep(30000);
		
		reportLog("Click on Take a Break");
		subjectDetailPage.clickTakeABreak();
		
		reportLog("Image 5");
		subjectDetailPage.verifySubjectCodeTextFieldShowing();
		
		reportLog("Image 6");
		subjectDetailPage.enterIncorrectSubjectCode("111-222-333-44");
		
		reportLog("Enter correct subject code");
		subjectDetailPage.enterSubjectCode();
		subjectDetailPage.clickContinueBtn();
		
		reportLog("Image 7");
		subjectDetailPage.verifySubjectIDAndPinTextBoxDispalyed();
		
		reportLog("Image 8");
		subjectDetailPage.enterSubjectIDAndPin("abcd", "2222", true);
		
		reportLog("Click on Forgot Pin link");
		subjectDetailPage.clickForgotLink();
		
		reportLog("Image 9");
		subjectDetailPage.verifySubjectIdDispalyed();
		
		reportLog("Image 10");
		subjectDetailPage.enterSubjectID("abcd", true);
		
		reportLog("Enter correct Subject ID");
		subjectDetailPage.enterSubjectID("ENUS18_1", false);
		
		reportLog("Image 11");
		subjectDetailPage.verifyProvideAnAnswerFieldShowing();
		
		reportLog("Image 12");
		subjectDetailPage.enterSecretAnswer("abc", true);
		
		reportLog("Enter correct Secret answer");
		subjectDetailPage.enterSecretAnswer("black", false);
		
		reportLog("Image 13");
		subjectDetailPage.verifyEnterPinAndConfirmPinTextFieldShowing();
		
		reportLog("Image 14");
		subjectDetailPage.enterPinAndConfirmPin("1234", "1111", true);
		
		reportLog("ENter used pin in both fields");
		subjectDetailPage.enterPinAndConfirmPin("1234", "1234", false);
		
		reportLog("Image 15");
		subjectDetailPage.clickOkBtn(true);
		
		reportLog("Enter same code in Pin and Confirm Pin text field");
		subjectDetailPage.enterPinAndConfirmPin("2222", "2222", false);
		subjectDetailPage.clickOkBtn(false);
		
		reportLog("Enter subject id and newly created PIN");
		subjectDetailPage.enterSubjectIDAndPin("ENUS18_1", "2222", false);
		
		reportLog("Image 16\nNote:\nthe background content inside the \nform “_EQ-5D-5L_” is placeholder, \nno translation needed");
		subjectDetailPage.clickIAmDoneBtn();
		
		reportLog("Click on No button");
		subjectDetailPage.clickNoBtn();	
		
		reportLog("Complete the assessment");
		subjectDetailPage.completeAssessment();
		
		reportLog("Image 18");
		subjectDetailPage.clickIAmDoneBtn();
		subjectDetailPage.clickOnAssessmentCompleteOkBtn();
	} 
		
	public void webAssessmentSubject(String subjectName) throws Exception {
			Properties properties = Configuration.readTestData("RegressionTestData");
			studyName = properties.getProperty("WebModalityStudy");
			
			dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
			studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
			studyNavigatorDashBoardPage.selectStudy(studyName, Constants.testSite);
			studyNavigatorDashBoardPage
					.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, subjectName);
			subjectDetailPage = studyNavigatorDashBoardPage.clickOnSearchedSubject(subjectName);
			subjectDetailPage.openWebAssessmentPage();
			//loginPage.logoutApplication();
			
	}
	
	@AfterMethod
	public void quit() {
		
	}
	
}
