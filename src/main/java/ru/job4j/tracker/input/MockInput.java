package ru.job4j.tracker.input;

public class MockInput implements Input {
	private final String[] answers;

	private int position = 0;

	public MockInput(String[] answers) {
		this.answers = answers;
	}

	@Override
	public int askInt(String question) {
		return Integer.parseInt(askStr(question));
	}

	@Override
	public String askStr(String question) {
		return answers[position++];
	}
}
