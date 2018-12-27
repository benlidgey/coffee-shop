package com.brighterthanblue.coffeeshop.purchase;

public class InsufficientFundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 59631943927460796L;

	private Integer customerId;
	private Integer orderTotalPrice;
	private Integer customerBalance;

	public InsufficientFundsException(Integer id, Integer totalPrice, Integer balance) {
		this.customerBalance = balance;
		this.customerId = id;
		this.orderTotalPrice = totalPrice;
	}

	@Override
	public String getMessage() {
		return "Insufficient funds for customer:" + customerId + ". Total price is: " + orderTotalPrice
				+ ", customer balance is: " + customerBalance;
	}

}
