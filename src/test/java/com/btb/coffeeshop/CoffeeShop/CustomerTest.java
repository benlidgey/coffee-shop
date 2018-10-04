package com.btb.coffeeshop.CoffeeShop;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;


public class CustomerTest {

	/**
	 * Test that creating a customer with a date of birth in the future will fail
	 * and throw an exception.
	 */
	@Test
	public void testCreateCustomerFutureDateOfBirth() {

		try {
			// set a date in the future by 10 years
			Date future = new Date();
			future = DateUtils.addYears(future, 10);

			// create a customer
			// the creation should fail
			Customer cust = new Customer(1L, "Mr Future", future, "An address", 10);
			
			// if get here then exception not thrown
			fail("Exception not thrown for future date of birth: " + future.toString());
		} catch (InvalidDateOfBirthException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test that creating a customer with a date of birth in the past will pass
	 */
	@Test
	public void testCreateCustomerPastDateOfBirth() {

		try {
			// set a date in the past by 10 years
			Date past = new Date();
			past = DateUtils.addYears(past, -10);

			// create a customer
			// the creation should fail
			Customer cust = new Customer(1L, "Mr Past", past, "An address", 10);
			assertNotNull(cust);
		} catch (InvalidDateOfBirthException ex) {
			// exception thrown so fail the test
			fail("Invalid Date of Birth: " + ex.toString());
		}
	}

}
