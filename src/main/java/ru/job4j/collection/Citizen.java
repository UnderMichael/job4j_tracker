package ru.job4j.collection;

import java.util.Objects;

public record Citizen(String passport, String username) {
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Citizen citizen = (Citizen) o;
		return Objects.equals(passport, citizen.passport);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(passport);
	}
}
