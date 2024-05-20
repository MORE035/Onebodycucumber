package com.online.pages;

import com.online.utils.driver.DriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class ActivityFeedsPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ActivityFeedsPage.class);
String count;
    By parentSelector= By.cssSelector("onebody-activity-feed");
    By myGlobalMissionsChildBy=By.cssSelector(".MuiTypography-root.MuiTypography-h4.css-1b7ppei");
    By contentChildBy=By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-1mwj5u");
    By likeIconBy=By.cssSelector(".MuiButtonBase-root .MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.css-hjmalu");

    By afterclicklikeIconBy=By.cssSelector(".MuiSvgIcon-root.MuiSvgIcon-colorError.MuiSvgIcon-fontSizeMedium.css-12yxjlz");

    By commentIconBy=By.cssSelector(".MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.css-hjmalu");
    By shareIconBy=By.cssSelector(".MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.css-vubbuv");

    By timestampBy=By.cssSelector(".MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.css-vubbuv");
    By countofLikeIconBy =By.cssSelector(".MuiTypography-root.MuiTypography-body1.css-1jb039z");


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

    public void isLikeIconDisplayed(){
       boolean flag= isDisplayedByShadowRoot(DriverManager.getDriver(),parentSelector,likeIconBy);
       Assertions.assertThat(flag).isTrue();
    }

    public void isCommentIconDisplayed(){
        boolean flag= isDisplayedByShadowRoot(DriverManager.getDriver(),parentSelector,commentIconBy);
        Assertions.assertThat(flag).isTrue();
    }

    public void isShareIconDisplayed(){
        boolean flag= isDisplayedByShadowRoot(DriverManager.getDriver(),parentSelector,shareIconBy);
        Assertions.assertThat(flag).isTrue();
    }

    public void isTimestampDisplayed(){
        boolean flag= isDisplayedByShadowRoot(DriverManager.getDriver(),parentSelector,timestampBy);
        Assertions.assertThat(flag).isTrue();
    }
    public String clickLikeIcon(){
         count =getTextElementByShadowRoot(DriverManager.getDriver(),parentSelector, countofLikeIconBy);
        clickElementByShadowRoot(DriverManager.getDriver(),parentSelector,likeIconBy);
        return count;
    }

    public void getLikeIconColour(){
        String expectedColour="rgba(211, 47, 47, 1)";
        String actualColour =getShadowrootAttribute(DriverManager.getDriver(),parentSelector,afterclicklikeIconBy);
        System.out.println(actualColour);
         Assertions.assertThat(expectedColour.equals(actualColour)).isTrue();
    }
    public void  isCountIncremented(){
        int actualcount=Integer.parseInt(count)+1;
        int expectedCount=Integer.parseInt(getTextElementByShadowRoot(DriverManager.getDriver(),parentSelector, countofLikeIconBy));
        boolean flag=false;
        if(actualcount==expectedCount){
            flag=true;
        }
        Assertions.assertThat(flag).isTrue();
    }

    public void refreshPage(){
        DriverManager.getDriver().navigate().refresh();
    }
    
    public void verifyPostcardChanges(){
        String expectedColour="rgba(211, 47, 47, 1)";
      int expectedCount =Integer.parseInt(getTextElementByShadowRoot(DriverManager.getDriver(),parentSelector,countofLikeIconBy));
        String actualColour =getShadowrootAttribute(DriverManager.getDriver(),parentSelector,likeIconBy);
        Assertions.assertThat(expectedColour.equalsIgnoreCase(actualColour)).isTrue();
        Assertions.assertThat(expectedCount==Integer.parseInt(count)+1).isTrue();
    }
}

