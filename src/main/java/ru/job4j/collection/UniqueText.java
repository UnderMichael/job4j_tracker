package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {

	public boolean isEquals(String originText, String duplicateText) {
		boolean result = true;
		String[] origin = originText.split(" ");
		String[] duplicate = duplicateText.split(" ");
		HashSet<String> check = new HashSet<>(Arrays.asList(origin));
		for (String duplicateWord : duplicate) {
			if (!check.contains(duplicateWord)) {
				result = false;
				break;
			}
		}
		return result;
	}
}
