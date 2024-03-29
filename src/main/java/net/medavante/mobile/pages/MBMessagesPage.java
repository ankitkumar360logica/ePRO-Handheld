package net.medavante.mobile.pages;

import java.util.List;

import org.junit.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import net.medavante.mobile.appium.core.MobileCoreFunctions;

public class MBMessagesPage extends MobileCoreFunctions {

	public MBMessagesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup//android.view.View")
	private MobileElement addMessageBtn; 
	
	@AndroidFindBy(xpath="//android.widget.ListView//android.view.ViewGroup/android.view.View/following-sibling::android.widget.TextView")
	private List<MobileElement> messageTodayList; 
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView")
	private MobileElement composeScreen;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText[@class='android.widget.EditText'])[1]")
	private MobileElement msgSubjectInputField;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText[@class='android.widget.EditText'])[2]")
	private MobileElement msgBodyInputField;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@class='android.widget.ImageButton']")
	private MobileElement backbtnOnComposeMsg;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[2][@class='android.view.ViewGroup'])[3]")
	private MobileElement selectFirstMessageFromList;
	
	//@AndroidFindBy(xpath = "//android.support.v7.widget.LinearLayoutCompat")
	@AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
	private MobileElement deleteMessage;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup//following-sibling::android.view.View")
	private MobileElement replyIcon;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/parentPanel']")
	private MobileElement warningPopupWindow;	
	
	
	/* Verify Today Message List is Present */
	public void verifyMessageListPresent() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		boolean flag = false;
		if (messageTodayList.size() > 0) {
			flag = true;
		}
		Assert.assertTrue(flag);
		capturescreen("Screenshot");
		//verifyPageIsDisplayAndCaptureTheScreenShot();
	}
	
	public void clickOnComposeMessageIcon() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		click(addMessageBtn);
	}
	
	public void verifyComposeMsgScreen() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		boolean flag = false;
		if(composeScreen.isDisplayed()) {
			flag = true;
		}
		Assert.assertTrue(flag);
		capturescreen("Screenshot");
	}
	
	public void inputTxtInMsgSubjectField(String msg) {
		setText(msgSubjectInputField, msg);
	}
	
	public void inputTxtInMsgBodyField(String txt) {
		setText(msgBodyInputField, txt);
	}
	
	public void clickOnBackbtnOnComposeScreen() {
		click(backbtnOnComposeMsg);
	}
	
	public void clickOnBackbtnOnComposeScreenToCaptureScreen() {
		click(backbtnOnComposeMsg);
		capturescreen("Screenshot");
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
	private MobileElement exitPopUp;
	
	public void verifyExitPopUp() {
		boolean flag = false;
		if(exitPopUp.isDisplayed()) {
			flag = true;
		}
		Assert.assertTrue(flag);
		capturescreen("Screenshot");
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
	private MobileElement noOptionOnExitPopUp;
	public void clickOnNoOnExitPopUp() {
		click(noOptionOnExitPopUp);
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private MobileElement yesOptionOnExitPopUp;
	public void clickOnYesOnExitPopUp() {
		click(yesOptionOnExitPopUp);
		_normalWait(globalWaitTime);
	}
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup//android.widget.TextView[@class='android.widget.TextView'])[2]")
	private MobileElement sendMsgBtn;
	public void clickOnSendMsgBtn(boolean blnCaptureScreenshot) {
		click(sendMsgBtn);
		if(blnCaptureScreenshot) {
		capturescreen("Screenshot");
		}
	}
	
	public void clickOnSendMessageBtnForMultiCapture() throws InterruptedException {
		click(sendMsgBtn);
		Thread.sleep(1000);
		capturescreen("Screenshot");

	}
	
	public void longPressOnSendMsgBtn() throws InterruptedException {
		longPress(sendMsgBtn);
		Thread.sleep(1000);
		capturescreen("Screenshot");
	}
	
	public void clickOnDeleteMessageButton() {
		click(deleteMessage);
		capturescreen("Screenshot");
	}
	
	public void clickDeletebtnOnMessageListScreen() throws InterruptedException {
		click(selectFirstMessageFromList);
		click(deleteMessage);
		Thread.sleep(1000);
		
		//capturescreen("Screenshot");
	}
	
	public void clickFirstMsgOnMessageListScreen(boolean blnCaptureScreenshot) {
		click(selectFirstMessageFromList);
		if(blnCaptureScreenshot) {
		capturescreen("Screenshot");
		}
	}
	
	public void clickReplyIcon() {
		//click(selectFirstMessageFromList);
		click(replyIcon);
		capturescreen("Screenshot");
	}
	
	public void verifyReplyInputAndSendButton() {
		Assert.assertTrue(isElementPresent(msgSubjectInputField));
		Assert.assertTrue(isElementPresent(sendMsgBtn));
		capturescreen("Screenshot");

	}
	
	public void verifyWarningpopupWithButtons(boolean blnCaptureScreenshot) {
		boolean flag = false;
		if(warningPopupWindow.isDisplayed() && noOptionOnExitPopUp.isDisplayed() && yesOptionOnExitPopUp.isDisplayed()) {
			flag = true;
		}
		Assert.assertTrue(flag);
		if(blnCaptureScreenshot) {
		capturescreen("Screenshot");
		}
		}
	
	public void clickOnComposeMessageIcon(int x, int y) {
		 _normalWait(DEFAULT_WAIT_ELEMENT);
		TouchAction action = new TouchAction(mobileDriver);
		action.press (PointOption.point(x, y)).release().perform();
		capturescreen("Screenshot");
	}
}
