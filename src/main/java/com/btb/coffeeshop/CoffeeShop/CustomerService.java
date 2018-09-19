/**
 * 
 */
package com.btb.coffeeshop.CoffeeShop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author blidgey
 *
 */
public class CustomerService {

	private Map<Long, Customer> customers = new HashMap<Long, Customer>();

	public void addCustomer(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
	}

	public void addPurchaseToCustomer(Long id, Basket basket) {
		// get customer
		Customer customer = customers.get(id);
		// add basket to order
		customer.addOrder(basket);
	}
}
