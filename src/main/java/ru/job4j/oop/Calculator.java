package ru.job4j.oop;

public class Calculator {
	private static int x = 5;

	public static int sum(int y) {
		return x + y;
	}

	public static int minus(int y) {
		return x - y;
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int result = calculator.multiply(10);
		System.out.println(result);

		result = minus(5);
		System.out.println(result);
		result = sum(6);
		System.out.println(result);
		double res = calculator.divide(13);
		System.out.println(res);
		res = calculator.sumOfAllOperations(7);
		System.out.println(res);
	}

	public double divide(int y) {
		return y / x;
	}

	public double sumOfAllOperations(int y) {
		return sum(y) + multiply(y) + minus(y) + divide(y);
	}

	public int multiply(int a) {
		return x * a;
	}
}
