package ru.job4j.bank;

import java.util.Objects;

public record User(String passport, String username) {
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(passport, user.passport);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(passport);
	}
}
