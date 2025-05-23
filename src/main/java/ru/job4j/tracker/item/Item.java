package ru.job4j.tracker.item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Item {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

	private final LocalDateTime created = LocalDateTime.now();

	private int id;

	private String name;

	public Item(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Item(String name) {
		this.name = name;
	}

	public Item() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		return id == item.id && Objects.equals(name, item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "Item{"
			   + "id=" + id
			   + ", name='" + name + '\''
			   + ", created=" + created.format(FORMATTER)
			   + '}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}