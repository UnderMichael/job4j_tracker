package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
	private final ArrayList<Person> persons = new ArrayList<>();

	public void add(Person person) {
		this.persons.add(person);
	}

	public ArrayList<Person> find(String key) {
		Predicate<Person> byName = person -> person.name().contains(key);
		Predicate<Person> bySurname = person -> person.surname().contains(key);
		Predicate<Person> byAddress = person -> person.address().contains(key);
		Predicate<Person> byPhone = person -> person.phone().contains(key);
		Predicate<Person> combine = byName.or(bySurname.or(byAddress.or(byPhone)));
		ArrayList<Person> result = new ArrayList<>();
		for (var person : persons) {
			if (combine.test(person)) {
				result.add(person);
			}
		}
		return result;
	}
}
