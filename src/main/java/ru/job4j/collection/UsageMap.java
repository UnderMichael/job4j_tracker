package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("qwe@qwe.qwe", "Иванов Иван Иванович");
		map.put("qwe@qwe.qwe", "С");
		map.put("test@mail.ru", "Петров Петр Петрович");
		map.put("test@mail.ru", "Дублирующими ключами");
		map.put("some@gmail.com", "Васильев Василий Васильевич");
		map.put("some@gmail.com", "Пары");
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}
}
