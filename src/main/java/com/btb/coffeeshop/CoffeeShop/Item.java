/**
 * 
 */
package com.btb.coffeeshop.CoffeeShop;

/**
 * @author blidgey
 *
 */
public class Item {

	private Long id;
	private String name;
	private Long price;

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
