package com.online.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ShadowDomHelper {

    //By using Java Script
    public static WebElement findElementByShadowRoot(WebDriver driver, By parentSelector, By childSelector) {
        WebElement shadowHost = driver.findElement(parentSelector);
        WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost);
        return shadowRootElement.findElement(childSelector);
    }


    //By using getShadowRoot() method;
    public static WebElement findElementByShadowRootMethod(WebDriver driver, By parentSelector, By childSelector) {
        SearchContext shadowHost = driver.findElement(parentSelector).getShadowRoot();
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


    // You can add more helper methods as needed

}

