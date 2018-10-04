package com.btb.coffeeshop.CoffeeShop;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class PurchaseServiceTest {

	
	
	@Test
	public void testGetBasketForNewCustomer() throws InvalidDateOfBirthException {
		// create an empty purchase service
		PurchaseService service = new PurchaseService();
		
		// create new customer
		Long id = createRandomId();
		Date dob = createDateOfBirth();
		Customer newCustomer = new Customer(id, "New customer", dob , "Address", 10);
		Basket basket = service.getBasket(newCustomer);
		
		// check basket is not null
		assertNotNull(basket);
		// check is empty
		assertTrue(basket.getItems().isEmpty());
	}

//	@Test
//	void testMakePurchase() {
//		fail("Not yet implemented");
//	}

	private Date createDateOfBirth() {
		Date dob = new Date();
		dob = DateUtils.addYears(dob, -20);
		return dob;
	}

	private Long createRandomId() {
		Random r = new Random();
		return r.nextLong();
	}
}
