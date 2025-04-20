package ru.job4j.tracker.item;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
	@Test
	void whenSortByAsc() {
		List<Item> list = new ArrayList<>(List.of(
				new Item(1, "John"),
				new Item(2, "Bob"),
				new Item(3, "Tom")
		));
		list.sort(new ItemAscByName());
		List<Item> expected = List.of(
				new Item(2, "Bob"),
				new Item(1, "John"),
				new Item(3, "Tom")
		);
		assertThat(list).isEqualTo(expected);
	}
}