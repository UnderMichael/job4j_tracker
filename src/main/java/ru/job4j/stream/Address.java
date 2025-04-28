package ru.job4j.stream;

import java.util.Objects;

public record Address(String city, String street, int home, int apartment) {
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return home == address.home
			   && apartment == address.apartment
			   && Objects.equals(city, address.city)
			   && Objects.equals(street, address.street);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, street, home, apartment);
	}
}
