@smoke @loginWithBackground
Feature: Login Feature
  As a user, I should be able to login with correct credentials to different accounts, and dashboard should be displayed.

Background: User is on login page
  Given User is on login page


  Scenario: Librarian login scenario
    Then User provides librarian credentials and logs in
    Then User should be able to see dashboard


  Scenario: Student login scenario
    Then User provides student credentials and logs in
    Then User should be able to see dashboard


    @db
  Scenario: Admin login scenario
    Then User provides admin credentials and logs in
    Then User should be able to see dashboard
