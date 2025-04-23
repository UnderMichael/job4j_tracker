package ru.job4j.collection.job;

public record Job(String name, int priority) {

	@Override
	public String toString() {
		return "Job{" + name + ", " + priority + '}';
	}
}
