package com.brighterthanblue.coffeeshop.customer;

import java.util.HashMap;

import com.brighterthanblue.coffeeshop.customer.Customer;
import com.brighterthanblue.coffeeshop.customer.CustomerServiceImpl;
import com.brighterthanblue.coffeeshop.customer.NoSuchCustomerException;

public class CustomerServiceMock extends CustomerServiceImpl {

	private HashMap<Integer, Customer> map = new HashMap<Integer, Customer>();

	@Override
	public void addCustomer(Customer customer) {
		map.put(customer.getId(), customer);

	}

	@Override
	public Customer get(Integer id) throws NoSuchCustomerException {
		return map.get(id);
	}

}
