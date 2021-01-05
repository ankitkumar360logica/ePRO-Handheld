package net.medavante.mobile.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import net.medavante.mobile.appium.core.MobileCoreFunctions;
import net.medavante.portal.utilities.Constants;

public class MobileSideMenuPage extends MobileCoreFunctions {

	public MobileSideMenuPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='OK']")
	private MobileElement humBurgerMenuIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageButton")
	private MobileElement menuBackIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Participant Version']")
	private MobileElement participantVersionText;

	@AndroidFindBy(xpath = "((//android.widget.ListView)[2]/android.widget.LinearLayout)[1]")
	private MobileElement myAccount;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Medications']")
	private MobileElement medications;

	@AndroidFindBy(xpath = "((//android.widget.ListView)[2]/android.widget.LinearLayout)[2]")
	private MobileElement mySchedule;

	@AndroidFindBy(xpath = "((//android.widget.ListView)[2]/android.widget.LinearLayout)[3]")
	private MobileElement studyInformation;

	@AndroidFindBy(xpath = "((//android.widget.ListView)[2]/android.widget.LinearLayout)[4]")
	private MobileElement contacts;

	@AndroidFindBy(xpath = "((//android.widget.ListView)[2]/android.widget.LinearLayout)[5]")
	private MobileElement settings;

	@AndroidFindBy(xpath = "((//android.widget.ListView)[2]/android.widget.LinearLayout)[6]")
	private MobileElement helpTutorial;

	@AndroidFindBy(xpath = "((//android.widget.ListView)[2]/android.widget.LinearLayout)[7]")
	private MobileElement aboutUs;

	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView")
	private MobileElement exitApplicationIcon;

	@AndroidFindBy(xpath = "//*[@class='android.support.v7.app.ActionBar$Tab'][1]")
	private MobileElement homeTab;

	@AndroidFindBy(xpath = "//*[@class='android.view.View' and @index='0']")
	private MobileElement addMedicationIcon;

	@AndroidFindBy(xpath = "(//*[@class='android.view.View' and @index='0'])[2]")
	private MobileElement addSecondMedicationIcon;

	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @content-desc='CreateMedicationMenuItem']")
	private MobileElement createMedicationMenuItem;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Name']")
	private MobileElement nameEditBox;

	@AndroidFindBy(xpath = "//android.support.v7.widget.LinearLayoutCompat")
	private MobileElement deleteIcon;

	@AndroidFindBy(xpath = "//*[@class='android.widget.LinearLayout']")
	private List<MobileElement> messageList;

	@AndroidFindBy(id = "android:id/content")
	private MobileElement confirmationDialog;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private MobileElement okOption;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
	private MobileElement cancelOption;

	@AndroidFindBy(xpath = "//android.widget.EditText//following-sibling::android.widget.Button")
	private MobileElement elementLast;

	@AndroidFindBy(xpath = "//android.widget.EditText//preceding-sibling::android.widget.Button")
	private MobileElement elementFirst;

	@AndroidFindBy(xpath = "//android.widget.EditText//following-sibling::android.widget.Button")
	private List<MobileElement> lastElement;

	@AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup']")
	private List<MobileElement> medicationList;

	@AndroidFindBy(xpath = "//*[@class='android.widget.ImageView']")
	private MobileElement qrCodeImage;

	@AndroidFindBy(xpath = "//android.widget.NumberPicker")
	private List<MobileElement> numberPicker;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Pick a')]")
	private MobileElement pickAdateBox;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement okNumberPickerButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[2]")
	private MobileElement deviceIDValue;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[10]")
	private MobileElement appVersion;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.TextView[12]")
	private MobileElement deviceModel;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.TextView)[3]")
	private MobileElement changeColorTheme;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.Button")
	private MobileElement cancelBTnOnchangeColorThemePopup;

	public void clickHomePageIcon() {
		click(homeTab);

	}
	
	public void verifyHomePageDisplay() {
		waitForElementToBecomeVisible(homeTab, DEFAULT_WAIT_2_ELEMENT);
		Assert.assertTrue(isElementPresent(homeTab));
		capturescreen("Screenshot");

	}

	public void clickOnAddIcon() {
      _normalWait(DEFAULT_WAIT_4_ELEMENT);
		waitForElementToBecomeVisible(addMedicationIcon, 30);
		click(addMedicationIcon);
		capturescreen("Screenshot");
		}

	public void clickOnBackIcon() {
		 _normalWait(DEFAULT_WAIT_4_ELEMENT);
		click(menuBackIcon);
		_normalWait(DEFAULT_WAIT_ELEMENT);
		//capturescreen("Screenshot");

	}

	public void verifyPageTitle(String pageTitle) {
		WebElement questionText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", pageTitle)));
		Assert.assertTrue(isElementPresent(questionText));
		capturescreen("Screenshot");

	}

	public void verifySideMenuOptions() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		Assert.assertTrue( myAccount.isEnabled() && mySchedule.isEnabled()
				&& studyInformation.isEnabled() && contacts.isEnabled() && settings.isEnabled()
				&& helpTutorial.isEnabled() && aboutUs.isEnabled());
		 capturescreen("Screenshot");
	}

	public void clickOnAboutUs() throws InterruptedException {
		Thread.sleep(2000);
		click(aboutUs);
		capturescreen("Screenshot");
		//click(menuBackIcon);
	}
	
	public void clickOnContacts() throws InterruptedException {
		Thread.sleep(2000);

		click(contacts);
		capturescreen("Screenshot");
		//click(menuBackIcon);
	}

	public void clickOnMySchedule() throws InterruptedException {
		Thread.sleep(2000);

		click(mySchedule);
		capturescreen("Screenshot");
		//click(menuBackIcon);
	}
	
	public void clickOnMyAccount() throws InterruptedException {
		Thread.sleep(1000);

		click(myAccount);
		Thread.sleep(2000);
		//Assert.assertTrue(menuBackIcon.isEnabled());
		capturescreen("Screenshot");
		//click(menuBackIcon);
	}

	public void clickOnStudyInformation() throws InterruptedException {
		Thread.sleep(1000);

		click(studyInformation);
		Thread.sleep(2000);
		capturescreen("Screenshot");
		//click(menuBackIcon);

	}

	public void clickOnSettings() throws InterruptedException {
		Thread.sleep(1000);

		click(settings);
		Thread.sleep(2000);
		capturescreen("Screenshot");
		//click(menuBackIcon);
	}
	
	public void clickOnChangeColorTheme() {
		click(changeColorTheme);
		capturescreen("Screenshot");
		//Assert.assertTrue(cancelBTnOnchangeColorThemePopup.isDisplayed());
	}
	
	public void exitFromColorThemePopup() {
		click(cancelBTnOnchangeColorThemePopup);
	}
	
	public void helpAndTutorials() throws InterruptedException {
		Thread.sleep(1000);

		click(helpTutorial);
		Thread.sleep(2000);
		capturescreen("Screenshot");

	}

	public void clickOnMedications() {
		click(medications);
		Assert.assertTrue(medications.isEnabled());
		capturescreen("Screenshot");
		waitForElementToBecomeVisible(addMedicationIcon, globalWaitTime);

	}

	public void clickOnExitApplication() throws Exception {
		waitForElementToBecomeVisible(exitApplicationIcon, DEFAULT_WAIT_ELEMENT);
		click(exitApplicationIcon);				
	}

	/* Verify user exit with application */
	public void verifyApplicationExit() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		capturescreen("Screenshot");
				
	}

	public void enterNameAndClickOnSave(String name) {
		setText(nameEditBox, name);
		click(createMedicationMenuItem);
		 _normalWait(DEFAULT_WAIT_4_ELEMENT);
	}

	public void clickOnSaveMedicationIcon() {
		click(createMedicationMenuItem);
		 _normalWait(DEFAULT_WAIT_4_ELEMENT);
	}

	public void verifyCreateMedicationIconDisplay() {
		Assert.assertTrue(createMedicationMenuItem.isDisplayed());
		capturescreen("Screenshot");
	}

	public void enterMedicationName(String string) {
		enterNameAndClickOnSave(string);
		capturescreen("Screenshot");
	}

	public void verifyTextOnScreen(String text) {
		WebElement messageText = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text)));
		Assert.assertTrue(messageText.isDisplayed());
		capturescreen("Screenshot");

	}

	public void verifyAddMedicationButtonDisplay() {
		Assert.assertTrue(addMedicationIcon.isDisplayed());
		capturescreen("Screenshot");
	}

	public void createMedication(String string) {
		clickOnAddIcon();
		enterNameAndClickOnSave(string);
		_normalWait(DEFAULT_WAIT_2_ELEMENT);
		capturescreen("Screenshot");
	}

	public void createSecondMedication(String string) {
		waitForElementToBecomeVisible(addSecondMedicationIcon, 30);
		click(addSecondMedicationIcon);
		enterNameAndClickOnSave(string);
		_normalWait(DEFAULT_WAIT_2_ELEMENT);
		capturescreen("Screenshot");

	}

	public void exitApplication() {
		click(humBurgerMenuIcon);
		waitForElementToBecomeVisible(exitApplicationIcon, DEFAULT_WAIT_ELEMENT);
		click(exitApplicationIcon);
		capturescreen("Screenshot");
	}

	public void selectMedicationListItem(String name) {
		WebElement medicationName = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", name)));
		click(medicationName);
		capturescreen("Screenshot");

	}

	public void clickOnDeleteIcon() {
		click(deleteIcon);
		_normalWait(30);
		capturescreen("Screenshot");
	}

	public void selectConfirmationOption(String option) {
		WebElement deleteOption = mobileDriver
				.findElement(By.xpath(String.format("//android.widget.Button[@text='%s']", option)));
		click(deleteOption);
		capturescreen("Screenshot");
	}

	public void verifyPresenceOfMedicationsInMedicatonList() {
		boolean flag = false;
		if (messageList.size() > 0) {
			Assert.assertTrue(flag, "Medication list is Present");
		}
	}

	public void selectMedicationFromList(String medication) {

		WebElement medicationName = mobileDriver.findElement(
				By.xpath(String.format("//*[@class='android.widget.LinearLayout']//*[@text='%s']", medication)));
		Assert.assertTrue(medicationName.isDisplayed());
		medicationName.click();
		waitForElementToBecomeVisible(deleteIcon, globalWaitTime);
		capturescreen("Screenshot");
	}

	public void verifyConfirmationDialogDisplayWithOkAndCancelOptions() {
		_normalWait(30);
		Assert.assertTrue(
				isElementPresent(confirmationDialog) && isElementPresent(cancelOption) && isElementPresent(okOption));

	}

	public void clickOnOKOption() {
		click(okOption);
		_normalWait(60);
	}

	public void clickOnCancelOption() {
		click(cancelOption);
		_normalWait(60);
	}

	/* Fill Medications Data */
	public void FillTextAndDropDownPopUpValues(String fieldIndex, String Value) {
		MobileElement medictaionDetails = getApiumDriver().findElement(
				By.xpath("//android.view.ViewGroup[@index='" + fieldIndex + "']//android.widget.EditText"));

		MobileElement element = getApiumDriver().findElement(By.xpath("//android.widget.EditText"));
		medictaionDetails.click();
		if (numberPicker.size() > 0) {
			while (getApiumDriver().findElements(By.xpath("//android.widget.EditText[@text='" + Value + "']"))
					.size() == 0) {
				if (lastElement.size() > 0) {
					TouchAction action = new TouchAction(mobileDriver);
					action.longPress(ElementOption.element(elementLast))
							.moveTo(ElementOption.element(element)).release().perform();
					_normalWait(3000);
				}

			}
			click(okOption);
		}

		else {
			medictaionDetails.sendKeys(Value);
		}
	}

	/* Fill All Details */
	public void fillAllDetailsForMedication() {

		setText(nameEditBox, Constants.WeekelyMedicationName);
		FillTextAndDropDownPopUpValues("4", "150");
		capturescreen("Screenshot");
		FillTextAndDropDownPopUpValues("6", "mg");
		capturescreen("Screenshot");
		FillTextAndDropDownPopUpValues("8", "orally");
		capturescreen("Screenshot");
		FillTextAndDropDownPopUpValues("11", "frequency");
		capturescreen("Screenshot");
		FillTextAndDropDownPopUpValues("12", "1");
		capturescreen("Screenshot");
		String current = currentOnlyDate();
		pickAdateFromCalender(current);
		FillTextAndDropDownPopUpValues("18", "end date");
		String dateToselect = getAfterSevenDayDateFromCurrentDate();
		pickAdateFromCalender(dateToselect);
		capturescreen("Screenshot");
		click(createMedicationMenuItem);
		capturescreen("Screenshot");
		clickOnBackIcon();

	}

	public void scrollTillTheElement(List<MobileElement> desiredElement) {
		while (desiredElement.size() == 0) {
			TouchAction action = new TouchAction(mobileDriver);
			action.longPress(ElementOption.element(elementLast)).release().perform();
		}
	}

	/* Pick a date from calender */
	public void pickAdateFromCalender(String dateTobeSelected) {
		pickAdateBox.click();
		getApiumDriver().findElement(By.xpath("//android.view.View[@text='" + dateTobeSelected + "']")).click();
		click(okOption);

	}

	/* Get date after seven days to curent day */
	public String getAfterSevenDayDateFromCurrentDate() {
		String currentDate = currentOnlyDate();
		int dateAfterSevenDay = Integer.parseInt(currentDate) + 7;
		String date = Integer.toString(dateAfterSevenDay);
		return date;
	}

	public void verifyQRCodeOnScreen() {
		Assert.assertTrue(qrCodeImage.isDisplayed());
		
	}
	
	/* Return Device Values From My Account screen */

	public String getDeviceIDValue()

	{
		_normalWait(3000);
		String value = getText(deviceIDValue);
		return value;
	}
	
	
	/* Return App Vetsion From My Account screen */

	public String getAppVersion()

	{
		_normalWait(3000);
		String value = getText(appVersion);
		return value;
	}
	
	/* Return device model From My Account screen */

	public String getDeviceModel()

	{
		_normalWait(3000);
		String value = getText(deviceModel);
		return value;
	}
	
	/**
	 * Verify Avatar And Version Label display
	 */
	public void verifyAvatarAndVersionLabelIsDisplay() {
		Assert.assertTrue(participantVersionText.isDisplayed());
		capturescreen("Screenshot");
	}
}