Feature:
  Agile Story: As a user, I should be able to search when I am on Google search page

  Background: User should be on Google search page
    Given User is on the google search page

  Scenario: Google default title verification
    Then User should see title is Google


  Scenario: Google Title Verification after search
    When User searches "facebook"
    Then User should see "facebook" in the title

  @wip #work in progress
  Scenario: Google Search page -About- link page title verification
    Then User should see About link and clicks on it
    Then User should see title Google - About Google, Our Culture & Company News

    @googleTable
  Scenario:
  Google search page footer links verification
    Then User should see six links in the footer
      | Advertising      |
      | Business         |
      | How Search Works |
      | Privacy          |
      | Terms            |
      | Settings         |

