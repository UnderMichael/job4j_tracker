package ru.job4j.cast;

public class Plain implements Vehicle {
	@Override
	public void move() {
		System.out.println("flies");
	}

	@Override
	public void passengers(int count) {

	}
}
