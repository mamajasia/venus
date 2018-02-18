Feature: Search Offer
  Scenario: Search for iPhone
    Given Aliexpress home page is loaded
    When "iPhone" phrase is entered in search field
    And enter key is pressed
    Then search result list is displayed
    #And all results on page contain "iPhone" phrase