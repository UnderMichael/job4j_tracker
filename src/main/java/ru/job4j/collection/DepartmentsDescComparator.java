package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		String[] o1Parts = o1.split("/");
		String[] o2Parts = o2.split("/");
		if (!o1Parts[0].equals(o2Parts[0])) {
			return o2Parts[0].compareTo(o1Parts[0]);
		}
		int minLength = Math.min(o1Parts.length, o2Parts.length);
		for (int i = 1; i < minLength; i++) {
			if (!o2Parts[i].equals(o1Parts[i])) {
				return o1Parts[i].compareTo(o2Parts[i]);
			}
		}
		return Integer.compare(o1Parts.length, o2Parts.length);
	}
}
