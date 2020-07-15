@SmartBear
Feature:  SmartBear order process

  Background: User is logged into SmartBear Tester account and on Order page
    Given User is logged into SmartBear Tester account and on Order page

    Scenario: User fills out the form as followed
    Then User selects "FamilyAlbum" from product dropdown, then User enters "4" to quantity, enters "John Wick" to customer name
    Then User enters "Kinzie Ave" to street
    Then enters "Chicago" to city
    And enters "IL" to state,  enters zip "6005610"
    Then selects Visa as card type and  enters "1111222233334444" to card number
    And  User enters "12/22" to expiration date
    Then User clicks process button
    Then User verifies "John Wick" is in the list



