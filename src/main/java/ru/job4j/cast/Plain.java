package ru.job4j.cast;

public class Plain implements Vehicle {
	private static final int MAX_PASSENGERS = 180;

	@Override
	public void move() {
		System.out.println("flies");
	}

	@Override
	public void passengers(int count) {
		if (count > MAX_PASSENGERS) {
			System.out.println("there's no so much seats");
		} else {
			System.out.println("The plain departs with " + count + " passengers.");
		}
	}
}
