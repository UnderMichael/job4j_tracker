package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.item.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
	@Test
	void whenCreateItem() {
		Output output = new StubOutput();
		Input input = new MockInput(
				new String[]{"0", "Item name", "1"}
		);
		Tracker tracker = new Tracker();
		ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
				new CreateAction(output),
				new ExitAction(output)));

		new StartUI(output).init(input, tracker, actions);
		assertThat(tracker.findAll().getFirst().getName()).isEqualTo("Item name");
	}

	@Test
	void whenExit() {
		Output output = new StubOutput();
		Input input = new MockInput(
				new String[]{"0"}
		);
		Tracker tracker = new Tracker();
		ArrayList<UserAction> actions = new ArrayList<>(List.of(
				new ExitAction(output)));
		new StartUI(output).init(input, tracker, actions);
		assertThat(output.toString()).isEqualTo(
				"Меню:" + System.lineSeparator()
				+ "0. Завершить программу" + System.lineSeparator()
				+ "=== Завершение программы ===" + System.lineSeparator()
		);
	}

	@Test
	void whenReplaceItem() {
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("Replaced item"));
		String replacedName = "New item name";
		Input input = new MockInput(
				new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
		);
		ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
				new ReplaceAction(output),
				new ExitAction(output)
		));
		new StartUI(output).init(input, tracker, actions);
		assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
	}

	@Test
	void whenDeleteItem() {
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
		Input input = new MockInput(
				new String[]{"0", String.valueOf(item.getId()), "1"}
		);
		ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
				new DeleteAction(output),
				new ExitAction(output)
		));
		new StartUI(output).init(input, tracker, actions);
		assertThat(tracker.findById(item.getId())).isNull();
	}

	@Test
	void whenReplaceItemTestOutputIsSuccessfully() {
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		Item one = tracker.add(new Item("test1"));
		String replaceName = "New Test Name";
		Input input = new MockInput(
				new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
		);
		ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
				new ReplaceAction(output),
				new ExitAction(output)
		));
		new StartUI(output).init(input, tracker, actions);
		String ln = System.lineSeparator();
		assertThat(output.toString()).isEqualTo(
				"Меню:" + ln
				+ "0. Изменить заявку" + ln
				+ "1. Завершить программу" + ln
				+ "=== Редактирование заявки ===" + ln
				+ "Заявка изменена успешно." + ln
				+ "Меню:" + ln
				+ "0. Изменить заявку" + ln
				+ "1. Завершить программу" + ln
				+ "=== Завершение программы ===" + ln
		);
	}

	@Test
	void whenFindAllTestOutputIsSuccessfully() {
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		Item item1 = tracker.add(new Item("test1"));
		Item item2 = tracker.add(new Item("test2"));
		Item item3 = tracker.add(new Item("test3"));
		Input input = new MockInput(
				new String[]{"0", "1"}
		);
		ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
				new FindAllAction(output),
				new ExitAction(output)
		));
		new StartUI(output).init(input, tracker, actions);
		String ln = System.lineSeparator();
		assertThat(output.toString()).isEqualTo(
				"Меню:" + ln
				+ "0. Показать все заявки" + ln
				+ "1. Завершить программу" + ln
				+ "=== Вывод всех заявок ===" + ln
				+ item1 + ln
				+ item2 + ln
				+ item3 + ln
				+ "Меню:" + ln
				+ "0. Показать все заявки" + ln
				+ "1. Завершить программу" + ln
				+ "=== Завершение программы ===" + ln
		);
	}

	@Test
	void whenFindByNameTestOutputIsSuccessfully() {
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		Item item1 = tracker.add(new Item("test"));
		tracker.add(new Item("other"));
		tracker.add(new Item("name"));
		Item item2 = tracker.add(new Item("test"));
		String searchedName = "test";
		Input input = new MockInput(
				new String[]{"0", searchedName, "1"}
		);
		ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
				new FindByNameAction(output),
				new ExitAction(output)
		));
		new StartUI(output).init(input, tracker, actions);
		String ln = System.lineSeparator();
		assertThat(output.toString()).isEqualTo(
				"Меню:" + ln
				+ "0. Показать заявки по имени" + ln
				+ "1. Завершить программу" + ln
				+ "=== Вывод заявок по имени ===" + ln
				+ item1 + ln
				+ item2 + ln
				+ "Меню:" + ln
				+ "0. Показать заявки по имени" + ln
				+ "1. Завершить программу" + ln
				+ "=== Завершение программы ===" + ln
		);
	}

	@Test
	void whenFindByIdTestOutputIsSuccessfully() {
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		tracker.add(new Item("test1"));
		tracker.add(new Item("other"));
		Item item = tracker.add(new Item("name"));
		tracker.add(new Item("test3"));
		String searchedId = "3";
		Input input = new MockInput(
				new String[]{"0", searchedId, "1"}
		);
		ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
				new FindByIdAction(output),
				new ExitAction(output)
		));
		new StartUI(output).init(input, tracker, actions);
		String ln = System.lineSeparator();
		assertThat(output.toString()).isEqualTo(
				"Меню:" + ln
				+ "0. Показать заявку по id" + ln
				+ "1. Завершить программу" + ln
				+ "=== Вывод заявки по id ===" + ln
				+ item + ln
				+ "Меню:" + ln
				+ "0. Показать заявку по id" + ln
				+ "1. Завершить программу" + ln
				+ "=== Завершение программы ===" + ln
		);
	}

	@Test
	void whenInvalidExit() {
		Output output = new StubOutput();
		Input input = new MockInput(
				new String[]{"3", "0"}
		);
		Tracker tracker = new Tracker();
		ArrayList<UserAction> actions = new ArrayList<>(List.of(
				new ExitAction(output)
		));
		new StartUI(output).init(input, tracker, actions);
		String ln = System.lineSeparator();
		assertThat(output.toString()).isEqualTo(
				"Меню:" + ln
				+ "0. Завершить программу" + ln
				+ "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
				+ "Меню:" + ln
				+ "0. Завершить программу" + ln
				+ "=== Завершение программы ===" + ln
		);
	}
}