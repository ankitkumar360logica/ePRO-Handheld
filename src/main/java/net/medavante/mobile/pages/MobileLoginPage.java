package net.medavante.mobile.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import App.MultiLingual;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.medavante.mobile.appium.core.MobileCoreFunctions;
import net.medavante.mobile.appium.core.MobileDriver;
import net.medavante.portal.selenium.core.BasePage;
import net.medavante.portal.utilities.Excel;
import net.medavante.portal.utilities.MobileConstants;

public class MobileLoginPage extends MobileCoreFunctions {

	public MobileLoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(className = "android.widget.EditText")
	private MobileElement pinInp;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.EditText)[1]")
	private MobileElement pinEditBox;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.EditText)[2]")
	private MobileElement confirmPinEditBox;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	private MobileElement editBox;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='OK']")
	private MobileElement humBurgerMenuIcon;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][1]")
	private MobileElement homeTab;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][2]")
	private MobileElement questionnairesTab;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][3]")
	private MobileElement MessagesTab;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][4]")
	private MobileElement logAnEventTab;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Registration Code']")
	private MobileElement registrationCodeInp;

	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.Button")
	private MobileElement submitBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.Button")
	private MobileElement nextBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private MobileElement chooseQuestionDropDownIcon;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Try Again']")
	private MobileElement tryAgainBtn;

	@AndroidFindBy(xpath = "//android.view.View[@index='0']")
	private MobileElement crossMarkBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@class='android.widget.Button']")
	private MobileElement continueBtn;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.Button")
	private MobileElement cancelBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement registerCodeText;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement answerCodeText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms and Conditions']")
	private MobileElement termsAndCondtionTitleText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='(PINs do not match)']")
	private MobileElement PINDontMatchText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Registration Code not found']")
	private MobileElement IncorrectRegCodeTextMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Exit Application'][1]")
	private MobileElement exitApplicationIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Register']")
	private MobileElement registerTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Create Identity']")
	private MobileElement createIdentityTitle;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.TextView)[1]")
	private MobileElement signInTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset PIN']")
	private MobileElement resetPINTitle;

	@AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
	private MobileElement registerInstruction;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan the code']")
	private MobileElement scanTheCodeBtn;

	@AndroidFindBy(xpath = "(//android.widget.ListView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup)[1]")
	private MobileElement choosAQuestion;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.TextView)[3]")
	private MobileElement verifyChooseAQuestion;
	
	@AndroidFindBy(xpath = "(//android.widget.ListView/android.widget.TextView)[1]")
	private MobileElement selectFirstQuestion;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter the code']")
	private MobileElement enterTheCodeBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement enterAnAnswerTextBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter an answer']")
	private MobileElement enterAnAnswer;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.TextView)[3]")
	private MobileElement forgetLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='zxingDefaultOverlay_TopTextLabel']")
	private MobileElement scanCodeScreenText;

	@AndroidFindBy(xpath = "//android.view.ViewGroup//android.widget.ImageButton")
	private MobileElement backBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@class='android.view.ViewGroup']//android.view.View")
	private MobileElement successIndicatorTickMarkIcon;

	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='Accept']")
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='1'])[3]")
	private MobileElement acceptBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Participant Version']")
	private MobileElement participantVersionText;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='android:id/statusBarBackground']")
	private MobileElement tapOn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.systemui:id/handler_image_view']")
	private MobileElement tapNext;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Smart View')]")
	private MobileElement smartView;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'360')]")
	private MobileElement systemConfiguration;
	
	

	/**
	 * Verify Create Identity screen is displayed
	 */
	public void verifyCreateIdentityScreenWithPINAndEditPIN() {
		Assert.assertTrue(isElementPresent(pinInp) && isElementPresent(nextBtn));
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Register instruction is displayed
	 */
	public void verifyInstructionMessageTextOnCreateIdentity(String messageToBeVerify) {
		waitForElementToBecomeVisible(createIdentityTitle, 60);
		Assert.assertTrue(registerInstruction.getText().equalsIgnoreCase(messageToBeVerify));
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Sign-In instruction is displayed
	 */
	public void verifySignInScreenDisplayed() {
		waitForElementToBecomeVisible(signInTitle, globalWaitTime);
		Assert.assertTrue(signInTitle.isDisplayed());
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Reset PIN instruction is displayed
	 * 
	 */
	public void verifyInstructionMessageTextOnResetPINScreen(String messageToBeVerify) {

		waitForElementToBecomeVisible(resetPINTitle, 60);
		Assert.assertTrue(registerInstruction.getText().equalsIgnoreCase(messageToBeVerify));

		 capturescreen("Screenshot");
	}

	/*
	 * Enter PIN and click Submit
	 **/

	public void loginWithPIN(String pinNum) {

		setText(pinInp, pinNum);
		waitForElementToBecomeVisible(submitBtn, globalWaitTime);
		click(submitBtn);
	}

	/*
	 * Enter PIN and edit PIN
	 **/

	public void loginCreateIdentity(String pinNum) {
		setText(pinInp, pinNum);
		waitForElementToBecomeVisible(nextBtn, globalWaitTime);
		
	}

	/**
	 * Enter pin num and login to the application
	 * 
	 * @param pinNum
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void verifyLoginScreenDisplay() {

		waitForElementToBecomeVisible(pinInp, 60);
		Assert.assertTrue(isElementPresent(pinInp));
		 capturescreen("Screenshot");

	}

	/**
	 * Enter pin num and login to the application
	 * 
	 * @param pinNum
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public MobileDashBoardPage loginUser(String pinNum) {
		waitForElementToBecomeVisible(pinInp, DEFAULT_WAIT_ELEMENT);
		setText(pinInp, pinNum);
		waitForElementToBecomeVisible(submitBtn, globalWaitTime);
		click(submitBtn);
       _normalWait(DEFAULT_WAIT_ELEMENT);
		MobileDashBoardPage dashboard = new MobileDashBoardPage(mobileDriver);
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), dashboard);
		return dashboard;
		
	}
	
	public MobileDashBoardPage mobiledashboard() {
		MobileDashBoardPage dashboard = new MobileDashBoardPage(mobileDriver);
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), dashboard);
		return dashboard;
	}
	
	public MobileSideMenuPage mobileSideMenu() {
		MobileSideMenuPage sideMenu = new MobileSideMenuPage(mobileDriver);
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), sideMenu);
		return sideMenu;

	}

	/**
	 * Verify Register instruction is displayed
	 */
	public void verifyInstructionMessageText(String registerMessageToBeVerify) {
		waitForElementToBecomeVisible(registerInstruction, DEFAULT_WAIT_ELEMENT);

	}

	/**
	 * Verify Register screen is displayed
	 */
	public void verifyRegisterScreenIsDisplay() {
		Assert.assertTrue(isElementPresent(registerTitle) && isElementPresent(scanTheCodeBtn)
				&& isElementPresent(enterTheCodeBtn));
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Register screen is displayed
	 */
	public void verifyRegisterScreenForEnterCodeIsDisplay() {
		Assert.assertTrue(isElementPresent(registerTitle) && isElementPresent(submitBtn));
		 capturescreen("Screenshot");
	}

	/**
	 * Click on enter the code button
	 */
	public void clickOnEnterTheCode() {		
       _normalWait(DEFAULT_WAIT_ELEMENT);
       enterTheCodeBtn.click();
	}

	/**
	 * Click on scan the code button
	 */
	public void clickOnScanTheCode() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		click(scanTheCodeBtn);
	}

	/**
	 * Click on back button
	 */
	public void clickOnBackButton() {
		click(backBtn);
		_normalWait(DEFAULT_WAIT_ELEMENT);
	}

	/**
	 * Verify Scan the code page is displayed with instruction message
	 */
	public void verifyScanTheCodePage(String scanCodeInstructionMessage) {
		Assert.assertTrue(scanCodeScreenText.getText().contains(scanCodeInstructionMessage));
		 capturescreen("Screenshot");
	}

	/**
	 * Enter the registration code on enter the code page
	 * 
	 * @param registrationCode
	 */
	public void enterTheRegistrationCode(String registrationCode) {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		registerCodeText.clear();
		setText(registrationCodeInp, registrationCode);
	}

	/**
	 * Verify entered 16-digit registration code is display
	 * 
	 * @param registrationCodeToBeVerify
	 */
	public void verifyRegistratedCode(String registrationCodeToBeVerify) {
		Assert.assertTrue(registerCodeText.getText().contains(registrationCodeToBeVerify));
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Continue button is display
	 */
	public void verifyContinueButtonIsDisplay() {
		waitForElementToBecomeVisible(continueBtn, globalWaitTime);
		Assert.assertTrue(continueBtn.isEnabled());
		 capturescreen("Screenshot");
	}

	/**
	 * Click on continue button
	 * @throws IOException 
	 */
	public void clickOnContinueButton(boolean blnCaptureScreenshot) {
		waitForElementToBecomeVisible(continueBtn, DEFAULT_WAIT_2_ELEMENT);
		_normalWait(DEFAULT_WAIT_2_ELEMENT);
		click(continueBtn);
		waitForElementToBecomeVisible(acceptBtn, DEFAULT_WAIT_2_ELEMENT);
		
		if(blnCaptureScreenshot) {
		capturescreen("Screenshot");
		}
	}

	/**
	 * Click on accept button
	 * @throws InterruptedException 
	 */
	public void clickOnAcceptBtn(boolean blnCaptureScreenshot) throws InterruptedException {
		waitForElementToBecomeVisible(acceptBtn, globalWaitTime);
		click(acceptBtn);
//		if(acceptBtn.isDisplayed()) {
//			if(blnCaptureScreenshot) {
//				capturescreen("Screenshot");
//			}
//		click(acceptBtn);
//		}
//		else {
//			enterPin_ConfirmCode(null);
//		}
		_normalWait(DEFAULT_WAIT_ELEMENT);
	}

	/**
	 * Verify Terms and conditions page is display
	 */
	public void verifyTermsAndConditionPageIsDisplay(String instructionMessageToBeVerify) {
		new WebDriverWait(mobileDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Terms and Conditions']")));
		Assert.assertTrue(termsAndCondtionTitleText.isDisplayed()
				&& termsAndCondtionTitleText.getText().contains("Terms and Conditions"));
		verifyInstructionMessageText(instructionMessageToBeVerify);
	}

	/**
	 * Verify Success Indicator - Tick mark is display
	 */
	public void verifySuccessIndicatorTickMarkIconIsDisplay() {
		Assert.assertTrue(isElementPresent(successIndicatorTickMarkIcon));
		 capturescreen("Screenshot");
	}

	/**
	 * verify Submit Button is DISABLED
	 */
	public void verifySubmitButtonIsDisabled() {
		Assert.assertFalse(submitBtn.isEnabled());
		 capturescreen("Screenshot");
	}

	/**
	 * verify Submit Button is Enabled
	 */
	public void verifySubmitButtonIsEnabled() {
		Assert.assertTrue(submitBtn.isEnabled());
		 capturescreen("Screenshot");
	}

	/**
	 * Click on submit button after entered the registration code
	 */
	public void clickOnSubmitButton() {
		click(submitBtn);
		//_normalWait(globalWaitTime);
		_normalWait(DEFAULT_WAIT_ELEMENT);
		
	}
	
	public void clickOnSubmitButtonToCaptureScreenshot() {
		click(submitBtn);
		_normalWait(DEFAULT_WAIT);
		//waitForElementToBecomeVisible(continueBtn, globalWaitTime);

		capturescreen("Screenshot");
		//_normalWait(globalWaitTime);
		_normalWait(DEFAULT_WAIT_ELEMENT);
		
	}
	
	public void clickOnSubmitButtonToCaptureScreenshot1() {
		click(submitBtn);
		_normalWait(DEFAULT_WAIT);
		//waitForElementToBecomeVisible(continueBtn, globalWaitTime);

		capturescreen("Screenshot");
		//_normalWait(globalWaitTime);
		_normalWait(DEFAULT_WAIT);
		
	}
	
	public void verifyContinueButtonDisplay(){
		waitForElementToBecomeVisible(continueBtn, globalWaitTime);
	}

	/**
	 * Verify Try Again button display
	 */
	public void verifyTryAgainButtonDisplayed() {
		Assert.assertTrue(tryAgainBtn.isDisplayed());
	}

	/**
	 * Verify Cross mark button display
	 */
	public void verifyCrossMarkButtonDisplayed() {
		Assert.assertTrue(crossMarkBtn.isDisplayed());
	}

	/**
	 * Click on Try Again button after entered the wrong registration code
	 */
	public void clickOnTryAgainButton() {
		click(tryAgainBtn);
		waitForElementToBecomeVisible(registrationCodeInp, 10);
	}

	public void verifyUserLogin() {
		waitForElementToBecomeVisible(homeTab, 60);
		click(homeTab);
		Assert.assertTrue(isElementPresent(homeTab));
		Assert.assertTrue(homeTab.isSelected());
		
	}
	
	public void exitApplication() {
		click(humBurgerMenuIcon);
		_normalWait(globalWaitTime);
		waitForElementToBecomeVisible(exitApplicationIcon, DEFAULT_WAIT_ELEMENT);
		click(exitApplicationIcon);
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Terms and conditions page is display
	 */
	public void verifyIncorrectRegistrationCodeErrorMessage() {
		waitForElementToBecomeVisible(IncorrectRegCodeTextMessage,DEFAULT_WAIT_ELEMENT);
		Assert.assertTrue(IncorrectRegCodeTextMessage.isDisplayed());
	}

	/**
	 * Verify forget PIN Link is displayed
	 */
	public void verifyForgetPINLinkDisplay() {
		Assert.assertTrue(isElementPresent(forgetLink));
		 capturescreen("Screenshot");
	}

	/**
	 * Verify forget PIN Link is displayed
	 */
	public void verify(String registerMessageToBeVerify) {
		waitForElementToBecomeVisible(forgetLink, 60);
		Assert.assertTrue(forgetLink.getText().trim().contains(registerMessageToBeVerify));
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Sign-In screen is displayed
	 * @throws IOException 
	 */
	public void verifySignInScreenWithPINEditBox() {
		Assert.assertTrue(isElementPresent(pinInp));
		 capturescreen("Screenshot");
	}

	public void clickOnForgetPINLink(boolean blnCaptureScreenshot) throws InterruptedException {
		waitForElementToBecomeVisible(forgetLink, 60);
		click(forgetLink);
		_normalWait(globalWaitTime);

		//waitForElementToBecomeVisible(registerInstruction, globalWaitTime);
		if(blnCaptureScreenshot) {
		capturescreen("Screenshot");
		}

	}

	public void verifyTextOnScreen(String text) {

		WebElement messageText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text)));
		Assert.assertTrue(messageText.isDisplayed());

	}
	
//	public void verifyTextOnScreen() throws IOException {
//		String screenTitle=	MultiLingual.locallang("IdentityScreenTitle");
//		System.out.println("Screen title is " + screenTitle);
//		MobileElement  messageText = mobileDriver.findElement(By.xpath("//android.widget.TextView[@text='"+screenTitle+"']"));
//		Assert.assertTrue(messageText.isDisplayed());
//	}

	public void verifyTextDoesNotAppearOnScreen(String text) {
		WebElement messageText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text)));
		Assert.assertFalse(messageText.isDisplayed());
	}

	/**
	 * verify Next Button is DISABLED
	 */
	public void verifyNextButtonIsDisabled() {
		waitForElementToBecomeVisible(nextBtn, 30);
		Assert.assertFalse(nextBtn.isEnabled());
		 capturescreen("Screenshot");
	}

	/**
	 * verify Next Button is Enabled
	 */
	public void verifyNextButtonIsEnabled() {
		waitForElementToBecomeVisible(nextBtn, globalWaitTime);
		Assert.assertTrue(nextBtn.isEnabled());
	}

	/**
	 * verify continue Button is Enabled
	 */
	public void verifyContinueButtonIsEnabled() {
		Assert.assertTrue(continueBtn.isEnabled());
	}

	/**
	 * Click on submit button after entered the registration code
	 * @throws IOException 
	 */
	public void clickOnNextButton() {
			waitForElementToBecomeVisible(nextBtn, 30);
			click(nextBtn);
			_normalWait(globalWaitTime);
			
	}
	
	public void clickOnNextButtonToCaptureScreenshot() throws InterruptedException {
		waitForElementToBecomeVisible(nextBtn, 30);
		click(nextBtn);
		//_normalWait(globalWaitTime);
		Thread.sleep(1500);
		capturescreen("Screenshot");
}
	/**
	 * Verify Avatar And Version Label display
	 */
	public void verifyAvatarAndVersionLabelIsDisplay() {
		Assert.assertTrue(participantVersionText.isDisplayed());
		 capturescreen("Screenshot");
	}

	/**
	 * Verify Terms and conditions page is display
	 */
	public void verifyPinAndConfirmPINEditBoxesAreDisplay() {
		Assert.assertTrue(isElementPresent(pinEditBox) && isElementPresent(confirmPinEditBox));
		 capturescreen("Screenshot");

	}
	
	public void verifyPinAndConfirmPINEditBoxesAreDisplayed() {
		Assert.assertTrue(isElementPresent(pinEditBox) && isElementPresent(confirmPinEditBox));
		 //capturescreen("Screenshot");

	}

	/**
	 * Enter the Pin code on enter the code page
	 * 
	 * @param pinCode
	 */
	public void enterPINCode(String PINCode) {
		waitForElementToBecomeVisible(pinEditBox, globalWaitTime);
		setText(pinEditBox, PINCode);
		mobileDriver.hideKeyboard();

	}
	
	public void enterIncorrectAnswer(String answer) {
		waitForElementToBecomeVisible(enterAnAnswerTextBox, globalWaitTime);
		for(int i=2; i>=0; i--) {
		setText(enterAnAnswerTextBox, answer);
		mobileDriver.hideKeyboard();
		clickOnNextButton();
		_normalWait(DEFAULT_WAIT);
		}
		 capturescreen("Screenshot");
	}

	/**
	 * Enter the Pin code on enter the code page
	 * 
	 * @param pinCode
	 * @throws IOException 
	 */
	public void enterConfirmPINCode(String PINCode) {
		waitForElementToBecomeVisible(confirmPinEditBox, globalWaitTime);
		setText(confirmPinEditBox, PINCode);
		mobileDriver.hideKeyboard();
		waitForElementToBecomeVisible(nextBtn, globalWaitTime);
	}
	
	public void enterPin_ConfirmCode(String PINCode) throws InterruptedException {
		waitForElementToBecomeVisible(pinEditBox, globalWaitTime);
		setText(pinEditBox, PINCode);
		mobileDriver.hideKeyboard();
		Thread.sleep(2000);
		
		waitForElementToBecomeVisible(confirmPinEditBox, globalWaitTime);
		setText(confirmPinEditBox, PINCode);
		mobileDriver.hideKeyboard();
		waitForElementToBecomeVisible(nextBtn, globalWaitTime);
	}

	public void clearConfirmPINBox() {
		editBox.clear();
		 //capturescreen("Screenshot");
	}

	/**
	 * Verify Pin dont match is display
	 * @throws IOException 
	 */
	public void verifyPinDontMatchTextDisplay() {
		//Assert.assertTrue(isElementPresent(PINDontMatchText));
		 capturescreen("Screenshot");

	}

	/**
	 * Verify Pin dont match not display
	 */
	public void verifyPinDontMatchTextisNotDisplay() {
		Assert.assertFalse(isElementPresent(PINDontMatchText));
		 capturescreen("Screenshot");

	}

	public void verifyChooseAQuestionDisplay(boolean blnCaptureScreenshot) {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		Assert.assertTrue(isElementPresent(choosAQuestion));
		if(blnCaptureScreenshot) {
			 capturescreen("Screenshot");
			}
	}
	
	public void verifyChooseAQuestionShowing(boolean blnCaptureScreenshot) {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		Assert.assertTrue(isElementPresent(verifyChooseAQuestion));
		if(blnCaptureScreenshot) {
		 capturescreen("Screenshot");
		}
	}

	public void clickOnChooseAQuestionOption(boolean blnCaptureScreenshot) {
		waitForElementToBecomeVisible(choosAQuestion, 30);
		click(choosAQuestion);
		_normalWait(DEFAULT_WAIT_ELEMENT);
		if(blnCaptureScreenshot) {
		capturescreen("Screenshot");
		}
	}
	
	public void clickOnChooseAQuestion(boolean blnCaptureScreenshot) {
		waitForElementToBecomeVisible(choosAQuestion, 30);
		click(choosAQuestion);
		_normalWait(DEFAULT_WAIT_ELEMENT);
		scrollFromTopToBottom();
		if(blnCaptureScreenshot) {
		capturescreen("Screenshot");
		}
	}
	
	public void clickOnCancelButton() {
		click(cancelBtn);
	}

	public void chooseAQuestion(String question) {
		_normalWait(globalWaitTime);
		click(choosAQuestion);	
		scrollFromTopToBottom();
		WebElement questionText = mobileDriver
		.findElement(By.xpath(String.format("//android.widget.FrameLayout//android.widget.TextView[@text='%s']", question)));
		if (questionText.isDisplayed()) {
			waitForElementToBecomeVisible(questionText, globalWaitTime);
			click(questionText);
		}

	}

	public void chooseAQuestion() {
		_normalWait(globalWaitTime);
		scrollFromTopToBottom();
//		WebElement questionText = mobileDriver
//		.findElement(By.xpath(String.format("//android.widget.FrameLayout//android.widget.TextView[@text='%s']", question)));
//		if (questionText.isDisplayed()) {
			waitForElementToBecomeVisible(selectFirstQuestion, globalWaitTime);
			click(selectFirstQuestion);
			_normalWait(globalWaitTime);

		}
	
	public void verifyQuestionText(String question) {
		WebElement questionText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", question)));
		Assert.assertTrue(isElementPresent(questionText));
		 capturescreen("Screenshot");
	}

	public void verifyAnswerCodeDisplay() {
		Assert.assertTrue(isElementPresent(enterAnAnswer));
		 capturescreen("Screenshot");
	}

	/**
	 * Enter the answer code for secret question
	 * 
	 * @param registrationCode
	 */
	public void enterAnAnswer(String answerCode) {
		setText(enterAnAnswerTextBox, answerCode);
		mobileDriver.hideKeyboard();
	}

	public void closeApp() {
		mobileDriver.closeApp();

	}

	public void reopenApp() {
		mobileDriver.launchApp();
		waitForElementToBecomeVisible(signInTitle, DEFAULT_WAIT_ELEMENT);
	}

	/* Exceptional Condition While Login */

	public MobileDashBoardPage scanCodeOrEnterPin(String registrationCode, String pinNum) throws IOException {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		if (getApiumDriver().findElementsByXPath("//android.widget.TextView[@text='Enter the code']").size() > 0) {

			clickOnEnterTheCode();
			enterTheRegistrationCode(registrationCode);
			clickOnSubmitButton();
			clickOnContinueButton(false);
			verifySignInScreenDisplayed();
			loginUser(pinNum);
		} else {
			verifySignInScreenDisplayed();
			loginUser(pinNum);
		}
		MobileDashBoardPage dashboard = new MobileDashBoardPage(mobileDriver);
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), dashboard);
		capturescreen("Screenshot");
		return dashboard;
	
	}


	/* Registration process For Subject For Configuration */

	public void configurationForRegisterTheSubject(String registrationCode) throws IOException {

		clickOnEnterTheCode();
		enterTheRegistrationCode(registrationCode);
		clickOnSubmitButton();
		//clickOnContinueButton(true);
		clickOnContinueButton(false);

	}	
	
	public void enterTheAnswerCode(String string) {
		setText(answerCodeText, string);
		mobileDriver.hideKeyboard();
	}
	
	/* To Invoke Smart View*/
	public void tapTopToBottom()
	{
		org.openqa.selenium.Dimension size = mobileDriver.manage().window().getSize();
		int x = size.width / 2;
		int y = size.height/2;
		TouchAction action = new TouchAction(mobileDriver);
		action.longPress(ElementOption.element(tapOn)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y)).release().perform();
		action.longPress(ElementOption.element(tapNext)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y)).release().perform();
		smartView.click();
		waitForElementToBecomeVisible(systemConfiguration,DEFAULT_WAIT_ELEMENT);
		_normalWait(3000);
		systemConfiguration.click();
		_normalWait(5000);
		clickBackButton();
		_normalWait(DEFAULT_WAIT_ELEMENT);
	}
	
	/**
	 * This will turn off the Android device Wifi
 	 */
	public void WifiOff() {
		List<String> disableWiFi = Arrays.asList(
				"wifi",
				"disable"
		);
		Map<String, Object> disableWiFiCmd = ImmutableMap.of(
				"command", "svc",
				"args", disableWiFi
		);

		mobileDriver.executeScript("mobile: shell", disableWiFiCmd);

	}

	/**
	 * This will turn off the Android device Wifi
	 */
	public void WifiOn() throws InterruptedException {
		List<String> disableWiFi = Arrays.asList(
				"wifi",
				"enable"
		);
		Map<String, Object> enableWiFiCmd = ImmutableMap.of(
				"command", "svc",
				"args", disableWiFi
		);
		try {
		mobileDriver.executeScript("mobile: shell", enableWiFiCmd);
		}
		catch (Exception e) {
			System.out.println("error in Enabling wi-fi");
			e.getStackTrace();
		}
		_normalWait(DEFAULT_WAIT_ELEMENT);

	}
	
	/**
	 * Hold and scroll down to refresh the page
	 */
	public void scrollDownToRefreshPage() {
       _normalWait(DEFAULT_WAIT);
		Dimension size;
		size = mobileDriver.manage().window().getSize();

		//Get X Y Coordinates for starting point touch action
		int startX = (int) (size.width * 0.50);
		int startY = (int) (size.height * 0.30);

		//Get X Y Coordinates for end point touch action
		int endX = (int) (size.width * 0.50);
		int endY = (int) (size.height * 0.70);

		try {
			new TouchAction(mobileDriver).press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
			Thread.sleep(2500);
			capturescreen("Screenshot");
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to scroll");
		}
			_normalWait(DEFAULT_WAIT);

	}
	
	public void tapOnViewIcon(int x, int y) {

		TouchAction action = new TouchAction(mobileDriver);
		action.press (PointOption.point(x,y)).release().perform();
		
	}
	
	public void tapByCoordinate(int x, int y, boolean blnCaptureScreenshot) throws InterruptedException {

		Thread.sleep(10000);
		try {
			TouchAction action = new TouchAction(mobileDriver);
			action.tap(PointOption.point(x,y)).perform();
			Thread.sleep(2000);
			if(blnCaptureScreenshot) {
			capturescreen("Screenshot");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to tap by coordinate");
		}

	}
	

	public void verifyText(WebElement element, int rownumber) throws Exception {

		String actualText = getText(element);
		System.out.println("Actual text is : " + actualText);
		
		String expectedText = Excel.readLanguageData(rownumber);
		System.out.println("Expected text is : " + expectedText);
		
		//if (actualText == expectedText) {
		if(actualText.equals(expectedText)) {
			System.out.println("Expected text: " + expectedText + " matches with actual text: " + actualText);
		} else {
			System.out.println("Actual text: " + actualText + " does not matches with expected text: " + expectedText);

		}
	}

	public void verifyPartialText(WebElement element, int rownumber) throws Exception {

		String actualText = getText(element);
		String expectedText = Excel.readLanguageData(rownumber).replaceAll("[0-9{}]", "");

		if (actualText.contains(expectedText)) {
			System.out.println("Expected text:" + expectedText + "contains in the actual text: " + actualText);
		} else {
			System.out.println("Expected text:" + expectedText + " does not matches with actual text: " + actualText);

		}

	}

		public void verifyAcceptbutton() throws Exception {
			_normalWait(DEFAULT_WAIT_ELEMENT);
			verifyText(acceptBtn,1);
			//verifyPartialText(acceptBtn,1);
		}
	
	
	
	
	
}