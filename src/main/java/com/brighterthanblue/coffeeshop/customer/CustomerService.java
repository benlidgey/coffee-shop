/**
 * 
 */
package com.btb.coffeeshop.customer;

import org.springframework.stereotype.Service;

import com.btb.coffeeshop.basket.Basket;
import com.btb.coffeeshop.purchase.InsufficientFundsException;

@Service("CustomerService")
public interface CustomerService {

	public void addCustomer(Customer customer);

	public void addPurchaseToCustomer(Integer id, Basket basket) throws NoSuchCustomerException;

	public void chargeCustomer(Integer id, Integer totalPrice) throws InsufficientFundsException, NoSuchCustomerException;

	public Customer get(Integer id) throws NoSuchCustomerException;
}
