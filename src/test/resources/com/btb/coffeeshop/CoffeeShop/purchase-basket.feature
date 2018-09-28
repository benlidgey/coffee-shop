
Feature: Purchase Basket
  Purchase a basket of items
  
Scenario Outline: Purchase a basket of items
  Given my basket contains <items> items of <price> pence each
  When the Purchase button is pressed
  Then the total price should be <total> pence
 
 Examples:
   | items | price | total |
   | 0 | 0 | 0 |
   | 1 | 0 | 0 |
   | 0 | 10 | 0 |
   | 1 | 10 | 10 |
   | 100 | 10 | 1000 |
   | 1 | 99 | 99 |
   | 10 | 99 | 990 |
   