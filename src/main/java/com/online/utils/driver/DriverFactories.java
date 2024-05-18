package com.online.utils.driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

import com.online.utils.config.ReadPropertyFileUtils;
import com.online.utils.enums.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.sap.driver.DriverManager;
//import org.sap.enums.ConfigProperties;
//
//import com.sap.utils.ReadPropertyFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactories {
	private DriverFactories() {}
	public static  WebDriver getDriver(String browser) throws MalformedURLException {
		WebDriver driver=null;
		String runmode= ReadPropertyFileUtils.get(ConfigProperties.RUNMODE);
			if (browser.equalsIgnoreCase("chrome")) {
				if(runmode.equals("remote")) {
					DesiredCapabilities cap=new DesiredCapabilities();
					cap.setBrowserName(Browser.CHROME.browserName());
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
				}else {
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getCHROMEDRIVERPATH());
				// DriverManager.setDriver(new ChromeDriver()); one more way.....
				driver=new ChromeDriver();
				}

			} else if (browser.equalsIgnoreCase("firefox")) {
				if(runmode.equals("remote")) {
					DesiredCapabilities cap=new DesiredCapabilities();
					cap.setBrowserName(Browser.FIREFOX.browserName());
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
				}else {
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxdriverpath());
				driver=new FirefoxDriver() ;

				}

			} else if (browser.equalsIgnoreCase("edge")) {
				if(runmode.equals("remote")) {
					DesiredCapabilities cap=new DesiredCapabilities();
					cap.setBrowserName(Browser.EDGE.browserName());
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
				}else {
				WebDriverManager.edgedriver().setup();
			//	System.setProperty("webdriver.edge.driver", FrameworkConstants.getEdgedriverpath());
				driver=new EdgeDriver();
				}
			}
			return driver;
			

	}
}

