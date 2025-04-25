package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс осуществляет работу со списком пользователей и счетам к ним привязанным;
 * Реализованы такие действия как добавление/удаление/поиск по паспорту пользователей,
 * добавление/поиск по реквизитам счета
 *
 * @author underMichael
 * @version 1.0
 */
public class BankService {
	private final Map<User, List<Account>> users = new HashMap<>();

	/**
	 * Метод добавляет пользователя в список, если его еще в нем нет
	 *
	 * @param user пользователь для добавления в список
	 */
	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<>());
	}

	/**
	 * Метод удаляет пользователя с указанным номером паспорта
	 *
	 * @param passport номер паспорта пользователя для удаления
	 */
	public void deleteUser(String passport) {
		users.remove(new User(passport, null));
	}

	/**
	 * Метод добавляет счет с указанными реквизитами для пользователя с указанным паспортом, если такой существует
	 *
	 * @param passport номер паспорта пользователя для добавления счета
	 * @param account  счет, который добавляется для указанного пользователя
	 */
	public void addAccount(String passport, Account account) {
		User user = findByPassport(passport);
		if (user != null) {
			List<Account> accounts = users.get(user);
			if (!accounts.contains(account)) {
				accounts.add(account);
			}
		}
	}

	/**
	 * Метод находит пользователя по указанному номеру паспорта
	 *
	 * @param passport номер паспорта пользователя, которого мы ищем
	 * @return User | null
	 */
	public User findByPassport(String passport) {
		for (User user : users.keySet()) {
			if (user.passport().equals(passport)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Метод находит счет пользователя по указанному номеру паспорта и реквизитам
	 *
	 * @param passport  номер паспорта пользователя, счет которого мы ищем
	 * @param requisite реквизиты счета, который мы ищем
	 * @return Account | null
	 */
	public Account findByRequisite(String passport, String requisite) {
		User user = findByPassport(passport);
		if (user != null) {
			for (Account account : users.get(user)) {
				if (account.getRequisite().equals(requisite)) {
					return account;
				}
			}
		}
		return null;
	}

	/**
	 * Метод переводит деньги с одного счета на другой.
	 * Возвращает true, в случае успеха и false - в случае неудачи.
	 *
	 * @param sourcePassport       номер паспорта пользователя, со счета которого совершается перевод
	 * @param sourceRequisite      номер счета, с которого совершается перевод
	 * @param destinationPassport  номер паспорта пользователя, на счёт которого совершается перевод
	 * @param destinationRequisite номер счета, на который совершается перевод
	 * @param amount               сумма перевода
	 * @return boolean
	 */
	public boolean transferMoney(String sourcePassport, String sourceRequisite, String destinationPassport, String destinationRequisite, double amount) {
		Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
		Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
		if (destinationAccount == null || sourceAccount == null || sourceAccount.getBalance() < amount) {
			return false;
		}
		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		destinationAccount.setBalance(destinationAccount.getBalance() + amount);

		return true;

	}

	/**
	 * Метод возвращает все счета пользователя
	 *
	 * @param user пользователь, счета которого мы хотим получить
	 * @return List < Account >
	 */
	public List<Account> getAccounts(User user) {
		return users.get(user);
	}
}
