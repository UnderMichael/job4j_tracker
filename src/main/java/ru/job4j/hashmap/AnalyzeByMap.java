package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
	public static double averageScore(List<Pupil> pupils) {
		int sum = 0;
		int count = 0;
		for (Pupil pupil : pupils) {
			for (Subject subject : pupil.subjects()) {
				sum += subject.score();
				count++;
			}
		}
		return (double) sum / count;
	}

	public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
		List<Label> result = new ArrayList<>();
		for (Pupil pupil : pupils) {
			int sum = 0;
			for (Subject subject : pupil.subjects()) {
				sum += subject.score();
			}
			result.add(new Label(pupil.name(), (double) sum / pupil.subjects().size()));
		}
		return result;
	}

	public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
		List<Label> result = new ArrayList<>();
		Map<String, Integer> map = getSubjectsScoreMap(pupils);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			double average = (double) entry.getValue() / pupils.size();
			result.add(new Label(entry.getKey(), average));
		}
		return result;
	}

	public static Label bestStudent(List<Pupil> pupils) {
		List<Label> result = new ArrayList<>();
		for (Pupil pupil : pupils) {
			int sum = 0;
			for (Subject subject : pupil.subjects()) {
				sum += subject.score();
			}
			result.add(new Label(pupil.name(), sum));
		}
		Comparator<Label> comparator = Comparator.naturalOrder();
		result.sort(comparator);

		return result.getLast();
	}

	public static Label bestSubject(List<Pupil> pupils) {
		List<Label> result = new ArrayList<>();
		Map<String, Integer> map = getSubjectsScoreMap(pupils);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			result.add(new Label(entry.getKey(), entry.getValue()));
		}
		Comparator<Label> comparator = Comparator.naturalOrder();
		result.sort(comparator);

		return result.getLast();
	}

	private static Map<String, Integer> getSubjectsScoreMap(List<Pupil> pupils) {
		Map<String, Integer> map = new LinkedHashMap<>();
		pupils.forEach(pupil ->
				pupil.subjects().forEach(subject ->
						map.merge(subject.name(), subject.score(), Integer::sum)));
		return map;
	}

}