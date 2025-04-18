package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
	private static SingleTracker instance = null;

	private final Tracker tracker = new Tracker();

	private SingleTracker() {
	}

	public static SingleTracker getInstance() {
		if (instance == null) {
			instance = new SingleTracker();
		}
		return instance;
	}

	public Item add(Item item) {
		return this.tracker.add(item);
	}

	public List<Item> findAll() {
		return this.tracker.findAll();
	}

	public List<Item> findByName(String key) {
		return this.tracker.findByName(key);
	}

	public void delete(int id) {
		this.tracker.delete(id);
	}

	public Item findById(int id) {
		return this.tracker.findById(id);
	}

	public boolean replace(int id, Item item) {
		return this.tracker.replace(id, item);
	}
}