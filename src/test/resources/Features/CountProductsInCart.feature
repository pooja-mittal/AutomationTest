#Author: pooja.mittal30@gmail.com
@smoke
Feature: Calculate the total number of items in the cart

  Scenario Outline: Validate total number of food items in the cart
    Given User launch an application with "<URL>"
    And Validate user navigate to given application page
    Then User select the location "<location>"
    Then User search for resturant "<resturantName>"
    And User select one dish from the menu "<dishName1>"
    And User click on continue button
    Then User select another dish from the menu "<dishName2>"
    And Clicks on continue
    Then User click on the cart
    And User read the price for the products
    Then User validate product price with item total
    Then User validate delivery fee acc to km "<deliveryFee>"
    Then User validate platform fee "<platformFee>"
    Then User validate total taxes fee "<totalTaxes>"
    Then User finally validate the total price

    Examples: 
      | URL                     | location | resturantName | dishName1             | dishName2        | deliveryFee | platformFee | totalTaxes |
      | https://www.swiggy.com/ |   560103 | Little Italy  | Pizza and Pasta Combo | Pasta Del Barone |          45 |           3 |     184.94 |
