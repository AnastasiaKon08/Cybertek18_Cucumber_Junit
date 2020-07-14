@login
Feature: Login Feature
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.


  @librarianLogin @employee
  Scenario: Librarian login scenario
    Given User is on login page
    Then User provides librarian credentials and logs in
    Then User should be able to see dashboard

  @studentLogin
  Scenario: Student login scenario
    Given User is on login page
    Then User provides student credentials and logs in
    Then User should be able to see dashboard

   @adminLogin @employee
  Scenario: Admin login scenario
    Given User is on login page
    Then User provides admin credentials and logs in
    Then User should be able to see dashboard







