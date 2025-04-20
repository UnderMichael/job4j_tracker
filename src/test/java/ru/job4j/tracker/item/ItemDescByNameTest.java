package ru.job4j.tracker.item;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
	@Test
	void whenSortByDesc() {
		List<Item> list = new ArrayList<>(List.of(
				new Item(1, "John"),
				new Item(2, "Bob"),
				new Item(3, "Tom")
		));
		list.sort(new ItemDescByName());
		List<Item> expected = List.of(
				new Item(3, "Tom"),
				new Item(1, "John"),
				new Item(2, "Bob")
		);
		assertThat(list).isEqualTo(expected);
	}
}