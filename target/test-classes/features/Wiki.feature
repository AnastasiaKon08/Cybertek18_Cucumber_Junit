@wiki
Feature: Wikipedia Search Functionality Title Verification

  Background: User is on Wikipedia home page
    Given User is on home page
    Then  User types Steve Jobs in the wiki search box and clicks on wiki search button

    Scenario: Title Verification
    Then User sees Steve Jobs is in the wiki title


     Scenario: Header Verification
     Then User sees Steve Jobs is in the main header

     Scenario: Image Header Verification
       Then User sees Steve Jobs is in the image header

