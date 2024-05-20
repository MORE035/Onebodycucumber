package com.online.pages;

import com.online.utils.constants.FrameworkConstants;
import com.online.utils.driver.DriverManager;
import com.online.utils.driver.ExpliciteWaitFactory;
import com.online.utils.enums.WaitStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/*import org.sap.constants.FrameworkConstants;
import org.sap.driver.DriverManager;
import org.sap.enums.WaitStrategy;
import org.sap.factories.ExpliciteWaitFactory;
import org.sap.reports.ExtentLogger;*/

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy, String elementName)  {
		ExpliciteWaitFactory.performExplicteWait(waitStrategy, by).click();
		//ExtentLogger.pass(elementName);

		//ExtentLogger.pass(elementName, true);


		//DriverManager.getDriver().findElement(by).click(); //clubed this code into Explicitewait factory
	}

	protected void enterText(By by, WaitStrategy waitStrategy, String value,String elementName){
		ExpliciteWaitFactory.performExplicteWait(waitStrategy, by).sendKeys(value);;

		//ExtentLogger.pass("value "+value+" entered in "+elementName,true);


		//DriverManager.getDriver().findElement(by).sendKeys(value); //clubed this code into Explicitewait factory
	}

	protected String getPageTitle() {

		return DriverManager.getDriver().getTitle();
	}


	protected boolean isAlertPresent(WaitStrategy waitstrategy) {
		try {
			ExpliciteWaitFactory.performExplicteWait(waitstrategy);
			DriverManager.getDriver().switchTo().alert();
			return true;
		}catch(Exception e) {

			return false;
		}
	}
	
	protected String getAlertText(WaitStrategy waitStrategy) {
		
		String message="";
		if(isAlertPresent(waitStrategy)) {
			
			Alert alert= DriverManager.getDriver().switchTo().alert();
			message=alert.getText();
			
			alert.accept();
			//ExtentLogger.pass("alert is Present",true);
			return message;
			
		}else {
		//	ExtentLogger.fail("No alert is Present",true);
			return "No alert is Present";
		}
	}
	public void handlingAdds(By patrentFrame,By childFrame,By dismissbtn) {
		WebElement parentWebElement = DriverManager.getDriver().findElement(patrentFrame);
		DriverManager.getDriver().switchTo().frame(parentWebElement);
		WebElement childWebElement = DriverManager.getDriver().findElement(childFrame);
		DriverManager.getDriver().switchTo().frame(childWebElement);
		DriverManager.getDriver().findElement(dismissbtn).click();
		DriverManager.getDriver().switchTo().defaultContent();
	}
	
	private void explicitlyWaitForElementToBeClickble(By by) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
		.until(ExpectedConditions.elementToBeClickable(by));
	}//This method code placed in Factory

	private void explicitlyWaitForElementToBePresence(By by) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}//This method code placed in Factory

	//By using getShadowRoot() method;
	public  static WebDriver  getDriverByShadowRoot(){
		return DriverManager.getDriver();
	}
	public static WebElement findElementByShadowRootMethod(WebDriver driver, By parentSelector, By childSelector) {
		WebElement parent =driver.findElement(parentSelector);
		try {
			Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}
		SearchContext shadowHost = parent.getShadowRoot();
		return shadowHost.findElement(childSelector);
	}
	public static String getTextElementByShadowRoot(WebDriver driver, By parentSelector, By childSelector)  {
		WebElement element = findElementByShadowRootMethod(driver, parentSelector, childSelector);
		return element.getText();
	}
	public static void clickElementByShadowRoot(WebDriver driver, By parentSelector, By childSelector) {
		WebElement element = findElementByShadowRootMethod(driver, parentSelector, childSelector);
		element.click();
	}
	public static Boolean isDisplayedByShadowRoot(WebDriver driver, By parentSelector, By childSelector) {
		WebElement element = findElementByShadowRootMethod(driver, parentSelector, childSelector);
		return element.isDisplayed();
	}

	public static void scrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	public static String getShadowrootAttribute(WebDriver driver, By parentSelector, By childSelector){
		WebElement element = findElementByShadowRootMethod(driver, parentSelector, childSelector);
		return element.getCssValue("color");
	}

}
