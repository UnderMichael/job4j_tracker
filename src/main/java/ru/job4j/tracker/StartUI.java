package ru.job4j.tracker;

public class StartUI {
	private Input input;

	private Tracker tracker;

	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		new StartUI().init(input, tracker);
	}

	private void createItem() {
		System.out.println("=== Создание новой заявки ===");
		String name = input.askStr("Введите имя: ");
		Item item = new Item(name);
		tracker.add(item);
		System.out.println("Добавленная заявка: " + item);
	}

	private void deleteItem() {
		System.out.println("=== Удаление заявки ===");
		int id = input.askInt("Введите id: ");
		Item item = tracker.findById(id);
		tracker.delete(id);
		System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
	}

	private void editItem() {
		System.out.println("=== Редактирование заявки ===");
		int id = input.askInt("Введите id: ");
		String name = input.askStr("Введите имя: ");
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

	private void listItemsByName() {
		System.out.println("=== Вывод заявок по имени ===");
		String name = input.askStr("Введите имя: ");
		Item[] items = tracker.findByName(name);
		if (items.length > 0) {
			for (Item item : items) {
				System.out.println(item);
			}
		} else {
			System.out.println("Заявки с именем: " + name + " не найдены.");
		}
	}

	private void getItemById() {
		System.out.println("=== Вывод заявки по id ===");
		int id = input.askInt("Введите id: ");
		Item item = tracker.findById(id);
		if (item != null) {
			System.out.println(item);
		} else {
			System.out.println("Заявка с введенным id: " + id + " не найдена.");
		}
	}

	public void init(Input scanner, Tracker tracker) {
		this.input = scanner;
		this.tracker = tracker;
		boolean run = true;
		while (run) {
			showMenu();
			int select = input.askInt("Выбрать: ");
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
				case 5:
					listItemsByName();
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