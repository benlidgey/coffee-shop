package com.btb.coffeeshop.CoffeeShop;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BasketTest {

	@Test
	public void testEmpty() {
		// Get an basket with something in it
		Basket basket = new Basket();
		basket.addItem(new Item());
		
		// Test it is not empty
		assertFalse("Basket is empty",basket.getItems().isEmpty());
		
		// Empty it
		basket.empty();
		
		// Test it is empty
		assertTrue("Basket is not empty", basket.getItems().isEmpty());
		
	}

}
