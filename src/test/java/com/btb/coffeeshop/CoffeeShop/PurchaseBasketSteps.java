package com.btb.coffeeshop.CoffeeShop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurchaseBasketSteps {

	Basket basket = new Basket();

	public PurchaseBasketSteps() {
		// TODO Auto-generated constructor stub
	}

	@Given("my basket contains {int} items of {int} pence each")
	public void my_basket_contains_items_of_pence_each(Integer numberOfItems, Integer price) {
		basket.empty();
		for (int i = 0; i < numberOfItems; i++) {
			Item item = new Item();
			item.setName(Integer.toString(i));
			item.setPriceInPence(price);
			basket.addItem(item);
		}

		assertTrue(basket.getItems().size() == numberOfItems);
	}

	@When("the Purchase button is pressed")
	public void the_Purchase_button_is_pressed() {
		// don't need to do anything here
	}

	@Then("the total price should be {int} pence")
	public void the_total_price_should_be_pence(Integer pence) {
		Integer total = 0;
		for (Item item : basket.getItems()) {
			// for the item get the price
			total += item.getPriceInPence();
		}
		
		// check the total price
		assertEquals(total, pence);
	}

}
