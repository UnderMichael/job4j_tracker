package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;

public class Profiles {
	public static List<Address> collect(List<Profile> profiles) {
		return profiles.stream()
				.map(Profile::address)
				.toList();
	}

	public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
		return profiles.stream()
				.sorted(Comparator.comparing(left -> left.address().city()))
				.distinct()
				.map(Profile::address)
				.toList();
	}
}
