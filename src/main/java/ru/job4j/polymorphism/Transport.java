package ru.job4j.polymorphism;

public interface Transport {
	int FUEL_COST = 54;

	void move();

	void passengers(int count);

	int refuel(int fuel);
}
