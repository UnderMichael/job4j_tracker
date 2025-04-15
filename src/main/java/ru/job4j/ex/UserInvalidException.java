package ru.job4j.ex;

public class UserInvalidException extends UserNotFound {
	public UserInvalidException(String message) {
		super(message);
	}
}
