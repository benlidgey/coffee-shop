/**
 * 
 */
package com.brighterthanblue.coffeeshop.customer;

import org.springframework.stereotype.Service;

import com.brighterthanblue.coffeeshop.basket.Basket;
import com.brighterthanblue.coffeeshop.purchase.InsufficientFundsException;

@Service("CustomerService")
public interface CustomerService {

	public void addCustomer(Customer customer);

	public void addPurchaseToCustomer(Integer id, Basket basket) throws NoSuchCustomerException;

	public void chargeCustomer(Integer id, Integer totalPrice) throws InsufficientFundsException, NoSuchCustomerException;

	public Customer get(Integer id) throws NoSuchCustomerException;
}
