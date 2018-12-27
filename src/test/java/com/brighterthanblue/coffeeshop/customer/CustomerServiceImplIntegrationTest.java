package com.brighterthanblue.coffeeshop.customer;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brighterthanblue.coffeeshop.CoffeeShopWebApplication;
import com.brighterthanblue.coffeeshop.DateOfBirthUtils;
import com.brighterthanblue.coffeeshop.customer.Customer;
import com.brighterthanblue.coffeeshop.customer.CustomerService;
import com.brighterthanblue.coffeeshop.customer.InvalidDateOfBirthException;
import com.brighterthanblue.coffeeshop.customer.NoSuchCustomerException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoffeeShopWebApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceImplIntegrationTest {

	@Autowired
//	@Qualifier("CustomerServiceImpl")
	CustomerService customerService;

	@Autowired
	@Qualifier("keyValueTemplate")
	KeyValueTemplate keyValueTemplate;

	static Customer customer1;

	static Customer customer2;

	@BeforeClass
	public static void setUp() throws InvalidDateOfBirthException {
		customer1 = new Customer(1, "Karen", DateOfBirthUtils.getDateInPast(10), "Karen address", 5000);
		customer2 = new Customer(2, "Jack", DateOfBirthUtils.getDateInPast(20), "Jack address", 2000);
	}

	@Test
	public void test1_WhenCustomerSaved_thenCustomerIsAddedToMap() {
		customerService.addCustomer(customer1);
		assertEquals(keyValueTemplate.findById(1, Customer.class).get(), customer1);
	}

	@Test
	public void test2_WhenCustomerGet_thenCustomerIsReturnedFromMap() throws NoSuchCustomerException {
		Customer customerFetched = customerService.get(1);
		assertEquals(customerFetched, customer1);
	}

}
