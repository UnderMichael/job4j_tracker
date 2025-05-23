package ru.job4j.collection.job;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
	@Override
	public int compare(Job o1, Job o2) {
		return o2.name().compareTo(o1.name());
	}
}
