#Author: batradeeshani@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions 
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps

@flightSearch
Feature: Flight Search function

  @signup
  Scenario: Validate signup page
    Given I am at app URL 
    When I validate that the dropdown has "English" and "Dutch"
    And I fill in name as "Deeshani"
		And I fill oganization as "Deeshani"
		And I input my email address
		And I click on I agree to the Terms and Conditions
		And I Click on SignUp
    Then I have signed up successfully

