/**
 * 
 */
package com.btb.coffeeshop.CoffeeShop;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author blidgey
 *
 */
public class Basket {

	private Collection<Item> items = new HashSet<Item>();

	public Basket() {
	}

	public void addItem(Item i) {
		items.add(i);
	}

	public void empty() {
		items = new HashSet<Item>();
	}

	public Collection<Item> getItems() {
		return items;
	}

	public Integer getTotalPrice() {
		Integer totalPrice = 0;
		for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
			Item item = (Item) iterator.next();
			totalPrice += item.getPriceInPence();
		}
		return totalPrice;
	}
}
