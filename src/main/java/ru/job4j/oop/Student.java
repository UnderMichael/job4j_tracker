package ru.job4j.oop;

public class Student {
	public static void main(String[] args) {
		Student petya = new Student();
		petya.music();
		petya.sing();
		petya.music();
		petya.sing();
		petya.music();
		petya.sing();
	}

	public void music() {
		System.out.println("tra tra tra");
	}

	public void sing() {
		System.out.println("I believe I can fly");
	}
}
