@login
Feature: Login with valid and invalid credentials
Background: Launch browser and url
Given Open "chrome" browser
And Launch the given url

@validlogin
Scenario: Login with valid credentials
Given Enter username as "standard_user"
And Enter password as "secret_sauce"
When Click on Login button
Then User should navigate to Homepage

@invalidlogin
Scenario Outline: Login with invalid credentials
Given Enter username as "<username>"
And Enter password as "<password>"
When Click on Login button
Then verify login error message

Examples: 
|username|password|
|test|test123|
|testlab|abc123|