package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		String[] o1Parts = o1.split("/");
		String[] o2Parts = o2.split("/");
		int result = o2Parts[0].compareTo(o1Parts[0]);
		if (result != 0) {
			return result;
		}
		return o1.compareTo(o2);
	}
}
