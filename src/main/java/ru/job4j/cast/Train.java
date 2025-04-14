package ru.job4j.cast;

public class Train implements Vehicle {
	private static final int MAX_PASSENGERS = 810;

	@Override
	public void move() {
		System.out.println("rides on rails");
	}

	@Override
	public void passengers(int count) {
		if (count > MAX_PASSENGERS) {
			System.out.println("there's no so much seats");
		} else {
			System.out.println("The train departs with " + count + " passengers.");
		}
	}
}
