package com.example.salut.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class AnimalContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<Animal> ITEMS = new ArrayList<Animal>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, Animal> ITEM_MAP = new HashMap<String, Animal>();

	static {
		// Add 3 sample items.
		addItem(new Animal("1", "Item 1", "Species 1", "gorilla"));
		addItem(new Animal("2", "Item 2", "Species 2", "ara"));
		addItem(new Animal("3", "Item 3", "Species 3", "snow_leopard"));
	}

	private static void addItem(Animal item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
}
