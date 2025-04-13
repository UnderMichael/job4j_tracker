package ru.job4j.pojo;

public class Library {

	public static void main(String[] args) {
		Book book1 = new Book("Clean code", (short) 464);
		Book book2 = new Book("Atomic habits", (short) 306);
		Book book3 = new Book("Grokking Algorithms", (short) 288);
		Book book4 = new Book("МУму", (short) 224);
		Book[] books = {book1, book2, book3, book4};
		for (int i = 0; i < books.length; i++) {
			Book book = books[i];
			System.out.println("book name: " + book.getName() + ", pages: " + book.getPages());
		}
		Book tmp = books[0];
		books[0] = books[3];
		books[3] = tmp;
		for (Book book : books) {
			if (book.getName().equals("Clean code")) {
				System.out.println("book name: " + book.getName() + ", pages: " + book.getPages());
			}
		}
	}
}
