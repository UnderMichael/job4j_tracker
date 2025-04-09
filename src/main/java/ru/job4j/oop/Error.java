package ru.job4j.oop;

public class Error {
	boolean active;

	int status;

	String message;

	public Error() {

	}

	public Error(boolean active, int status, String message) {
		this.active = active;
		this.status = status;
		this.message = message;
	}

	public static void main(String[] args) {
		Error first = new Error();
		Error second = new Error(true, 404, "Not found");
		Error third = new Error(false, 200, "Success");
		first.getInfo();
		second.getInfo();
		third.getInfo();
	}

	public void getInfo() {
		System.out.println("Error active is " + this.active);
		System.out.println("Error status is " + this.status);
		System.out.println("Error messsage is " + this.message);
		System.out.println();
	}
}
