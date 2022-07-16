Feature: Sanity Test
Background: Launch browser and url
Given Open "chrome" browser
And Launch the given url
@sanity
Scenario: sanity check
Given Enter username as "standard_user"
And Enter password as "secret_sauce"
When Click on Login button
Then User should navigate to Homepage
Given Add Backpack to cart
Then Verify product in the cart
And Click Checkout and fill the details
When click on continue and Finish
Then verify order is placed 