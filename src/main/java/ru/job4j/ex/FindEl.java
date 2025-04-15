package ru.job4j.ex;

public class FindEl {
	public static int indexOf(String[] value, String key) throws ElementNotFound {
		int result = -1;
		for (int i = 0; i < value.length; i++) {
			if (value[i].equals(key)) {
				result = i;
				break;
			}
		}
		if (result == -1) {
			throw new ElementNotFound("Element " + key + " not found in array");
		}
		return result;
	}

	public static void main(String[] args) {
		String[] value = {"123", "1231", "123123"};
		try {
			int result = FindEl.indexOf(value, "3213");
			System.out.println("index of searched value is " + result);
		} catch (ElementNotFound e) {
			e.printStackTrace();
		}
	}
}