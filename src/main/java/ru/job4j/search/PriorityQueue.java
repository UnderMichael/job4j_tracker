package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
	private final LinkedList<Task> tasks = new LinkedList<>();

	public Task take() {
		return tasks.poll();
	}

	public void put(Task task) {
		int index = 0;
		for (var element : tasks) {
			if (task.priority() < element.priority()) {
				break;
			}
			index++;
		}
		tasks.add(index, task);
	}
}
