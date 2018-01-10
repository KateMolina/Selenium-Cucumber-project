
Feature: Test the login functionality on sdet university
 Scenario: the user should be able to login with correct password
 Given user is on the login page
 When user enters correct username and correct password
 Then user gets conformation

  Scenario Outline:the user should be able to login
  Given user is on the login page
  When user enters email <username>
  And user enters password <password>
  Then user gets conformation

    Examples:
   | username | password |
   | molinakate888@gmail.com | 1234567 |
   | tim@testemail.com       | trpass  |
#   | jv@testemail            | jvpass  |