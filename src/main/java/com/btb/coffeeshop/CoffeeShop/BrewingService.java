/**
 * 
 */
package com.btb.coffeeshop.CoffeeShop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author blidgey
 *
 */
public class BrewingService {

	private Map<String, Integer> stock = new HashMap<String, Integer>();

	public Collection<String> searchByName(String search) {
		// TODO search for the items in the stock based on name matching
		return new ArrayList<String>();
	}

	public void brewItem(String itemName) {
		// get the number of items from the stock
		Integer numberInStock = stock.get(itemName);
		// reduce by one
		stock.put(itemName, numberInStock - 1);
	}

	public void addToStock(String name, Integer number) {
		if (stock.containsKey(name)) {
			int currentStock = stock.get(name);
			currentStock += number;
			stock.put(name, currentStock);
		} else {
			stock.put(name, number);
		}
	}

}
