Feature: To verify activity feeds loaded in the widget

  Scenario: Verify activity feeds
    Given the Activity Feeds page
    When new activity is loaded into the widget titled "My Global Messages"
    Then verify each feed's content
    And verify the Like icon is displayed
    And verify the Comment icon is displayed
    And verify the Share icon is displayed
    And verify the timestamp is displayed
