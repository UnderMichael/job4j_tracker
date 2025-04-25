package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		BiConsumer<Integer, String> biConsumer = (number, string) -> map.put(number, string);
        /*
            Замените вставку элементов в карту на использование BiConsumer, он уже объявлен, требуется его реализовать.
         */
		biConsumer.accept(1, "one");
		biConsumer.accept(2, "two");
		biConsumer.accept(3, "three");
		biConsumer.accept(4, "four");
		biConsumer.accept(5, "five");
		biConsumer.accept(6, "six");
		biConsumer.accept(7, "seven");

		BiPredicate<Integer, String> biPredicate = (key, value) -> key % 2 == 0 || value.length() == 4;
		for (Integer key : map.keySet()) {
            /*
                Замените проверку в if() на использование BiPredicate, он объявлен выше, требуется его реализовать.
             */
			if (biPredicate.test(key, map.get(key))) {
				System.out.println("key: " + key + " value: " + map.get(key));
			}
		}
        /*
            Заменить создание ArrayList из значений Map на Supplier, объявлен ниже, требуется его реализовать.
         */
		Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
		List<String> strings = supplier.get();

		Consumer<String> consumer = string -> System.out.println(string);
		Function<String, String> function = string -> string.toUpperCase();
		for (String string : strings) {
            /*
                Заменить вывод строк на применение Consumer
                Заменить преобразование строк к строкам в верхнем регистре с помощью Function
                Необходимое объявлено выше, требуется их реализовать.
            */
			consumer.accept(function.apply(string));
		}
	}
}