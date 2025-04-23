package ru.job4j.collection;

import java.util.Objects;

public record User(String name, int age) implements Comparable<User> {
	@Override
	public int compareTo(User o) {
		int compareNames = name.compareTo(o.name());
		if (compareNames != 0) {
			return compareNames;
		}
		return Integer.compare(age, o.age());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		User user = (User) obj;
		return age == user.age() && Objects.equals(name, user.name());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
