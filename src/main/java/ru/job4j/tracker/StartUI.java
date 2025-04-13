package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
	private Scanner scanner;

	private Tracker tracker;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tracker tracker = new Tracker();
		new StartUI().init(scanner, tracker);
	}

	private void createItem() {
		System.out.println("=== Создание новой заявки ===");
		System.out.print("Введите имя: ");
		String name = scanner.nextLine();
		Item item = new Item(name);
		tracker.add(item);
		System.out.println("Добавленная заявка: " + item);
	}

	private void deleteItem() {
		System.out.println("=== Удаление заявки ===");
		System.out.print("Введите id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Item item = tracker.findById(id);
		tracker.delete(id);
		System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
	}

	private void editItem() {
		System.out.println("=== Редактирование заявки ===");
		System.out.print("Введите id: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите имя: ");
		String name = scanner.nextLine();
		Item item = new Item(name);
		if (tracker.replace(id, item)) {
			System.out.println("Заявка изменена успешно.");
		} else {
			System.out.println("Ошибка замены заявки.");
		}
	}

	private void listAllItems() {
		System.out.println("=== Вывод всех заявок ===");
		Item[] items = tracker.findAll();
		if (items.length > 0) {
			for (Item item : items) {
				System.out.println(item);
			}
		} else {
			System.out.println("Хранилище еще не содержит заявок");
		}
	}

	private void getItemById() {
		System.out.println("=== Вывод заявки по id ===");
		System.out.print("Введите id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Item item = tracker.findById(id);
		if (item != null) {
			System.out.println(item);
		} else {
			System.out.println("Заявка с введенным id: " + id + " не найдена.");
		}
	}

	public void init(Scanner scanner, Tracker tracker) {
		this.scanner = scanner;
		this.tracker = tracker;
		boolean run = true;
		while (run) {
			showMenu();
			System.out.print("Выбрать: ");
			int select = Integer.parseInt(scanner.nextLine());
			switch (select) {
				case 0:
					createItem();
					break;
				case 1:
					listAllItems();
					break;
				case 2:
					editItem();
					break;
				case 3:
					deleteItem();
					break;
				case 4:
					getItemById();
					break;
				case 6:
					run = false;
					break;
				default:
					System.out.println("unsupported value");
			}
		}
	}

	private void showMenu() {
		String[] menu = {
				"Добавить новую заявку", "Показать все заявки", "Изменить заявку",
				"Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
				"Завершить программу"
		};
		System.out.println("Меню:");
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + ". " + menu[i]);
		}
	}
}