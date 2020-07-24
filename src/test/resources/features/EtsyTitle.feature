@smoke @etsy
Feature: Etsy Title Verification
  Background:
    Given User is on https://www.etsy.com

    @title
  Scenario:
    Then User sees title as expected

    @woodenSpoon
  Scenario:
  Then User types "Face masks" in the search box and hits enter
  Then User sees "Face masks" is in the title







