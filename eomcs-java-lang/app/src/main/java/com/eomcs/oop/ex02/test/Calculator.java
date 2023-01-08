package com.eomcs.oop.ex02.test;

class Calculator{

  int result = 0;

  void plus(int a) {
    this.result += a;
  }

  void minus(int a) {
    this.result -= a;
  }

  void multiple(int a) {
    this.result *= a;
  }

  void divide(int a) {
    this.result /= a;
  }
}