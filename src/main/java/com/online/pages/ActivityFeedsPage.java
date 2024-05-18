package com.online.pages;

import com.online.stepdefinitions.ToVerifyActivityFeedsStepDef;
import com.online.utils.driver.DriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class ActivityFeedsPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ActivityFeedsPage.class);

    By parentSelector= By.cssSelector("onebody-activity-feed");
    By myGlobalMissionsChildBy=By.cssSelector(".MuiTypography-root.MuiTypography-h4.css-1b7ppei");
    By contentChildBy=By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-1mwj5u");

    public void isPageDisplayed() {
        String title = getPageTitle();
        Assertions.assertThat(title)
                .isNotNull()
                .as("String actually empty").isNotEmpty()
                .as("String actually Not Blank").isNotBlank()
                .isEqualTo("Next Step - Lausanne Movement");


    }
    public void titleDisplayed(String expectedtitle){
       String actual= getTextElementByShadowRoot(getDriverByShadowRoot(),parentSelector,myGlobalMissionsChildBy);
       Assertions.assertThat(expectedtitle)
               .isEqualTo(actual);
    }
    public void iscontentNotBlank(){
        String content=getTextElementByShadowRoot(getDriverByShadowRoot(),parentSelector,contentChildBy);
        Assertions.assertThat(content)
                .isNotNull()
                .as("String actually empty").isNotEmpty()
                .as("String actually Not Blank").isNotBlank();
    }

}

