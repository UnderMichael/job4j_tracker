package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
	private final ArrayList<Person> persons = new ArrayList<>();

	public void add(Person person) {
		this.persons.add(person);
	}

	public ArrayList<Person> find(String key) {
		ArrayList<Person> result = new ArrayList<>();
		for (Person person : persons) {
			if (person.phone().contains(key)
				|| person.address().contains(key)
				|| person.name().contains(key)
				|| person.surname().contains(key)) {
				result.add(person);
			}
		}
		return result;
	}
}
