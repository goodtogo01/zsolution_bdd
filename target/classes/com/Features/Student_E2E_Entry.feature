#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Zsolution Student E2E Functions and Actions



  Scenario Outline: Add new Student
    Given I am on home page of Zsolution website
    And I select Student Manue to see the student page option
    When I click on student button from student option to redirect to the student entry form 
    And I start adding data for "<GroupName>", "<id>", "<firstName>", "<lastName>" "<Grade>", "<email>" fields
    And Click on Insert Value button once entry is completed
    Then I am able to see confirmation message
    And I close the browser
     
    
    Examples:
    |	GroupName	|	id	|	firstName	|	lastName	|	Grade	|	email	|
    |	Group: 4	|	948	|	Jamal			|	kamal			| 4th		|	jamal@zsolution.com	|
    #|	Group: 4	|	254	|	Alom			|	Folom			| 6th		|	jamal@zsolution.com	|
    #|	Group: 4	|	652	|	Jhon			|	Mohally		| 9th		|	jamal@zsolution.com	|
    #|	Group: 4	|	840	|	Danny			|	Rom 			| 12th	|	jamal@zsolution.com	|
    
    


