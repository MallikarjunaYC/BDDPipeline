Feature: Dashboard Page 

Background:

Given user is logged into the application
|user name|password|
|mallik.yc@gmail.com|443150|

Scenario: Verify the Dashboard page title
Given user is on dashboard page
When user gets the title of the page
Then page title should be "Dashboard"


Scenario: Check the dashboard page links
Given user is on dashboard page
Then the page should have the following links
| Orders |
| Support |

And the count should be 3