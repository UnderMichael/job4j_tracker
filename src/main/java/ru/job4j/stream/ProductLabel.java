package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
	public List<String> generateLabels(List<Product> products) {
		return products.stream()
				.filter(product -> product.standard() - product.actual() <= 3)
				.filter(product -> product.standard() - product.actual() >= 0)
				.map(product -> new Label(product.name(), product.price() / 2))
				.map(Label::toString)
				.toList();
	}
}