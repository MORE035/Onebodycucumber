Feature: To verify activity feeds loaded in the widget

  Scenario: Verify activity feeds
    Given the Activity Feeds page
    When new activity is loaded into the widget titled "My Global Messages"
    Then verify each feed's content
    And verify the Like icon is displayed
    And verify the Comment icon is displayed
    And verify the Share icon is displayed
    And verify the timestamp is displayed

  Scenario: A user views the Activity Feeds widget
    Given a user is on the Activity Feeds widget
    When the title "My Global Missions" is displayed on the widget
    Then the user can see activity feeds are displayed
    And the user can see the Like icon is displayed at the bottom of the feed
    And the user can see the Comment icon is displayed at the bottom of the feed
    And the user can see the Share icon is displayed at the bottom of the feed
    And the user can see the timestamp is displayed at the bottom right-hand side of the feed

  Scenario: A user scrolls on the Activity Feeds widget
    Given a user is on the Activity Feeds widget
    When the user scrolls down the feeds using the scroll bar
    Then the feeds move upwards
    And when the user scrolls up the feeds using the scroll bar
    Then the feeds NBSP move NBSP downwards