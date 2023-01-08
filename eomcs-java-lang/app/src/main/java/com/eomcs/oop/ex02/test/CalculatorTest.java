package com.eomcs.oop.ex02.test;

public class CalculatorTest {

  public static void main(String[] args) {

    Calculator c1= new Calculator();

    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    System.out.printf("result = %d\n", c1.result);

  }
}