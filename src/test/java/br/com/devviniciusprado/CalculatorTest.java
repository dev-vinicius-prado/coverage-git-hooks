package br.com.devviniciusprado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldAddTwoNumbers() {
     assertEquals(5, calculator.add(2, 3));
     assertEquals(0, calculator.add(-1, 1));
     assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    void shouldSubtractTwoNumbers() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-2, calculator.subtract(-1, 1));
        assertEquals(1, calculator.subtract(-2, -3));
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-1, calculator.multiply(-1, 1));
        assertEquals(6, calculator.multiply(-2, -3));
    }

    @Test
    void shouldDivideTwoNumbers() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-1, calculator.divide(-1, 1));
        assertEquals(2, calculator.divide(-6, -3));
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    void shouldCalculatePercentage() {
        assertEquals(50.0, calculator.percentage(50, 100));
        assertEquals(0.0, calculator.percentage(0, 100));
        assertEquals(100.0, calculator.percentage(100, 100));
        assertEquals(0.0, calculator.percentage(50, 0));
        assertEquals(30.0, calculator.percentage(30, 100));
        assertEquals(400.0, calculator.percentage(400, 100));
    }
}