package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
	private String fullName;

	private String group;

	private LocalDate admissionDate;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAdmissionDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return admissionDate.format(formatter);
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
