/**
 * 
 */
package com.btb.coffeeshop.customer;

/**
 * @author blidgey
 *
 */
public class Item {

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", priceInPence=" + priceInPence + "]";
	}

	private Long id;
	private String name;
	private Integer priceInPence;

	public Integer getPriceInPence() {
		return priceInPence;
	}

	public void setPriceInPence(Integer price) {
		this.priceInPence = price;
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
