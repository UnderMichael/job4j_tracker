package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
	private final Suit suit;

	private final Value value;

	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public static void main(String[] args) {
		Stream.of(Value.values())
				.flatMap(value -> Stream.of(Suit.values())
						.map(suit -> new Card(suit, value)))
				.forEach(System.out::println);
	}

	@Override
	public String toString() {
		return value + " " + suit;
	}

	private enum Suit {
		Diamonds, Hearts, Spades, Clubs
	}

	private enum Value {
		V_6, V_7, V_8
	}
}