package com.brighterthanblue.coffeeshop.purchase;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.brighterthanblue.coffeeshop.DateOfBirthUtils;
import com.brighterthanblue.coffeeshop.basket.Basket;
import com.brighterthanblue.coffeeshop.brew.BrewingService;
import com.brighterthanblue.coffeeshop.customer.Customer;
import com.brighterthanblue.coffeeshop.customer.CustomerService;
import com.brighterthanblue.coffeeshop.customer.CustomerServiceMock;
import com.brighterthanblue.coffeeshop.customer.InvalidDateOfBirthException;
import com.brighterthanblue.coffeeshop.customer.Item;
import com.brighterthanblue.coffeeshop.customer.NoSuchCustomerException;
import com.brighterthanblue.coffeeshop.purchase.InsufficientFundsException;
import com.brighterthanblue.coffeeshop.purchase.PurchaseService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PurchaseBasketSteps extends CucumberStepDefinitions {

	private CustomerService customerService = new CustomerServiceMock();
	private PurchaseService purchaseService = new PurchaseService();
	private BrewingService brewingService = new BrewingService();
	
	private Integer customerId = RandomUtils.nextInt();
	private Customer customer;
	// private Basket basket;
	private boolean insufficientFunds = false;

	public PurchaseBasketSteps() {

		try {
			customer = new Customer(customerId, "name", DateOfBirthUtils.getDateInPast(15), "1 high St", 0);
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
	public void the_Purchase_button_is_pressed() throws NoSuchCustomerException {
		try {
			// make the purchase
			Basket basket = purchaseService.getBasket(customer);
			customerService.addPurchaseToCustomer(customer.getId(), basket);
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
