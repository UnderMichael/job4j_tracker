package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
	private final List<Item> items = new ArrayList<>();

	private int ids = 1;

	public Item add(Item item) {
		item.setId(ids++);
		items.add(item);
		return item;
	}

	public List<Item> findAll() {
		return items;
	}

	public List<Item> findByName(String key) {
		List<Item> result = new ArrayList<>();
		for (Item item : items) {
			if (item.getName().equals(key)) {
				result.add(item);
			}
		}
		return result;
	}

	public void delete(int id) {
		Item item = findById(id);
		items.remove(item);
	}

	public Item findById(int id) {
		int index = indexOf(id);
		return index != -1 ? items.get(index) : null;
	}

	public boolean replace(int id, Item item) {
		Item oldItem = findById(id);
		boolean result = oldItem != null;

		if (result) {
			items.remove(oldItem);
			item.setId(id);
			items.add(item);
		}

		return result;
	}

	private int indexOf(int id) {
		int result = -1;
		for (int index = 0; index < items.size(); index++) {
			if (items.get(index).getId() == id) {
				result = index;
				break;
			}
		}
		return result;
	}
}