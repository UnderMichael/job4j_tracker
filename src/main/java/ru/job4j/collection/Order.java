package ru.job4j.collection;

import java.util.Objects;

public record Order(String number, String name) {
	@Override
	public String toString() {
		return "Order{"
			   + "number='" + number + '\''
			   + ", name='" + name + '\''
			   + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;
		return Objects.equals(number, order.number)
			   && Objects.equals(name, order.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, name);
	}
}
