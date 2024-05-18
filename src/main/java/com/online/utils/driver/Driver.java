package com.online.utils.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.online.utils.config.ReadPropertyFileUtils;
import com.online.utils.enums.ConfigProperties;
import com.online.utils.exceptions.BrowserInvocationFailedException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
import org.sap.constants.FrameworkConstants;
import org.sap.enums.ConfigProperties;
import org.sap.exceptions.BrowserInvocationFailedException;
import org.sap.factories.DriverFactories;

import com.sap.utils.ReadPropertyFileUtils;
*/

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * 
 * 22-Aug-2023
 * @author "Vasanth"
 * @version 1
 * @since 1
 * @see DriverManager
 *  <p> driver class for inition threadwise </p>

 */
public final class Driver {
	/**
	 * private constructor for avoid external usage
	 */
	private Driver() {

	}

	public static void initDriver(String browser)  {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactories.getDriver(browser));
			} catch (Exception e) {
				throw new BrowserInvocationFailedException("please check the capabilities of the browser",e.fillInStackTrace());
			}
		}
		DriverManager.getDriver().get(ReadPropertyFileUtils.get(ConfigProperties.URL));
		DriverManager.getDriver().manage().window().maximize();
		// DriverManager.getDriver().manage().timeouts().implicitlyWait(10,
		// TimeUnit.SECONDS);
	}
	/**
	 * quit the browser
	 */
	public static void quitDriver() {	
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
