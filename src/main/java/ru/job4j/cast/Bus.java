package ru.job4j.cast;

public class Bus implements Vehicle {
	@Override
	public void move() {
		System.out.println("driving along the road");
	}

	@Override
	public void passengers(int count) {

	}
}
