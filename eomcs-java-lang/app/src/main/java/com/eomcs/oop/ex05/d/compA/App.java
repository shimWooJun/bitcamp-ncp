// 상속 - 상속 문법을 이용한 기능 추가
package com.eomcs.oop.ex05.d.compA;

public class App {
  public static void main(String[] args) {
    Sedan c = new Sedan();

    c.model = "티코";
    c.maker = "비트자동차";
    c.capacity = 5;

    c.sunloof = true;
    c.auto = true;

    c.start();
    c.run();
    c.stop();

  }
}
