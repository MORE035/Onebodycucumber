package com.online.stepdefinitions;

import com.api.stepdefinition.CreateBookingStepdefinition;
import com.online.pages.ActivityFeedsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;

public class ToVerifyActivityFeedsStepDef {
    ActivityFeedsPage activityFeedsPage=new ActivityFeedsPage();
    private static final Logger LOG = LogManager.getLogger(ToVerifyActivityFeedsStepDef.class);

    @Given("the Activity Feeds page")
    public void the_activity_feeds_page() {
        activityFeedsPage.isPageDisplayed();

    }

    @When("new activity is loaded into the widget titled {string}")
    public void
    new_activity_is_loaded_into_the_widget_titled(String string) {
        activityFeedsPage.titleDisplayed(string);

    }

    @Then("verify each feed's content")
    public void verify_each_feed_s_content() {
       activityFeedsPage.iscontentNotBlank();
    }

    @Then("verify the Like icon is displayed")
    public void verify_the_like_icon_is_displayed() {

    }

    @Then("verify the Comment icon is displayed")
    public void verify_the_comment_icon_is_displayed() {

    }

    @Then("verify the Share icon is displayed")
    public void verify_the_share_icon_is_displayed() {

    }

    @Then("verify the timestamp is displayed")
    public void verify_the_timestamp_is_displayed() {

    }

}
