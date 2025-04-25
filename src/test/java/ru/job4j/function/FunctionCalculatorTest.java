package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
	@Test
	void whenLinearFunctionThenLinearResults() {
		FunctionCalculator function = new FunctionCalculator();
		List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
		List<Double> expected = Arrays.asList(11D, 13D, 15D);
		assertThat(result).containsAll(expected);
	}

	@Test
	void whenQuadraticFunctionThenQuadraticResults() {
		FunctionCalculator function = new FunctionCalculator();
		List<Double> result = function.diapason(3, 9, x -> 3 * Math.pow(x, 2) + 2 * x + 1);
		List<Double> expected = Arrays.asList(34D, 57D, 86D, 121D, 162D, 209D);
		assertThat(result).containsAll(expected);
	}

	@Test
	void whenExponentialFunctionThenExponentialResults() {
		FunctionCalculator function = new FunctionCalculator();
		List<Double> result = function.diapason(2, 7, x -> Math.pow(2, x));
		List<Double> expected = Arrays.asList(4D, 8D, 16D, 32D, 64D);
		assertThat(result).containsAll(expected);
	}
}