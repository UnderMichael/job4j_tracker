package ru.job4j.early;

public class PasswordValidator {
	private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

	@SuppressWarnings("checkstyle:MethodLength")
	public static String validate(String password) throws IllegalArgumentException {
		if (password == null) {
			throw new IllegalArgumentException("Password can't be null");
		}
		if (password.length() < 8 || password.length() > 32) {
			throw new IllegalArgumentException("Password should be length [8, 32]");
		}
		for (String forbidden : FORBIDDEN) {
			if (password.toLowerCase().contains(forbidden.toLowerCase())) {
				throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
			}
		}

		boolean hasUpCase = false;
		boolean hasLowCase = false;
		boolean hasDigit = false;
		boolean hasSpecial = false;
		for (char symbol : password.toCharArray()) {
			if (hasDigit && hasLowCase && hasSpecial && hasUpCase) {
				break;
			}
			if (Character.isDigit(symbol)) {
				hasDigit = true;
			} else if (Character.isUpperCase(symbol)) {
				hasUpCase = true;
			} else if (Character.isLowerCase(symbol)) {
				hasLowCase = true;
			} else if (!Character.isLetterOrDigit(symbol)) {
				hasSpecial = true;
			}
		}
		if (!hasUpCase) {
			throw new IllegalArgumentException("Password should contain at least one uppercase letter");
		}
		if (!hasLowCase) {
			throw new IllegalArgumentException("Password should contain at least one lowercase letter");
		}
		if (!hasDigit) {
			throw new IllegalArgumentException("Password should contain at least one figure");
		}
		if (!hasSpecial) {
			throw new IllegalArgumentException("Password should contain at least one special symbol");
		}
		return password;
	}
}
