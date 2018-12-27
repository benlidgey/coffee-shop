/**
 * 
 */
package com.brighterthanblue.coffeeshop.customer;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import com.brighterthanblue.coffeeshop.basket.Basket;

@KeySpace("customers")
public class Customer {

	@Id
	private Integer id;
	private String name;
	private Date dateOfBirth;
	private String address;
	private Collection<Basket> orders = new HashSet<Basket>();
	private Integer balanceInPence = 0;

	public Customer(Integer id, String name, Date dob, String addr, Integer balanceInPence)
			throws InvalidDateOfBirthException {
		this.id =id;
		this.name = name;
		setDateOfBirth(dob);
		this.address = addr;
		this.balanceInPence = balanceInPence;
	}

	public void setBalance(Integer pence) {
		this.balanceInPence = pence;
	}

	public void setAddress(String addr) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void addOrder(Basket basket) {
		orders.add(basket);
	}

	public Integer getBalance() {
		return balanceInPence;
	}

	public void charge(Integer totalPrice) {
		this.balanceInPence -= totalPrice;

	}

	@Override
	public String toString() {
		return "Customer [customerId=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", orders=" + orders + ", balanceInPence=" + balanceInPence + "]";
	}

}
