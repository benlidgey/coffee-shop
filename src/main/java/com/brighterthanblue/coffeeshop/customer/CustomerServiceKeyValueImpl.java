package com.brighterthanblue.coffeeshop.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.stereotype.Service;

@Service
@DependsOn("keyValueTemplate")
public class CustomerServiceKeyValueImpl extends CustomerServiceImpl {

	@Autowired
	@Qualifier("keyValueTemplate")
	KeyValueTemplate keyValueTemplate;

	@Override
	public void addCustomer(Customer customer) {
		keyValueTemplate.insert(customer);
	}
	
	@Override
	public Customer get(Integer id) throws NoSuchCustomerException {
		final Optional<Customer> cust = keyValueTemplate.findById(id, Customer.class);
		if (cust.isPresent()) {
			return cust.get();
		} else {
			throw new NoSuchCustomerException(id);
		}
	}

}
