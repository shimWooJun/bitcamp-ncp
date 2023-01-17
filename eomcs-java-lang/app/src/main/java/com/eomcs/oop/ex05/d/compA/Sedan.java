package com.eomcs.oop.ex05.d.compA;

import com.eomcs.oop.ex05.d.Car;

public class Sedan extends Car {
  public boolean sunloof;
  public boolean auto;

  public void start() {
    System.out.println("출발!");
  }

  public void stop() {
    System.out.println("주차!");
  }
}
