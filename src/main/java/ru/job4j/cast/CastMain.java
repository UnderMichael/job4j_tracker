package ru.job4j.cast;

public class CastMain {
	public static void main(String[] args) {
		Vehicle bus1 = new Bus();
		Vehicle bus2 = new Bus();
		Vehicle bus3 = new Bus();
		Vehicle train1 = new Train();
		Vehicle train2 = new Train();
		Vehicle train3 = new Train();
		Vehicle plain1 = new Plain();
		Vehicle plain2 = new Plain();
		Vehicle plain3 = new Plain();
		Vehicle[] vehicles = {bus1, bus2, bus3, train1, train2, train3, plain1, plain2, plain3};
		for (Vehicle vehicle : vehicles) {
			vehicle.move();
		}
	}
}
