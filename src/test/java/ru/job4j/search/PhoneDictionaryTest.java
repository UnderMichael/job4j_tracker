package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
	@Test
	public void whenFindByName() {
		var phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev", "534872", "Bryansk")
		);
		phones.add(new Person("Ivan", "Petrov", "123456", "Moscow"));
		phones.add(new Person("Anna", "Sidorova", "987654", "Saint Petersburg"));
		phones.add(new Person("Dmitry", "Kuznetsov", "246810", "Novosibirsk"));
		phones.add(new Person("Elena", "Smirnova", "135791", "Yekaterinburg"));
		phones.add(new Person("Sergey", "Volkov", "112233", "Kazan"));
		phones.add(new Person("Olga", "Fedorova", "556677", "Nizhny Novgorod"));
		phones.add(new Person("Nikolay", "Belov", "778899", "Rostov-on-Don"));
		phones.add(new Person("Marina", "Morozova", "314159", "Samara"));
		phones.add(new Person("Alexey", "Vinogradov", "202122", "Ufa"));
		phones.add(new Person("Tatiana", "Zaitseva", "909090", "Chelyabinsk"));
		var persons = phones.find("Petr");
		assertThat(persons.getFirst().surname()).isEqualTo("Arsentev");
	}

	@Test
	public void whenNotFound() {
		var phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev", "534872", "Bryansk")
		);
		phones.add(new Person("Ivan", "Petrov", "123456", "Moscow"));
		phones.add(new Person("Anna", "Sidorova", "987654", "Saint Petersburg"));
		phones.add(new Person("Dmitry", "Kuznetsov", "246810", "Novosibirsk"));
		phones.add(new Person("Elena", "Smirnova", "135791", "Yekaterinburg"));
		phones.add(new Person("Sergey", "Volkov", "112233", "Kazan"));
		phones.add(new Person("Olga", "Fedorova", "556677", "Nizhny Novgorod"));
		phones.add(new Person("Nikolay", "Belov", "778899", "Rostov-on-Don"));
		phones.add(new Person("Marina", "Morozova", "314159", "Samara"));
		phones.add(new Person("Alexey", "Vinogradov", "202122", "Ufa"));
		phones.add(new Person("Tatiana", "Zaitseva", "909090", "Chelyabinsk"));
		var persons = phones.find("Michael");
		assertThat(persons).isEqualTo(new ArrayList<Person>());
	}
}