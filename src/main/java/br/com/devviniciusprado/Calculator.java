package br.com.devviniciusprado;

public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Division by zero is not allowed.");
    }
    return a / b;
  }

  public double percentage(int value, int total) {
    if (total == 0) {
      return 0;
    }
    return (double) value * 100 / total;
  }
}
