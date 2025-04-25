package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
	public static void main(String[] args) {
		List<Attachment> attachments = Arrays.asList(
				new Attachment("image 1", 100),
				new Attachment("image 4", 232),
				new Attachment("image 2", 34),
				new Attachment("image 3", 13)
		);
		Comparator<Attachment> comparator = new Comparator<>() {
			@Override
			public int compare(Attachment o1, Attachment o2) {
				return Integer.compare(o1.size(), o2.size());
			}
		};
		attachments.sort(comparator);
		System.out.println(attachments);
		Comparator<Attachment> comparatorByName = new Comparator<>() {
			@Override
			public int compare(Attachment o1, Attachment o2) {
				return o1.name().compareTo(o2.name());
			}
		};
		attachments.sort(comparatorByName);
		System.out.println(attachments);
	}
}