package com.btb.coffeeshop.CoffeeShop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Calendar;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurchaseBasketSteps {

	private CustomerService customerService = new CustomerService();
	private PurchaseService purchaseService = new PurchaseService();
	private BrewingService brewingService = new BrewingService();
	private Long customerId = RandomUtils.nextLong();
	private Customer customer;
	// private Basket basket;
	private boolean insufficientFunds = false;

	public PurchaseBasketSteps() {

		try {
			Calendar c = Calendar.getInstance();
			c.set(1970, 1, 1);
			customer = new Customer(customerId, "name", c.getTime(), "1 high St", 0);
		} catch (InvalidDateOfBirthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// basket = new Basket();
		customerService.addCustomer(customer);

		purchaseService.setCustomerService(customerService);
		purchaseService.setBrewingService(brewingService);
	}

	@Given("my basket contains {int} items called latte of {int} pence each")
	public void my_basket_contains_items_called_latte_of_pence_each(Integer numberOfItems, Integer price) {
		// basket.empty();
		for (int i = 0; i < numberOfItems; i++) {
			Item item = new Item();
			item.setName("latte");
			item.setPriceInPence(price);
			// basket.addItem(item);
			// add to the basket
			purchaseService.addItem(customer, item);
		}

		Basket basket = purchaseService.getBasket(customer);
		assertTrue(basket.getItems().size() == numberOfItems);
	}
	
	@Given("the stock contains {int} items called latte")
	public void the_stock_contains_items_called_latte(Integer int1) {
	    // add to the brewing service
		brewingService.addToStock("latte", int1);
	}

	@When("the Purchase button is pressed")
	public void the_Purchase_button_is_pressed() {
		try {
			// make the purchase
			Basket basket = purchaseService.getBasket(customer);
			customerService.addPurchaseToCustomer(customer.getCustomerId(), basket);
			// call the purchase service

			purchaseService.makePurchase(customer);
		} catch (InsufficientFundsException e) {
			// insufficient funds in customer account
			// set the flag to show that it has been thrown
			insufficientFunds = true;
		}
	}

	@Then("the total price should be {int} pence")
	public void the_total_price_should_be_pence(Integer pence) {

		Basket basket = purchaseService.getBasket(customer);

		Integer total = 0;
		for (Item item : basket.getItems()) {
			// for the item get the price
			total += item.getPriceInPence();
		}

		// price cannot be negative
		assertTrue(total >= 0);

		// check the total price
		assertEquals(total, pence);
	}

	@Then("a purchase failed error should be thrown")
	public void a_purchase_failed_error_should_be_thrown() {
		// insufficient funds should be true
		assertTrue(insufficientFunds);
	}

}
