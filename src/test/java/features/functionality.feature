Feature: Functionality Testing

  @ConsoleError
  Scenario Outline: Verifying console errors on page loads
    Given I hit the following urls "<urls>"
    Then I verify the logEntries

    Examples: 
      | urls                                                 |
      | https://www.w3.org/standards/badpage                 |
      | https://www.w3.org/standards/webofdevices/multimodal |
      | https://www.w3.org/standards/webdesign/htmlcss       |

      
    @AllLinks
    Scenario Outline: Verifying console errors on page loads
    Given I hit the following urls "<urls>"
    Then I verify printing all the links
    
      Examples: 
      | urls                                                 |
      | https://www.w3.org/standards/badpage                 |
      | https://www.w3.org/standards/webofdevices/multimodal |
      | https://www.w3.org/standards/webdesign/htmlcss       |
      
      
      @BrokenLinks
    Scenario Outline: Verifying console errors on page loads
    Given I hit the following urls "<urls>"
    Then I verify BrokenLinks
    
      Examples: 
      | urls                                                 |
      | https://www.w3.org/standards/badpage                 |
      | https://www.w3.org/standards/webofdevices/multimodal |
      | https://www.w3.org/standards/webdesign/htmlcss       |
      
      
      