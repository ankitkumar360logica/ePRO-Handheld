package net.medavante.portal.pages.webassessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.medavante.portal.selenium.core.BasePage;

public class WebAssessmentPage extends BasePage{

	public WebAssessmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//div[@data-ng-repeat='visit in visits'][2]/div[1]")
	private WebElement visit3;
	
	@FindBy(xpath = "//div[@data-ng-click='selectVisit(visit)']//a[@class='circle-button btn btn-white']")
	private WebElement visitInitiateIcon;
	
	@FindBy(xpath = "//a[@data-ng-click='initiateWebAssessment(form)']")
	private WebElement confirmWebAssessmentLink;
	
	@FindBy(xpath = "//button[@data-ng-click='webAssessmentConfirm()']")
	private WebElement btnConfirmWebAssessment;
	
	@FindBy(xpath = "//button[@data-ng-click='onWebLocalOpened()']")
	private WebElement btnOpenWebAssessment;

	
	
	
	
	
	
	
	public void openWebAssessmentPage() throws InterruptedException {
		System.out.println("Enter in the method");
		Thread.sleep(10000);
		//waitAndClick(visit3);
		System.out.println("click on visit3");
		javascriptButtonClick(visitInitiateIcon);
		javascriptButtonClick(visit3);
		Thread.sleep(4000);		
		clickOn(visitInitiateIcon);
		Thread.sleep(4000);		
		clickOn(confirmWebAssessmentLink);
		Thread.sleep(4000);		
		clickOn(btnConfirmWebAssessment);
		Thread.sleep(4000);		
		clickOn(btnOpenWebAssessment);
		Thread.sleep(4000);		
		reportInfo();

	}
	
	public void clicked() {
		// logger.info("Click");
		//moveToElement(element);
		visit3.click();
	}
	
}
