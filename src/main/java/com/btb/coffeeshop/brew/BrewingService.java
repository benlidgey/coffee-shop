/**
 * 
 */
package com.btb.coffeeshop.brew;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author blidgey
 *
 */
@Service
public class BrewingService {

	private Map<String, Integer> stock = new HashMap<String, Integer>();

	public Collection<Coffee> searchByType(String search) {
		// TODO search for the items in the stock based on name matching
		final Collection<Coffee> coffees = new ArrayList<Coffee>();
		coffees.add(new Coffee("Latte", CoffeeType.CAFFINATED, 180));
		coffees.add(new Coffee("Decaf Latte", CoffeeType.DECAFF, 200));

		return coffees;
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
