package com.brighterthanblue.coffeeshop.purchase;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.brighterthanblue.coffeeshop.basket.Basket;
import com.brighterthanblue.coffeeshop.customer.Customer;
import com.brighterthanblue.coffeeshop.customer.InvalidDateOfBirthException;
import com.brighterthanblue.coffeeshop.purchase.PurchaseService;

public class PurchaseServiceTest {

	
	
	@Test
	public void testGetBasketForNewCustomer() throws InvalidDateOfBirthException {
		// create an empty purchase service
		PurchaseService service = new PurchaseService();
		
		// create new customer
		Integer id = createRandomId();
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

	private Integer createRandomId() {
		Random r = new Random();
		return r.nextInt();
	}
}
