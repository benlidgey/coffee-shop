/**
 * 
 */
package com.btb.coffeeshop.customer;

import java.util.HashMap;
import java.util.Map;

import com.btb.coffeeshop.basket.Basket;
import com.btb.coffeeshop.purchase.InsufficientFundsException;

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

	public void chargeCustomer(Long id, Integer totalPrice) throws InsufficientFundsException {
		// get customer
		Customer customer = customers.get(id);

		Integer balance = customer.getBalance();

		// check the customer has enough in their account
		if (balance <= totalPrice) {

			// charge the customer the amount
			customer.charge(totalPrice);
		} else {
			// the customer does not have enough in their account
			// so reject the charge
			throw new InsufficientFundsException(id, totalPrice, balance);
		}

	}
}
