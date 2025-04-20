package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
	private final Map<String, Citizen> citizens = new HashMap<>();

	public boolean add(Citizen citizen) {
		boolean result = !citizens.containsKey(citizen.passport());
		if (result) {
			citizens.put(citizen.passport(), citizen);
		}
		return result;
	}

	public Citizen get(String passport) {
		return citizens.get(passport);
	}
}
