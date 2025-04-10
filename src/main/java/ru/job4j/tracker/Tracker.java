package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
	private final Item[] items = new Item[100];

	private int ids = 1;

	private int size = 0;

	public Item add(Item item) {
		item.setId(ids++);
		items[size++] = item;
		return item;
	}

	public Item[] findAll() {
		Item[] result = new Item[this.size];
		int size = 0;
		for (Item item : this.items) {
			if (item != null) {
				result[size] = item;
				size++;
			}
		}
		return Arrays.copyOf(result, size);
	}

	public Item[] findByName(String key) {
		Item[] result = new Item[this.size];
		int size = 0;
		for (Item item : this.items) {
			if (item != null && item.getName().equals(key)) {
				result[size] = item;
				size++;
			}
		}
		return Arrays.copyOf(result, size);
	}

	public void delete(int id) {
		int index = indexOf(id);
		if (index != -1) {
			int length = size - index - 1;
			System.arraycopy(items, index + 1, items, index, length);
			items[size - 1] = null;
			size--;
		}
	}

	public Item findById(int id) {
		int index = indexOf(id);
		return index != -1 ? items[index] : null;
	}

	public boolean replace(int id, Item item) {
		int index = indexOf(id);
		boolean result = index != -1;

		if (result) {
			item.setId(id);
			items[index] = item;
		}

		return result;
	}

	private int indexOf(int id) {
		int result = -1;
		for (int index = 0; index < size; index++) {
			if (items[index].getId() == id) {
				result = index;
				break;
			}
		}
		return result;
	}
}