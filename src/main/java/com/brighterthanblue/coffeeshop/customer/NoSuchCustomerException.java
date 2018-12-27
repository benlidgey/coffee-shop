package com.btb.coffeeshop.customer;

public class NoSuchCustomerException extends Exception {

	private static final long serialVersionUID = 8223068514835537800L;

	private Integer id;
	
	public NoSuchCustomerException(Integer id, String message) {
		super(message);
		this.id = id;
	}

	public NoSuchCustomerException(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getMessage() {
		return "Customer:" + id + " not found.";
	}


}
