package com.online.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber/report",
				"json:target/cucumber/cucumber.json",
				"com.api.utils.MyTestListener"
		},
		features = {"src/test/resources/online/features"},
		glue = {"com.online.stepdefinitions"},
		// dryRun = true,
		monochrome = true,
		snippets = SnippetType.CAMELCASE
		// publish = true
)
public class TestRunner {

}
