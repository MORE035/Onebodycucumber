package com.online.stepdefinitions;

import com.online.utils.config.ReadPropertyFileUtils;
import com.online.utils.driver.Driver;
import com.online.utils.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Hooks {

	private static final Logger LOG = LogManager.getLogger(Hooks.class);
	
	@Before
	public void testStart(Scenario scenario) throws Exception {
		LOG.info("*****************************************************************************************");
		LOG.info("	Scenario: "+scenario.getName());
		LOG.info("*****************************************************************************************");
		Driver.initDriver(ReadPropertyFileUtils.getValue("browser"));
	}
	@After
	public void stop(){
		Driver.quitDriver();
	}
}
