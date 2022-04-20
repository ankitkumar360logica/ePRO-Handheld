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


public class WebModality_Sanity_Translation_For_Bulgarian_SIP extends BaseTest {
	
	private String subjectName = "AutoWebModality" + generateRandomString(5);

	@BeforeClass
	public void executionOn() {
		exceutionOn = "MobileAndWebExecution";
	}

	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public WebModality_Sanity_Translation_For_Bulgarian_SIP(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("WebModalityUpdatedStudy");
	}

	/**
	 * ====================================================================================================================
	 * Web Modality Script Workflow
	 * ====================================================================================================================
	 * 
	 * 
	 *  */
	

	@Test(description = "Web Modality Script Workflow", groups = { "Sanity" })

	public void VirgilWebSanityScreenshots_Bulgarian() throws Exception {
		
		//**************** Web Modality function ***********************************
		
		reportLog("Login into application");
		dashBoardPage = loginPage.loginInApplication(TRNUserName, TRN_Password);
		
		reportLog("Go to Navigate and select Study");
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);

		reportLog("Select Study and Sites");
		studyNavigatorDashBoardPage.selectStudyNew(studyName, Constants.All_SiteText);
		
		reportLog("Click on Select button");
		studyNavigatorDashBoardPage.clickSelectButton();
		
		reportLog("Click on plus '+' icon");
		studyNavigatorDashBoardPage.clickAddSubjectBtn();
		
		reportLog("Choose Site");
		studyNavigatorDashBoardPage.slectSite();
		
		reportLog("Enter Screening # Name");
		studyNavigatorDashBoardPage.fillRequiredfieldsForsubject(subjectName);
		
		reportLog("Select the language");
		studyNavigatorDashBoardPage.selectSubjectLanguage("Bulgarian");
		
		reportLog("Click on Save button");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		
		reportLog("Verify Subject details page");
		subjectDetailPage.verifyNewSubjectDetailPage();
		
		reportLog("Click on Register button at Subject details page");
		subjectDetailPage.clickOnRegister(true);
		
		reportLog("Verify Register Subject pop up and click on Start Registration button");
		subjectDetailPage.verifyRegisterSubPopUpWindowOpen(true);
		
		reportLog("Click on Start Registration button");
		subjectDetailPage.clickOnRegisterSubjectBtn();
		
		reportLog("Verify Terms and Condition page and click Accept button.");
		subjectDetailPage.setBrowserWindowTo80();
		subjectDetailPage.verifyTermsAndConditionPageOpen(true);
	
		reportLog("Click on Accept button");
		subjectDetailPage.clickAcceptBtn(false);
		
		//reportLog("Verify Create Password page");
		//subjectDetailPage.verifyCreatePasswordFormShowing(false);
		
		reportLog("Verify Create Password page with Note Lists, Condition Lists, Password and Confirm Password fields and Next button");
		subjectDetailPage.verifyCreatePasswordPage();
		
		reportLog("Enter data in Password and Confirm Password field and click Next button");
		subjectDetailPage.enterPassword("Welcome@123", false);
		subjectDetailPage.enterConfirmPassword("Welcome@123", true);
		subjectDetailPage.clickNextBtn(false);
		
		//reportLog("Verify PIN creation page");
		//subjectDetailPage.verifyCreatePINFormShowing();
		
		reportLog("Verify Create PIN page with Note Lists, PIN length, PIN and Confirm PIN fields and Next button");
		subjectDetailPage.verifyCreatePINPage();
		
		reportLog("Enter value in PIN and Confirm PIN field and click Next button");
		subjectDetailPage.enterPinForSubject("1234", false);
		subjectDetailPage.enterConfirmPinForSubject("1234", true);
		
		reportLog("Verify Secret Question page");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Verify Select a Question page");
		subjectDetailPage.verifySelectAQuestionPage();
		
		reportLog("Click on question drop down to show the questions list");		
		subjectDetailPage.clickQuestionDropDown(true);
		
		reportLog("Scroll the question list and select a question");
		subjectDetailPage.scrollTheQuestionListAndSelectAQuestion(true);
		
		reportLog("Enter answer for the selected question and click Next button");
		subjectDetailPage.provideAnswerForSelectedQuestion("Black", true);
		
		reportLog("Click on Next button");
		subjectDetailPage.clickNextBtn(false);
		
		reportLog("Verify Successfully Setup Password and PIN, Close this tab text and Open Web App button");
		subjectDetailPage.verifyRegistrationCompletedSuccessfully();

	} 	
}