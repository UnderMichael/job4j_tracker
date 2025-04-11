package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
	public static void main(String[] args) {
		Student student = new Student();
		student.setAdmissionDate(LocalDate.of(2025, 4, 11));
		student.setGroup("1-пкс");
		student.setFullName("Иван Васильич Перепелкин");
		System.out.println(student.getFullName() + " поступил " + student.getAdmissionDate() + " зачислен в группу " + student.getGroup());

	}
}
