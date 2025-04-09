package ru.job4j.oop;

public class Battery {
	private int load;

	public Battery(int load) {
		this.load = load;
	}

	public static void main(String[] args) {
		Battery first = new Battery(70);
		Battery second = new Battery(30);
		System.out.println("first." + first.about());
		System.out.println("second." + second.about());
		first.exchange(second);
	}

	public void exchange(Battery target) {
		target.load += load;
		load = 0;
	}

	public String about() {
		return "My charge: " + load + "%";
	}
}
