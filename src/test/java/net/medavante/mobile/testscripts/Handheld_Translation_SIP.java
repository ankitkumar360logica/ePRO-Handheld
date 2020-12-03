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
		
//		PropReader.updateproprty("locale.country", "RU");
//		PropReader.updateproprty("locale.language", "ru");
//
//        String abc1=	MultiLingual.locallang("App.Home.001");
//		
//		System.out.println(abc1);
	
		
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
		mobileLoginPage.configurationForRegisterTheSubject("314E-B501-4FCE-BC57");

		reportLog("1.5:MobileView Login with configured Pin");
		mobileLoginPage.verifySignInScreenDisplayed();
		dashborad = mobileLoginPage.loginUser(Mobile_Pin);

		reportLog("1.6:MobileView Check top menu configured with home,questionnaries,message,log an event");
		dashborad.verifyUserLogin();
		dashborad.verifyTopMenuOptions();
	}

		
	@AfterMethod
	public void deactivateUser(ITestResult result) throws InterruptedException {

		if (ITestResult.SUCCESS == result.getStatus()) {

			reportLog("Deactivate Subject");
			dashBoardPage = loginPage.loginInApplication(SuperAdminUN, SuperAdminPW);
			studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
					Constants.NavigateText, Constants.StudyText);
			studyNavigatorDashBoardPage.searchFilterValueByColumnNameAndValue(Constants.StudyDashBoard_columnName_Subject, subjectName);
			subjectDetailPage = studyNavigatorDashBoardPage.selectByFirstCell(NewSubjectDetailPage.class);
			subjectDetailPage.deactivateSubjectConfiguration(SuperAdminUN, SuperAdminPW);
			loginPage.logoutApplication();
			loginPage.verifyUserLogout();
		} else {
			Log.error("Deactivation Not needed");
		}
	}
}
