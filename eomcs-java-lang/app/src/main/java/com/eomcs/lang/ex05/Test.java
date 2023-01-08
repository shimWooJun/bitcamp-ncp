package com.eomcs.lang.ex05;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner keyscanner = new Scanner(System.in);
    int a, b, c;
    System.out.print("숫자를 입력하세요: ");
    a = keyscanner.nextInt();
    System.out.print("숫자를 입력하세요: ");
    b = keyscanner.nextInt();
    c = a + b;
    System.out.println(a + " + " + b + " = " + c +" 입니다.");
  }

}
