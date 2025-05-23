package ru.job4j.collection;

import java.util.Objects;

public record Account(String passport, String username, String deposit) {

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(passport, account.passport);
	}

	@Override
	public String toString() {
		return "Account{"
			   + "passport='" + passport + '\''
			   + ", username='" + username + '\''
			   + ", deposit='" + deposit + '\''
			   + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(passport);
	}
}
