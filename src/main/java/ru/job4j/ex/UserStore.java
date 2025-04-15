package ru.job4j.ex;

public class UserStore {

	public static User findUser(User[] users, String login) throws UserNotFound {
		User result = null;
		for (User user : users) {
			if (login.equals(user.getUsername())) {
				result = user;
			}
		}
		if (result == null) {
			throw new UserNotFound("user not found in array");
		}
		return result;
	}

	public static boolean validate(User user) throws UserInvalidException {
		if (!user.isValid()) {
			throw new UserInvalidException("user is not valid");
		}
		if (user.getUsername().length() < 3) {
			throw new UserInvalidException("username must be 3 characters or longer");
		}
		return true;
	}

	public static void main(String[] args) {
		User[] users = {
				new User("Petr Arsentev", false)
		};
		try {
			User user = findUser(users, "Petr Arsentev");
			if (validate(user)) {
				System.out.println("This user has an access");
			}
		} catch (UserInvalidException e) {
			System.out.println("user validation failed: " + e.getMessage());
		} catch (UserNotFound e) {
			System.out.println("finding user failed: " + e.getMessage());
		}
	}
}