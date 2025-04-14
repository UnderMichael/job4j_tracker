package ru.job4j.cast;

public class Bus implements Vehicle {
	private static final int MAX_PASSENGERS = 60;

	@Override
	public void move() {
		System.out.println("driving along the road");
	}

	@Override
	public void passengers(int count) {
		if (count > MAX_PASSENGERS) {
			System.out.println("there's no so much seats");
		} else {
			System.out.println("The bus departs with " + count + " passengers.");
		}
	}
}
