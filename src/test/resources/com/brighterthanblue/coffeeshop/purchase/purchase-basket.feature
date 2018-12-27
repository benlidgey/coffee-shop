
Feature: Purchase Basket
  Purchase a basket of items
  
Scenario Outline: Purchase a basket of items
  Given my basket contains <numberOfBasketItems> items called <stockName> of <price> pence each
  	And the stock contains <numberOfStockItems> items called <stockName>
  When the Purchase button is pressed
  Then the total price should be <total> pence
 
 Examples:
   | stockName | numberOfStockItems | numberOfBasketItems | price | total |
   | latte | 1 | 0 | 0 | 0 |
   | latte | 1 | 1 | 0 | 0 |
   | latte | 1 | 0 | 10 | 0 |
   | latte | 10 | 10 | 10 | 100 |
   | latte | 100 | 100 | 10 | 1000 |
   | latte | 1 | 1 | 99 | 99 |
   | latte | 100 | 10 | 99 | 990 |
   
 Scenario: Purchase a basket of 2 items
  Given my basket contains 2 items called latte of 50 pence each
  	And the stock contains 2 items called latte
  When the Purchase button is pressed
  Then the total price should be 100 pence
 
 Scenario: Purchase a basket of items with a negative price
  Given my basket contains 2 items called latte of -10 pence each
  	And the stock contains 2 items called latte
  When the Purchase button is pressed
  Then a purchase failed error should be thrown
 