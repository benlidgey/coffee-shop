package com.btb.coffeeshop.basket;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.btb.coffeeshop.customer.Item;

public class BasketTest {

	@Test
	public void testEmpty() {
		// Get an basket with something in it
		Basket basket = new Basket();
		basket.addItem(new Item());
		
		// Test it is not empty
		assertFalse(basket.getItems().isEmpty(), "Basket is empty");
		
		// Empty it
		basket.empty();
		
		// Test it is empty
		assertTrue(basket.getItems().isEmpty(), "Basket is not empty");
		
	}

}
