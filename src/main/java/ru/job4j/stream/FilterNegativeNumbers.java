package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> positive = numbers.stream()
				.filter(number -> number > 0)
				.toList();
		positive.forEach(System.out::println);
	}
}