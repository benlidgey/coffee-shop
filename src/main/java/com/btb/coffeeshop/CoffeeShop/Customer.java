/**
 * 
 */
package com.btb.coffeeshop.CoffeeShop;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author blidgey
 *
 */
public class Customer {

	private Long customerId;
	private String name;
	private Date dateOfBirth;
	private String address;
	private Collection<Basket> orders = new HashSet<Basket>();

	public Customer(Long id, String name, Date dob, String addr) throws InvalidDateOfBirthException {
		setCustomerId(id);
		setName(name);
		setDateOfBirth(dob);
		setAddress(addr);
	}

	private void setAddress(String addr) {
		this.address = addr;
	}

//	private void setDateOfBirth(Date dob) throws InvalidDateOfBirthException {
//		this.dateOfBirth = dob;
//
//	}
	

	private void setDateOfBirth(Date dob) throws InvalidDateOfBirthException {
		if (dob != null && dob.before(new Date())) {
			// dob is in the past
			this.dateOfBirth = dob;
		} else {
			// dob is in the future
			throw new InvalidDateOfBirthException("Date of birth " + dob + " is in the future.");
		}
	}

	private void setName(String customerName) {
		this.name = customerName;
	}

	public String getName() {
		return this.name;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public Long getCustomerId() {
		return customerId;
	}

	private void setCustomerId(Long id) {
		this.customerId = id;
	}

	public void addOrder(Basket basket) {
		orders.add(basket);
	}

}
