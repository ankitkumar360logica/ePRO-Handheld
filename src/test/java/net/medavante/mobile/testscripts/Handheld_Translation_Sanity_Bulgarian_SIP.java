package net.medavante.mobile.testscripts;

import java.util.Properties;

import org.testng.ITestResult;
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
import net.medavante.portal.utilities.MobileConstants;

public class Handheld_Translation_Sanity_Bulgarian_SIP extends BaseTest {

	private String language = "Bulgarian";
	//private String subjectName = "SubjectFor" +language+generateRandomAlphanumericString(6);
	private String subjectName = "200-" +GenerateRandomNumber(3);

	@SuppressWarnings("unused")
	private String registrationCode;

	@BeforeClass
	public void executionOn() {
		exceutionOn = "MobileAndWebExecution";
	}

	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public Handheld_Translation_Sanity_Bulgarian_SIP(String driver) {
		super(driver);
	}
	
	@BeforeMethod
	public void getTestData() throws Exception {	
		
		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("ProductionMobileStudy");
				
	}

	/**
	 * ====================================================================================================================
	 * eCOA Handheld Script Workflow
	 * ====================================================================================================================
	 * 
	 *  */
	
	@Test(description = "eCOA Handheld Script Workflow", groups = { "Mobile" })

	public void eCOAHandheldScriptWorkflow_Bulgarian() throws Exception {
		
		reportLog("Login into application");
		dashBoardPage = loginPage.loginInApplication(SITEUserName, SITE_Password);
		
		reportLog("Go to Navigate and select Study");
		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);

		reportLog("Select Study and Sites");
		studyNavigatorDashBoardPage.selectProdStudyAndSite(studyName, Constants.Prod_Site);
		
		reportLog("Click on Select button");
		studyNavigatorDashBoardPage.clickSelectButton();
		
		reportLog("Click on plus '+' icon");
		studyNavigatorDashBoardPage.clickAddSubjectBtn();
		
		//reportLog("Choose Site");
		//studyNavigatorDashBoardPage.slectSite();
		
		reportLog("Enter Screening # Name");
		studyNavigatorDashBoardPage.fillRequiredfieldsForsubject(subjectName);
		
		reportLog("Select the language");
		studyNavigatorDashBoardPage.selectSubjectLanguage(language);
		
		reportLog("Click on Save button");
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		
		System.out.println("Subject Name is: " +subjectName);
		
		reportLog("Verify Subject details page and click on Reported Outcome icon");
		subjectDetailPage.verifyNewSubjectDetailPage();
		
		
		reportLog("Get the registration code");	
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon(true);
		registrationCode = subjectDetailPage.getRegistrationCodeOfSubject();
		
		reportLog("Click on Close button");
		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();
		
		//reportLog("1.1:MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();
		
		reportLog("Launch the app and tap on Enter the code button");
		mobileLoginPage.verifyRegisterScreenIsDisplay();
		
	    reportLog("Verify the registration instruction message");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		
		reportLog("Registration Code text field is showing");
		mobileLoginPage.clickOnEnterTheCode();
		
		reportLog("Enter the registration code and click Submit button");
		mobileLoginPage.enterTheRegistrationCode(registrationCode, true);
		
		reportLog("Click Submit button");
		mobileLoginPage.clickSubmitBtn();
		
		reportLog("Verify page Title, Title Top text, Accept button and Participant Version text are in Non-English and click on Accept button");
		mobileLoginPage.verifyTermsAndConditionPage();
			
		reportLog("MobileView: Click on Accept button at Terms and Condition page");
		mobileLoginPage.clickOnAcceptBtn(false); 
		
		reportLog("Verify page Title, Title Top text, PIN, Confirm PIN, and Next button are in Non-English");
		mobileLoginPage.verifyCreateIdentityPage();
		
		reportLog("Enter PIN and Cofirm PIN and click Next button");
		mobileLoginPage.enterPINCode(MobileConstants.Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(MobileConstants.Mobile_Pin, true);

		reportLog("Click Next button");
		mobileLoginPage.clickOnNextButton();
		
		reportLog("Verify page Title, Title Top text, Choose a question, Enter an Answer and Next button are in Non-English and click on Choose a question drop down");
		mobileLoginPage.verifyChooseAQuetionPage();
		
		reportLog("Verify the question list and select a question");
		mobileLoginPage.clickOnChooseAQuestion(true);
		
		reportLog("Select a question from the list");
		mobileLoginPage.chooseAQuestion();
			
		reportLog("Enter answer for the selected question and click Next button");
		mobileLoginPage.enterAnAnswer("Black", true);
		
		reportLog("Click on Next button");
		mobileLoginPage.clickOnNextButton();
		
		reportLog("Verify page Title, Title Top text, Checklist1, Checklist2 and Continue button are in Non-English");
		mobileLoginPage.verifyChecklistPage();

		reportLog("Click on Continue button");
		mobileLoginPage.clickOnContinueButton(false);
	
		reportLog("Verify Submit button and I Forgot the Link are in non-English.");
		mobileLoginPage.verifySignInPage();	
				
	} 
	
	@AfterMethod
	public void updateSubjectValueInPropertiesFile(ITestResult result) throws InterruptedException {
			reportLog("*********Deactivate Subject***********");
			if (ITestResult.SUCCESS == result.getStatus()) {
				
			
			subjectDetailPage.deactivateSubjectConfiguration(TRNUserName, TRN_Password);
			loginPage.logoutApplication();
		
			loginPage.verifyUserLogout();
	}
	}
	
}
