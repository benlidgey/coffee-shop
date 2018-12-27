/**
 * 
 */
package com.brighterthanblue.coffeeshop.customer;

import com.brighterthanblue.coffeeshop.basket.Basket;
import com.brighterthanblue.coffeeshop.purchase.InsufficientFundsException;

public abstract class CustomerServiceImpl implements CustomerService {


	@Override
	public abstract void addCustomer(Customer customer);

	@Override
	public void addPurchaseToCustomer(Integer id, Basket basket) throws NoSuchCustomerException {
		// get customer
		Customer customer = get(id);
		// add basket to order
		customer.addOrder(basket);
	}

	@Override
	public abstract Customer get(Integer id) throws NoSuchCustomerException;

	@Override
	public void chargeCustomer(Integer id, Integer totalPrice) throws InsufficientFundsException, NoSuchCustomerException {
		// get customer
		Customer customer = get(id);

		
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
