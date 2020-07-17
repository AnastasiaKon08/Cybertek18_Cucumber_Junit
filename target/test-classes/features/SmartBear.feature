@SmartBear @ScenarioOutline
Feature:  SmartBear order process

  Background: User is logged into SmartBear Tester account and on Order page
    Given User is logged into SmartBear Tester account and on Order page


  Scenario Outline: User fills out the form as followed
    Then User selects "<product>" from product dropdown, then User enters "<quantity>" to quantity, enters "<customerName>" to customer name
    Then User enters "<street>" to street
    Then enters "<city>" to city
    And enters "<state>" to state,  enters zip "<zip>"
    Then selects Visa as card type and  enters "<cardNumber>" to card number
    And  User enters "<expDate>" to expiration date
    Then User clicks process button
    Then User verifies "<customerName>" is in the list

    Examples: Data to be passed and verified by User
      | product      | quantity | customerName   | street           | city       | state | zip    | cardNumber        | expDate |
      | MyMoney      | 1        | Ken Adams      | Kinzie Street    | Washington | DC    | 100024 | 5369675326566467  | 11/23   |
      | FamilyAlbum  | 2        | Angel Opio     | Grey Tree Street | Chicago    | IL    | 837289 | 84676374673826478 | 12/24   |
      | ScreenSaver | 5        | Joey Tribianni | Brown Street     | New York   | NY    | 396782 | 983657367663478   | 10/21   |









