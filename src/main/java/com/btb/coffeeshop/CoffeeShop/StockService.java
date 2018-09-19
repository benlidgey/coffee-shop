/**
 * 
 */
package com.btb.coffeeshop.CoffeeShop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author blidgey
 *
 */
public class StockService {

	private Map<Item, Integer> stock = new HashMap<Item, Integer>();

	public Collection<Item> searchByName(String search) {
		// TODO search for the items in the stock based on name matching
		return new ArrayList<Item>();
	}

	public void removeItemFromStock(Item item) {
		// get the number of items from the stock
		Integer numberInStock = stock.get(item);
		// reduce by one
		stock.put(item, numberInStock - 1);
	}

}
