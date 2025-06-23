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
  
  public int square(int a) {
        return a * a;
  }

  public int squareRoot(int a) {
    if (a < 0) {
       throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
    }
    return (int) Math.sqrt(a);
  }

  public int power(int base, int exponent) {
    if (exponent < 0) {
       throw new IllegalArgumentException("Exponent must be non-negative.");
    }
    return (int) Math.pow(base, exponent);
  }
}
