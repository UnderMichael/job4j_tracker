package ru.job4j.tracker;

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
}