package ru.job4j.polymorphism;

public class Bus implements Transport {
	private static final int MAX_PASSENGERS = 60;

	@Override
	public void move() {
		System.out.println("Bus start moving");
	}

	@Override
	public void passengers(int count) {
		if (count > MAX_PASSENGERS) {
			System.out.println("there's no so much seats");
		} else {
			System.out.println("The bus departs with " + count + " passengers.");
		}
	}

	@Override
	public int refuel(int fuel) {
		return fuel * Transport.FUEL_COST;
	}
}
