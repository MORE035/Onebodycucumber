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

    String beforeClickSize;
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
        activityFeedsPage.isLikeIconDisplayed();
    }

    @Then("verify the Comment icon is displayed")
    public void verify_the_comment_icon_is_displayed() {
        activityFeedsPage.isCommentIconDisplayed();
    }

    @Then("verify the Share icon is displayed")
    public void verify_the_share_icon_is_displayed() {
        activityFeedsPage.isShareIconDisplayed();
    }

    @Then("verify the timestamp is displayed")
    public void verify_the_timestamp_is_displayed() {
        activityFeedsPage.isTimestampDisplayed();
    }

//    Scenario 2
    @Given("the user is on the Activity Feeds widget")
    public void the_user_is_on_the_activity_feeds_widget() {
        activityFeedsPage.titleDisplayed("My Global Missions");
    }

    @When("the user clicks on the Like icon")
    public void the_user_clicks_on_the_like_icon() {

       beforeClickSize = activityFeedsPage.clickLikeIcon();
    }

    @Then("the Like icon colour changes to red")
    public void the_like_icon_colour_changes_to_red() {
      activityFeedsPage.getLikeIconColour();
    }

    @Then("the counter value next to the Like icon increments by one")
    public void the_counter_value_next_to_the_like_icon_increments_by_one() {
          activityFeedsPage.isCountIncremented();
    }

    @When("the user clicks on refresh")
    public void the_user_clicks_on_refresh() {
           activityFeedsPage.refreshPage();
    }

    @Then("the user sees no change in the icon colour NBSP and counter NBSP value")
    public void the_user_sees_no_change_in_the_icon_colour_nbsp_and_counter_nbsp_value() {
          activityFeedsPage.verifyPostcardChanges();
    }


}
