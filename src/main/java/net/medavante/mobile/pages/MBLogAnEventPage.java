package net.medavante.mobile.pages;

//import java.sql.Driver;
import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.medavante.mobile.appium.core.MobileCoreFunctions;

public class MBLogAnEventPage extends MobileCoreFunctions{

	public MBLogAnEventPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.widget.ListView//android.view.ViewGroup/android.view.View/following-sibling::android.widget.TextView")
	private List<MobileElement> eventList; 
	
	@AndroidFindBy(xpath="//android.view.ViewGroup//android.widget.Button")
	private MobileElement startBtn; 
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='4']")
	private MobileElement nextArrowIcon; 
	
	@AndroidFindBy(xpath="//android.view.View[@index='5']")
	private MobileElement nextArrowIcon2; 
	
	@AndroidFindBy(xpath="(//android.view.View[@index='5'])[2]")
	private MobileElement nextArrowIcon3; 
	
	@AndroidFindBy(xpath= "//android.widget.ListView//android.view.View//android.view.View//android.widget.RadioButton[1]")
	private MobileElement selectRadioBtn;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@index='2']//android.view.View[@index='2']")
	private MobileElement setHealthArrow; 
	
	@AndroidFindBy(xpath = "//android.widget.Button[@class='android.widget.Button']")
	private MobileElement continueBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@class='android.widget.ImageButton']")
	private MobileElement backIcon;

	
	public void clickOnEvent(String eventToBeOpen) throws InterruptedException{
		for(MobileElement we:eventList){
			if(we.getText().equalsIgnoreCase(eventToBeOpen)){
				click(we);
				//Thread.sleep(2000);
				waitForElementToBecomeVisible(startBtn,DEFAULT_WAIT_ELEMENT);
				capturescreen("Screenshot");
				break;
				}
		}
		_normalWait(DEFAULT_WAIT_ELEMENT);
		//capturescreen("Screenshot");
	}
	
	public void clickOnEventWithoutStartBtnVisible(String eventToBeOpen) throws InterruptedException{
		for(MobileElement we:eventList){
			if(we.getText().equalsIgnoreCase(eventToBeOpen)){
				click(we);
				//Thread.sleep(1000);
				capturescreen("Screenshot");
			}
		}
	}
	
	public void clickOnEvent1WithoutStartBtnVisible(String eventToBeOpen) throws InterruptedException{
		for(MobileElement we:eventList){
			if(we.getText().equalsIgnoreCase(eventToBeOpen)){
				click(we);
				Thread.sleep(3000);
				capturescreen("Screenshot");
			}
		}
	}
	
	public void clickStartBtn() {
		click(startBtn);
		_normalWait(DEFAULT_WAIT_ELEMENT);
	}
	
	public void clickOnBackIcon() {
		click(backIcon);
	}
	
	public void completeEvent() {
		_normalWait(DEFAULT_WAIT_ELEMENT);
		click(nextArrowIcon2);
		click(nextArrowIcon2);
		click(selectRadioBtn);
		click(nextArrowIcon2);
		click(selectRadioBtn);
		click(nextArrowIcon2);
		click(selectRadioBtn);
		click(nextArrowIcon2);
		click(selectRadioBtn);
		click(nextArrowIcon2);
		click(selectRadioBtn);
		click(nextArrowIcon2);
		click(nextArrowIcon2);
		click(setHealthArrow);
		click(nextArrowIcon3);
		click(nextArrowIcon2);
		capturescreen("Screenshot");

	}
	
	public void clickContinueBtn() {
		click(continueBtn);
	}

}
