
@testcucumber
Feature: Search Product
  

  
  Background: Flow till home page 
  Given user launches home page
  
  Scenario: Search Product with global search and add details in cart
    Then user should click global search
    And user views search results and clicks more
    Then user should view cart and add details to it
    And user should go to checkout screen
    
  Scenario: Search products from category and move to other window 
    Given user clicks dresses option from menu bar and moves to sub menu
    Then user moves to casual dress results and clicks more option
    And user navigates to another window using google plus option and enters email 
 

  