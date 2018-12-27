/**
 * 
 */
package com.brighterthanblue.coffeeshop.brew;

/**
 * @author blidgey
 *
 */
public class Coffee {

	private String name;
	private CoffeeType type;
	private int price;

	public Coffee(String n, CoffeeType t, int price) {
		name = n;
		type = t;
	}

	public String getName() {
		return name;
	}

	public CoffeeType getType() {
		return type;
	}
	
	public int getPrice() {
		return price;
	}
}
