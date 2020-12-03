package net.medavante.mobile.testscripts;

import java.util.Properties;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.itextpdf.text.log.SysoCounter;

import App.MultiLingual;
import App.PropReader;
import net.medavante.portal.dataproviders.DataProviders;

import net.medavante.portal.pages.studynavigator.StudyDashBoardPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.selenium.core.Configuration;
import net.medavante.portal.utilities.Constants;

public class Handheld_TranslationScript_SIP extends BaseTest{

	@BeforeClass
	public void executionOn(){
		exceutionOn="MobileAndWebExecution"; 
	}
	
	@Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
	public Handheld_TranslationScript_SIP(String driver) {
		super(driver);
	}
	
	@BeforeMethod 
	public void getTestData1() throws Exception {
		String abc = MultiLingual.locallang("App.Home.001");
		reportLog("Testing multi language thing" + abc);
		
//		PropReader.updateproprty("locale.country", "RU");
//		PropReader.updateproprty("locale.language", "ru");
//		String abc1 = MultiLingual.locallang("App.Home.001");
//		System.out.println(abc1);

		System.setProperty("className", getClass().getSimpleName());
		Properties properties = Configuration.readTestData("RegressionTestData");
		studyName = properties.getProperty("StudyMobileEPROVirigilAPK");
		
		reportLog("Go to Portal Side to Create Subject");
		dashBoardPage = loginPage.loginInApplication(FormUserName, Form_Password);

		studyNavigatorDashBoardPage = dashBoardPage.selectHorizontalUpperNavMenuItem(StudyDashBoardPage.class,
				Constants.NavigateText, Constants.StudyText);
		Thread.sleep(3000);

		studyNavigatorDashBoardPage.creatingSubjectForPreRequisite(studyName, Constants.testSite,
				screeningNum);
		subjectDetailPage = studyNavigatorDashBoardPage.clickOnSaveBTN();
		subjectDetailPage.verifyNewSubjectDetailPage();

		reportLog("Get the Registration Code From The Subject");
		subjectDetailPage.clickOnReportedOutComeMobileSubjectQrIcon();
		registrationCode = subjectDetailPage.getRegistrationCodeOfSubject();
		subjectDetailPage.clickOnSubjectRegistrationPopUpCloseButton();
		
		loginPage.logoutApplication();
		loginPage.verifyUserLogout();
	}
	
		@Test(description = "Accept terms and conditions", groups = { "Mobile" })

		public void acceptTermsCondition() throws Exception {

		reportLog("1.1: MobileView As a Participant logged into the application");
		mobileLoginPage = androidSetUp();

		reportLog(
				"1.2: MobileView Application launch and verify Register screen with instruction message,register the subject");
		mobileLoginPage.verifyInstructionMessageText(registerScreenInstruction);
		mobileLoginPage.clickOnEnterTheCode();
		mobileLoginPage.enterTheRegistrationCode(registrationCode);
		mobileLoginPage.clickOnSubmitButton();
		
		mobileLoginPage.clickOnContinueButton();
		
		mobileLoginPage.verifyTermsAndConditionPageIsDisplay(termsAndCondtionInstructionMessage);
		mobileLoginPage.clickOnAcceptBtn();

		mobileLoginPage.verifyInstructionMessageText(createIdentityInstructionMessage);
		mobileLoginPage.enterPINCode(Mobile_Pin);
		mobileLoginPage.enterConfirmPINCode(Mobile_Pin);

		mobileLoginPage.clickOnNextButton();
	}
}