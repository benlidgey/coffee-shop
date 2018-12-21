/**
 * 
 */
package com.btb.coffeeshop.purchase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btb.coffeeshop.basket.Basket;
import com.btb.coffeeshop.brew.BrewingService;
import com.btb.coffeeshop.customer.Customer;
import com.btb.coffeeshop.customer.CustomerService;
import com.btb.coffeeshop.customer.Item;
import com.btb.coffeeshop.customer.NoSuchCustomerException;

@Service("PurchaseService")
public class PurchaseService {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BrewingService brewingService;

	private Map<Customer, Basket> baskets = new HashMap<Customer, Basket>();

	public Basket getBasket(Customer customer) {
		// get basket for customer
		Basket basket = baskets.get(customer);

		// check if basket exists
		if (basket == null) {
			// if not then create basket and add to baskets
			basket = new Basket();
			baskets.put(customer, basket);
		}
		return basket;
	}

	public void clearBasket(Customer customer) {
		Basket basket = getBasket(customer);
		basket.empty();
		baskets.put(customer, basket);
	}

	public void addItem(Customer customer, Item item) {
		Basket basket = getBasket(customer);
		basket.addItem(item);
	}

	public void makePurchase(Customer customer) throws InsufficientFundsException, NoSuchCustomerException {

		// get the basket for the customer
		Basket basket = getBasket(customer);

		// charge the customer
		try {
			customerService.chargeCustomer(customer.getId(), basket.getTotalPrice());
		} catch (InsufficientFundsException e) {
			// TODO log purchase error
			throw e;
		}

		// go through each item and remove from stock
		for (Iterator<Item> iterator = basket.getItems().iterator(); iterator.hasNext();) {
			Item item = iterator.next();
			// TODO what happens if the stock is empty?
			brewingService.brewItem(item.getName());
		}
		// add the order to the customer
		customerService.addPurchaseToCustomer(customer.getId(), basket);

	}

	public BrewingService getBrewingService() {
		return brewingService;
	}

	public void setBrewingService(BrewingService brewingService) {
		this.brewingService = brewingService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
