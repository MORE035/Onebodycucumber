Feature: To verify activity feeds loaded in the widget

  Scenario: Verify activity feeds
    Given the Activity Feeds page
    When new activity is loaded into the widget titled "My Global Missions"
    Then verify each feed's content
    And verify the Like icon is displayed
     And verify the Comment icon is displayed
    And verify the Share icon is displayed
    And verify the timestamp is displayed

  Scenario: senario 2
    Given the user is on the Activity Feeds widget
    When the user clicks on the Like icon
    Then the Like icon colour changes to red
    And the counter value next to the Like icon increments by one
    When the user clicks on refresh
    Then the user sees no change in the icon colour NBSP and counter NBSP value
