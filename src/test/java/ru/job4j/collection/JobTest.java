package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.collection.job.*;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
	@Test
	public void whenComparatorByDescNameAndDescPriority() {
		Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
		int rsl = cmpNamePriority.compare(
				new Job("test", 0),
				new Job("test", 1)
		);
		assertThat(rsl).isGreaterThan(0);
	}

	@Test
	public void whenComparatorByDescPriorityAndDescName() {
		Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 1),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isLessThan(0);
	}

	@Test
	public void whenComparatorByAscNameAndDescPriority() {
		Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
		int rsl = cmpNamePriority.compare(
				new Job("test", 0),
				new Job("test", 1)
		);
		assertThat(rsl).isGreaterThan(0);
	}

	@Test
	public void whenComparatorByDescPriorityAndAscName() {
		Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobAscByName());
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 1),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isGreaterThan(0);
	}

	@Test
	public void whenComparatorByAscNameAndAscPriority() {
		Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
		int rsl = cmpNamePriority.compare(
				new Job("test", 0),
				new Job("test", 1)
		);
		assertThat(rsl).isLessThan(0);
	}

	@Test
	public void whenComparatorByAscPriorityAndAscName() {
		Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 1),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isGreaterThan(0);
	}

	@Test
	public void whenComparatorByDescNameAndAscPriority() {
		Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
		int rsl = cmpNamePriority.compare(
				new Job("test", 0),
				new Job("test", 1)
		);
		assertThat(rsl).isLessThan(0);
	}

	@Test
	public void whenComparatorByAscPriorityAndDescName() {
		Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 1),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isLessThan(0);
	}

	@Test
	public void whenComparatorByDescName() {
		Comparator<Job> cmpNamePriority = new JobDescByName();
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 0),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isLessThan(0);
	}

	@Test
	public void whenComparatorByAscName() {
		Comparator<Job> cmpNamePriority = new JobAscByName();
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 0),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isGreaterThan(0);
	}

	@Test
	public void whenComparatorByAscPriority() {
		Comparator<Job> cmpNamePriority = new JobAscByPriority();
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 0),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isLessThan(0);
	}

	@Test
	public void whenComparatorByDescPriority() {
		Comparator<Job> cmpNamePriority = new JobDescByPriority();
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 0),
				new Job("Fix bug", 1)
		);
		assertThat(rsl).isGreaterThan(0);
	}
}