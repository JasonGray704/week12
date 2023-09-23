package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat; 
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;    
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	
	@BeforeEach
	void setUp() throws Exception {
		
		testDemo = new TestDemo();
	}

	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
			arguments(3, 7, 10, false),
			arguments(-5, 6, 1, true),
			arguments(4, -7, -3, true),
			arguments(-8, -2, -10, true),
			arguments(0, 4, 4, true)
		);
	}
	
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
			assertThat(testDemo.addPositive(2, 5)).isEqualTo(7);
			assertThat(testDemo.addPositive(13, 3)).isEqualTo(16);
			assertThat(testDemo.addPositive(6, 24)).isEqualTo(30);
			assertThat(testDemo.addPositive(3, 1)).isEqualTo(4);
			assertThat(testDemo.addPositive(87, 35)).isEqualTo(122);
	}

	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForDivideTwoIntegers")
	void assertThatTwoNumbersAreDividedCorrectly(int c, int d, double expected, boolean expectException) {
		
		if (!expectException) {
			assertThat(testDemo.divideTwoIntegers(c, d)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.divideTwoIntegers(c, d)).isInstanceOf(ArithmeticException.class);
		} 
	} 
	
	
	@Test
	static Stream<Arguments> argumentsForDivideTwoIntegers() {
		return Stream.of(
			arguments(12, 2, 6, false),
			arguments(-8, 5, -1.6, false),
			arguments(56, 32, 1.75, false),
			arguments(45, 768, 0.05859375, false),
			arguments(3, 7, 0.42857142857142855, false),
			arguments(9, 0, 0, true)

		);	
	}
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mock = spy(testDemo);
		
		doReturn(5).when(mock).getRandomInt();
		
		int squared = mock.randomNumberSquared();
		assertThat(squared).isEqualTo(25);
	}

}
