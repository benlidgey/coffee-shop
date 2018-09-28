/**
 * 
 */
package com.btb.coffeeshop.CoffeeShop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author blidgey
 *
 */
public class PurchaseService {

	private CustomerService customerService;
	private BrewingService stockService;

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

	public void makePurchase(Customer customer) {

		// get the basket for the customer
		Basket basket = getBasket(customer);

		// go through each item and remove from stock
		for (Iterator<Item> iterator = basket.getItems().iterator(); iterator.hasNext();) {
			Item item = (Item) iterator.next();
			// TODO what happens if the stock is empty?
			stockService.brewItem(item);
		}
		// add the order to the customer
		customerService.addPurchaseToCustomer(customer.getCustomerId(), basket);
	}

	public BrewingService getStockService() {
		return stockService;
	}

	public void setStockService(BrewingService stockService) {
		this.stockService = stockService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
