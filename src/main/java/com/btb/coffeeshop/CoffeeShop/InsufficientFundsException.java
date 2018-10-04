package com.btb.coffeeshop.CoffeeShop;

public class InsufficientFundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 59631943927460796L;

	private Long customerId;
	private Integer orderTotalPrice;
	private Integer customerBalance;

	public InsufficientFundsException(Long id, Integer totalPrice, Integer balance) {
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
