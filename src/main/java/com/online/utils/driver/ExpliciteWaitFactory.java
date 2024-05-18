package com.online.utils.driver;

import com.online.utils.constants.FrameworkConstants;
import com.online.utils.enums.WaitStrategy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/*import org.sap.constants.FrameworkConstants;
import org.sap.driver.DriverManager;
import org.sap.enums.WaitStrategy;*/

public final class ExpliciteWaitFactory {

	public static WebElement performExplicteWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds( FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds( FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds( FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}


	public static Alert performExplicteWait(WaitStrategy waitStrategy) {

		Alert alert =null;

		if(waitStrategy == WaitStrategy.PRESENCE) {

			alert = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds( FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.alertIsPresent());
			return alert;
		}else if(waitStrategy == WaitStrategy.NONE) {
			return alert;
		}
		return alert;
	}
}
