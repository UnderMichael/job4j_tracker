package ru.job4j.collection.job;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
	@Override
	public int compare(Job o1, Job o2) {
		return Integer.compare(o2.priority(), o1.priority());
	}
}
