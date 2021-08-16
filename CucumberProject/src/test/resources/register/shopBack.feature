Feature: ShopBack Mobile App testing

  In order to verify earnings and available balance. The user wants to login and check profiles.
     - User logins profile
     - Check earnings and available balance
        - if the shown earnings and balance are expected, status is pass. otherwise status is failed.
     - Save earnings and balance on the page and status into excel

  The second case is to test a unlogined user who is able to found stores by searching keywords
     - a normal user launch app
     - taps on search text box
     - search wanted store by given keywords

  Test data:
      Emailid : hujy11@gmail.com
      Password : yxchappy

  Scenario Outline: User Login ShopBack APP
    Given User is on main page
    When User taps on Profile icon
    And User clicks on Log In
    And User enters "<userEmail>" and "<passWord>"
    And User clicks on LogIn
    Then User Earning is showing
    And Available Balance is seen
    And Compared "<userEarning>" and "<availableBalance>"
    And Save tested userid and Earning and Balance into excel
    Examples:
      |userEmail       |passWord|userEarning|availableBalance|
      |hujy11@gmail.com|yxchappy|$0.00      |$0.00           |

  Scenario: Searchs store or category
     Given User is on main page
     When User taps on Search icon
     And User enters searched keywords dress
     Then Captured searched result page
