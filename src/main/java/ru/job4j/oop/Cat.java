package ru.job4j.oop;

public class Cat {
	private String food;

	private String name;

	public static void main(String[] args) {
		System.out.println("There is gav's food");
		Cat gav = new Cat();
		gav.giveNick("gav");
		gav.eat("cutlet");
		gav.show();
		System.out.println("There is black's food");
		Cat black = new Cat();
		black.giveNick("black");
		black.eat("fish");
		black.show();
	}

	public void giveNick(String nick) {
		this.name = nick;
	}

	public void show() {
		System.out.println(this.name + " ate " + this.food);
	}

	public void eat(String meat) {
		this.food = meat;
	}
}
